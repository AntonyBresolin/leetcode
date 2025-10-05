package org.example.treinamento_tdd.strategy;

import org.example.treinamento_tdd.CalculoBonusStrategy;

import java.math.BigDecimal;

public class CalculoBonusGerenteStrategy implements CalculoBonusStrategy {
    private static final BigDecimal BONUS_GERENTE = new BigDecimal("0.15");
    private static final BigDecimal BONIFICACAO_EXTRA_GERENTE = new BigDecimal("1000.0");

    @Override
    public BigDecimal calcular(BigDecimal totalVendas) {
        return totalVendas.multiply(BONUS_GERENTE).add(BONIFICACAO_EXTRA_GERENTE);
    }
}