package entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class BenefitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private EmployeeEntity employee;
    public int infortuni;
    public int giorniMalattia;
    public int ferie;
    public double premiProduzione;
    List<String> beneficiMaterialiAziendali;

    public BenefitsEntity(long id,EmployeeEntity employee, int infortuni, int giorniMalattia, int ferie, double premiProduzione, List<String> beneficiMaterialiAziendali) {
        this.id = id;
        this.employee = employee;
        this.infortuni = infortuni;
        this.giorniMalattia = giorniMalattia;
        this.ferie = ferie;
        this.premiProduzione = premiProduzione;
        this.beneficiMaterialiAziendali = beneficiMaterialiAziendali;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

        public int getInfortuni () {
            return infortuni;
        }

        public void setInfortuni ( int infortuni){
            this.infortuni = infortuni;
        }

        public int getGiorniMalattia () {
            return giorniMalattia;
        }

        public void setGiorniMalattia ( int giorniMalattia){
            this.giorniMalattia = giorniMalattia;
        }

        public int getFerie () {
            return ferie;
        }

        public void setFerie ( int ferie){
            this.ferie = ferie;
        }

        public double getPremiProduzione () {
            return premiProduzione;
        }

        public void setPremiProduzione ( double premiProduzione){
            this.premiProduzione = premiProduzione;
        }

        public List<String> getBeneficiMaterialiAziendali () {
            return beneficiMaterialiAziendali;
        }

        public void setBeneficiMaterialiAziendali (List < String > beneficiMaterialiAziendali) {
            this.beneficiMaterialiAziendali = beneficiMaterialiAziendali;
        }



}
