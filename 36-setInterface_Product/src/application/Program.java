package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.Product;

public class Program {

    public static void main(String[] args) {

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS IF CONTAINS NOTEBOOK - HASH*");

        Set<String> set1Hash = new HashSet<>();

        set1Hash.add("TV");
        set1Hash.add("Notebook");
        set1Hash.add("Tablet");
        set1Hash.add("Smartphone");

        System.out.println();                   // quebra de linha
        System.out.println(set1Hash.contains("Notebook"));

        System.out.println();                   // quebra de linha
        // se existir 'Notebook" na lista, o 'HashSet' retorna,
        // com a maior velocidade, o 'true', mas não mantém a ordem
        // original de inserção dos dados:
        for (String p : set1Hash) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS IF CONTAINS NOTEBOOK - TREE*");

        Set<String> set2Tree = new TreeSet<>();

        set2Tree.add("Tv");                     // v mínúsculo para ordenar
        set2Tree.add("Notebook");
        set2Tree.add("Tablet");
        set2Tree.add("Smartphone");

        System.out.println();                   // quebra de linha
        System.out.println(set2Tree.contains("Notebook"));

        System.out.println();                   // quebra de linha
        // se existir 'Notebook" na lista, o 'TreeSet' retorna
        // o 'true' e ordenando os dados, feito um 'sort':
        for (String p : set2Tree) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS IF CONTAINS NOTEBOOK - LINKED*");

        Set<String> set3Linked = new LinkedHashSet<>();

        set3Linked.add("TV");
        set3Linked.add("Notebook");
        set3Linked.add("Tablet");
        set3Linked.add("Smartphone");

        System.out.println();                   // quebra de linha
        System.out.println(set3Linked.contains("Notebook"));

        System.out.println();                   // quebra de linha
        // se existir 'Notebook" na lista, o 'TreeSet' retorna
        // o 'true' e mantém a ordem original de inserção dos dados:
        for (String p : set3Linked) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS TABLET REMOVED - REMOVE*");

        Set<String> set4Remove = new LinkedHashSet<>();

        set4Remove.add("TV");
        set4Remove.add("Notebook");
        set4Remove.add("Tablet");
        set4Remove.add("Smartphone");

        set4Remove.remove("Tablet");

        System.out.println();                   // quebra de linha
        for (String p : set4Remove) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS INITIAL T ITEMS REMOVED - REMOVE IF*");

        Set<String> set5RemIf = new LinkedHashSet<>();
        set5RemIf.add("TV");
        set5RemIf.add("Notebook");
        set5RemIf.add("Tablet");
        set5RemIf.add("Smartphone");

        System.out.println();                   // quebra de linha
        // removendo (se) predicado: cada elemento 'x' tal que 'length'
        // seja maior ou igual a três (mantendo apenas os menores que três
        // caracteres):
        //set5RemIf.removeIf(x -> x.length() >= 3);

        // removendo (se) predicado: cada elemento 'x' tal que 'charAt(0)'
        // (o caracter na primeira posição) seja 'T':
        set5RemIf.removeIf(x -> x.charAt(0) == 'T');

        for (String p : set5RemIf) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*THIS BLOCK RETURNS SET OPERATIONS*");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        System.out.println();                   // quebra de linha

        // união:
        System.out.println("I - UNION:");
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);
        System.out.println();                   // quebra de linha

        // interseção:
        System.out.println("II - INTERSECTION:");
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);
        System.out.println();                   // quebra de linha

        // diferença:
        System.out.println("III - DIFFERENCE:");
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*HASHCODE COMPARISON*");

        Set<Product> set6Equals = new HashSet<>();

        set6Equals.add(new Product("TV", 900.0));
        set6Equals.add(new Product("Notebook", 2000.0));
        set6Equals.add(new Product("Tablet", 1200.0));
        set6Equals.add(new Product("Smartphone", 1200.0));

        System.out.println();                   // quebra de linha
        // como são instâncias diferentes e o Java faz referência por ponteiros,
        // faz-se necessária a implementação de equals e hashCode na classe
        // 'Product' para a comparação com set ter efeito, sendo realizada uma
        // comparação por conteúdo, retornando 'true' para o Notebook, e não
        // pelo ponteiro do objeto, que retornaria 'false':
        Product prod1 = new Product("Notebook", 2000.0);

        System.out.println(set6Equals.contains(prod1));

        System.out.println();                   // quebra de linha

//***************************************************************************//
        System.out.println("**********************************************************");
        System.out.println("*TREESET COMPARISON*");

        Set<Product> set7TreeSetComp = new TreeSet<>();

        set7TreeSetComp.add(new Product("TV", 900.0));
        set7TreeSetComp.add(new Product("Notebook", 2000.0));
        set7TreeSetComp.add(new Product("Tablet", 1200.0));
        set7TreeSetComp.add(new Product("Smartphone", 1200.0));

        System.out.println();                   // quebra de linha
        // para efetivar a comparação com o 'TreeSet', a classe 'Product'
        // precisa implementar a interface 'Comparable<>'; esta, por sua vez,
        // exige a implementação do método 'compareTo' com a lógica desejada,
        // que aqui tem como critério o nome para a ordem alfabética:
        for (Product p : set7TreeSetComp) {
            System.out.println(p);
        }

        System.out.println();                   // quebra de linha

        System.out.println("**********************************************************");
     }
}
