package services;

public class BrazilInterestService implements InterestService {

    private double interestRate;

    public BrazilInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
    // com a implementação do método 'default' na interface, o método não
    // precisa ser repetido nas classes que a implementam.
}
