package org.example.motor_de_descontos.desconto;

import org.example.motor_de_descontos.MotorDeDescontos;

import java.math.BigDecimal;

public interface Desconto {
    BigDecimal calcular(BigDecimal precoOriginal, MotorDeDescontos.TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto);
}
