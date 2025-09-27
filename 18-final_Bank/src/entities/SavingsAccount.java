package entities;

// para impedir que sejam criadas subclasses de uma classe
// usa-se 'final' no entrypoint para sinalizar que
// ela já é a última em uma sequência de
// subclasses herdadas; uma 'final class' também apresenta
// maior performance no runtime das operações:
public final class SavingsAccount extends Account {

	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void updateBalance () {
		balance += balance * interestRate;
	}

	// assim como se pode impedir que uma classe seja herdadas
	// em uma subclasse, um método também pode ter sua sobreposição
	// impedida pelo uso de 'final'; normalmente, é convém acrescentar
	// o 'final' em métodos já sobrepostos para evitar inconsistências
	// na aplicação:
	@Override
    public final void withdraw(double amount) {
        balance -= amount;
	}
}
