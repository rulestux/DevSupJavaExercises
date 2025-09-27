/* em OOP, definir package no cabeçalho com nome coincidindo
 * com o diretório onde está o programa:*/
package application;

// vinculando "importando" a classe padrão java.util.Scanner:
import java.util.Scanner;

// vinculando "importando" a classe entities.Triangle:
import entities.Triangle;

public class Program {
    public static void main(String[] args) {

        /* declarando a variável sc para instanciar o objeto do tipo
         * (classe) java.util.Scanner, usando-o mais adiante:*/
        Scanner sc = new Scanner(System.in);

        /* a declaração de variáveis "double xA, xB, xC, yA, yB, yC;"
         * do programa original, sem OOP, é substituída pela
         * declaração das variáveis x e y, como novos objetos instanciando
         * o tipo 'triangle', i. e., a classe 'entities.Triangle',
         * importada acima (note-se que esse formato é análogo
         * à instanciação do Scanner sc):*/
        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        /* declarando novas variáveis para receber as medidas
         * dos lados do triângulo no programa em OOP vinculando
         * aos ATRIBUTOS do OBJETO instanciado, conforme ATRIBUTOS
         * estabelecidos na CLASSE (tipo) entities.Triangle:*/
        System.out.println("Enter the measures of triangle X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        /* as operações com os triângulos passam a ser definidas como
         * MÉTODOS em entities.Triangle, sendo retomados pela chamada
         * desses métodos como FUNÇÕES de entities.Triangle,
         * como se segue: */
        double areaX = x.area();
        double areaY = y.area();

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
        sc.close();
    }

}
