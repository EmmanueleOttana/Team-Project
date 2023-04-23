package repository;

import entity.EmployeeEntity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    List<EmployeeEntity> employees = new ArrayList<>();
    Map<String, LocalTime> workingHours = new HashMap<>();

    static void saveEmployees(EmployeeEntity employee){
        employees.add(employee);
    }

    static Map<String, String> printHoursEmployees() {
        Map<String, String> hoursEmployees = new HashMap<>();
        for ( String key : workingHours.keySet() ) {
            String newFormat = String.valueOf(workingHours.get(key)).replaceAll(":","h");
            hoursEmployees.put(key,newFormat+"'");
        }
    return hoursEmployees;
    }


}
