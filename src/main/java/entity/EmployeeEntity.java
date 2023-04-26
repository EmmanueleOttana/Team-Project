package entity;

import jakarta.persistence.*;
import repository.TypeOfContract;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private static int totalIdEmployees;
    private String codiceFiscale;
    private String typeOfWork;
    private TypeOfContract typeOfContract;
    private final LocalDate dateOfBirth;
    private LocalTime workHours; //ore di lavoro giornaliero
    private LocalDateTime accessBadge;

    public EmployeeEntity(String name,
                          String surname,
                          String codiceFiscale,
                          String typeOfWork,
                          TypeOfContract typeOfContract,
                          String dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        totalIdEmployees ++;
        this.id = totalIdEmployees;
        this.codiceFiscale = codiceFiscale;
        this.typeOfWork = typeOfWork;
        this.typeOfContract = typeOfContract;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTypeOfContract() { return typeOfContract.toString(); }

    public void setTypeOfContract(TypeOfContract typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getAccessBadge() { return accessBadge; }

    public void setAccessBadge(LocalDateTime accessBadge) { this.accessBadge = accessBadge; }

    public LocalTime getWorkHours() { return workHours; }

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
