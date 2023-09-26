package com.hashedin.migration.services;

import com.hashedin.migration.entity.User;
import com.hashedin.migration.repository.UserRepository;
import com.hashedin.migration.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getAllUsersTest() {
        User user = new User();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setEmail("test@gmail.com");
        when(userRepository.save(user)).thenReturn(user);
        User result = userService.saveUser(user);
        assertNotNull(result);
    }

    @Test
    public void editUserTest() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("password");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        User result = userService.editUser(1L, user);
        assertNotNull(result);
    }

    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        userService.deleteUser(1L);
        assertNotNull(user);
    }

    @Test
    public void getProductCountTest() {
        when(productRepository.count()).thenReturn(1L);
        Long result = userService.getProductCount();
        assertEquals(1L, result);
    }
}