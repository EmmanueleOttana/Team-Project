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
import start.entities.Dismissal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class DismissalControllerTest {

    @Autowired
    private DismissalController dismissalController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void dismissalControllerLoads(){
        assertThat(dismissalController).isNotNull();
    }

    private Dismissal createDismissal() throws Exception{
        return new Dismissal(1
                ,"1111-11-11"
                ,"testReason"
                ,1);
    }
    private void createAnAdminRequest(Dismissal dismissal)throws Exception{
        if (dismissal == null) return;
        String dismissalJSON = objectMapper.writeValueAsString(dismissal);
        this.mockMvc.perform(post("/dismissal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dismissalJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Dismissal getDismissal(MvcResult result) throws Exception{
        String dismissalJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(dismissalJSON, Dismissal.class);
    }

    @Test
    void createADismissalTest()throws Exception{
        Dismissal dismissalFromResponse = createDismissal();
        createAnAdminRequest(dismissalFromResponse);
    }

    @Test
    void getDismissalFromID()throws Exception {
        createADismissalTest();
        this.mockMvc.perform(get("/dismissal/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readDismissalList()throws Exception{
        createADismissalTest();
        this.mockMvc.perform(get("/dismissal"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteDismissal()throws Exception{
        createADismissalTest();
        this.mockMvc.perform(delete("/dismissal/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
