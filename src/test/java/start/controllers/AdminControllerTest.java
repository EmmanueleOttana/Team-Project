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
import start.entities.Admin;


import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void adminControllerLoads(){
        assertThat(adminController).isNotNull();
    }

    private Admin createAdmin() throws Exception{
        return new Admin(1,
                "Test1",
                "TestPassword1",
                "TestRole1",
                "TestAuth1");
    }
    private void createAnAdminRequest(Admin admin)throws Exception{
        if (admin == null) return;
        String adminJSON = objectMapper.writeValueAsString(admin);
        this.mockMvc.perform(post("/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(adminJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    private Admin getAdmin(MvcResult result) throws Exception{
        String adminJSON = result.getResponse().getContentAsString();
        return objectMapper.readValue(adminJSON, Admin.class);
    }

    @Test
    void createAnAdminTest()throws Exception{
        Admin adminFromResponse = createAdmin();
        createAnAdminRequest(adminFromResponse);
    }

    @Test
    void getAdminFromID()throws Exception {
        createAnAdminTest();
        this.mockMvc.perform(get("/admin/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void readAdminList()throws Exception{
        createAnAdminTest();
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /*@Test
    void updateAdmin()throws Exception{
        createAnAdminTest();
        Admin newAdmin = new Admin(1,
                "Test2",
                "TestPassword2",
                "TestRole2",
                "TestAuth2");
        String adminJSON = objectMapper.writeValueAsString(newAdmin);
        this.mockMvc.perform(put("/admin/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(adminJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }*/
    @Test
    void deleteAdmin()throws Exception{
        createAnAdminTest();
        this.mockMvc.perform(delete("/admin/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
