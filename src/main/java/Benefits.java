import java.time.LocalDate;
import java.util.List;

public class Benefits {

    public int infortuni;
    public int giorniMalattia;
    public int ferie;
    public double premiProduzione;
    List<String> beneficiMaterialiAziendali;

    public Benefits(String name, String surName, int ID, String codiceFiscale, String typeOfWork, String typeOfContract, LocalDate dateOfBirth)
    {

    }


    public int getInfortuni() {
        return infortuni;
    }

    public void setInfortuni(int infortuni) {
        this.infortuni = infortuni;
    }

    public int getGiorniMalattia() {
        return giorniMalattia;
    }

    public void setGiorniMalattia(int giorniMalattia) {
        this.giorniMalattia = giorniMalattia;
    }

    public int getFerie() {
        return ferie;
    }

    public void setFerie(int ferie) {
        this.ferie = ferie;
    }

    public double getPremiProduzione() {
        return premiProduzione;
    }

    public void setPremiProduzione(double premiProduzione) {
        this.premiProduzione = premiProduzione;
    }

    public List<String> getBeneficiMaterialiAziendali() {
        return beneficiMaterialiAziendali;
    }

    public void setBeneficiMaterialiAziendali(List<String> beneficiMaterialiAziendali) {
        this.beneficiMaterialiAziendali = beneficiMaterialiAziendali;
    }
}
