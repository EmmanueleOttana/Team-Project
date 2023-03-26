package Employee;

import Contracts.TypeOfContract;

public class EmployeeEntity {
    private String name;
    private String surname;
    private int ID;
    private static int totalIdEmployees;
    private String codiceFiscale;
    private String typeOfWork;
    TypeOfContract typeOfContract;
    private String dateOfBirth;
    public EmployeeService service = new EmployeeService();

    public EmployeeEntity(String name,
                          String surname,
                          String codiceFiscale,
                          String typeOfWork,
                          TypeOfContract typeOfContract,
                          String dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        totalIdEmployees ++;
        this.ID = totalIdEmployees;
        this.codiceFiscale = codiceFiscale;
        this.typeOfWork = typeOfWork;
        this.typeOfContract = typeOfContract;
        this.dateOfBirth = dateOfBirth;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getTypeOfContract() { return typeOfContract.toString(); }

    public void setTypeOfContract(TypeOfContract typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", ID=" + this.ID +
                ", CodiceFiscale='" + this.codiceFiscale + '\'' +
                ", typeOfWork='" + this.typeOfWork + '\'' +
                ", typeOfContract='" + this.typeOfContract + '\'' +
                ", dateOfBirth='" + this.dateOfBirth + '\'' +
                '}';
    }

}
