package application;

import java.util.Scanner;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the items quantity: ");
		/* instanciando o inteiro 'n' que receberá o número de
		 * itens, o qual será também o número de itens no vetor
		 * e seu total de elementos no índice mais adiante: */
        int n = sc.nextInt();
        /* note-se que, como o 'sc' anterior foi para um 'int',
         * assim como qualquer outro tipo primitivo, precisamos
		 * 'consumir' a próxima 'ln' deixada em buffer pelo ENTER 
         * antes de seguir com o uso do 'scanner': */
        sc.nextLine();

		// quebra de linha:
		System.out.println();
        
		/* criando o vetor para receber a quantidade de produtos,
         * a usar os atributos de 'entities.Product': */
        Product[] vect = new Product[n];

        /* como a variável 'vect' é a instanciação de um vetor de
         * 'Product', conforme explicitado pelos colchetes em
         * 'Product[]', ela passa a ter atributos pŕoprios de
         * um vetor, feito o atributo '.length', que pode ser usado
         * para referenciar o comprimento do vetor e, portanto,
         * substituir a variável 'n' na declaração do 'for',
         * conforme em 'i<vect.length' a seguir: */
        for (int i=0; i<vect.length; i++) {
            System.out.println("Enter the product name: ");
            String name = sc.nextLine();
            System.out.println("Enter the product price: ");
            System.out.print("$ ");
            double price = sc.nextDouble();
			/* ao final de cada 'loop', é criada uma nova instância
			 * de 'entities.Product': */
            vect[i] = new Product(name, price);
			// quebra de linha:
            System.out.println();
        }

        // variável para receber a média de valores:
        double sum = 0.0;
            /* loop for para obter e somar todos os valores
             * inseridos: */
        for (int i=0; i<vect.length; i++) {
            /* chamando 'getPrice()' para obter dados apenas des
             * valores dos produtos: */
            sum += vect[i].getPrice();
            }
        // cálculo da média, também substituindo 'n' 'vect.length':
        double avg = sum / vect.length;

        System.out.printf("AVERAGE PRICE: $ %.2f\n", avg);

    sc.close();
    }
}
