package application;

// importando a CLASSE padrão Java '.ArrayList', pois as listas
// precisam ser instanciadas, mas não podem sê-lo diretamente,
// uma vez que elas não são CLASSES; as listas são INTERFACES
// e só CLASSES podem ser instanciadas como OBJETOS; assim sendo,
// a CLASSE padrão 'ArrayList' fará esse trabalho aqui:
import java.util.ArrayList;
// importando a INTERFACE padrão Java 'List':
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // instanciando a INTERFACE 'List', como OBJETO 'list'
        // do TIPO 'Employee' através da CLASSE padrão 'ArrayList':
        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        // criando a variável local 'N' para receber o número de
        // NODES (nós) que vão compor a LIST:
        int N = sc.nextInt();
        // loop FOR para preencher os NODES da LIST:
        for (int i=0; i<N; i++) {
            // quebra de linha:
            System.out.println();
            // entrada dos dados:
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            // testando se o 'id' inserido já existe:
            while (hasId(list, id)) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            // note-se que, como o 'sc' anterior foi para um 'int',
            // assim como qualquer outro tipo primitivo, precisamos
            // 'consumir' a próxima 'ln' deixada em buffer pelo ENTER
            // antes de seguir com o uso do 'scanner':
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            // instanciação do objeto 'emp' a partir da CLASSE
            // 'entities.Employee', com os parâmetros do CONSTUCTOR
            // para armazenar os dados inseridos:
            Employee emp = new Employee(id, name, salary);

            // comando para inserção de NODE à lista
            // ao final do loop FOR:
            list.add(emp);
        }

        // quebra de linha:
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        // solução mais simples, usando função (método) extra abaixo,
        // fora do escopo do probrama principal:
        //Integer pos = position(list, idSalary);
        //if (pos == null) {
        //    System.out.println("Employee not found.");
        //}
        //else {
        //    System.out.print("Enter the percentage: ");
        //    double percent = sc.nextDouble();
        //    list.get(pos).increaseSalary(percent);
        //}

        // solução mais elegante, com uso de expressões lambda:

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("Employee not found.");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }


        // quebra de linha:
        System.out.println();
        System.out.println("List of Employees:");
        // 'for each' para usar o 'forString()' de cada instância da CLASSE
        // 'entities.Employee', OBJETO 'emp', contido na LISTA 'list':
        for (Employee e : list) {
            System.out.println(e);
        }


    sc.close();
    }

    // criando função (método) auxiliar para retornar a posição de um nó
    // na lista fora do ESCOPO do programa principal, sendo portanto
    // 'List<Employee> list' outra instanciação independente de
    // 'List'; esta função também é 'static' para permitir o uso
    // dela pela 'static main';
    // 'positions' receberá entre () essa instância mais um inteiro
    // 'id', cujo valor servirá de referência para buscar o 'id'
    // que o programa precisa encontrar para fazer o incremento do
    // salário:
    public static Integer position(List<Employee> list, int id) {
        // 'for' enquanto 'i' (o índice) for menor do que o tamanho
        // da LISTA (list.size()):
        for (int i=0; i < list.size(); i++) {
            // se a função 'list.get(i)' na posição 'i' obtiver
            // '.getId()' um valor 'id' igual '==' ao 'id' fornecido
            // como argumento acima, retornar o valor de 'i'
            // para ser usado como não 'null' na variável 'position'
            // na função principal:
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
