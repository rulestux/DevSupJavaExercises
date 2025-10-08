package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        // usando 'System.getProperty()' para ler o arquivo em qualquer
        // diretório de usuário:
        String homeDir = System.getProperty("user.home");
        // localização do arquivo criado pelo projeto 'CsvMaker' anexo a este
        // exercício, usando 'File.separator' para separadores multiplataforma:
        String path = homeDir + File.separator + "CSV_Files" + File.separator + "in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                // criando um vetor para a leitura das linhas, usando ','
                // como delimitador para a criação de subarrays:
                String[] fields = line.split(",");
                // instanciando um produto para cada node da lista, usando os
                // dados da posição '0' do vetor para o nome e da posição '1'
                // para o valor:
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            // inicialmente, o método 'max' só funciona com inteiros, mas com
            // a implementação dos 'generics'
            Product x = CalculationService.max(list);
            System.out.println("Most expensive:");
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
