package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

    // testando as operações da classe 'Account',
    // cuja regra de saque, expressão pelo método withdraw,
    // apresenta cobrança de taxa:
    Account acc1 = new Account(1001, "Alex", 1000.0);
    acc1.withdraw(200.0);
    System.out.println(acc1.getBalance());

    // testando as operações da subclasse 'SavingsAccount',
    // cuja regra de saque, expressa pelo método 'withdraw',
    // apresenta sobreposição de isenção da cobrança de taxa
    // (note-se o upcasting em que um objeto de 'Account'
    // recebe uma instância da subclasse 'SavingsAccount'):
    Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
    acc2.withdraw(200.0);
    System.out.println(acc2.getBalance());

    // testando as operações da subclasse 'BusinessAccount',
    // cuja regra de saque, expressa pelo método withdraw,
    // apresenta uma sobreposição com cobrança de taxa maior
    // do que a da superclasse 'Account' (note-se o upcastong
    // em que um objeto de 'Account' recebe uma instância da
    // subclasse 'BusinessAccount'):
    Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
    acc3.withdraw(200.0);
    System.out.println(acc3.getBalance());
    }
}
