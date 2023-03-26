package peoplePower;

import contracts.TypeOfContract;
import employee.EmployeeRepository;
import employee.EmployeeService;

public class PeoplePowerService {
    public static void main(String[] args){
        EmployeeRepository emplRepo = new EmployeeRepository();
        EmployeeService emplService = new EmployeeService(emplRepo);

        emplService.registerEmployee("Harry","Potter","PTTHRY80L31E098E","Programmatore",TypeOfContract.OPEN_ENDED,"1980-07-31");
        emplService.registerEmployee("Hermione","Granger","GRNHMN79P59F158S","Professoressa",TypeOfContract.AGENCY_WORK,"1979-09-19");

        System.out.println(emplRepo.getEmployees());





    }
}
