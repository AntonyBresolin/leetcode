import java.math.BigDecimal;
import java.math.RoundingMode;

public class MotorDeDescontos {

    /**
     * Calcula o preço final de um carrinho de compras aplicando a melhor regra de desconto possível.
     * O método atual é complexo, frágil e difícil de estender.
     *
     * @param precoOriginal O preço total dos itens no carrinho.
     * @param tipoCliente O tipo do cliente (ex: "PADRAO", "CLIENTE_OURO").
     * @param itensNoCarrinho A quantidade de itens no carrinho.
     * @param cupomDeDesconto O código do cupom aplicado, se houver.
     * @return O preço final com o maior desconto aplicado.
     */
    public BigDecimal calcularPrecoFinal(BigDecimal precoOriginal, String tipoCliente, int itensNoCarrinho, String cupomDeDesconto) {
        BigDecimal maiorDesconto = BigDecimal.ZERO;

        // Regra 1: Desconto por valor
        if (precoOriginal.compareTo(new BigDecimal("1000.0")) > 0) {
            BigDecimal desconto = precoOriginal.multiply(new BigDecimal("0.10"));
            if (desconto.compareTo(maiorDesconto) > 0) {
                maiorDesconto = desconto;
                System.out.println("LOG: Desconto por valor alto considerado: " + maiorDesconto);
            }
        }

        // Regra 2: Desconto por quantidade de itens
        if (itensNoCarrinho >= 5) {
            BigDecimal desconto = precoOriginal.multiply(new BigDecimal("0.05"));
            if (desconto.compareTo(maiorDesconto) > 0) {
                maiorDesconto = desconto;
                System.out.println("LOG: Desconto por quantidade de itens considerado: " + maiorDesconto);
            }
        }

        // Regra 3: Desconto para clientes especiais
        if ("CLIENTE_OURO".equals(tipoCliente)) {
            BigDecimal desconto = precoOriginal.multiply(new BigDecimal("0.15"));
            if (desconto.compareTo(maiorDesconto) > 0) {
                maiorDesconto = desconto;
                System.out.println("LOG: Desconto de CLIENTE_OURO considerado: " + maiorDesconto);
            }
        }

        // Regra 4: Desconto por cupom
        if ("NATAL20".equals(cupomDeDesconto)) {
            BigDecimal desconto = precoOriginal.multiply(new BigDecimal("0.20"));
            if (desconto.compareTo(maiorDesconto) > 0) {
                maiorDesconto = desconto;
                System.out.println("LOG: Desconto de cupom NATAL20 considerado: " + maiorDesconto);
            }
        }

        System.out.println("LOG: Maior desconto aplicável: " + maiorDesconto);
        BigDecimal precoFinal = precoOriginal.subtract(maiorDesconto);

        return precoFinal.setScale(2, RoundingMode.HALF_UP);
    }


    public static void main(String[] args) {
        MotorDeDescontos motor = new MotorDeDescontos();

        // Cenário 1: Cliente Ouro (15%) com compra > 1000 (10%). O desconto de 15% deve vencer.
        BigDecimal preco1 = motor.calcularPrecoFinal(new BigDecimal("2000.0"), "CLIENTE_OURO", 3, null);
        System.out.println("Preço final Cliente Ouro (esperado 1700.00): " + preco1); // 2000 - (2000 * 0.15) = 1700

        System.out.println("--------------------");

        // Cenário 2: Compra com 6 itens (5%) e cupom NATAL20 (20%). O cupom deve vencer.
        BigDecimal preco2 = motor.calcularPrecoFinal(new BigDecimal("500.0"), "PADRAO", 6, "NATAL20");
        System.out.println("Preço final com Cupom (esperado 400.00): " + preco2); // 500 - (500 * 0.20) = 400

        System.out.println("--------------------");

        // Cenário 3: Compra sem nenhum desconto aplicável.
        BigDecimal preco3 = motor.calcularPrecoFinal(new BigDecimal("100.0"), "PADRAO", 1, null);
        System.out.println("Preço final sem descontos (esperado 100.00): " + preco3);
    }
}