package entities;

// a classe 'Product' passa a implementar a interface 'Comparable<>', o que a
// leva a sobrescrever o método 'compareTo()' mais abaixo:
public class Product implements Comparable<Product>{

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + ", $" + String.format("%.2f", getPrice());
    }

    @Override
    public int compareTo(Product other) {
        // o método 'compareTo()' nesse programa compara o valor do produto
        // atual com o valor de outro produto objeto da mesma classe:
        return price.compareTo(other.getPrice());
    }
}
