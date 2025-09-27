package entities;

public class Product {

    /* o encapsulamento consiste em tornar privados atributos de uma
     * classe, que passam a ser acessados através de getters e setters.
     * por convenção, getters e setters ficam depois dos constructors.
     * note que os atributos 'public' se tornam 'private': */
    private String name;
    private double price;
	
    /* constructor: para configurar o construtor, precisamos passar
     * os elementos que serão requeridos como parâmetros do método
     * e referenciar os atributos do objeto com a palavra 'this.'.
	 * a palavra 'this.' faz referência à CLASSE, forçando a
	 * retomada do ATRIBUTO da classe, explicitando-o, retirando
	 * a ambiguidade com o PARÂMETRO (ou argumento) do MÉTODO,
	 * i. e., o parâmetro da presente FUNÇÃO, uma variável local
	 * que possui o mesmo nome, e é chamado dentro das {}
	 * da função, sem o 'this.'. */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

}
