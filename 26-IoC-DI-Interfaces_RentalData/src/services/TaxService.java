package services;

// a implementação da interface simplifica eventuais
// manutenções ou escaladas do projeto; por exemplo,
// caso a classe 'BrazilTaxService' precise ser substituída
// por uma classe que represente a tributação de outro país,
// em caso de necessidade de adaptar o código, basta que
// a nova classe implemente -- com uma propagação usando
// 'implements' no entrypoint -- a interface, dispensando
// as inúmeras alterações no corpo do código das outras
// classes que referenciam métodos de classes de tributação;
// a partir da interface, pode-se fazer injeção de dependência
// pelo construtor, ao se instanciar objeto da interface
// numa classe que a implemente.
public interface TaxService {

    // na interface, já se subentende que os
    // métodos são públicos e abstratos, não
    // sendo necessário declará-los como
    // 'public abstract':
    Double tax(Double amount);
}
