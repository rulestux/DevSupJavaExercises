package entities;

public class Account {

    // encapsulation: private variables == private attributes:
    private int number;
    private String holder;
    private double balance;

    // generating constructors (or builders):
    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    /* gerado o CONSTRUCTOR com os 3 argumentos, o atributo 'balance',
     * que representa o saldo, deve ser substituído pela operação de
     * depósito 'deposit' declarada abaixo, posto que essa será a
     * primeira movimentação da conta, que não possui saldo pre-existente.
     * esse procedimento simplifica posteriores alterações no código,
     * caso alguma política do contratante a respeito da criação de
     * novas contas seja alterada:*/
    public Account(int number, String holder, double initialDeposit) {
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
    }

    // generating accessors (getters and setters):
    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }
    /* os ACCESSORS 'setNumber()' e 'setBalance()' foram removidos
     * porque esses dados não vão sofrer alteração durante a execução
     * do programa.*/

    /* ao 'balance' (saldo), será acrescido o 'amout' (montante),
     * variável local que vai receber o valor de 'deposit' que será
     * adicionado ao saldo, por isso 'balance' recebe seu próprio valor
     * somado ao 'amount' com +=.*/
    public void deposit(double amount) {
        balance += amount;
    }
    /* o inverso acontece em 'withdraw' (saque), que vai subtrair
     * um valor de saque de 'balance' através da variável local
     * 'amount', por isso o uso de -=; além disso, ao valor
     * a se subtrair deve ser adicionado o valor de $5
     * da taxa de saque:*/
    public void withdraw(double amount) {
        balance -= amount + 5.0;
    }

    // acrescentando o método 'toString()' para o acesso formatado
    // aos dados:
    @Override
    public String toString() {
        return "Account " +
            "number: " + getNumber() +
            ", holder: " + getHolder() +
            ", balance: $ " + String.format("%.2f", getBalance());
    }

}
