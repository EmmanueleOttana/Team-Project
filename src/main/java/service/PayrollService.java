package service;

import entity.ContractsEntity;
import entity.PayrollEntity;

public class PayrollService
{
    public PayrollEntity payrollEntity;
    public ContractsEntity contractsEntity;
    private boolean employeeWork;
    public double calculatePayRoll(double getOreEffettuate){
        if(employeeWork) {
            double stipendioBase = this.contractsEntity.getWage();
            double straordinari = 0.0;
            if (payrollEntity.getOreEffettuate() > this.contractsEntity.getHoursContract()) {
                straordinari = getOreEffettuate - this.contractsEntity.getHoursContract();
                getOreEffettuate = this.contractsEntity.getHoursContract();
            }
            double totaleRetribuzione = (getOreEffettuate * stipendioBase) + (straordinari * stipendioBase * 1.5);
            double trattenute = totaleRetribuzione * (this.payrollEntity.getTrattenuteStato() / 100);
            double retribuzioneLorda = totaleRetribuzione - trattenute;
            double irpef = 0.0;
            if (retribuzioneLorda > 15000) {
                irpef = (retribuzioneLorda - 150000) * 0.2;
            }
            double retribuzioneNetta = retribuzioneLorda - irpef;
            return retribuzioneNetta;
        }
        else
        {
            return 0;
        }
    }
}
