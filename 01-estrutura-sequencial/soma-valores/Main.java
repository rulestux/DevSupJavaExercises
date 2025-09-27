import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Locale.setDefault(Locale.forLanguageTag("pt-BR"));
    Scanner sc = new Scanner(System.in);

    System.out.println("Insira o primeiro valor: ");
    double num1 = sc.nextDouble();
    System.out.println("Insira o segundo valor: ");
    double num2 = sc.nextDouble();
    System.out.println();

    double result = num1 + num2;
    System.out.printf("A soma resulta em %.2f%n", result);
    System.out.println();

    sc.close();
    }
}
