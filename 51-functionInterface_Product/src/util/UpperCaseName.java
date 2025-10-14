package util;

import java.util.function.Function;

import entities.Product;

// classe 'UpperCaseName' implementa a interface 'Function',
// recebendo como parâmetros um objeto 'Product' e um objeto
// do tipo 'String', que será o tipo de retorno:
public class UpperCaseName implements Function<Product, String>{

    // método para retornar em 'upper case' o nome do produto:
    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}
