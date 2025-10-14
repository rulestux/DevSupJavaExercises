package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

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
        // programa para calcular a média dos valores dos produtos
        // em arquivo *.csv e retornar os produtos com valor abaixo
        // da média calculada.

        // leitura do arquivo:
        String path = file.toString();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Product> list = new ArrayList<>();

            String lineReading = br.readLine();
            while (lineReading != null) {
                String[] fields = lineReading.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                lineReading = br.readLine();
            }

            // criação de 'pipeline' 'stream' para obter a soma dos valores
            // dos produtos:
            double avg = list.stream()
                // método 'map()' para extrair apenas os valores dos
                // itens mapeados:
                .map(p -> p.getPrice())
                // função 'reduce()' para aplicar a expressão de soma
                // de todos os valores rastreados acima, dividindo
                // pelo comprimento da lista, que é a quantidade
                // total de itens, com o que se obtém a média:
                .reduce(0.0, (x, y) -> x + y) / list.size();

            System.out.println("Average price: " + String.format("$%.2f", avg));

            // obtendo uma lista em ordem alfabética decrescente dos
            // produtos com valores abaixo da média:

            // instanciação de 'Comparator' para ordenar em ordem
            // alfabética:
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            List<String> names = list.stream()
                .filter(p -> p.getPrice() < avg)
                .map(p -> p.getName())
                // método 'Comparator' para inverter a ordem:
                .sorted(comp.reversed())
                // método para converter a stream em lista:
                .collect(Collectors.toList());

            // função 'forEach()' de strings para receber o consumer
            // sout:
            names.forEach(System.out::println);

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
