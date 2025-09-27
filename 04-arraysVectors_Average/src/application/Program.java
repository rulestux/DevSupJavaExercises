package application;

import java.util.Scanner;

public class Program {
// programa para calcular a média entre 'n' itens.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        /* instanciando o objeto 'vect', que receberá
         * de 'n' o seu comprimento (length); a sintaxe
         * dos vetores é indicada pelo tipo e os colchetes
         * como em 'double[]'; após o comando 'new',
         * o vetor é instanciado com o tipo e o comprimento
         * entre os colchetes: */

        double[] vect = new double[n];

        System.out.println("Enter items: ");
        /* usando o loop 'for' para receber todos os dados
         * cuja média será calculada até o item 'n': */
        for (int i=0; i<n; i++) {
            vect[i] = sc.nextDouble();
        }

        /* usando o loop 'for' para somar todos os itens até
         * o item 'n', em uma operação cuja variável 'sum'
         * guarda o total dessa soma: */
        double sum = 0.0;
        for (int i=0; i<n; i++) {
            sum += vect[i];
        }

        /* operação para obter a média a se guardar na variável
         * 'avg' (average): */
        double avg = sum / n;

        // imprimindo o resultado na tela:
        System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);

        sc.close();
    }
}
