// importando a CLASSE padrão java.util.Scanner:
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /* declarando a variável sc para criar o objeto do tipo (classe)
         * 'java.util.Scanner', usando-o mais adiante:*/
        Scanner sc = new Scanner(System.in);

        // declarando as variáveis que representam os lados do triângulo:
        double xA, xB, xC, yA, yB, yC;

        System.out.println("Enter the measures of triangle X: ");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y: ");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        // fórmula de Heron de Alexandria para calcular a área do triângulo:
        double p = (xA + xB + xC) / 2.0;
        double areaX = Math.sqrt(p * (p-xA) * (p - xB) * (p - xC));
        p = (yA + yB + yC) / 2.0;
        double areaY = Math.sqrt(p * (p-yA) * (p - yB) * (p - yC));

        System.out.printf("Triangle X area: %.2f%n", areaX);
        System.out.printf("Triangle Y area: %.2f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Larger area: X");
        }
        else if (areaX < areaY){
                System.out.println("Larger area: Y");
            }
            else {
                System.out.println("Areas are equal");
            }
    }
}
