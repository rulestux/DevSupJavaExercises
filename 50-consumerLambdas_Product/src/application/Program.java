package application;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Consumer;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // EXPRESSÃO LAMBDA DECLARADA (com o predicado declarado):
        //Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1);
        //list.forEach(cons);;

        // EXPRESSÃO LAMBDA 'IN LINE' (sem precisar declara o predicado):
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        list.forEach(System.out::println);
    }
}
