package entities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company() {
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double basicTax;
        if (numberOfEmployees > 10) {
            basicTax = getAnualIncome() * 0.14;
        }
        else {
            basicTax = getAnualIncome() * 0.16;
        }
        return basicTax;
    }

    // implementação alternativa, com OPERADOR TERNÁRIO:
    //public Double tax() {
    //    double basicTax = (numberOfEmployees >10 ) ? getAnualIncome() * 0.14 : getAnualIncome() * 0.16;
    //    return basicTax;
    //}

    public String toString() {
        return getName()
            + ": $"
            + String.format("%.2f", tax());
    }

}
