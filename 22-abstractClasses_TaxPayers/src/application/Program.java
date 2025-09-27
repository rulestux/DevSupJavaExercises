package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ao instanciar a lista do tipo da superclasse abstrata
        // 'TaxPayer', a lógica do upcasting e do polimorfismo
        // entra em ação, na medida em que se podem instanciar nós
        // (nodes) com objetos tanto de subclasse 'Company'
        // quanto da subclasse 'Individual'; o polimorfismo
        // fica mais evidente no comportamento diversificado
        // que o método abstrato 'tax()' terá nas diversas
        // instâncias de 'Company' e 'Individual' ao longo
        // da lista de 'TaxPayer':
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            // implementação de loop 'while' para a validação da entrada:
            while (true) {
                // teste para verificar se o input é válido:
                if (type == 'i' || type == 'c') {
                    // quebra para finalizar o 'while'caso o input
                    // seja válido:
                    break;
                } else {
                    System.out.print("Invalid option. Try again.\nPlease enter 'i' for Individual or 'c' for Company: ");
                    type = sc.next().charAt(0);
                    sc.nextLine();
                }
            }
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: $");
            double anualIncome = sc.nextDouble();
            if (type == 'i') {
                System.out.print("Health expenditures: $");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                sc.nextLine();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();

        System.out.println("TAXES PAID:");
        double sum = 0.0;
        for (TaxPayer tp : list) {
            // para cada TaxPayer 'tp' na lista 'list', será
            // exibido o respectivo 'toString':
            System.out.println(tp);
            // para cada TaxPayer 'tp' na lista 'list', será
            // acrescido um valor de imposto pago
            // à variável sum, por incremento '+=';
            // importante notar que 'tp' é instância
            // da superclasse abstrata 'TaxPayer',
            // cujo método abstrato 'tax()' será utilizado
            // através de 'tp.tax()'; o método abstrato
            // mostra sua utilidade na medida em que sua
            // existência na superclasse permite que ele
            // seja chamado para todos os nós (nodes) da
            // lista 'list', independente de seu
            // comportamento único próprio de cada subclasse,
            // caracterizando o POLIMORFISMO:
            sum += tp.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $%.2f\n", sum);

        sc.close();
    }
}
