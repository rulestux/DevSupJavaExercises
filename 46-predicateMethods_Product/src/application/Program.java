package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 450.0));
        list.add(new Product("HD Case", 80.9));

        // instanciação da classe PRODUCT, com o método estático
        // na posição do predicado, com '::' (METHOD REFERENCE):
        //list.removeIf(Product::staticProductPredicate);

        // instanciação da classe PRODUCT, o método não estático,
        // na posição do predicado, com '::' (METHOD REFERENCE):
        list.removeIf(Product::nonStaticProductPredicate);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
