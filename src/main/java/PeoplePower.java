import HumanResources.Employees;

public class PeoplePower {
    String Agency;
    String descriptionOfApp;
    String NationalContract;
    public PeoplePower(String agency, String descriptionOfApp, String nationalContract)
    {
        Agency = agency;
        this.descriptionOfApp = descriptionOfApp;
        NationalContract = nationalContract;
    }
    public String getAgency() {
        return Agency;
    }
    public void setAgency(String agency) {
        Agency = agency;
    }
    public String getDescriptionOfApp() {
        return descriptionOfApp;
    }
    public void setDescriptionOfApp(String descriptionOfApp) {
        this.descriptionOfApp = descriptionOfApp;
    }
    public String getNationalContract() {
        return NationalContract;
    }
    public void setNationalContract(String nationalContract) {
        NationalContract = nationalContract;
    }
    public static void main(String[] args)
    {


        Employees user1 = new Employees("Harry","Potter","TTNGKDJ91SGST91I","Mago","Stage","14/04/1991");

        System.out.println(user1.toString());
    }
}
