package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AgruparPalavrasPorAnagramasTest {

    @Test
    void should_return_correct_anagram() {
        // Arrange
        String[] palavras = {"roma", "amor", "casa", "saca", "mar", "ram"};

        // Act
        Map<String, List<String>> result = AgruparPalavrasPorAnagramas.agrupadorDeAnagramas(palavras);

        // Assert
        assertEquals(2, result.get("amor").size());
        assertEquals(2, result.get("amr").size());
        assertEquals(2, result.get("aacs").size());
    }

}