package entities;

public class Triangle {
    // declarando ATRIBUTOS para a CLASSE Triangle:
    public double a;
    public double b;
    public double c;

    /* na declaração de FUNÇÕES (i.e., MÉTODOS), usam-se ()
    * (como em area()) onde se definem PARÂMETROS
    * (dados a serem processados na operação), para serem
    * inseridos apenas se necessário.*/
    public double area() {
        // fórmula de Heron de Alexandria:
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p* (p - a) * (p - b) * (p - c));
    }
}
