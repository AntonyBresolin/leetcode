package org.example.treinamento_tdd;

import org.example.treinamento_tdd.strategy.CalculoBonusGerenteStrategy;
import org.example.treinamento_tdd.strategy.CalculoBonusSupervisorStrategy;
import org.example.treinamento_tdd.strategy.CalculoBonusVendedorStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class CalculadoraDeBonus {
    private final Logger logger; // TODO - ESTUDAR ESSA ESTRUTURA
    private final Map<Cargo, CalculoBonusStrategy> bonusStrategies = new EnumMap<>(Cargo.class);

    public CalculadoraDeBonus(Logger logger) {
        this.logger = logger;

        bonusStrategies.put(Cargo.VENDEDOR, new CalculoBonusVendedorStrategy());
        bonusStrategies.put(Cargo.GERENTE, new CalculoBonusGerenteStrategy());
        bonusStrategies.put(Cargo.SUPERVISOR, new CalculoBonusSupervisorStrategy());
    }

    private static final BigDecimal META_MINIMA = BigDecimal.valueOf(10000.0);

    private static final BigDecimal BONUS_TEMPO_DE_CASA = BigDecimal.valueOf(0.02);
    private static final BigDecimal BONUS_CAMPANHA_ESPECIAL = BigDecimal.valueOf(500.0);
    private static final int TEMPO_DE_CASA_PARA_BONUS_ADICIONAL = 5;

    private static final BigDecimal BONUS_NAO_BATER_META = BigDecimal.valueOf(0.0);

    public static class Pessoa {
        private Cargo cargo;
        private int anosDeCasa;

        @SuppressWarnings("unused")
        public Pessoa() {
        }

        public Pessoa(Cargo cargo, int anosDeCasa) {
            this.cargo = cargo;
            this.anosDeCasa = anosDeCasa;
        }

        public Cargo getCargo() { return cargo; }

        public int getAnosDeCasa() { return anosDeCasa; }
    }

    public enum Cargo {
        VENDEDOR, GERENTE, SUPERVISOR;
    }

    public BigDecimal calcularBonus(Pessoa pessoa, BigDecimal totalVendas, boolean campanhaEspecialAtiva) {
        BigDecimal bonus = BigDecimal.ZERO;

        BigDecimal bonusNaoBaterMeta = validarMetaBatida(totalVendas);
        if (bonusNaoBaterMeta != null) return bonusNaoBaterMeta;

        logger.log("LOG: Meta de vendas atingida. Calculando bônus...");

        bonus = bonus.add(calcularBonusPorCargo(pessoa, totalVendas));
        bonus = bonus.add(calcularBonusPorTempoDeCasa(pessoa, totalVendas));
        bonus = bonus.add(calcularBonusCampanhaEspecial(campanhaEspecialAtiva));

        logger.log("LOG: Bônus final calculado para " + pessoa.cargo + ": " + bonus);
        return bonus.setScale(1, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularBonusCampanhaEspecial(boolean campanhaEspecialAtiva) {
        BigDecimal bonus = BigDecimal.ZERO;
        if (campanhaEspecialAtiva) {
            bonus = bonus.add(BONUS_CAMPANHA_ESPECIAL);
            logger.log("LOG: Bônus de campanha especial aplicado: +500.0");
        }
        return bonus;
    }

    private BigDecimal calcularBonusPorTempoDeCasa(Pessoa pessoa, BigDecimal totalVendas) {
        if (pessoa.getAnosDeCasa() >= TEMPO_DE_CASA_PARA_BONUS_ADICIONAL) {
            BigDecimal bonusTempoCasa = totalVendas.multiply(BONUS_TEMPO_DE_CASA);
            logger.log("LOG: Adicional por tempo de casa aplicado: " + BONUS_TEMPO_DE_CASA);
            return bonusTempoCasa;
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal calcularBonusPorCargo(Pessoa pessoa, BigDecimal totalVendas) {
        CalculoBonusStrategy strategy = bonusStrategies.get(pessoa.getCargo());
        if (strategy == null) throw new IllegalArgumentException("Estratégia não existe para o cargo atual");

        BigDecimal bonus = strategy.calcular(totalVendas);
        logger.log("LOG: Bônus base de "+pessoa.getCargo()+" calculado: " + bonus);
        return bonus;
    }

    private BigDecimal validarMetaBatida(BigDecimal totalVendas) {
        if (totalVendas.compareTo(META_MINIMA) < 0) {
            logger.log("LOG: Funcionário não atingiu a meta de vendas. Bônus zerado.");
            return BONUS_NAO_BATER_META;
        }
        return null;
    }


}