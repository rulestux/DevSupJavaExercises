package application;

import java.util.Scanner;

import entities.Account;

public class Program {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    /* criando variável 'account' para instanciar objeto da classe
     * 'entities.Account', a ser chamada eventualmente aqui no programa
     * principal: */
    Account account;

    System.out.print("Enter account number: ");
    int number = sc.nextInt();
    System.out.print("Enter account holder: ");
    sc.nextLine();
    String holder = sc.nextLine();
    System.out.print("Is there an initial deposit (y/n)? ");
    char response = sc.next().charAt(0);
    if (response == 'y') {
        System.out.print("Enter initial deposit value: ");
        double initialDeposit = sc.nextDouble();
        // usando o constructor:
        account = new Account(number, holder, initialDeposit);
    }
    else {
        // usando o constructor em overload (sobrecarga):
        account = new Account(number, holder);
    }

    System.out.println();
    System.out.println("Account data: ");
    /* ao chamar o objeto 'account', instância da classe 'entities.Account'
     * no contexto de um 'System.out.println()', como parâmetro,
     * automaticamente o método 'toString()' de 'entities.Account'
     * é acionado.*/
    System.out.println(account);

    System.out.println();
    System.out.print("Enter a deposit value: ");
    // variável temporária para receber o dado do 'deposit':
    double depositValue = sc.nextDouble();
    // atribuindo o conteúdo da variável como parâmetro do médodo
    // 'deposit' da classe 'entities.Account' através da variável
    // 'account':
    account.deposit(depositValue);
    System.out.println();
    System.out.println("Updated account data: ");
    System.out.println(account);

    System.out.println();
    System.out.print("Enter a withdraw value: ");
    // variável temporária para receber o dado do 'withdraw':
    double withdrawValue = sc.nextDouble();
    account.withdraw(withdrawValue);
    System.out.println();
    System.out.println("Updated account data: ");
    System.out.println(account);

    sc.close();
    }
}
