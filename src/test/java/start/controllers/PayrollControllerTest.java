package start.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import start.entities.ContractDuration;
import start.entities.Employee;
import start.entities.Payroll;
import start.entities.TypeOfContract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class PayrollControllerTest {

    @Autowired
    private PayrollController payrollController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void payrollControllerLoads(){
        assertThat(payrollController).isNotNull();
    }

    private final Employee testEmployee = new Employee("Test1"
            , "SurnameTest1"
            , "testFiscalCode01"
            , "Tipo Di Lavoro Test"
            , TypeOfContract.INTERNSHIP
            , ContractDuration.FULL_TIME
            , "1999-12-12"
            ,12.5);
    private Payroll createPayroll() throws Exception{
        return new Payroll(testEmployee,
                1.0,
                1.0,
                1.0);
    }
    private void createAPayrollRequest(Payroll payroll)throws Exception{
        if (payroll == null) return;
        String payrollJSON = objectMapper.writeValueAsString(payroll);
        this.mockMvc.perform(post("/payroll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payrollJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Payroll getPayroll(MvcResult result) throws Exception{
        String payrollJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(payrollJSON, Payroll.class);
    }

    @Test
    void createAPayrollTest()throws Exception{
        Payroll payrollFromResponse = createPayroll();
        createAPayrollRequest(payrollFromResponse);
    }

    @Test
    void getPayrollFromID()throws Exception {
        createAPayrollTest();
        this.mockMvc.perform(get("/payroll/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readPayrollList()throws Exception{
        createAPayrollTest();
        this.mockMvc.perform(get("/payroll"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void deletePayroll()throws Exception{
        createAPayrollTest();
        this.mockMvc.perform(delete("/payroll/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
