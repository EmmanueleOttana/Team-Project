package start.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import start.entities.Employee;
import start.services.EmployeeService;
import start.services.PayrollService;

@Component
public class EmployeeDTO {
    private long id;
    private String name;
    private String surname;
    private String typeOfContract;
    private String oreEffettuate;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PayrollService payrollService;

    public EmployeeDTO(Employee employee) {
        setId(employee.getId());
        setName(employee.getName());
        setSurname(employee.getSurname());
        setTypeOfContract(employee.getTypeOfContract().getDisplayType());
        setOreEffettuate(employeeService.convertFromLocalTime(payrollService.calculateHours(employee.getId())));
    }

    public EmployeeDTO() {
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", oreEffettuate='" + oreEffettuate + '\'' +
                '}';
    }
}
