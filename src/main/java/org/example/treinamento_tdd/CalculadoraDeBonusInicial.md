public class CalculadoraDeBonus {

    /**
     * Calcula o bônus de um funcionário baseado em cargo, tempo de casa e desempenho de vendas.
     * Este método possui múltiplas regras de negócio entrelaçadas.
     *
     * @param cargo O cargo do funcionário ("VENDEDOR" ou "GERENTE").
     * @param anosDeCasa O número de anos que o funcionário está na empresa.
     * @param totalVendas O valor total de vendas do funcionário no ano.
     * @param campanhaEspecialAtiva Se a campanha de bônus extra está ativa.
     * @return O valor total do bônus.
     */
    public double calcularBonus(String cargo, int anosDeCasa, double totalVendas, boolean campanhaEspecialAtiva) {
        double bonus = 0.0;

        // Regra 1: Meta Mínima de Vendas
        if (totalVendas < 10000.0) {
            System.out.println("LOG: Funcionário não atingiu a meta de vendas. Bônus zerado.");
            return 0.0;
        }

        System.out.println("LOG: Meta de vendas atingida. Calculando bônus...");

        // Regra 2: Bônus Base por Cargo
        if ("VENDEDOR".equals(cargo)) {
            bonus = totalVendas * 0.10; // 10% para Vendedor
            System.out.println("LOG: Bônus base de Vendedor calculado: " + bonus);
        } else if ("GERENTE".equals(cargo)) {
            bonus = (totalVendas * 0.15) + 1000.0; // 15% + 1000 fixo para Gerente
            System.out.println("LOG: Bônus base de Gerente calculado: " + bonus);
        }

        // Regra 3: Bônus Adicional por Tempo de Casa
        if (anosDeCasa >= 5) {
            double bonusTempoDeCasa = totalVendas * 0.02;
            bonus += bonusTempoDeCasa;
            System.out.println("LOG: Adicional por tempo de casa aplicado: " + bonusTempoDeCasa);
        }

        // Regra 4: Bônus de Campanha Especial
        if (campanhaEspecialAtiva) {
            bonus += 500.0;
            System.out.println("LOG: Bônus de campanha especial aplicado: +500.0");
        }

        System.out.println("LOG: Bônus final calculado para " + cargo + ": " + bonus);
        return bonus;
    }

    // Método main usado para testes manuais
    public static void main(String[] args) {
        CalculadoraDeBonus calculadora = new CalculadoraDeBonus();

        // Cenário 1: Vendedor que bate a meta, com tempo de casa e campanha
        double bonus1 = calculadora.calcularBonus("VENDEDOR", 6, 20000.0, true);
        System.out.println("Bônus Vendedor (esperado ~2900): " + bonus1);
        // (20000 * 0.10) + (20000 * 0.02) + 500 = 2000 + 400 + 500 = 2900

        System.out.println("--------------------");

        // Cenário 2: Gerente que bate a meta, sem tempo de casa e sem campanha
        double bonus2 = calculadora.calcularBonus("GERENTE", 2, 50000.0, false);
        System.out.println("Bônus Gerente (esperado ~8500): " + bonus2);
        // (50000 * 0.15) + 1000 = 7500 + 1000 = 8500

        System.out.println("--------------------");

        // Cenário 3: Vendedor que não bate a meta
        double bonus3 = calculadora.calcularBonus("VENDEDOR", 3, 9500.0, true);
        System.out.println("Bônus Vendedor sem meta (esperado 0): " + bonus3);
    }
}