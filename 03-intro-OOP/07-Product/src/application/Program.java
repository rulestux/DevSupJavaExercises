package application;

import java.util.Scanner;

import entities.Product;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* criação da variável 'product' que representa a CLASSE
         * entities.Product, instanciando-a como OBJETO:*/
        Product product = new Product();

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        /* atribuindo valor aos ATRIBUTOS do objeto 'product'
        * instância da CLASSE entities.Product:*/
        product.name = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = sc.nextInt();

        System.out.println();
        /* referenciando o MÉTODO 'toString()', dentro do
         * 'System.out.println()', ao chamar a variável
         * 'product', instância da CLASSE 'entities.Product',
         * para exibir os dados inseridos acima já formatados: */
        System.out.println("Product data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        /* criação de variável a ser usada para transferir os
         * dados coletados a serem processados pelas funções
         * de 'entities.Product', instanciada como OBJETO 'product': */
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.println();
        System.out.println("Updated data: " + product);

        sc.close();
    }
}
