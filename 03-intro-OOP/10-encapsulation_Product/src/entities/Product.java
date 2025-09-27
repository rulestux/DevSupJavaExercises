package entities;

public class Product {

    /* o encapsulamento consiste em tornar privados atributos de uma
     * classe, que passam a ser acessados através de getters e setters.
     * por convenção, getters e setters ficam depois dos constructors.
     * note que os atributos 'public' se tornam 'private': */
    private String name;
    private double price;
    private int quantity;

    /* constructor: para configurar o construtor, precisamos passar
     * os elementos que serão requeridos como parâmetros do método
     * e referenciar os atributos do objeto com a palavra 'this.'.
	 * a palavra 'this.' faz referência à CLASSE, forçando a
	 * retomada do ATRIBUTO da classe, explicitando-o, retirando
	 * a ambiguidade com o PARÂMETRO (ou argumento) do MÉTODO,
	 * i. e., o parâmetro da presente FUNÇÃO, uma variável local
	 * que possui o mesmo nome, e é chamado dentro das {}
	 * da função, sem o 'this.'. */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalValueInStock() {
        return price * quantity;
    }

    /* getters e setters fazem a referência ao atributo em camelCase,
     * no padrão 'getAttributeName()' e 'setAttributeName()'. */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addProducts(int quantity) {
        /* a palavra 'this.' faz referência à CLASSE, forçando a
         * retomada do ATRIBUTO da classe, explicitando-o, retirando
         * a ambiguidade com o PARÂMETRO (ou argumento) do MÉTODO,
         * i. e., o parâmetro da presente FUNÇÃO, uma variável local
         * que possui o mesmo nome, e é chamado dentro das {}
         * da função, sem o 'this.'. */
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    /* convertendo os dados de ATRIBUTOS dos OBJETOS instanciados na
     * CLASSE 'entities.Product' para String, usando o MÉTODO 'toString()'
     * da CLASSE Object (final, estática) do Java, a fim de que possam ser
     * adequadamente impressos na tela, quando qualquer OBJETO
     * instanciado como a CLASSE 'entities.Product' for chamado pela
     * função 'System.out.println()' no programa principal: */
    public String toString() {
        return name
            + ", $ "
            /* usando a função String.format() para formatar
             * os dados double: */
            + String.format("%.2f", price)
            + ", "
            +quantity
            +" units, Total: $ "
            + String.format("%.2f", totalValueInStock());
    }
}
