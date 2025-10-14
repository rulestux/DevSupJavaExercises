package services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {

    // incluindo o 'Pradicate' 'criteria' como parâmetro,
    // para não inserir o critério de teste no corpo do
    // método, dando liberdade de uso/reuso ao permitir
    // construir o critério no momento da instanciação:
    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum = 0.0;
        for (Product p : list) {
            // incluindo o objeto 'criteria', que poderá ser definido no momento
            // da instanciação, com uma expressão lambda:
            if (criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
