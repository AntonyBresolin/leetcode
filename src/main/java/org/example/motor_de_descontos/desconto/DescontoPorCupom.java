package org.example.motor_de_descontos.desconto;

import org.example.motor_de_descontos.MotorDeDescontos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DescontoPorCupom implements Desconto {
    private static final HashMap<String, BigDecimal> descontos = new HashMap<>(
            Map.of(
                    "NATAL20", new BigDecimal("0.20")
            )
    );

    @Override
    public BigDecimal calcular(BigDecimal precoOriginal, MotorDeDescontos.TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal percentual = descontos.getOrDefault(cupomDeDesconto, BigDecimal.ZERO);
        return precoOriginal.multiply(percentual);
    }
}
