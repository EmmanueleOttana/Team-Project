package entity;

import jakarta.persistence.*;

@Entity
@Table
public class TypeOfWorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String manualWork;
    private String staticWork;
    private String transferWork;

    public TypeOfWorkEntity(long id,String manualWork, String staticWork, String transferWork) {
        this.id=id;
        this.manualWork = manualWork;
        this.staticWork = staticWork;
        this.transferWork = transferWork;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getManualWork() { return manualWork; }

    public void setManualWork(String manualWork) { this.manualWork = manualWork; }

    public String getStaticWork() { return staticWork; }

    public void setStaticWork(String staticWork) { this.staticWork = staticWork; }

    public String getTransferWork() { return transferWork; }

    public void setTransferWork(String transferWork) { this.transferWork = transferWork; }


}
