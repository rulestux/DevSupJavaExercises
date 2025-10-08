package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

public class Program {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        // usando 'System.getProperty()' para ler o arquivo em qualquer
        // diretório de usuário:
        String homeDir = System.getProperty("user.home");
        // usando 'File.separator' para separadores multiplataforma:
        String path = homeDir + File.separator + "CSV_Files" + File.separator + "in.csv";

        // início da estrutura try-catch com a instanciação do 'BufferedReader'
        // como parâmetro:
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String employeeCsv = br.readLine();
            while (employeeCsv != null) {
                // vetor para extrair os dados do arquivo *.csv
                // separando-os usando a vírgula como critério:
                String[] fields = employeeCsv.split(",");
                // instanciando cada empregado extraindo os nomes e salários
                // das respectivas posições de cada vetor (1 vetor/empregado):
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                // ler na variável 'employeeCsv' a próxima linha até encontrar
                // a linha vazia:
                employeeCsv = br.readLine();
            }
            // para ordenar a lista de instâncias da classe 'Employee' usando o
            // 'Collections.sort', a classe precisa implementar a interface
            // 'Comparable'.
            Collections.sort(list);
            for (Employee emp : list) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
