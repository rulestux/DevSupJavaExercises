package entities;

// incorporam-se todos os atributos e métodos de 'Account'
// vinculando-a por herança através de 'extends' no
// entrypoint:
public class BusinessAccount extends Account {

    private Double loanLimit;

    // aconselha-se incluir o 'super()' para prevenir alguma alteração
    // futura na lógica do construtor padrão da classe original,
    // a superclasse, garantindo a eficiência da herança:
  public BusinessAccount() {
        super();
    }

    // inclusão do 'super()' para importar os elementos do construtuor
    //  na classe original (superclasse):
   public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }
}
