package start.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import start.DTO.EmployeeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Component
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String codiceFiscale;
    @Column
    private String typeOfWork;
    @Enumerated(EnumType.ORDINAL)
    private TypeOfContract typeOfContract;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private double pagaOraria;
    @Column
    private LocalDateTime accessBadge;
    @Transient
    private LocalTime workHours; //ore di lavoro giornaliero
    @Transient
    private String userName;
    @Transient
    private EmployeeDTO employeeDTO = new EmployeeDTO();

    public Employee(String name,
                    String surname,
                    String codiceFiscale,
                    String typeOfWork,
                    TypeOfContract typeOfContract,
                    String dateOfBirth,
                    double pagaOraria)
    {
        this.name = name;
        this.surname = surname;
        this.codiceFiscale = codiceFiscale;
        this.typeOfWork = typeOfWork;
        this.typeOfContract = typeOfContract;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.pagaOraria = pagaOraria;
    }
    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public EmployeeDTO assignEmployeeDTO() {
        this.employeeDTO.setIdEmployee(this.getId());
        this.employeeDTO.setName(this.getName());
        this.employeeDTO.setSurname(this.getSurname());
        this.employeeDTO.setTypeOfContract(this.getTypeOfContract().getDisplayType());
        return this.employeeDTO;
    }
    public String assignUserName() {
        this.userName = this.id + this.surname + this.name;
        return this.userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public TypeOfContract getTypeOfContract() { return typeOfContract; }

    public void setTypeOfContract(TypeOfContract typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getAccessBadge() { return accessBadge; }

    public void setAccessBadge(LocalDateTime accessBadge) { this.accessBadge = accessBadge; }

    public LocalTime getWorkHours() { return workHours; }

    public double getPagaOraria() {
        return pagaOraria;
    }

    public void setPagaOraria(double pagaOraria) {
        this.pagaOraria = pagaOraria;
    }

    public void setWorkHours(int workMinutes) {
        if(workMinutes >= 60) {
            int hours = workMinutes / 60;
            int minutes = workMinutes % 60;
            this.workHours = LocalTime.of(hours,minutes);
        }else {
            this.workHours = LocalTime.of(0,workMinutes);
        }
    }

    public void resetAccess(){ this.accessBadge = null; this.workHours = null; }

    @Override
    public String toString() {
        return "Employees{" +
                "name= " + this.name +
                ", surname= " + this.surname +
                ", ID= " + this.id +
                ", CodiceFiscale= " + this.codiceFiscale +
                ", typeOfWork= " + this.typeOfWork +
                ", typeOfContract= " + this.typeOfContract +
                ", dateOfBirth= " + this.dateOfBirth +
                ", isAtWork?= " + (this.accessBadge != null) +
                '}';
    }

}
