package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //====================================================================//
        // INICIANDO A GERAÇÃO DO ARQUIVO
        List<String> csvLines = new ArrayList<>();

        // coletando dados sobre o arquivo:
        System.out.println("Enter the file name:");
        String fileName = sc.nextLine();
        System.out.print("Enter the number of lines: #");
        int ln = sc.nextInt();
        sc.nextLine();

        // coletando os dados para o arquivo CSV:
        for (int i = 1; i <= ln; i++) {
            System.out.println("Line #" + i + " data (ITEM,ITEM,etc):");
            String lineWriting = sc.nextLine();
            csvLines.add(lineWriting);
        }

        // criando o diretório de trabalho:
        File dir = new File(System.getProperty("user.home"), "Java_CSV_Files");
        if (dir.mkdir()) {
            System.out.println(dir + " directory created successfully.");
        }
        else {
            System.out.println(dir + " diretory already exists or failed to create.");
        }

        // criando o arquivo com a extensão *.csv:
        File file = new File(dir, fileName + ".csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String lineWriting : csvLines) {
                bw.write(lineWriting);
                bw.newLine();
            }
            System.out.println(file + " file created successfully.");
        }
        catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }

        // CONCLUÍDA A GERAÇÃO DO ARQUIVO
        //====================================================================//

        // INÍCIO DO EXERCÍCIO
        // programa para retornar o e-mail dos funcionários cujos salários
        // são maiores que um valor fornecido.

        // leitura do arquivo:
        String path = file.toString();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String lineReading = br.readLine();
            while (lineReading != null) {
                String[] fields = lineReading.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                lineReading = br.readLine();
            }

            System.out.print("Enter salary: $");
            Double min = sc.nextDouble();

            // lista de e-mails:
            List<String> emails = list.stream()
                // filtrar lista pelos salários maiores que o
                // 'min' fornecido:
                .filter(x -> x.getSalary() > min)
                // mapear listando os e-mails:
                .map(x -> x.getEmail())
                // ordenar os emails:
                .sorted()
                // recompor a lista:
                .collect(Collectors.toList());

            System.out.println();       // quebra de linha
            System.out.println("E-mail of people whose salary is more than " + String.format("$%.2f", min) + ":");
            // exibindo e-mails:
            emails.forEach(System.out::println);

            // listando funcionários cuja inicial é 'M' e somando seus
            // salários:
            double sum = list.stream()
                .filter(x -> x.getName().charAt(0) == 'M')
                .map(x -> x.getSalary())
                .reduce(0.0, (x, y) -> x + y);

            System.out.println();       // quebra de linha
            System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("$%.2f", sum));
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
