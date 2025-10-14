package util;

import java.util.function.Consumer;

import entities.Product;

// implementando a interface CONSUMER:
public class PriceUpdate implements Consumer<Product>{

    // método para incrementar 10% do valor:
    @Override
    public void accept(Product p) {
        p.setPrice((p.getPrice() * 1.1));
    }
}
