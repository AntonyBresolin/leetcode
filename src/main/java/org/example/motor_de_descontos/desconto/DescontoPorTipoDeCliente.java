package org.example.motor_de_descontos.desconto;

import org.example.motor_de_descontos.MotorDeDescontos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DescontoPorTipoDeCliente implements Desconto {

    public static final BigDecimal DESCONTO_CLIENTE_OURO = new BigDecimal("0.15");
    public static final BigDecimal DESCONTO_CLIENTE_PADRAO = new BigDecimal("0.0");

    private static final HashMap<MotorDeDescontos.TipoCliente, BigDecimal> descontos = new HashMap<>(
            Map.of(
                    MotorDeDescontos.TipoCliente.CLIENTE_OURO, DESCONTO_CLIENTE_OURO,
                    MotorDeDescontos.TipoCliente.PADRAO, DESCONTO_CLIENTE_PADRAO
            )
    );

    @Override
    public BigDecimal calcular(BigDecimal precoOriginal, MotorDeDescontos.TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal desconto = descontos.getOrDefault(tipoCliente, BigDecimal.ZERO);

        return precoOriginal.multiply(desconto);
    }

}
