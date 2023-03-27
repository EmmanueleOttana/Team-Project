package employee;

import contracts.TypeOfContract;

public class EmployeeService {
    EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public void registerEmployee(String name,
                                 String surname,
                                 String codiceFiscale,
                                 String typeOfWork,
                                 TypeOfContract typeOfContract,
                                 String dateOfBirth){

        EmployeeEntity employee = new EmployeeEntity(name,surname,codiceFiscale,typeOfWork,typeOfContract,dateOfBirth);
        repo.saveEmployees(employee);
        System.out.println("L'utente " + surname+name+employee.getID() + " è stato registrato!");
    }

}