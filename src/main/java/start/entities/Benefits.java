package start.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Benefits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Employee employee;
    @Column
    private int infortuni;
    @Column
    private int giorniMalattia;
    @Column
    private int ferie;
    @Column
    private double awardsProduction;

    private List<String> benefitsCorporateMaterials = new ArrayList<>();

    public Benefits(long id, Employee employee, int infortuni, int giorniMalattia, int ferie, double awardsProduction, List<String> benefitsCorporateMaterials) {
        this.id = id;
        this.employee = employee;
        this.infortuni = infortuni;
        this.giorniMalattia = giorniMalattia;
        this.ferie = ferie;
        this.awardsProduction = awardsProduction;
        this.benefitsCorporateMaterials = benefitsCorporateMaterials;
    }
    public Benefits(){}

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

        public double getAwardsProduction() {
            return awardsProduction;
        }

        public void setAwardsProduction(double awardsProduction){
            this.awardsProduction = awardsProduction;
        }

        public List<String> getBenefitsCorporateMaterials() {
            return benefitsCorporateMaterials;
        }

        public void setBenefitsCorporateMaterials(List < String > benefitsCorporateMaterials) {
            this.benefitsCorporateMaterials = benefitsCorporateMaterials;
        }



}
