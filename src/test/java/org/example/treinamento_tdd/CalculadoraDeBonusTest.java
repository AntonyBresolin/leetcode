package org.example.treinamento_tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculadoraDeBonusTest {

    @Mock
    Logger logger;

    @InjectMocks
    CalculadoraDeBonus calculadoraDeBonus;

    @Test
    public void vendedorComMetaETempoDeCasaECampanha() {
        CalculadoraDeBonus.Pessoa pessoa = new CalculadoraDeBonus.Pessoa(CalculadoraDeBonus.Cargo.VENDEDOR, 6);
        BigDecimal totalVendas = new BigDecimal("20000.0");
        boolean campanhaEspecialAtiva = true;
        BigDecimal bonificacaoEsperada = new BigDecimal("2900.0");

        BigDecimal bonus = calculadoraDeBonus.calcularBonus(pessoa, totalVendas, campanhaEspecialAtiva);

        assertEquals(bonificacaoEsperada, bonus);

        Mockito.verify(logger, Mockito.times(5)).log(ArgumentMatchers.anyString());
    }

    @Test
    public void gerenteComMetaESemTempoDeCasaESemCampanha() {
        CalculadoraDeBonus.Pessoa pessoa = new CalculadoraDeBonus.Pessoa(CalculadoraDeBonus.Cargo.GERENTE, 2);
        BigDecimal totalVendas = new BigDecimal("50000.0");
        boolean campanhaEspecialAtiva = false;
        BigDecimal bonificacaoEsperada = new BigDecimal("8500.0");

        BigDecimal bonus = calculadoraDeBonus.calcularBonus(pessoa, totalVendas, campanhaEspecialAtiva);

        assertEquals(bonificacaoEsperada, bonus);
    }

    @Test
    public void vendedorSemMetaESemTempoDeCasaEComCampanha() {
        CalculadoraDeBonus.Pessoa pessoa = new CalculadoraDeBonus.Pessoa(CalculadoraDeBonus.Cargo.GERENTE, 2);
        BigDecimal totalVendas = new BigDecimal("9500.0");
        boolean campanhaEspecialAtiva = true;
        BigDecimal bonificacaoEsperada = new BigDecimal("0.0");

        BigDecimal bonus = calculadoraDeBonus.calcularBonus(pessoa, totalVendas, campanhaEspecialAtiva);

        assertEquals(bonificacaoEsperada, bonus);
    }

    @Test
    public void vendedorComMetaESemTempoDeCasaEComCampanha() {
        CalculadoraDeBonus.Pessoa pessoa = new CalculadoraDeBonus.Pessoa(CalculadoraDeBonus.Cargo.GERENTE, 6);
        BigDecimal totalVendas = new BigDecimal("20000.0");
        boolean campanhaEspecialAtiva = true;
        BigDecimal bonificacaoEsperada = new BigDecimal("4900.0");

        BigDecimal bonus = calculadoraDeBonus.calcularBonus(pessoa, totalVendas, campanhaEspecialAtiva);

        assertEquals(bonificacaoEsperada, bonus);
    }

    @Test
    public void supervisorComMetaESemTempoDeCasaEComCampanha() {
        CalculadoraDeBonus.Pessoa pessoa = new CalculadoraDeBonus.Pessoa(CalculadoraDeBonus.Cargo.SUPERVISOR, 6);
        BigDecimal totalVendas = new BigDecimal("20000.0");
        boolean campanhaEspecialAtiva = true;
        BigDecimal bonificacaoEsperada = new BigDecimal("5900.0");

        BigDecimal bonus = calculadoraDeBonus.calcularBonus(pessoa, totalVendas, campanhaEspecialAtiva);

        assertEquals(bonificacaoEsperada, bonus);
    }

}