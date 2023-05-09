package start.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

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
    private LocalTime workHours; //ore di lavoro giornaliero
    @Column
    private LocalDateTime accessBadge;

    public Employee(String name,
                    String surname,
                    String codiceFiscale,
                    String typeOfWork,
                    TypeOfContract typeOfContract,
                    String dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        this.codiceFiscale = codiceFiscale;
        this.typeOfWork = typeOfWork;
        this.typeOfContract = typeOfContract;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
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
