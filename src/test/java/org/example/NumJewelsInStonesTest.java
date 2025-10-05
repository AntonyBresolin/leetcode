package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumJewelsInStonesTest {

    @Test
    void shouldReturnTwoStones() {
        // Arrange
        String jewels = "aA";
        String stones = "aAbbbb";

        // Act
        int result = NumJewelsInStones.returnNumJewelsInStones(jewels, stones);

        // Assert
        assertEquals(2, result);
    }

}