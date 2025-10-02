package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    // associações de classe:
    private BrazilTaxService taxService;

    // sem o construtor padrão, para forçar o preenchimento
    // dos argumentos:
    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    // a classe 'RentalService' também prescinde de getters e setters;

    public void processInvoice(CarRental carRental) {
        // utilizando a classe 'Duration' para obter a mensuração
        // do lapso de tempo entre o início e o fim do aluguel
        // com o método 'toMinutes()':
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        // convertendo os minutos em unidaes de horas com
        // excedentes enventuais em decimais:
        double hours = minutes / 60.0;
        double basicPayment;
        if (hours <= 12.0) {
            // utilizando o método 'Math.ceil' para arredondar
            // o valor decimal eventual da variável 'hours'
            // para unidade inteira maior:
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            // dividindo a variável 'hours' por 24, para obter
            // o valor em unidades de dias:
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}

