package start.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Employee;
import start.services.EmployeeService;
import start.services.PayrollService;

public class EmployeeDTO {
    private long idDipendente;
    private String nome;
    private String cognome;
    private String tipoDiContratto;
    private String oreEffettuate;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PayrollService payrollService;

    public EmployeeDTO(Employee employee) {
        this.setIdDipendente(employee.getId());
        this.setNome(employee.getName());
        this.setCognome(employee.getSurname());
        this.setTipoDiContratto(employee.getTypeOfContract().getDisplayType());
        this.setOreEffettuate(String.valueOf(payrollService.calculateHours(employee.getId())));
    }

    public EmployeeDTO() {
    }

    public long getIdDipendente() {
        return idDipendente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipoDiContratto() {
        return tipoDiContratto;
    }

    public String getOreEffettuate() {
        return oreEffettuate;
    }

    public void setOreEffettuate(String oreEffettuate) {
        this.oreEffettuate = oreEffettuate;
    }

    public void setIdDipendente(long idDipendente) {
        this.idDipendente = idDipendente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTipoDiContratto(String tipoDiContratto) {
        this.tipoDiContratto = tipoDiContratto;
    }

    @Override
    public String toString() {
        return "{" +
                "\nID_Dipendente : " + idDipendente +
                "\nNome : " + nome +
                "\nCognome : " + cognome +
                "\nTipo_Di_Contratto : " + tipoDiContratto +
                "\nOre_Effettuate : " + oreEffettuate +
                "\n}";
    }


}
