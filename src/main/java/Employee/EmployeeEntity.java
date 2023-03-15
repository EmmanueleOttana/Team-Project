package employee;

public class EmployeeEntity {
    private String name;
    private String surname;
    private int ID;
    private static int totalIdEmployees;
    private String CodiceFiscale;
    private String typeOfWork;
    private String typeOfContract;
    private String dateOfBirth;
    public EmployeeService service = new EmployeeService();

    public EmployeeEntity(String name,
                          String surname,
                          String codiceFiscale,
                          String typeOfWork,
                          String typeOfContract, String dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        totalIdEmployees ++;
        this.ID = totalIdEmployees;
        CodiceFiscale = codiceFiscale;
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
        return CodiceFiscale;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


}
