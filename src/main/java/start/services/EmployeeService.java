package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Employee;
import start.entities.TypeOfContract;
import start.repositories.EmployeeRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static start.repositories.EmployeeRepository.workingHours;

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
                employee.assignUserName();
        if (!workingHours.containsKey(valueKey)) {
            workingHours.put(valueKey, employee.getWorkHours());
            employee.resetAccess();
        }else {
            int totalMinutes = ((workingHours.get(valueKey).getHour() + employee.getWorkHours().getHour())*60) +
                    workingHours.get(valueKey).getMinute() + employee.getWorkHours().getMinute();
            if(totalMinutes >= 60) {
                int hours = totalMinutes / 60;
                int minutes = totalMinutes % 60;
                workingHours.put(valueKey, LocalTime.of(hours,minutes));
            }else {
                workingHours.put(valueKey, LocalTime.of(0, totalMinutes));
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

    /**
     * Ritorna una Map<String,String> di tutte le Ore lavorative dell' Employee
     * @param employee
     * @return Map<String,String>
     */
    public Map<String, String> getHoursEmployee(Employee employee) {
        Map<String, String> hoursEmployee = new HashMap<>();
        String valueKey = employee.assignUserName();
        for (String key : mapConverter(workingHours).keySet() ) {
            if (key.contains(valueKey)) {
                hoursEmployee.put(valueKey, mapConverter(workingHours).get(key));
                return hoursEmployee;
            }
        }
        hoursEmployee.put(valueKey, "ha effettuato il primo accesso della giornata!");
        return hoursEmployee;
    }

    /**
     * Ritorna una Map<String,LocalTime> delle le ore del Singolo Employee
     * @param employee
     * @return
     */
    public Map<String, LocalTime> getSingleEmployeeHours(Employee employee) {
        Map<String, LocalTime> employeeHours = new HashMap<>();
        String valueKey = employee.assignUserName();
        String currentMonth = LocalDate.now().getYear() + "-" +
                (LocalDate.now().getMonthValue() < 10 ?
                        "0" + LocalDate.now().getMonthValue() :
                        LocalDate.now().getMonthValue());
        for (String key : workingHours.keySet()) {
            String keyMonth = key.substring(0,7);
            if (key.contains(valueKey) && keyMonth.equals(currentMonth)) {
                employeeHours.put(key, workingHours.get(key));
            }
        }
        return employeeHours;
    }
    // Custom and CRUD calls
    public List<Employee> getAllEmployees() throws Exception{
        List<Employee> allEmployeesFromDB = repoEmployee.findAll();
        if (allEmployeesFromDB.isEmpty()){
            throw new Exception("No Employees found!");
        }
        return allEmployeesFromDB;
    }

    public Employee newEmployee(Employee employee)throws Exception{
        try {
            if (employee==null) return null;
            return repoEmployee.saveAndFlush(employee);
        }catch (Exception e){
            throw new Exception("Employee not found");
        }
    }
    public Optional<Employee> getEmployeeById(long id) throws Exception{
        try {
            return repoEmployee.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deleteEmployee(long id)throws Exception{
        try {
            repoEmployee.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    /**
     *  Ritorna un un replace di un Employee by ID
     * @param id dell'Employee
     * @return Employee
     */
    public Employee getReplaceEmployee(long id){
        Employee newEmployee = repoEmployee.getReferenceById(id);
        return repoEmployee.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setTypeOfWork(newEmployee.getTypeOfWork());
                    return repoEmployee.saveAndFlush(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repoEmployee.saveAndFlush(newEmployee);
                });
    }
    /**
     *  Crea il badge
     * @param id dell'Employee
     * @return Map<String,String>
     * @throws Exception
     */
    public Map<String,String> setBadge(long id) throws Exception{
        LocalDateTime now = LocalDateTime.now();
        Employee employee = repoEmployee.findById(id).orElseThrow(()
                -> new Exception("ID not found: "+id));
        if(employee.getAccessBadge() == null) {
            employee.setAccessBadge(now);
            repoEmployee.saveAndFlush(employee);
        }else {
            employee.setWorkHours( (int) ChronoUnit.MINUTES.
                    between(employee.getAccessBadge(),now));
            resetBadge(employee);
            repoEmployee.saveAndFlush(employee);
        }
        return getHoursEmployee(employee);
    }

    /**
     * @param id
     * @return una Map<String,String> con tutte le ore di un singolo dipendente
     * @throws Exception
     */
    public Map<String,String> getAllHoursEmployee(long id) throws Exception {
        try {
            return mapConverter(getSingleEmployeeHours(repoEmployee.findById(id).get()));
        }catch(Exception e){
            throw new Exception("Hours not found");
        }
    }

    /**
     * Converte in stringa un LocalTime rendendo il formato più leggibile
     * @param time
     * @return il nuovo formato di ore e minuti
     */
    public String convertFromLocalTime(LocalTime time){
        String crop = String.valueOf(time).substring(0,String.valueOf(time).lastIndexOf(":"));
        return crop.replaceAll(":", "h")+"'";
    }
    /**
     * Converte in stringa un LocalDateTime rendendo il formato più leggibile
     * @param dateTime
     * @return il nuovo formato di ore e minuti
     */
    public String convertFromLocalDateTime(LocalDateTime dateTime){
        String crop = String.valueOf(dateTime).substring(0,String.valueOf(dateTime).lastIndexOf(":"));
        String newFormat = crop.replaceAll(":", "h")+"'";
        return newFormat.replaceAll("T", " ");
    }
    /**
     * @return La lista di tutti i dipendenti in azienda
     */
    public List<Employee> employeesInTheCompany(){
        List<Employee> inTheCompany = new ArrayList<>();
        for ( Employee employee : repoEmployee.findAll() ) {
            if(employee.getAccessBadge() != null) {
                inTheCompany.add(employee);
            }
        }
        return inTheCompany;
    }
    /**
     * @param id
     * @return Una stringa con delle informazioni sull'accesso del dipendente
     */
    public String isInTheCompany(long id){      //RENDERE QUESTA FUNZIONE UN ARRAY DI ID
        Employee employee = repoEmployee.findById(id).orElseThrow();
            if(employee.getAccessBadge() != null) {
                LocalTime access = employee.getAccessBadge().toLocalTime();
                return employee.assignUserName()+" ha effettuato l'accesso alle "+convertFromLocalTime(access);
            }
        return "Il dipendente "+employee.assignUserName()+" non è in azienda!";
    }
    /**
     * @return La lista di tutti i dipendenti che non sono in azienda
     */
    public List<Employee> employeesAreNotInTheCompany(){
        List<Employee> NotInTheCompany = new ArrayList<>();
        for ( Employee employee : repoEmployee.findAll() ) {
            if(employee.getAccessBadge() == null) {
                NotInTheCompany.add(employee);
            }
        }
        return NotInTheCompany;
    }
    @Deprecated
    public String createDummiesEmployees() throws Exception {
        try {
            Employee employee1 = new Employee("Harry", "Potter", "PTTHRY80L31E098E",
                    "Programmatore", TypeOfContract.OPEN_ENDED, "1980-07-31", 10);
            Employee employee2 = new Employee("Hermione", "Granger", "GRNHMN79P59F158S",
                    "Professoressa", TypeOfContract.AGENCY_WORK, "1979-09-19", 12);
            Employee employee3 = new Employee("User", "Fake", "USEFAK80L31E098E",
                    "Programmatore", TypeOfContract.ON_CALL_CONTRACT, "1991-04-14", 11.5);
            repoEmployee.saveAndFlush(employee1);
            repoEmployee.saveAndFlush(employee2);
            repoEmployee.saveAndFlush(employee3);
            return "Dummies employees are created!";
        }catch (Exception e){
            throw new Exception("Cannot create Dummies :C");
        }
    }
}