package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.ProductService;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // instanciação da classe 'ProductService', em
        // cuja sequência de parâmetros está o 'Predicate'
        // 'criteria':
        ProductService ps = new ProductService();

        // aplicando o método de soma filtrada, definindo o
        // comportamento do objeto 'criteria' com expressão lambda:
        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println("Sum = " + String.format("$%.2f", sum));
    }
}
