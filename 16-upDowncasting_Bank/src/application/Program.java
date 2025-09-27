package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

    	Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING
        // objeto de subclasse pode ser atrubuído a um objeto
        // da superclasse:
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING
        // um objeto de superclasse não pode ser atrubuído
        // diretamente da mesma forma a um objeto de subclasse;
        // deve-se, então, fazer um 'casting':
        BusinessAccount bacc1 = (BusinessAccount)acc2;
        bacc1.loan(100.0);

        // por outro lado, quando for necessário atribuir um objeto
        // de uma subclasse a algum da superclasse que recebeu
        // um obbjeto de outra subclasse, como no caso de 'acc3',
        // o casting não será suficiente, sendo necessário usar
        // a expressão 'instanceof' dentro de uma estrutura
        // condicional:
        //BusinessAccount bacc2 = (BusinessAccount)acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount bacc2 = (BusinessAccount)acc3;
                bacc2.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount bacc2 = (SavingsAccount)acc3;
            bacc2.updateBalance();
            System.out.println("Update!");
        }

    }
}
