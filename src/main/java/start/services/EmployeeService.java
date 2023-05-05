package start.services;

import start.entities.Employee;
import start.repositories.EmployeeRepository;
import start.entities.TypeOfContract;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class EmployeeService {
    Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    public void registerEmployee(String name,
                                 String surname,
                                 String codiceFiscale,
                                 String typeOfWork,
                                 TypeOfContract typeOfContract,
                                 String dateOfBirth){

        Employee employee = new Employee(name,surname,codiceFiscale,typeOfWork,typeOfContract,dateOfBirth);
        EmployeeRepository.saveEmployees(employee);
        System.out.println("L'utente " + surname+name+employee.getId() + " è stato registrato!");
    }
    public void resetBadge() {
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
    public void badge(){
        LocalDateTime now = LocalDateTime.now();
        if(employee.getAccessBadge() == null) {
            employee.setAccessBadge(now);
        }else {
            employee.setWorkHours( (int) ChronoUnit.MINUTES.between(employee.getAccessBadge(),now));
            resetBadge();
            }
    }

}
