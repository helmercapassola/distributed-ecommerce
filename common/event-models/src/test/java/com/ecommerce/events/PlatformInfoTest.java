package com.ecommerce.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatformInfoTest {

    @Test
    void shouldReturnCorrectPlatformName() {

        String expectedName =
                "Distributed E-commerce Event Streaming Platform";

        String actualName = PlatformInfo.getName();

        assertEquals(expectedName, actualName);
    }
}