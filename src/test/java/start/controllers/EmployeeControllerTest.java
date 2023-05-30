package start.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import start.entities.ContractDuration;
import start.entities.Employee;
import start.entities.TypeOfContract;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void employeeControllerLoads(){
        assertThat(employeeController).isNotNull();
    }
    private Employee createEmployee() throws Exception{
        return new Employee("Test1"
                , "SurnameTest1"
                , "testFiscalCode01"
                , "Tipo Di Lavoro Test"
                , TypeOfContract.INTERNSHIP
                , ContractDuration.FULL_TIME
                , "1999-12-12"
                ,12.5);
    }

    private void createAnEmployeeRequest(Employee employee)throws Exception{
        if (employee==null) return;
        String employeeJSON = objectMapper.writeValueAsString(employee);
        this.mockMvc.perform(post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Employee getEmployee(MvcResult result) throws Exception{
        String employeeJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(employeeJSON, Employee.class);
    }

    @Test
    void createAnEmployeeTest()throws Exception{
        Employee employeeFromResponse = createEmployee();
        createAnEmployeeRequest(employeeFromResponse);
    }

    @Test
    void getEmployeeFromID()throws Exception {
        createAnEmployeeTest();
        this.mockMvc.perform(get("/employee/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readEmployeeList()throws Exception{
        createAnEmployeeTest();
        this.mockMvc.perform(get("/employee/getAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void updateEmployee()throws Exception{
        createAnEmployeeTest();
        Employee newEmployee = new Employee("Test2"
                , "SurnameTest2"
                , "testFiscalCode02"
                , "Tipo Di Lavoro Test 2"
                , TypeOfContract.INTERNSHIP
                , ContractDuration.FULL_TIME
                , "1991-04-14"
                ,27.5);
        String employeeJSON = objectMapper.writeValueAsString(newEmployee);
        this.mockMvc.perform(put("/employee/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void deleteEmployee()throws Exception{
        createAnEmployeeTest();
        this.mockMvc.perform(delete("/employee/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}