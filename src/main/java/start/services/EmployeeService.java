package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Employee;
import start.repositories.EmployeeRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repoEmployee;

    /**
     * Serve ad inserire gli accessi del dipendente nel HashMap<>() dedicato ed una volta fatto resettarne il badge.
     * @param employee
     */
    public void resetBadge(Employee employee) {
        String valueKey = LocalDate.of(employee.getAccessBadge().getYear(), employee.getAccessBadge().getMonthValue(), employee.getAccessBadge().getDayOfMonth()) + " " +
                "Employee: id: "+employee.getId() +" Surname: "+ employee.getSurname() +" Name: "+ employee.getName();
        if (!EmployeeRepository.workingHours.containsKey(valueKey)) {
            EmployeeRepository.workingHours.put(valueKey, employee.getWorkHours());
            employee.resetAccess();
        }else {
            int totalMinutes = ((EmployeeRepository.workingHours.get(valueKey).getHour() + employee.getWorkHours().getHour())*60) +
                    EmployeeRepository.workingHours.get(valueKey).getMinute() + employee.getWorkHours().getMinute();
            if(totalMinutes >= 60) {
                int hours = totalMinutes / 60;
                int minutes = totalMinutes % 60;
                EmployeeRepository.workingHours.put(valueKey, LocalTime.of(hours,minutes));
            }else {
                EmployeeRepository.workingHours.put(valueKey, LocalTime.of(0, totalMinutes));
                employee.resetAccess();
            }
        }
    }

    /**
     * Converte un HashMap<>() da <String, LocalTime> a <String, String> per una maggiore visualizzazione
     * @param map
     * @return HashMap <String, String>()
     */
    public Map<String, String> mapConverter(Map<String,LocalTime> map){
        Map<String, String> converter = new HashMap<>();
        for (String key : map.keySet()) {
            String newFormat = String.valueOf(map.get(key)).replaceAll(":", "h");
            converter.put(key, newFormat + "'");
        }
        return converter;
    }



}