package HumanResources;

public class Employees {
    public String name;
    public String surname;
    public int ID;
    public static int totalIdEmployees;
    public String CodiceFiscale;
    public String typeOfWork;
    public String typeOfContract;
    public String dateOfBirth;
    public Employees(){}

    public Employees(String name,
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

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID=" + ID +
                ", CodiceFiscale='" + CodiceFiscale + '\'' +
                ", typeOfWork='" + typeOfWork + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
