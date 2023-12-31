package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.DTO.EmployeeDTO;
import start.DTO.EmployeeDTOAccess;
import start.entities.ContractDuration;
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

    public EmployeeService(EmployeeRepository repoEmployee) {
        this.repoEmployee = repoEmployee;
    }

    public EmployeeService() {
    }

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
                employee.resetAccess();
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
     * Ritorna una Map<String,String> di tutte le Ore lavorative di un singolo Employee
     * @param employee
     * @return Map<String,String>
     */
    @Deprecated
    public Map<String, String> getHoursEmployee(Employee employee) {
        Map<String, String> hoursEmployee = new HashMap<>();
        String valueKey = employee.assignUserName();
        for (String key : mapConverter(workingHours).keySet() ) {
            if (key.contains(valueKey) && key.contains(currentMonthAndDay())) {
                hoursEmployee.put(valueKey, mapConverter(workingHours).get(key));
                return hoursEmployee;
            }
        }
        hoursEmployee.put(valueKey, "Ha appena effettuato l'accesso!");
        return hoursEmployee;
    }

    /**
     * Crea il badge
     * @param id dell'Employee
     * @return Map<String,String>
     * @throws Exception
     */
    public EmployeeDTO setBadge(long id) throws Exception{
        LocalDateTime now = LocalDateTime.now();
        Employee employee = repoEmployee.findById(id).orElseThrow(()
                -> new Exception("ID not found: "+id));
        if(employee.getAccessBadge() == null) {
            employee.setAccessBadge(now);
            employee.assignEmployeeDTO().setOreEffettuate("Ha appena effettuato l'accesso!");
            repoEmployee.saveAndFlush(employee);
        }else {
            employee.setWorkHours( (int) ChronoUnit.MINUTES.
                    between(employee.getAccessBadge(),now));
            employee.assignEmployeeDTO().setOreEffettuate(convertFromLocalTimeChronoUnit(employee.getWorkHours()));
            resetBadge(employee);
            repoEmployee.saveAndFlush(employee);
        }
        return employee.assignEmployeeDTO();
    }

    /**
     * Ritorna una Map<String,LocalTime> delle le ore del Singolo Employee
     * @param employee
     * @return
     */
    public Map<String, LocalTime> getSingleEmployeeHours(Employee employee) {
        Map<String, LocalTime> employeeHours = new HashMap<>();
        String valueKey = employee.assignUserName();
        for (String key : workingHours.keySet()) {
            String keyMonth = key.substring(0,7);
            if (key.contains(valueKey) && keyMonth.equals(currentMonthAndDay())) {
                employeeHours.put(key, workingHours.get(key));
            }
        }
        return employeeHours;
    }

    /**
     * @return Il mese e giorno corrente in stringa
     */
    public String currentMonthAndDay(){
        return LocalDate.now().getYear() + "-" +
                (LocalDate.now().getMonthValue() < 10 ?
                        "0" + LocalDate.now().getMonthValue() :
                        LocalDate.now().getMonthValue());
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
    public Employee getReplaceEmployee(long id, Employee employee) throws Exception {
        try {
            Employee newEmployee = repoEmployee.getReferenceById(id);
            newEmployee.setId(id);
            newEmployee.setName(employee.getName());
            newEmployee.setSurname(employee.getSurname());
            newEmployee.setCodiceFiscale(employee.getCodiceFiscale());
            newEmployee.setTypeOfWork(employee.getTypeOfWork());
            newEmployee.setTypeOfContract(employee.getTypeOfContract());
            newEmployee.setContractDuration(employee.getContractDuration());
            newEmployee.setDateOfBirth(employee.getDateOfBirth());
            newEmployee.setPagaOraria(employee.getPagaOraria());
            newEmployee.setWorkHours(employee.getWorkHours());
            return repoEmployee.saveAndFlush(newEmployee);
        }catch (Exception e){
            throw new Exception("Cannot Update the Employee");
        }

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
     * Converte in stringa un LocalTimeChronoUnit rendendo il formato più leggibile
     * @param time
     * @return il nuovo formato di ore e minuti
     */
    public String convertFromLocalTimeChronoUnit(LocalTime time){
        String crop = String.valueOf(time);
        return crop.replaceAll(":", "h")+"'";
    }

    /**
     * Converte in stringa un LocalTime rendendo il formato a ChronoTime più leggibile
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
        return crop.replaceAll("T", " ");
    }

    /**
     * Rende un LocalTime in un formato orario più leggibile
     * @param time
     * @return Stringa
     */
    public String viewFromLocalTime(LocalTime time){
        return String.valueOf(time)
                .substring(0, String.valueOf(time)
                .lastIndexOf(":"));
    }

    /**
     * todo Da implementare in classe ADMIN
     * @return La lista di tutti i dipendenti in azienda
     */
    public List<EmployeeDTOAccess> employeesInTheCompany(){
        List<EmployeeDTOAccess> inTheCompany = new ArrayList<>();
        for ( Employee employee : repoEmployee.findAll() ) {
            if(employee.getAccessBadge() != null) {
                EmployeeDTOAccess dtoAccess = employee.assignEmployeeDTOAccess();
                dtoAccess.setAccessoBadge(convertFromLocalDateTime(employee.getAccessBadge()));
                inTheCompany.add(dtoAccess);
            }
        }
        return inTheCompany;
    }

    /**
     * todo Da implementare in classe ADMIN
     * @param id
     * @return Una stringa con delle informazioni sull'accesso del dipendente
     */
    public Map<String,String> isInTheCompany(long[] id) {
        Map<String, String> accesses = new HashMap<>();
        for (int i = 0; i < id.length; i++) {
            Employee employee = repoEmployee.findById(id[i]).orElseThrow();
            if (employee.getAccessBadge() != null) {
                accesses.put(employee.assignUserName() + " accessoBadge"
                        , convertFromLocalDateTime(employee.getAccessBadge()));
            } else {
                accesses.put(employee.assignUserName(), "Non è in azienda!");
            }
        }
        return accesses;
    }

    /**
     * todo Da implementare in classe ADMIN
     * @return La lista di tutti i dipendenti che non sono in azienda
     */
    public List<EmployeeDTO> employeesAreNotInTheCompany(){
        PayrollService payrollService = new PayrollService(repoEmployee);
        List<EmployeeDTO> NotInTheCompany = new ArrayList<>();
        for ( Employee employee : repoEmployee.findAll() ) {
            if(employee.getAccessBadge() == null) {
                employee.assignEmployeeDTO().setOreEffettuate(
                        payrollService.convertFromDouble(
                                payrollService.calculateHours(employee.getId())));
                NotInTheCompany.add(employee.assignEmployeeDTO());
            }
        }
        return NotInTheCompany;
    }
    @Deprecated
    public String createDummiesEmployees() throws Exception {
        try {
            Employee employee1 = new Employee("Harry", "Potter", "PTTHRY80L31E098E",
                    "Programmatore", TypeOfContract.OPEN_ENDED, ContractDuration.FULL_TIME, "1980-07-31", 10);
            Employee employee2 = new Employee("Hermione", "Granger", "GRNHMN79P59F158S",
                    "Professoressa", TypeOfContract.AGENCY_WORK, ContractDuration.FULL_TIME, "1979-09-19", 12);
            Employee employee3 = new Employee("User", "Fake", "USEFAK80L31E098E",
                    "Programmatore", TypeOfContract.ON_CALL_CONTRACT, ContractDuration.PART_TIME, "1991-04-14", 11.5);
            repoEmployee.saveAndFlush(employee1);
            repoEmployee.saveAndFlush(employee2);
            repoEmployee.saveAndFlush(employee3);
            return "Dummies employees are created!";
        }catch (Exception e){
            throw new Exception("Cannot create Dummies :C");
        }
    }


}