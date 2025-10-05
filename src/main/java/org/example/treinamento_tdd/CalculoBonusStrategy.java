package org.example.treinamento_tdd;

import java.math.BigDecimal;

public interface CalculoBonusStrategy {
    BigDecimal calcular(BigDecimal totalVendas);
}
