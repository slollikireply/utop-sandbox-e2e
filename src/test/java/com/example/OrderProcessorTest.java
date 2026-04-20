package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OrderProcessorTest {

    private final OrderProcessor processor =
            new OrderProcessor(new PriceCalculator(), new UserValidator());

    @Test
    void quoteForValidCustomerProducesPositiveTotal() {
        assertTrue(processor.quote("alice", 30, 100.0) > 0);
    }
}
