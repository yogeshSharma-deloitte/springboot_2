package com.hashedin.migration.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testProduct() {
        Product product = new Product();
        Long id = 1L;
        String name = "Test Product";
        String description = "This is a test product";

        product.setId(id);
        product.setName(name);
        product.setDescription(description);

        assertNotNull(product);
        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
    }
}