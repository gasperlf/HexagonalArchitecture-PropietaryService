package com.powerup.user.infraestructure.configuration.security;

import com.google.gson.Gson;
import com.powerup.user.domain.model.Role;
import com.powerup.user.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SecurityTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "Admin",roles = "ADMIN")
    public void adminRoleCreatingProprietary() throws Exception{
        User user = new User(
                1L,
                "ProprietaryTestuser",
                "LastnameUser",
                "+573013265935",
                "testuser@gmail.com",
                "12345",
                new Role(
                        2L,
                        "ROLE_PROPRIETARY",
                        "Proprietary"
                ),
                "9610235698"
        );

        Gson gson = new Gson();
        String json = gson.toJson(user);


        mockMvc.perform(post("/user/proprietary")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "Proprietary", roles = "PROPRIETARY")
    public void proprietaryCreatingAnEmployee() throws Exception{
        User user = new User(
                1L,
                "EmployeeTestuser",
                "LastnameUser",
                "+573013265938",
                "employeetestuser@gmail.com",
                "12345",
                new Role(
                        3L,
                        "ROLE_EMPLOYEE",
                        "Employee"
                ),
                "9610235691"
        );

        Gson gson = new Gson();
        String json = gson.toJson(user);

        mockMvc.perform(post("/user/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "Client")
    public void clientCreatingAndAccountByHimself() throws Exception{
        User user = new User(
                1L,
                "ClientTestuser",
                "LastnameUser",
                "+573013265944",
                "clienttestuser@gmail.com",
                "12345",
                new Role(
                        4L,
                        "ROLE_CLIENT",
                        "Client"
                ),
                "9610235691"
        );

        Gson gson = new Gson();
        String json = gson.toJson(user);

        mockMvc.perform(post("/user/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }
}