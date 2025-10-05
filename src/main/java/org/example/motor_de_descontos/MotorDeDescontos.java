package org.example.motor_de_descontos;

import org.example.motor_de_descontos.desconto.Desconto;
import org.example.motor_de_descontos.logger.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MotorDeDescontos {

    private final Logger logger;
    private final List<Desconto> descontos;

    public MotorDeDescontos(Logger logger, List<Desconto> descontos) {
        this.logger = logger;
        this.descontos = descontos;
    }

    public enum TipoCliente {
        PADRAO,
        CLIENTE_OURO
    }

    public BigDecimal calcularPrecoFinal(BigDecimal precoOriginal, TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal maiorDesconto = BigDecimal.ZERO;

        for (Desconto desconto : descontos) {
            BigDecimal descontoAtual = desconto.calcular(precoOriginal, tipoCliente, itensNoCarrinho, cupomDeDesconto);

            if (descontoAtual.compareTo(maiorDesconto) > 0) {
                maiorDesconto = descontoAtual;
                logger.log("LOG: Maior desconto aplicável: " + maiorDesconto);
            }
        }


        logger.log("LOG: Maior desconto aplicável: " + maiorDesconto);
        BigDecimal precoFinal = precoOriginal.subtract(maiorDesconto);

        return precoFinal.setScale(2, RoundingMode.HALF_UP);
    }

}