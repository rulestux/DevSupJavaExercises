package entities;

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

    // implementação dos métodos 'hashCode()' e 'equals()' para as operações
    // com conjuntos:
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product object = (Product) o;

        if (name != null ? !name.equals(object.name) : object.name != null) return false;
        return !(price != null ? !price.equals(object.price) : object.price != null);
    }

    // implementação do método 'toString()' para a operação de comparação com
    // o 'TreeSet':
    @Override
    public String toString() {
        return "Product [name: " + getName() + " | price: $" + String.format("%.2f", getPrice()) + "]";
    }

    // para efetivar a comparação com o 'TreeSet', a classe 'Product'
    // precisa implementar a interface 'Comparable<>'; esta, por sua vez,
    // exige a implementação do método 'compareTo' com a lógica desejada
    // que aqui tem como critério o nome para a ordem alfabética:
    @Override
    public int compareTo(Product other) {
        return name.toUpperCase().compareTo(other.getName().toUpperCase());
    }
}
