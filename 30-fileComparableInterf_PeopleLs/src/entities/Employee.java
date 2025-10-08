package entities;

// para ordenar a lista de instâncias da classe Employee usando o
// 'Collections.sort', a classe precisa implementar a interface
// 'Comparable'.
public class Employee implements Comparable<Employee> {

    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // método inserido automaticamente pelo jdtls a partir da
    // interface 'Comparable', cuja utilidade é a comparação
    // de objetos instanciados a partir da presente classe:
    @Override
    public int compareTo(Employee other) {
        return name.compareTo(other.getName());
    }
    // caso se deseje ordenar pela outra referência da classe,
    // o salário, pode-se substituir a variável 'name' por 'salary' e
    // 'getName' por 'getSalary'; além disso, pode-se obter uma
    // ordem inversa colocando o sinal negativo na frente do retorno
    // do método: '-salary.compareTo(other.getSalary());'.

    @Override
    public String toString() {
        return getName()
            + ", $"
            + String.format("%.2f", getSalary());
    }

}
