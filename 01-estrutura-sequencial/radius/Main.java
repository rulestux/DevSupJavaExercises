import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

    Locale.setDefault(Locale.forLanguageTag("pt-BR"));
    Scanner sc = new Scanner(System.in);

    System.out.println("Insira o raio em metros: ");
    double radius = sc.nextDouble();

    double powerRadius = Math.pow(radius, 2);
    double circleArea = 3.14159 * powerRadius;

    System.out.println();
    System.out.printf("A área do círculo é %.2fm².%n", circleArea);
    }
}
