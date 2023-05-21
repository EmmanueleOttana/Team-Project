package start.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import start.entities.Employee;
import start.services.EmployeeService;
import start.services.PayrollService;

@Component
public class EmployeeDTO {
    private long idEmployee;
    private String name;
    private String surname;
    private String typeOfContract;
    private String oreEffettuate;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PayrollService payrollService;

    public EmployeeDTO(Employee employee) {
        this.setIdEmployee(employee.getId());
        this.setName(employee.getName());
        this.setSurname(employee.getSurname());
        this.setTypeOfContract(employee.getTypeOfContract().getDisplayType());
        this.setOreEffettuate(String.valueOf(payrollService.calculateHours(employee.getId())));
    }

    public EmployeeDTO() {
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public String getOreEffettuate() {
        return oreEffettuate;
    }

    public void setOreEffettuate(String oreEffettuate) {
        this.oreEffettuate = oreEffettuate;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    @Override
    public String toString() {
        return "{" +
                "\nID_Dipendente : " + idEmployee +
                "\nNome : " + name +
                "\nCognome : " + surname +
                "\nTipo_Di_Contratto : " + typeOfContract +
                "\nOre_Effettuate : " + oreEffettuate +
                "\n}";
    }


}
