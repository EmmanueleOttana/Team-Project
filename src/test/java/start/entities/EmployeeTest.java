package start.entities;

import jakarta.persistence.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("Harry", "Potter", "PTTHRY80L31E098E",
            "Programmatore", TypeOfContract.OPEN_ENDED, ContractDuration.FULL_TIME, "1980-07-31", 10);

    @Test
    void assignEmployeeDTO() {
        employee.assignEmployeeDTO();
        System.out.println(employee.assignEmployeeDTO());
    }
}