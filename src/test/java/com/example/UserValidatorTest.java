package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    void acceptsTypicalAge() {
        assertTrue(validator.isValidAge(30));
    }

    @Test
    void acceptsTypicalUsername() {
        assertTrue(validator.isValidUsername("alice"));
    }

    @Test
    void normalizesNonNullEmail() {
        assertNotNull(validator.normalizeEmail("Alice@Example.com"));
    }
}
