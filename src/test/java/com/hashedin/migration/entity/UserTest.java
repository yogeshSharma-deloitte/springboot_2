package com.hashedin.migration.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("password");
        user.setEmail("test@gmail.com");

        assertEquals(1L, user.getId());
        assertEquals("test", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("test@gmail.com", user.getEmail());
    }

    @Test
    public void testUserWithParameters() {
        User user = new User("test", "password", "test@gmail.com");

        assertEquals("test", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("test@gmail.com", user.getEmail());
    }

    @Test
    public void testSetters() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("password");
        user.setEmail("test@gmail.com");

        assertEquals(1L, user.getId());
        assertEquals("test", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("test@gmail.com", user.getEmail());
    }
}