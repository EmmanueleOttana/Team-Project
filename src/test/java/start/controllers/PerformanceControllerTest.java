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
import start.entities.Performance;
import start.entities.TypeOfContract;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class PerformanceControllerTest {

    /**
     * TODO Da sistemare la classe Performance : Richiede l'Employee
     */

    @Autowired
    private PerformanceController performanceController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void performanceControllerLoads(){
        assertThat(performanceController).isNotNull();
    }

    private final Employee testEmployee = new Employee("Test1"
            , "SurnameTest1"
            , "testFiscalCode01"
            , "Tipo Di Lavoro Test"
            , TypeOfContract.INTERNSHIP
            , ContractDuration.FULL_TIME
            , "1999-12-12"
            ,12.5);


    private Performance createPerformance() throws Exception{
        return new Performance(1,1,"TestReview",1,1,1);
    }
    private void createAPerformanceRequest(Performance performance)throws Exception{
        if (performance == null) return;
        String performanceJSON = objectMapper.writeValueAsString(performance);
        this.mockMvc.perform(post("/performance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(performanceJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Performance getPerformance(MvcResult result) throws Exception{
        String performanceJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(performanceJSON, Performance.class);
    }

    @Test
    void createAPerformanceTest()throws Exception{
        Performance performanceFromResponse = createPerformance();
        createAPerformanceRequest(performanceFromResponse) ;
    }

    @Test
    void getPerformanceFromID()throws Exception {
        createAPerformanceTest();
        this.mockMvc.perform(get("/performance/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readPerformanceList()throws Exception{
        createAPerformanceTest();
        this.mockMvc.perform(get("/performance"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePerformance()throws Exception{
        createAPerformanceTest();
        this.mockMvc.perform(delete("/performance/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
