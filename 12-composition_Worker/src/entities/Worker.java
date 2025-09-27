package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

    // atributos básicos:
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    // implementando a composição de objetos por associação.
	// na ASSOCIAÇÃO, são vinculadas classes numa relação sem
	// dependência: as classes existem de modo independente, mas
	// passam a ter relação entre si.
    // associação i: instanciando um objeto 'department' da 
	// classe 'entities.department'
    private Department department;
    // associação ii (vários contratos, representados por uma
    // lista | a lista 'contracts' já será instanciada como
    // 'new ArrayList<>()' na declaração do atributo):
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department/*, List<HourContract> contracts*/) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        // como os 'contracts' são uma lista, caracterizando
        // uma composição 'tem muitos', eles não serão
        // incluídos no 'constructor':
        //this.contracts = contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    // removendo 'setters' para que a lista de contratos não seja
    // alterada senão pelos métodos a seguir:
    //public void setContracts(List<HourContract> contracts) {
    //    this.contracts = contracts;
    //}

    // implementação dos métodos previstos para a classe,
	// começando pelos métodos 'add' e 'remove' que substituem
	// os 'setters' para as 'Lists':
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        // 'for each' para verificar cada contrato na lista
        // 'contracts':
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
