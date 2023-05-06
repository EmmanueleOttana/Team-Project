package start.services;

import org.springframework.stereotype.Service;
import start.entities.Contracts;
import start.entities.Payroll;

@Service
public class PayrollService {

    private Payroll payroll;
    private Contracts contracts;
    private boolean employeeWork;

    public double calculatePayRoll(double getOreEffettuate){
        if(employeeWork) {
            double stipendioBase = this.contracts.getWage();
            double straordinari = 0.0;
            if (payroll.getOreEffettuate() > contracts.getHoursContract()) {
                straordinari = getOreEffettuate - contracts.getHoursContract();
                getOreEffettuate =this.contracts.getHoursContract();
            }
            double totaleRetribuzione = (getOreEffettuate * stipendioBase) + (straordinari * stipendioBase * 1.5);
            double trattenute = totaleRetribuzione * (payroll.getTrattenuteStato() / 100);
            double retribuzioneLorda = totaleRetribuzione - trattenute;
            double irpef = 0.0;
            if (retribuzioneLorda > 15000) {
                irpef = (retribuzioneLorda - 150000) * 0.2;
            }
            double retribuzioneNetta = retribuzioneLorda - irpef;
            return retribuzioneNetta;
        }
            return 0;
    }


}