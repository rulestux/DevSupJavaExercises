package util;

public class Calculator {

    /* na declaração de variáveis 'constantes', como 'membro
     * estático', a convenção prescreve o uso da palavra 'final',
     * um vez que tais constantes não serão alteradas no programa;
     * note-se a estrutura 'public static', em que 'static'
     * caracteriza o membro estático:
    */
    public static final double PI = 3.14;

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
     * instanciada como objeto no programa principal.*/

    public static double circumference(double radius) {
        return 2.0 * PI * radius;
    }

    public static double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }


}
