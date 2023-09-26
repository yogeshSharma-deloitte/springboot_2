package com.hashedin.migration.controllers;

import com.hashedin.migration.entity.User;
import com.hashedin.migration.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

@Autowired
private MockMvc mockMvc;

@MockBean
private UserService userService;

@Test
public void getAllUsersTest() throws Exception {
User user = new User();
List<User> userList = Arrays.asList(user);
when(userService.getAllUsers()).thenReturn(userList);
mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
}

@Test
public void editUserTest() throws Exception {
User user = new User();
when(userService.editUser(1L, user)).thenReturn(user);
mockMvc.perform(MockMvcRequestBuilders.put("/users/1").content("{\"id\": 1, \"email\": \"user@gmail.com\"}").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
}

@Test
public void addUserTest() throws Exception {
User user = new User();
when(userService.saveUser(user)).thenReturn(user);
mockMvc.perform(MockMvcRequestBuilders.post("/users").content("{\"id\": 1, \"email\": \"user@gmail.com\"}").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
}

@Test
public void deleteUserTest() throws Exception {
mockMvc.perform(MockMvcRequestBuilders.delete("/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
}

}