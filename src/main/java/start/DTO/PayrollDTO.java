package start.DTO;

import org.springframework.stereotype.Component;
import start.entities.Employee;
import start.entities.Payroll;

@Component
public class PayrollDTO {

    private long idPayroll;
    private EmployeeDTO employeeDTO = new EmployeeDTO();
    private String oreEffettuate;
    private double retribuzioneLorda;
    private double retribuzioneNetta;

    public PayrollDTO(Payroll payroll, Employee employee) {
        this.setIdPayroll(payroll.getId());
        this.setEmployeeDTO(employee.assignEmployeeDTO());
        this.setOreEffettuate(String.valueOf(payroll.getOreEffettuate()));
        this.setRetribuzioneLorda(payroll.getRetribuzioneLorda());
        this.setRetribuzioneNetta(payroll.getRetribuzioneNetta());
    }

    public PayrollDTO() {
    }

    public void setIdPayroll(long idPayroll) {
        this.idPayroll = idPayroll;
    }

    public void setOreEffettuate(String oreEffettuate) {
        this.oreEffettuate = oreEffettuate;
    }

    public void setRetribuzioneLorda(double retribuzioneLorda) {
        this.retribuzioneLorda = retribuzioneLorda;
    }

    public void setRetribuzioneNetta(double retribuzioneNetta) {
        this.retribuzioneNetta = retribuzioneNetta;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "{" +
                "\nID_Busta_Paga : " + this.idPayroll +
                "\nID_Dipendente : " + this.employeeDTO.getIdEmployee() +
                "\nNome : " + this.employeeDTO.getName() +
                "\nCognome : " + this.employeeDTO.getSurname() +
                "\nTipo_Di_Contratto : " + this.employeeDTO.getTypeOfContract() +
                "\nOre_Effettuate : " + this.oreEffettuate +
                "\nRetribuzione_Lorda : " + this.retribuzioneLorda +
                "\nRetribuzione_Netta : " + this.retribuzioneNetta +
                "\n}";
    }
}
