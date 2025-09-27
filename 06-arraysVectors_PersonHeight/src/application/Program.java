package application;

import java.util.Scanner;

import entities.Person;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        // instanciando o inteiro 'n' que receberá o número de
        // pessoas, o qual será também o número de itens no vetor
        // e seu total de elementos no índice, mais adiante:
        int n = sc.nextInt();
        // note-se que, como o 'sc' anterior foi para um 'int',
        // assim como qualquer outro tipo primitivo, precisamos
        // 'consumir' a próxima 'ln' deixada em buffer pelo ENTER
        // antes de seguir com o uso do 'scanner':
        sc.nextLine();

        // quebra de linha
        System.out.println();

        // criando o vetor para receber a quantidade de pessoas,
        // a usar os atributos de 'entities.Person':
        Person[] vect = new Person[n];

        // como a variável 'vect' é a instanciação de um vetor de
        // 'Person', conforme explicitado pelos colchetes em
        // 'Person[]', ela passa a ter atributos próprios de
        // um vetor, feito o atributo '.length', que pode ser usado
        // para referenciar o comprimento do vetor e, portanto,
        // substituir a variável 'n' na declaração do 'for',
        // conforme em 'i<vect.length' a seguir:
        for (int i=0; i < vect.length; i++) {
            System.out.print("Enter the person " + (i+1) + " name: ");
            String name = sc.nextLine();
            System.out.print("Enter the person " + (i+1) + " age: ");
            int age = sc.nextInt();
			// note-se que, como o 'sc' anterior foi para um 'int',
			// assim como qualquer outro tipo primitivo, precisamos
			// 'consumir' a próxima 'ln' deixada em buffer pelo ENTER
			// antes de seguir com o uso do 'scanner':
            sc.nextLine();
            System.out.print("Enter the person " + (i+1) + " height: ");
            double height = sc.nextDouble();
            // ao final de cada ' loop', é criada uma nova instância
            // de 'entities.Person':
            vect[i] = new Person(name, age, height);
            // 'consumindo' a linha subsequente a um tipo primitivo:
            sc.nextLine();
      }

		// quebra de linha:
        System.out.println();

		// soma das alturas: 
        double sum = 0.0;
        for (int i=0; i < vect.length; i++) {
            sum += vect[i].getHeight();
        }
		// média das alturas:
        double avgHeight = sum / vect.length;
        System.out.printf("Average height: %.2f\n", avgHeight);

		// contagem de menores de 16:
        int count = 0;
        for (int i=0; i < vect.length; i++) {
            if (vect[i].getAge() < 16) {
            count++;
            }
        }
		// cálculo do percentual de menores de 16:
        double percentChildren = count * 100.0 / vect.length;
        System.out.printf("Children percentage: %.1f%%\n", percentChildren);

		// lista de nomes dos menores de 16:
        for (int i=0; i < vect.length; i++) {
            if (vect[i].getAge() < 16) {
                System.out.println(vect[i].getName());
            }

        sc.close();
        }
    }
}
