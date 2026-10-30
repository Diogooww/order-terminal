/**
 * Sistema de pedidos em terminal.
 * Permite listar produtos, montar um pedido e calcular o total com desconto.
 *
 * @author Diogo Meneses
 * @version 1.0
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int select = 0;
        int exit = 1;
        String[][] products = {
                {"Teclado", "150,00"},
                {"Mouse", "80,00"},
                {"Monitor ", "900,00"},
                {"Headset", "250,00"},
                {"Webcam", "320,00"}
        };
        String [][] cart = new String[10][3];

        do {
            System.out.println("===== ORDER TERMINAL =====\n" +
                    "1 - Listar produtos\n" +
                    "2 - Adicionar item ao pedido\n" +
                    "3 - Ver pedido atual\n" +
                    "4 - Finalizar pedido\n" +
                    "0 - Sair sem finalizar\n\n\n\n");
            if (!s.hasNext()){
                continue;
            }
            boolean hasIntFirst = s.hasNextInt();
            select = s.nextInt();
            boolean menuOption = CheckMenuOptions(select, hasIntFirst);
            if (!menuOption){
                System.out.println("Digite um valor válido!");
                continue;
            }



            switch (select) {
                case 1:
                    System.out.println("===== PRODUTOS =====\n");
                    for (int i = 0; i < products.length; i++){
                        System.out.println((i + 1) + ". " + products[i][0] + " - R$" + products[i][1]);
                    }
                    System.out.println("\nDigite qualquer tecla para voltar ao menu.\n");
                    select = s.nextInt();
                    if (select == 0){
                        select = 1;
                    }

                    break;


                case 2:
                    int cartQuantity = 0;

                    System.out.println("===== Adicionar ao Carrinho =====\n");
                    while (exit != 0){
                        System.out.println("-Informe os itens que você deseja colocar no carrinho-\n\n");
                        for (int i = 0; i < products.length; i++){
                            System.out.println((i + 1) + ". " + products[i][0] + " - R$" + products[i][1]);
                        }

                        System.out.println("Digite o número do produto que você deseja colocar no carrinho.");
                        int productChoice = s.nextInt();
                        boolean checkProductId = checkProductChoice(productChoice);
                        if (!checkProductId){
                            System.out.println("Digite um valor correto.\n\n");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            }catch (InterruptedException e){
                                Thread.currentThread().interrupt();
                            }
                            continue;
                        }

                        System.out.println("Digite a quantidade que você deseja do produto: " + products[productChoice - 1][0]);
                        String quantityChoice = s.next();
                        boolean checkQuantity = checkQuantityChoice(quantityChoice);
                        if (!checkQuantity){
                            System.out.println("Digite uma quantidade correta.\n\n");
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            }catch (InterruptedException e){
                                Thread.currentThread().interrupt();
                            }
                            continue;
                        }

                        cart[cartQuantity][0] = products[productChoice - 1][0];
                        cart[cartQuantity][1] = products[productChoice - 1][1];
                        cart[cartQuantity][3] = quantityChoice;

                        if (cartQuantity >= 9){
                            System.out.println("Carrinho cheio!\n" +
                                    "Esses são os produtos que estão no seu carrinho:\n\n");

                            StringBuilder resultado = new StringBuilder();

                            for (String[] item : cart) {
                                if (resultado.length() > 0) {
                                    resultado.append(", ");
                                }
                                resultado.append(String.join(" ", item));
                            }

                            System.out.println(resultado);
                            break;
                        }

                        System.out.println("Digite 0 para continuar:");
                        exit = s.nextInt();

                        cartQuantity += 1;
                    }
            }

        }while (select != 0);


    }

    public static boolean checkQuantityChoice(String productQuantity){
        int quantity;
        try {
            quantity = Integer.parseInt(productQuantity);
        } catch (NumberFormatException e) {
            return false;
        }

        if (quantity <= 0 || quantity > 99){
            return false;
        }

        return true;
    }


    public static boolean checkProductChoice(int productChoice){
        if (productChoice < 1 || productChoice > 5){
            return false;
        }
        return true;
    }


    public static boolean CheckMenuOptions(int menuOption, boolean hasInterger){
        if (menuOption > 4 || menuOption < 0){
            return false;
        }
        if (hasInterger){
            return true;
        }

        return false;
    }
}