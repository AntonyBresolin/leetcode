package org.example.motor_de_descontos.desconto;

import org.example.motor_de_descontos.MotorDeDescontos;

import java.math.BigDecimal;

public class DescontoPorValor implements Desconto {

    public static final String VALOR_LIMITE_PARA_COMECAR_APLICAR_DESCONTO = "1000.0";
    public static final String DESCONTO_SE_GASTAR_MUITO = "0.10";

    @Override
    public BigDecimal calcular(BigDecimal precoOriginal, MotorDeDescontos.TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal desconto = BigDecimal.ZERO;
        if (precoOriginal.compareTo(new BigDecimal(VALOR_LIMITE_PARA_COMECAR_APLICAR_DESCONTO)) > 0) {
            desconto = precoOriginal.multiply(new BigDecimal(DESCONTO_SE_GASTAR_MUITO));
        }
        return desconto;
    }
}
