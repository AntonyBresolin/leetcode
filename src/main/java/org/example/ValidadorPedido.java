package org.example;

import java.math.BigDecimal;

public class ValidadorPedido {
    private final RepositorioCliente repositorioCliente;
    private final LoggerPort logger;

    public ValidadorPedido(RepositorioCliente repositorioCliente, LoggerPort logger) {
        this.repositorioCliente = repositorioCliente;
        this.logger = logger;
    }

    // Frete
    final static BigDecimal VALOR_LIMITE_PARA_PAGAMENTO_DE_FRETE = BigDecimal.valueOf(500.0);
    final static BigDecimal VALOR_FRETE_COM_IMPOSTO = BigDecimal.valueOf(0.0);
    final static BigDecimal VALOR_FRETE_SEM_IMPOSTO = BigDecimal.valueOf(25.0);

    // Tabela imposto
    final static BigDecimal IMPOSTO_SAO_PAULO = BigDecimal.valueOf(0.18);
    final static BigDecimal IMPOSTO_GERAL = BigDecimal.valueOf(0.12);
    final static String SAO_PAULO = "SP";


    public static class Pessoa {
        private String nome;
        private BigDecimal limiteCredito;

        @SuppressWarnings("unused")
        public Pessoa() {
        }

        public Pessoa(String nome, BigDecimal limiteCredito) {
            this.nome = nome;
            this.limiteCredito = limiteCredito;
        }

        @Deprecated
        public Pessoa(String nome, double limiteCredito) {
            this.nome = nome;
            this.limiteCredito = BigDecimal.valueOf(limiteCredito);
        }

        public String getNome() {
            return nome;
        }

        public BigDecimal getLimiteCredito() {
            return limiteCredito;
        }
    }

    public static class Produto {
        private int estoque;
        private BigDecimal valorProduto;

        @SuppressWarnings("unused")
        public Produto() {
        }

        public Produto(int estoque, BigDecimal valorProduto) {
            this.estoque = estoque;
            this.valorProduto = valorProduto;
        }

        @Deprecated
        public Produto(int estoque, double valorProduto) {
            this.estoque = estoque;
            this.valorProduto = BigDecimal.valueOf(valorProduto);
        }

        public int getEstoque() {
            return estoque;
        }

        public BigDecimal getValorProduto() {
            return valorProduto;
        }
    }


    public String validar(Produto produto, Pessoa cliente, String estado) {
        String x = verificarSeListaNegra(cliente.getNome());
        if (x != null) return x;

        String x1 = verificarDisponibilidadeEstoque(produto.getEstoque());
        if (x1 != null) return x1;

        BigDecimal imposto = definirImpostoSobreValorProduto(produto.getValorProduto(), estado);
        BigDecimal valorProdutoComImposto = produto.getValorProduto().add(imposto);

        logger.log("LOG: Valor com imposto calculado: "+ valorProdutoComImposto);

        if (valorProdutoComImposto.compareTo(cliente.getLimiteCredito()) > 0) {
            return "ERRO: Limite de crédito excedido.";
        }

        BigDecimal frete = definirValorFrete(valorProdutoComImposto);
        logger.log("LOG: Frete calculado: "+ frete);

        BigDecimal valorFinal = valorProdutoComImposto.add(frete);
        logger.log("LOG: Valor final do pedido: "+ valorFinal);

        return "APROVADO";
    }

    private static BigDecimal definirValorFrete(BigDecimal valorProdutoComImposto) {
        if (valorProdutoComImposto.compareTo(VALOR_LIMITE_PARA_PAGAMENTO_DE_FRETE) > 0) {
            return VALOR_FRETE_COM_IMPOSTO;
        }

        return VALOR_FRETE_SEM_IMPOSTO;
    }

    private static BigDecimal definirImpostoSobreValorProduto(BigDecimal valorProduto, String estado) {
        if (estado.equals(SAO_PAULO)) {
            return valorProduto.multiply(IMPOSTO_SAO_PAULO);
        }

        return valorProduto.multiply(IMPOSTO_GERAL);
    }

    private static String verificarDisponibilidadeEstoque(int estoque) {
        if (estoque <= 0) {
            return "ERRO: Pedido com estoque zerado.";
        }
        return null;
    }

    private String verificarSeListaNegra(String nomeCliente) {
        if (repositorioCliente.isClienteNaListaNegra(nomeCliente)) {
            return "ERRO: Cliente na lista negra.";
        }
        return null;
    }

    public static void main(String[] args) {
        // 1. Criar as implementações (Adapters) que vamos usar
        LoggerPort logger = new LoggerConsoleAdapter();
        RepositorioCliente repositorioCliente = new RepositorioClienteEmMemoriaAdapter();

        // 2. Injetar as dependências no Core Logic via construtor
        ValidadorPedido validador = new ValidadorPedido(repositorioCliente, logger);

        // 3. Usar o validador. A partir daqui, nada muda!
        // Cenário 1: Pedido que deve ser aprovado
        ValidadorPedido.Produto produto1 = new ValidadorPedido.Produto(10, 600.00);
        ValidadorPedido.Pessoa cliente1 = new ValidadorPedido.Pessoa("Cliente Bom", 1000.00);
        String resultado1 = validador.validar(produto1, cliente1, "RJ");
        System.out.println("Resultado do Cenário 1: " + resultado1);
    }

}