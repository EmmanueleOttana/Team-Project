public class TypeOfwork {

    Employees employee;
    public String manualWork;
    public String staticWork;
    public String transferWork;

    public TypeOfwork(Employees employee, String manualWork, String staticWork, String transferWork) {
        this.employee = employee;
        this.manualWork = manualWork;
        this.staticWork = staticWork;
        this.transferWork = transferWork;
    }

    public String getManualWork() {
        return manualWork;
    }

    public void setManualWork(String manualWork) {
        this.manualWork = manualWork;
    }

    public String getStaticWork() {
        return staticWork;
    }

    public void setStaticWork(String staticWork) {
        this.staticWork = staticWork;
    }

    public String getTransferWork() {
        return transferWork;
    }

    public void setTransferWork(String transferWork) {
        this.transferWork = transferWork;
    }
}
