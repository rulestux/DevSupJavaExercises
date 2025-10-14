package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {

        List<Integer> listInt = Arrays.asList(3, 4, 5, 10, 7);

        // criando uma 'Stream' a partir de uma lista:
        Stream<Integer> st1 = listInt.stream();
        // convertendo uma 'Stream' em vetor de strings
        // para imprimi-la na tela:
        System.out.println(Arrays.toString(st1.toArray()));

        // aplicando função com 'map' a cada elemento da 'Stream',
        // no exemplo, multiplicando cada elemento por 10:
        st1 = listInt.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // criando uma 'Stream' com strings:
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        // 'Stream' com criação de função de iteração:
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        // como a função criada é potencialmente infinita,
        // aplica-se um 'limit()' passando 10 como número
        // máximo de elementos para a saída:
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        // 'Stream' para a sequência de Fibonacci; como o Java não
        // possui 'tuplas', inicia-se com um vetor de 'Long' com
        // duas posições como primeiro elemento da 'Stream';
        // a expressão lambda (função de geração para a sequência)
        // será um objeto 'p' que leva (->) a um novo array (vetor)
        // de longs cujo primeiro elemento é o elemento anterior
        // na posição '1' e o segundo elemento é o elemento anterior
        // na posição '0' mais o elemento anterior na posição '1';
        // para extrair o único elemento válido para a sequência
        // de Fibonacci, usa-se enfim o map para extrair cada
        // elemento da posição '0' de cada vetor formado:
        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));

        // somatório dos elementos de uma 'Stream' com 'reduce()':
        int sum = listInt.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum: " + sum);
        // produtório dos elementos de uma 'Stream':
        int prod = listInt.stream().reduce(1, (x, y) -> x * y);
        System.out.println("Product: " + prod);
    }
}
