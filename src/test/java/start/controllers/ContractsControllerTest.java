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
import start.entities.Contracts;
import start.entities.TypeOfContract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class ContractsControllerTest {
    @Autowired
    private ContractsController contractsController;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contractsControllerLoads(){
        assertThat(contractsController).isNotNull();
    }

    private Contracts createContracts() throws Exception{
        return new Contracts(TypeOfContract.TERM_CONTRACT
                ,
                1.0,
                1.0,
                true,
                false,
                1);
    }
    private void createAContractRequest(Contracts contracts)throws Exception{
        if (contracts == null) return;
        String contractJSON = objectMapper.writeValueAsString(contracts);
        this.mockMvc.perform(post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contractJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Contracts getContract(MvcResult result) throws Exception{
        String contractJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(contractJSON, Contracts.class);
    }

    @Test
    void createAContractTest()throws Exception{
        Contracts contractFromResponse = createContracts();
        createAContractRequest(contractFromResponse);
    }

    @Test
    void getContractsFromID()throws Exception {
        createAContractTest();
        this.mockMvc.perform(get("/contract/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readContractsList()throws Exception{
        createAContractTest();
        this.mockMvc.perform(get("/contract"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteContract()throws Exception{
        createAContractTest();
        this.mockMvc.perform(delete("/contract/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
