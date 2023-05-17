package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Admin;
import start.entities.Employee;
import start.repositories.AdminRepository;
import org.springframework.web.bind.annotation.*;
import start.services.AdminService;
import start.services.EmployeeService;


import java.util.List;
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
    public Employee replaceEmployee(@PathVariable Long id) {
        return employeeService.getReplaceEmployee(id);
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) throws Exception {
        employeeService.deleteEmployee(id);
    }
}
