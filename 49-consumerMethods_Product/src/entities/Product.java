package entities;

public class Product {

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

    // declaração de método estático, que trabalha com o
    // produto recebido como argumento:
    public static void staticPriceUpdate(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    // declaração de método não estático, que trabalha com o
    // próprio produto da instância, e não com o produto passado
    // como argumento:
    public void nonStaticPriceUpdate() {
        price = price * 1.1;
    }

    @Override
    public String toString() {
        return "Product name: "
            + getName()
            + ", price: "
            + String.format("$%.2f", getPrice());
    }
}
