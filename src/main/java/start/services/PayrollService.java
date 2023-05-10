package start.services;
import org.springframework.stereotype.Service;
import start.entities.Contracts;
import start.entities.Payroll;
@Service
public class PayrollService {
    private Payroll payroll;
    private Contracts contracts;
    public double calculatePayRoll(){
        double oreMensili = 0.0;
        double stipendioBase = contracts.getWage();
        double straordinari=0.0;
        if (payroll.getOreEffettuate()>contracts.getHoursContract()){
            straordinari = payroll.getOreEffettuate() - contracts.getHoursContract();
            oreMensili=contracts.getHoursContract()+straordinari;
        }
        System.out.println("ore fatte questo mese: " + oreMensili);
        double stipendioLordo= 0.0;
        double pagaOraria= 0.0;
        pagaOraria= contracts.getWage()/ contracts.getHoursContract();
        stipendioLordo=(contracts.getWage()+(straordinari*(pagaOraria*1.35)));
        System.out.println("Stipendio lordo: "+stipendioLordo);
        double inps = stipendioLordo * 0.0975;
        System.out.println("Inps: "+inps);
        double irpef = calcolaIrpef(stipendioLordo);
        System.out.println("Irpef: "+irpef);
        double altreTrattenute = payroll.getTrattenuteStato();
        System.out.println("altreTrattenute: " +altreTrattenute);
        double retribuzioneLorda = stipendioLordo - inps - irpef - altreTrattenute;
        double retribuzioneNetta = retribuzioneLorda - calcolaContributiPensionistici(retribuzioneLorda);
        return retribuzioneNetta;
    }
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
    private double calcolaContributiPensionistici(double retribuzioneLorda) {
        return retribuzioneLorda * 0.0919;
    }
}