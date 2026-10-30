/**
 * Sistema de pedidos em terminal.
 * Permite listar produtos, montar um pedido e calcular o total com desconto.
 *
 * @author Diogo Meneses
 * @version 1.0
 */

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int select = 0;
        String [][] products = {
                {"Teclado", "150,00"},
                {"Mouse", "80,00"},
                {"Monitor ", "900,00"},
                {"Headset", "250,00"},
                {"Webcam", "320,00"}
        };

        String [][] cart = {{}};


        do {
            System.out.println("===== ORDER TERMINAL =====\n" +
                    "1 - Listar produtos\n" +
                    "2 - Adicionar item ao pedido\n" +
                    "3 - Ver pedido atual\n" +
                    "4 - Finalizar pedido\n" +
                    "0 - Sair sem finalizar\n\n\n\n");
            if (s.hasNextInt()) {
                select = s.nextInt();
            } else {
                s.next();
                select = 1;
                continue;
            }


            switch (select) {
                case 1:
                    System.out.println("===== PRODUTOS =====\n");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i][0] + " - R$" + products[i][1]);
                    }

                    System.out.println("\nDigite qualquer tecla para voltar ao menu.\n");
                    s.next();

                    break;


                case 2:
                    System.out.println("===== Adicionar ao Carrinho =====\n" +
                            "- Informe os IDs dos produtos que você quer comprar");
                    int produtoId = s.nextInt();
                    for (int i = 0; i < products.length; i++) {

                    }

            }

        }while (select != 0);

    }
}