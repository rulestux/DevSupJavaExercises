import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Set the default locale to Brazilian Portuguese
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
        java.util.Scanner sc = new Scanner(System.in);

        System.out.println("Insira a largura: ");
        double width = sc.nextDouble();
        System.out.println("Insira o comprimento: ");
        double length = sc.nextDouble();
        System.out.println("Insira o valor do m²: ");
        double squareMeter = sc.nextDouble();

        double area = width * length;
        double price = area * squareMeter;

        System.out.println();
        System.out.printf("Área: %.2fm²%n", area);
        System.out.printf("Valor: R$ %.2f%n", price);
        System.out.println();

        sc.close();
    }

}
