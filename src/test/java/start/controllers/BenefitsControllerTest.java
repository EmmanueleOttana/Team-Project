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
import start.entities.Benefits;
import start.entities.ContractDuration;
import start.entities.Employee;
import start.entities.TypeOfContract;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class BenefitsControllerTest {

    @Autowired
    private BenefitsController benefitsController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void benefitsControllerLoads(){
        assertThat(benefitsController).isNotNull();
    }

    private final List<String> benefitsCorpMat = new ArrayList<>();
    private final Employee testEmployee = new Employee("Test1"
            , "SurnameTest1"
            , "testFiscalCode01"
            , "Tipo Di Lavoro Test"
            , TypeOfContract.INTERNSHIP
            , ContractDuration.FULL_TIME
            , "1999-12-12"
            ,12.5);

    private Benefits createBenefits() throws Exception{

        return new Benefits(1,
                 testEmployee,
                1,
                1,
                1,
                2.0,
                benefitsCorpMat);
    }
    private void createABenefitsRequest(Benefits benefits)throws Exception{
        if (benefits == null) return;
        String benefitsJSON = objectMapper.writeValueAsString(benefits);
        this.mockMvc.perform(post("/benefits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(benefitsJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Benefits getBenefits(MvcResult result) throws Exception{
        String benefitsJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(benefitsJSON, Benefits.class);
    }

    @Test
    void createABenefitsTest()throws Exception{
        Benefits benefitsFromResponse = createBenefits();
        createABenefitsRequest(benefitsFromResponse);
    }

    @Test
    void getBenefitsFromID()throws Exception {
        createABenefitsTest();
        this.mockMvc.perform(get("/benefits/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readBenefitsList()throws Exception{
        createABenefitsTest();
        this.mockMvc.perform(get("/benefits"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /*@Test
    void updateBenefits()throws Exception{
        createABenefitsTest();
        Benefits newBenefits = new Benefits(1,
                "Test2",
                "TestPassword2",
                "TestRole2",
                "TestAuth2");
        String benefitsJSON = objectMapper.writeValueAsString(newBenefits);
        this.mockMvc.perform(put("/benefits/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(benefitsJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }*/
    @Test
    void deleteBenefits()throws Exception{
        createABenefitsTest();
        this.mockMvc.perform(delete("/benefits/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
