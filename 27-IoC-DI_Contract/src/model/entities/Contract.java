package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private Integer number;
    private LocalDate date;
    private Double totalValue;

    // conforme implementação esboçada pelo diagrama UML,
    // como sinalizou o '*' (asterisco), devem-se instanciar
    // vários objetos da classe 'Installment' (parcelas);
    // para tanto, utiliza-se a classe lista:
    private List<Installment> installments = new ArrayList<>();

    public Contract() {
    }

    // construtor sem as 'installments' (parcelas), uma vez que,
    // quando a classe Contract for instanciada, ainda não haverá
    // parcelas:
    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    // getter sem setter da lista, porque a lista não é alterada
    // por setter:
    public List<Installment> getInstallments() {
        return installments;
    }
}
