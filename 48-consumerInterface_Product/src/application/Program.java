package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import util.PriceUpdate;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // aplicando a classe que estende a CONSUMER ao
        // método 'list.forEach':
        list.forEach(new PriceUpdate());

        // chamando o 'System.out.println()' com REFERENCE METHOD:
        list.forEach(System.out::println);
    }
}
