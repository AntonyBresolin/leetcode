package org.example.treinamento_tdd.strategy;

import org.example.treinamento_tdd.CalculoBonusStrategy;

import java.math.BigDecimal;

public class CalculoBonusVendedorStrategy implements CalculoBonusStrategy {
    private static final BigDecimal BONUS_VENDEDOR = new BigDecimal("0.10");

    @Override
    public BigDecimal calcular(BigDecimal totalVendas) {
        return totalVendas.multiply(BONUS_VENDEDOR);
    }
}
