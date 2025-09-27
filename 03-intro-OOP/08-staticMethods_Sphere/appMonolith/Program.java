package appMonolith;

import java.util.Scanner;

public class Program {

    /* na declaração de variáveis 'constantes', como 'membro
     * estático', a convenção prescreve o uso da palavra 'final',
     * um vez que tais constantes não serão alteradas no programa;
     * note-se a estrutura 'public static final' declarada fora
     * da estrutura do programa 'public static void main(String[] args) {}'
    */
    public static final double PI = 3.14;

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter radius: ");
    double radius = sc.nextDouble();

    double c = circumference(radius);

    double v = volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value %.2f%n", PI);

    sc.close();
    }

    public static double circumference(double radius) {
        return 2.0 * PI * radius;
    }

    public static double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}
