package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Admin;
import start.entities.Employee;
import start.repositories.AdminRepository;
import start.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Admin admin;
    //password verifica
    public boolean checkPassword(String password){
        return this.admin.getPassword().equals(password);
    }
    //aggiungere una nuova autorizzazione all'amministratore
    public void addAuthorization(String newAuthorization) {
        admin.setAuthorizations(admin.getAuthorizations() + ", " + newAuthorization);
    }
    //verifica se l'amministratore ha un'autorizzazione specifica
    //divide la stringa authorizations in un array di stringhe, utilizzando la virgola come "separatore"
    public boolean hasAuthorization(String authorization) {
        String[] authArray = this.admin.getAuthorizations().split(",");
        for (String auth : authArray) {
            if (auth.equals(authorization)) {
                return true;
            }
        }
        return false;
    }
    //CRUD
    public List<Admin> getAllAdmins() throws Exception{
        List<Admin> allAdminsFromDB = adminRepository.findAll();
        if (allAdminsFromDB.isEmpty()){
            throw new Exception("No Admins found!");
        }
        return allAdminsFromDB;
    }
    public Admin newAdmin(Admin admin)throws Exception{
        try {
            if (admin==null) return null;
            return adminRepository.saveAndFlush(admin);
        }catch (Exception e){
            throw new Exception("Admin not found");
        }
    }
    public Optional<Admin> getAdminById(long id) throws Exception{
        try {
            return adminRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
    public void deleteAdmin(long id)throws Exception{
        try {
            adminRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public List<Employee> fastSearch(String value) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        for ( Employee dummy : employeeRepository.findAll() ) {
            if (String.valueOf(dummy.getId()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getName()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getSurname()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getCodiceFiscale()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getTypeOfWork()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getTypeOfContract()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getContractDuration()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getDateOfBirth()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getPagaOraria()).toLowerCase().contains(value.toLowerCase())
            || String.valueOf(dummy.getAccessBadge()).toLowerCase().contains(value.toLowerCase())){
                employeeList.add(dummy);
            }
        }
        if (employeeList.isEmpty()) throw new Exception("Nessun utente è stato trovato");
        return employeeList;
    }



}

