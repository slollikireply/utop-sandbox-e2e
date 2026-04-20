package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OrderProcessorTest {

    private final OrderProcessor processor =
            new OrderProcessor(new PriceCalculator(), new UserValidator());

    @Test
    void quoteForValidCustomerProducesPositiveTotal() {
        assertTrue(processor.quote("alice", 30, 100.0) > 0);
    }

    @Test
    void quoteThrowsExceptionForInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.quote("invalid_user", 30, 100.0);
        });
    }

    @Test
    void quoteThrowsExceptionForInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.quote("alice", 15, 100.0);
        });
    }

    @Test
    void quoteAppliesSeniorDiscountCorrectly() {
        double total = processor.quote("alice", 65, 100.0);
        assertTrue(total < processor.quote("alice", 64, 100.0));
    }
}
