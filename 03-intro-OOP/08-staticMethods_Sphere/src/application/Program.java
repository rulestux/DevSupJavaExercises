package application;

import java.util.Scanner;

import util.Calculator;

public class Program {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter radius: ");
    double radius = sc.nextDouble();

    /* a vantagem de declarar atributos ou métodos como
     * 'membros estáticos' é poder referenciá-los no
     * programa principal sem precisar criar variáveis para
     * instanciá-los como objetos de uma classe em estruturas
     * feito: 'Calculator calc = new Calculator()'.
     *
     * isso ocorre porque o programa está dentro de um método
     * estático 'public static void main(String[] args) {}',
     * em que não se pode referenciar outros métodos que não
     * sejam estáticos, a menos que eles sejam de uma classe
     * instanciada como objeto no programa principal.
     *
     * aqui então podemos referenciar os atributos e métodos
     * da classe util.Calculator sem precisar instanciar como
     * 'Calculator calc = new Calculator()'.*/

    double c = Calculator.circumference(radius);
    double v = Calculator.volume(radius);

    System.out.printf("Circumference: %.2f\n", c);
    System.out.printf("Volume: %.2f\n", v);
    System.out.printf("PI value %.2f\n", Calculator.PI);

    sc.close();
    }

}
