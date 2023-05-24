package start.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.DTO.PayrollDTO;
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
    private EmployeeRepository employeeRepository;
    @Autowired
    private PayrollRepository payrollRepository;

    public PayrollService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public PayrollService() {
    }

    /**
     * @param employee
     * @return La busta paga di un employee
     */
    public Object[] calculatePayRoll(Employee employee){
        double straordinari = 0.0;
        double oreEffettuate = calculateHours(employee.getId());
        double oreDaContratto = twoDigits(employee.getContractDuration().getOreDaContratto());
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
                twoDigits(tutteLeTrattenute),
                twoDigits(retribuzioneLorda),
                twoDigits(retribuzioneNetta));
        newPayroll.setOreEffettuate(twoDigits(oreEffettuate));
        PayrollDTO payrollDTO = newPayroll.assignPayrollDTO();
        payrollDTO.setDipendente(employee.assignEmployeeDTO());
        payrollDTO.getDipendente().setOreEffettuate(convertFromDouble(newPayroll.getOreEffettuate()));
        return new Object[]{newPayroll,payrollDTO};
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
     * Converte un LocalTime in un Double
     * @param localTime
     * @return Double
     */
    public double converterLocalTime(LocalTime localTime){
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();
        String converter = hours + "." + minutes;
        return Double.parseDouble(converter);
    }

    /**
     * Converte in stringa un Double rendendo il formato più leggibile
     * @param number
     * @return il nuovo formato di ore e minuti
     */
    public String convertFromDouble(double number){
        String crop = String.valueOf(number);
        String cents = crop.substring(crop.indexOf('.')+2);
        if( cents.isEmpty() ) return crop.replaceAll("\\.", "h0")+"'";
        return crop.replaceAll("\\.", "h")+"'";
    }

    /**
     * @param idEmployee
     * @return Somma tutte le ore mensili effettuate da un singolo dipendente.
     */
    public Double calculateHours(long idEmployee) {
        Employee employee = employeeRepository.findById(idEmployee).orElseThrow();
        int hours = 0;
        int minutes = 0;
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        for (LocalTime time : employeeService.getSingleEmployeeHours(employee).values()) {
            hours += time.getHour();
            minutes += time.getMinute();
        }
        if (minutes >= 60) {
            hours += (minutes / 60);
            minutes = minutes % 60;
        }
        return Double.parseDouble(hours + "."
                + (minutes < 10 ? "0" + minutes : minutes));
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
    public PayrollDTO calculatePayrollByID(long id) throws Exception {
        try {
            Object[] payrollComplete = calculatePayRoll(employeeRepository.findById(id).orElseThrow());
            Payroll payroll = (Payroll) payrollComplete[0];
            PayrollDTO payrollDTO = (PayrollDTO) payrollComplete[1];
            payrollRepository.saveAndFlush(payroll);
            payrollDTO.setIdBustaPaga(payroll.getId());
            return payrollDTO;
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
    public double twoDigits(double numberDouble){
        int number = (int) (numberDouble *100);
        return (double) number /100;
    }

}