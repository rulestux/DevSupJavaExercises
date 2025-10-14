package util;

import java.util.function.Predicate;

import entities.Product;

// implementando a interface PREDICATE:
public class ProductPredicate implements Predicate<Product> {

    @Override
    public boolean test (Product p) {
        return p.getPrice() >= 100.0;
    }
}
