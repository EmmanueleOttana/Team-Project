package Employee;

public class EmployeeEntity {
    public String name;
    public String surName;
    public int ID;
    public String CodiceFiscale;
    public String typeOfWork;
    public String typeOfContract;
    public String dateOfBirth;
    public EmployeeEntity(){
    }
    public EmployeeEntity(String name,
                          String surName,
                          int ID,
                          String codiceFiscale,
                          String typeOfWork,
                          String typeOfContract, String dateOfBirth)
    {
        this.name = name;
        this.surName = surName;
        this.ID = ID;
        CodiceFiscale = codiceFiscale;
        this.typeOfWork = typeOfWork;
        this.typeOfContract = typeOfContract;
        this.dateOfBirth = dateOfBirth;
    }


    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
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
                ", surName='" + surName + '\'' +
                ", ID=" + ID +
                ", CodiceFiscale='" + CodiceFiscale + '\'' +
                ", typeOfWork='" + typeOfWork + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
