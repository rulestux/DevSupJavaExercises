package application;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // EXPRESSÃO LAMBDA DECLARADA (com o predicado declarado):
        //Predicate<Product> pred = p -> p.getPrice() >= 100.0;

        //list.removeIf(pred);

        //EXPRESSÃO LAMBDA 'IN LINE' (sem precisar declara o predicado):
        list.removeIf(p -> p.getPrice() >= 100.0);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
