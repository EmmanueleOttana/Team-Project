public class Employees {
    public String name;
    public String surname;
    public int ID;
    public static int totalEmployeeId;
    public String CodiceFiscale;
    public String typeOfWork;
    public String typeOfContract;
    public String dateOfBirth;

    public Employees(String name,
                     String surname,
                     String codiceFiscale,
                     String typeOfWork,
                     String typeOfContract, String dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        totalEmployeeId ++;
        this.ID = totalEmployeeId;
        this.CodiceFiscale = codiceFiscale;
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
