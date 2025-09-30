 package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    // refatorando o exercício conforme correção do professor;
    // tratamento de exceções transferido para o novo método
    // 'validateWithdraw', que é chamado no corpo do método
    // 'withdraw' antes de concluir a execução da função:
    public void withdraw(Double amount) throws DomainException {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(double amount) throws DomainException {
        if (amount > getWithdrawLimit()) {
            throw new DomainException("The amount exceeds withdraw limit.");
        }
        if (amount > getBalance()) {
            throw new DomainException("Not enough balance.");
        }
    }
}
