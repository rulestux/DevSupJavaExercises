package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // instanciação de uma lista de strings 'names' que
        // receberá os nomes em 'upper case';
        // para aplicar o método estático 'UpperCaseName()',
        // é preciso usar a função 'map()' de 'stream()',
        // uma função que permite aplicar outras funções
        // sobre cada elemento de uma 'stream()';
        // note-se que a 'List' foi convertida em 'stream,
        // para com o 'map' se aplicar o 'UpperCaseName',
        // e depois a 'stream' é revertida novamente em
        // 'List' com o 'Collectors.toList()':
        //List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

        // método não estático:
        List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
