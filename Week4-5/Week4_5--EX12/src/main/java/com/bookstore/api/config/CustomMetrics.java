package com.bookstore.api.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter bookCreationCounter;
    private final Gauge activeUsersGauge;

    public CustomMetrics(MeterRegistry meterRegistry) {
        // Define a custom counter
        this.bookCreationCounter = meterRegistry.counter("book_creation_total", "type", "book");

        // Define a custom gauge
        this.activeUsersGauge = Gauge.builder("active_users", this, CustomMetrics::getActiveUsers)
                                      .description("Number of active users")
                                      .register(meterRegistry);
    }

    // Example method to increment the counter
    public void incrementBookCreationCounter() {
        bookCreationCounter.increment();
    }

    // Example method to get the number of active users (dummy implementation)
    private int getActiveUsers() {
        return 42; // Replace with actual logic
    }
}
