package start.services;
import org.springframework.stereotype.Service;
import start.entities.Dismissal;
import start.entities.Employee;

@Service
public class DismissalService {

    public Employee employee;
    public Dismissal dismissal;
    public String getTypeOfDismissal() {
        if (dismissal.getReasonsOfDismissal().contains("giusta causa")) {
            return "Licenziamento per giusta causa";
        } else if (dismissal.getReasonsOfDismissal().contains("superamento periodo di prova")) {
            return "Licenziamento per superamento periodo di prova";
        } else {
            return "Licenziamento per altri motivi";
        }
    }
    public String printInfo() {
        return "ID: " + dismissal.getId() +" "+
                "Data di licenziamento: " + dismissal.getDataLicenziamento()+" "+
                "Motivo del licenziamento: " + getTypeOfDismissal()+" "+
                "Livello di esperienza del dipendente: " + dismissal.getExperienceLevel();
    }
}