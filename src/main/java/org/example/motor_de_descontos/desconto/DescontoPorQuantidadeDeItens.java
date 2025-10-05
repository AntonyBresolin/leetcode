package org.example.motor_de_descontos.desconto;

import org.example.motor_de_descontos.MotorDeDescontos;

import java.math.BigDecimal;

public class DescontoPorQuantidadeDeItens implements Desconto {

    public static final int QUANTIDADE_DE_ITENS_PARA_APLICAR_DESCONTO = 5;
    public static final String DESCONTO_CASO_TENHA_MUITOS_ITEMS = "0.05";

    @Override
    public BigDecimal calcular(BigDecimal precoOriginal, MotorDeDescontos.TipoCliente tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal desconto = BigDecimal.ZERO;
        if (itensNoCarrinho >= QUANTIDADE_DE_ITENS_PARA_APLICAR_DESCONTO) {
             desconto = precoOriginal.multiply(new BigDecimal(DESCONTO_CASO_TENHA_MUITOS_ITEMS));
        }
        return desconto;
    }

}
