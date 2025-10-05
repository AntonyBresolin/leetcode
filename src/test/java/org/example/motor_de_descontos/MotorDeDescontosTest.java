package org.example.motor_de_descontos;

import org.example.motor_de_descontos.desconto.DescontoPorCupom;
import org.example.motor_de_descontos.desconto.DescontoPorQuantidadeDeItens;
import org.example.motor_de_descontos.desconto.DescontoPorTipoDeCliente;
import org.example.motor_de_descontos.desconto.DescontoPorValor;
import org.example.motor_de_descontos.logger.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MotorDeDescontosTest {

    @Mock
    private Logger logger;

    private MotorDeDescontos motorDeDescontos;

    @BeforeEach
    public void setUp() {
        motorDeDescontos = new MotorDeDescontos(logger, Arrays.asList(
                new DescontoPorValor(),
                new DescontoPorQuantidadeDeItens(),
                new DescontoPorTipoDeCliente(),
                new DescontoPorCupom()
        ));
    }

    @Test
    public void clienteOuroMenosDe5ItensSemCupom() {
        BigDecimal precoOriginal = new BigDecimal("2000.0");
        MotorDeDescontos.TipoCliente tipoCliente = MotorDeDescontos.TipoCliente.CLIENTE_OURO;
        int itensNoCarrinho = 3;
        String cupomDeDesconto = null;
        BigDecimal precoFinalEsperado = new BigDecimal("1700.00");

        BigDecimal precoFinal = motorDeDescontos.calcularPrecoFinal(precoOriginal, tipoCliente, itensNoCarrinho, cupomDeDesconto);

        assertEquals(precoFinalEsperado, precoFinal);
    }

    @Test
    public void clienteOuroMenosDe6ItensComCupomNatal20() {
        BigDecimal precoOriginal = new BigDecimal("500.0");
        MotorDeDescontos.TipoCliente tipoCliente = MotorDeDescontos.TipoCliente.PADRAO;
        int itensNoCarrinho = 6;
        String cupomDeDesconto = "NATAL20";
        BigDecimal precoFinalEsperado = new BigDecimal("400.00");

        BigDecimal precoFinal = motorDeDescontos.calcularPrecoFinal(precoOriginal, tipoCliente, itensNoCarrinho, cupomDeDesconto);

        assertEquals(precoFinalEsperado, precoFinal);

        Mockito.verify(logger, Mockito.times(3)).log(ArgumentMatchers.anyString());
    }

    @Test
    public void compraSemNenhumDesconto() {
        BigDecimal precoOriginal = new BigDecimal("100.0");
        MotorDeDescontos.TipoCliente tipoCliente = MotorDeDescontos.TipoCliente.PADRAO;
        int itensNoCarrinho = 1;
        String cupomDeDesconto = null;
        BigDecimal precoFinalEsperado = new BigDecimal("100.00");

        BigDecimal precoFinal = motorDeDescontos.calcularPrecoFinal(precoOriginal, tipoCliente, itensNoCarrinho, cupomDeDesconto);

        assertEquals(precoFinalEsperado, precoFinal);
    }
}