package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Employee;
import start.repositories.EmployeeRepository;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repoEmployee;
    public EmployeeService(EmployeeRepository repo) {
        this.repoEmployee = repo;
    }


    public void resetBadge(Employee employee) {
        String valueKey = LocalDate.of(employee.getAccessBadge().getYear(), employee.getAccessBadge().getMonthValue(), employee.getAccessBadge().getDayOfMonth()) + " " +
                employee.getSurname() + employee.getName() + employee.getId();
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



}