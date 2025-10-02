package model.services;

// com a implementação da interface 'TaxService',
// a classe 'BrazilTaxService' passa a se comportar
// como uma subclasse da interface 'TaxService',
// por upcasting, com a inclusão de 'implements'
// em seu entrypoint:
public class BrazilTaxService implements TaxService {

    public Double tax(Double amount) {
        if (amount <= 100.0) {
            return amount * 0.2;
        }
        else {
            return amount * 0.15;
        }
    }
}
