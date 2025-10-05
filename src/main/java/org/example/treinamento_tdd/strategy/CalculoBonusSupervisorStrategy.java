package org.example.treinamento_tdd.strategy;

import org.example.treinamento_tdd.CalculoBonusStrategy;

import java.math.BigDecimal;

public class CalculoBonusSupervisorStrategy implements CalculoBonusStrategy {
    private static final BigDecimal BONUS_SUPERVISOR = new BigDecimal("0.20");
    private static final BigDecimal BONIFICACAO_EXTRA_SUPERVISOR = new BigDecimal("1000.0");

    @Override
    public BigDecimal calcular(BigDecimal totalVendas) {
        return totalVendas.multiply(BONUS_SUPERVISOR).add(BONIFICACAO_EXTRA_SUPERVISOR);
    }
}