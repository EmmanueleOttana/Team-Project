package start.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Contracts;
import start.entities.Employee;
import start.entities.Payroll;
import start.repositories.EmployeeRepository;
import start.repositories.PayrollRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    private Contracts contracts;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    PayrollRepository payrollRepository;

    PayrollService payrollService;



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
        } else if (redditoImponibile > 15001 && redditoImponibile <= 28000) {
            irpef = 3450 + ((redditoImponibile - 15001) * 0.25);
        } else if (redditoImponibile > 28001 && redditoImponibile <= 50000) {
            irpef = 6700 + ((redditoImponibile - 28001) * 0.35);
        } else if (redditoImponibile > 50001 ) {
            irpef = 14400 + ((redditoImponibile - 50001) * 0.43);
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
        for (LocalTime time : employeeService.getSingleEmployeeHours(employee).values()) {
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
    // Custom and CRUD calls
    public List<Payroll> getAllPayrolls()throws Exception{
        List<Payroll> allPayrollsFromDB = payrollRepository.findAll();
        if (allPayrollsFromDB.isEmpty()){
            throw new Exception("No Payrolls found!");
        }
        return allPayrollsFromDB;
    }
    public Payroll newPayroll(Payroll payroll)throws Exception {
        try {
            if (payroll == null) return null;
            return payrollRepository.saveAndFlush(payroll);
        } catch (Exception e) {
            throw new Exception("Payroll not found");
        }
    }
    public Optional<Payroll> getSinglePayrollByID(long id) throws Exception{
        try {
            return payrollRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
    public void deletePayrollByID(long id) throws Exception{
        try {
            payrollRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
    public Payroll calculatePayrollByID(long id) throws Exception {
        try {
            return payrollRepository.saveAndFlush(payrollService.
                    calculatePayRoll(employeeRepository.findById(id).get()));
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
}