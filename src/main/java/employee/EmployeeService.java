package employee;

public class EmployeeService {
    EmployeeEntity employee;

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + employee.getName() + '\'' +
                ", surname='" + employee.getSurname() + '\'' +
                ", ID=" + employee.getID() +
                ", CodiceFiscale='" + employee.getCodiceFiscale() + '\'' +
                ", typeOfWork='" + employee.getTypeOfWork() + '\'' +
                ", typeOfContract='" + employee.getTypeOfContract() + '\'' +
                ", dateOfBirth='" + employee.getDateOfBirth() + '\'' +
                '}';
    }
}
