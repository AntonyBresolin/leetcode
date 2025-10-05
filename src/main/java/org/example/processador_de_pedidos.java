package org.example;

import java.util.*;

public class processador_de_pedidos {
    public static double taxa = 5.5;
    public static String status;

    public static void Processar_Itens(List lista,String tipo){
        double a=0;
        String relatorioFinal = new String("");
        for(int i=0;i<lista.size();i++){
            try{
                String item = (String)lista.get(i);
                String[] partes=item.split(":");
                double preco = Double.parseDouble(partes[1]);
                a += preco;
                relatorioFinal = relatorioFinal + partes[0] + " - R$ " + preco + "\n";
            } catch(Exception e)
            {
            }
        }
        double temp = 0;
        if (tipo == "URGENTE") {
            temp = a * 0.1;
            a += temp;
            status = "Processado com urgência";
        } else {
            status = "Processado normalmente";
        }

        double totalFinal;
        if(a > 200.0){
            double d = a * 0.15; // 15% de desconto
            totalFinal = a - d;
            System.out.println("Desconto aplicado!");
        }
        else {
            totalFinal = a;
        }
        totalFinal = totalFinal + taxa;

        System.out.println("--- Relatório de Itens ---");
        System.out.println(relatorioFinal);
        System.out.println("Subtotal: " + a);
        System.out.println("Total Final: " + totalFinal);
        System.out.println("Status: " + status);
    }

    public static void main(String[] args) {
        List compras = new ArrayList();
        compras.add("Teclado Mecanico:150.0");
        compras.add("Mouse Gamer:95.50");
        compras.add("Monitor Ultrawide:1200.0");
        compras.add("item-invalido"); // item para dar erro
        Processar_Itens(compras, "URGENTE");
    }
}