package start.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Dismissal;
import start.entities.Employee;
import start.repositories.DismissalRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DismissalService {
    @Autowired
    private DismissalRepository dismissalRepository;

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

    public List<Dismissal> getAllDismissals() throws Exception{
        List<Dismissal> allDismissalsFromDB = dismissalRepository.findAll();
        if (allDismissalsFromDB.isEmpty()){
            throw new Exception("No Dismissal found!");
        }
        return allDismissalsFromDB;
    }

    public Dismissal newDismissal(Dismissal dismissal)throws Exception{
        try {
            if (dismissal==null) return null;
            return dismissalRepository.saveAndFlush(dismissal);
        }catch (Exception e){
            throw new Exception("Dismissal not found");
        }
    }
    public Optional<Dismissal> getDismissalById(long id) throws Exception{
        try {
            return dismissalRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deleteDismissalByID(long id)throws Exception{
        try {
            dismissalRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
}