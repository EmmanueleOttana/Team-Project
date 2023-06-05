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
import start.entities.TypeOfWork;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class TypeOfWorkControllerTest {


    @Autowired
    private TypeOfWorkController typeOfWorkController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void adminControllerLoads(){
        assertThat(typeOfWorkController).isNotNull();
    }

    private TypeOfWork createTypeOfWork() throws Exception{
        return new TypeOfWork(1,"ManualTest","StaticTest","TransferTest");
    }
    private void createATypeOfWorkRequest(TypeOfWork typeOfWork)throws Exception{
        if (typeOfWork == null) return;
        String typeOfWorkJSON = objectMapper.writeValueAsString(typeOfWork);
        this.mockMvc.perform(post("/typeOfWork")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(typeOfWorkJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private TypeOfWork getTypeOfWork(MvcResult result) throws Exception{
        String typeOfWorkJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(typeOfWorkJSON, TypeOfWork.class);
    }

    @Test
    void createATypeOfWorkTest()throws Exception{
        TypeOfWork typeOfWorkFromResponse = createTypeOfWork();
        createATypeOfWorkRequest(typeOfWorkFromResponse);
    }

    @Test
    void getTypeOfWorkFromID()throws Exception {
        createATypeOfWorkTest();
        this.mockMvc.perform(get("/typeOfWork/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readTypeOfWorkList()throws Exception{
        createATypeOfWorkTest();
        this.mockMvc.perform(get("/typeOfWork"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteTypeOfWork()throws Exception{
        createATypeOfWorkTest();
        this.mockMvc.perform(delete("/typeOfWork/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
