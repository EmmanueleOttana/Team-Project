package start.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Contracts;
import start.entities.Employee;
import start.entities.Payroll;
import start.repositories.EmployeeRepository;
import java.time.LocalTime;

@Service
public class PayrollService {
    @Autowired
    private Contracts contracts;
    @Autowired
    private EmployeeRepository repoEmployee;

    /**
     * @param employee
     * @return La busta paga di un employee
     */
    public Payroll calculatePayRoll(Employee employee){
        double straordinari = 0.0;
        double oreEffettuate = converterLocalTime(calculateHours(employee));
        double oreDaContratto = employee.getTypeOfContract().getOreDaContratto();
        if ( oreEffettuate  > oreDaContratto ){
            straordinari = oreEffettuate - oreDaContratto;
        }
        System.out.println("ore fatte questo mese: " + oreEffettuate);
        contracts.setWage(employee.getPagaOraria() * oreEffettuate);
        double stipendioLordo= (contracts.getWage()+(straordinari*(employee.getPagaOraria()*1.35)));
        System.out.println("Stipendio lordo: "+stipendioLordo);
        double inps = stipendioLordo * 0.0975;
        System.out.println("Inps: "+inps);
        double irpef = calcolaIrpef(stipendioLordo);
        System.out.println("Irpef: "+irpef);
        //double altreTrattenute = payroll.getTrattenuteStato();
        //System.out.println("altreTrattenute: " +altreTrattenute);
        double tutteLeTrattenute = inps + irpef /*+ altreTrattenute*/;
        double retribuzioneLorda = stipendioLordo - tutteLeTrattenute;
        double retribuzioneNetta = retribuzioneLorda - calcolaContributiPensionistici(retribuzioneLorda);
        Payroll newPayroll = new Payroll(employee,
                tutteLeTrattenute,
                retribuzioneLorda,
                retribuzioneNetta);
        newPayroll.setOreEffettuate(calculateHours(employee));
        return newPayroll;
    }

    /**
     * @param stipendioLordo
     * @return Il calcolo dell'Irpef
     */
    private double calcolaIrpef(double stipendioLordo) {
        double irpef = 0;
        double redditoImponibile = stipendioLordo - 5000;
        if (redditoImponibile > 0 && redditoImponibile <= 15000) {
            irpef = redditoImponibile * 0.23;
        } else if (redditoImponibile > 15000 && redditoImponibile <= 28000) {
            irpef = 3450 + ((redditoImponibile - 15000) * 0.27);
        } else if (redditoImponibile > 28000 && redditoImponibile <= 55000) {
            irpef = 6960 + ((redditoImponibile - 28000) * 0.38);
        } else if (redditoImponibile > 55000 && redditoImponibile <= 75000) {
            irpef = 17220 + ((redditoImponibile - 55000) * 0.41);
        } else if (redditoImponibile > 75000) {
            irpef = 25420 + ((redditoImponibile - 75000) * 0.43);
        }
        return irpef;
    }

    /**
     * @param retribuzioneLorda
     * @return i contributi pensionistici
     */
    private double calcolaContributiPensionistici(double retribuzioneLorda) {
        return retribuzioneLorda * 0.0919;
    }

    /**
     * Converte un LocalTime in un Float
     * @param localTime
     * @return Float
     */
    public float converterLocalTime(LocalTime localTime){
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();
        String converter = hours + "." + minutes;
        return Float.parseFloat(converter);
    }
    /**
     * @param employee
     * @return Somma tutte le ore mensili effettuate da un singolo dipendente.
     */
    public LocalTime calculateHours(Employee employee) {
        int hours = 0;
        int minutes = 0;
        for (LocalTime time : repoEmployee.getSingleEmployeeHours(employee).values()) {
            hours += time.getHour();
            minutes += time.getMinute();
        }
        if(minutes < 60) return LocalTime.of(hours,minutes);
        else {
            hours += (minutes / 60);
            minutes = minutes % 60;
            return LocalTime.of(hours,minutes);
        }
    }



}