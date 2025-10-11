package services;

import java.security.InvalidParameterException;

public interface InterestService {

    double getInterestRate();

    // implementação do método 'default' na interface, cujo código será
    // reaproveitado em toda a classe que implementar a presente interface:
    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("Months must be greater than zero.");
        }
        // note-se que 'Math.pow' é um método para potenciação, em que
        // o último argumento é o expoente:
        return amount * Math.pow(1.0 + getInterestRate() / 100, months);
    }
}
