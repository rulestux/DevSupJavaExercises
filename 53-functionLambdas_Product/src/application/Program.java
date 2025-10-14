package application;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // EXPRESSÃO LAMBDA DECLARADA (com o predicado declarado):
        //Function<Product, String> func = p -> p.getName().toUpperCase();

        //List<String> names = list.stream().map(func).collect(Collectors.toList());

        // EXPRESSÃO LAMBDA 'IN LINE' (sem precisar declara o predicado):

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
