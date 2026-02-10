package br.com.alura;

import java.util.Scanner;
import br.com.alura.compras.models.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        Cartao cartao = new Cartao();
        Menu menu = new Menu();
        //Cartao cartao = new Cartao(3000){};
        short opc = 0;
        do {
            menu.exibir();
            opc = scanner.nextShort();
            scanner.nextLine();
            switch (opc){
                case 1:
                    System.out.println("\nDigite o limite inicial do cartão: ");
                        double limite = scanner.nextInt();
                        scanner.nextLine();
                    cartao.setLimite(limite);
                    break;
                case 2:
                    System.out.println("\nLimite atual do cartão: R$ "+cartao.getLimite());
                    break;
                case 3:
                    if(cartao.getLimite() == 0 && cartao.getCompras().isEmpty()){
                        System.out.println("\nDefina o limite do cartão antes de realizar compras");
                        break;
                    }

                    System.out.println("\nItem: ");
                        String item = scanner.nextLine();
                    System.out.println("\nValor: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                    if(valor<= cartao.getLimite()) {
                        Compra c = new Compra(item, valor);
                        cartao.comprar(c);
                        System.out.println("\nCompra realizada com sucesso!");
                        System.out.printf("\nLimite atual do cartão: R$ %.2f",cartao.getLimite());
                    } else {
                        System.out.println("\nCompra não realizada por limite insuficiente");
                    }
                    break;
                case 4:
                    cartao.exibirFaturamento();
                    break;
                case  0:
                    cartao.exibirFaturamento();
                    System.out.println("\nEncerrando aplicação...");
                    break;
                default:
                    System.out.println("\nDigite uma opção válida");
                    break;
            }
        }while (opc!=0);
    }
}