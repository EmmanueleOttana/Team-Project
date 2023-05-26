package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.DTO.EmployeeDTO;
import start.DTO.EmployeeDTOAccess;
import start.entities.Admin;
import start.entities.Employee;
import start.repositories.AdminRepository;
import org.springframework.web.bind.annotation.*;
import start.services.AdminService;
import start.services.EmployeeService;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    List<Admin> getAllAdmins() throws Exception {
        return adminService.getAllAdmins();
    }

    @PostMapping
    Admin newAdmin(@RequestBody Admin newAdmin) throws Exception {
        return adminService.newAdmin(newAdmin);
    }

    @GetMapping("/{id}")
    Optional<Admin> getSingleAdmin(@PathVariable Long id)throws Exception{
        return adminService.getAdminById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteAdmin(@PathVariable Long id) throws Exception {
        adminService.deleteAdmin(id);
    }
    @GetMapping("/employee/getAll")
    List<Employee> getAllEmployees() throws Exception {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee/create")
    Employee newEmployee(@RequestBody Employee newEmployee) throws Exception{
        return employeeService.newEmployee(newEmployee);
    }

    @GetMapping("/employee/{id}")
    Optional<Employee> getSingleEmployee(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee replaceEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception{
        return employeeService.getReplaceEmployee(id,employee);
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) throws Exception {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employee/company")
    public List<EmployeeDTOAccess> employeeInTheCompany () {
        return employeeService.employeesInTheCompany();
    }
    @GetMapping("/employee/info")
    public Map<String,String> isInTheCompany(@RequestParam long[] id){
        return employeeService.isInTheCompany(id);
    }
    @GetMapping("/employee/absence")
    public List<EmployeeDTO> employeesAreNotInTheCompany(){
        return employeeService.employeesAreNotInTheCompany();
    }

}
