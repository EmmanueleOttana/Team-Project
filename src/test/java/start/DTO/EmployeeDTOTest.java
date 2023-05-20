package start.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class EmployeeDTOTest {
    @Autowired
    EmployeeDTO employeeDTO;

    @Test
    void testDTO(){
        System.out.println(employeeDTO.toString());
    }

}