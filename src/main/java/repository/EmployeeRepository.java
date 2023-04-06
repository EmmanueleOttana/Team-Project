package repository;

import entity.EmployeeEntity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    public static List<EmployeeEntity> employees = new ArrayList<>();
    public static Map<String, LocalTime> workingHours = new HashMap<>();

    public static void saveEmployees(EmployeeEntity employee){
        employees.add(employee);
    }

    public static Map<String, String> printHoursEmployees() {
        Map<String, String> hoursEmployees = new HashMap<>();
        for ( String key : workingHours.keySet() ) {
            String newFormat = String.valueOf(workingHours.get(key)).replaceAll(":","h");
            hoursEmployees.put(key,newFormat+"'");
        }
    return hoursEmployees;
    }


}
