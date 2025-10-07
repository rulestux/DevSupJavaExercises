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

import model.entities.Product;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: #");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: $");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            list.add(new Product(name, price, quantity));
        }

        // criando o diretório de trabalho, incluindo 'System.getProperty()'
        // para o java rastrear diretório de usuário no Debian:
        File dir = new File(System.getProperty("user.home"),"Product_Exercise");
        // efetivando a criação do diretório:
        if (dir.mkdir()) {
            System.out.println(dir + " directory created successfully.");
        }
        else {
            System.out.println(dir + " diretory already exists or failed to create.");
        }

        // criando o arquivo com a lista original de produtos:
        File file = new File(dir, "Products_List.csv");
        // como parâmetros do 'try', entram as instanciações de:
        // 'FileWriter' classe cuja função escreve conteúdo em arquivos e
        // 'BufferedWriter', que confere agilidade ao procedimento:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            // implementação do 'for each' da lista 'list'
            // para escrever as linhas do arquivo:
            for (Product product : list) {
                // escrevendo cada linha usando a saída do
                // método 'toString' de 'product' através
                // do método 'BufferedWriter.write()':
                bw.write(product.toString());
                bw.newLine();
            }
            System.out.println(file + " file created successfully.");
        }
        // tratando exceção usando recursos nativos do Java:
        catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }

        // criando novo diretório para o arquivo final e incluindo
        // 'File.separator' para garantir uma compatibilidade multiplataforma
        // dos separadores:
        dir = new File(System.getProperty("user.home"),"Product_Exercise" + File.separator + "out");
        // efetivando a criação do diretório:
        if (dir.mkdir()) {
            System.out.println(dir + " directory created successfully.");
        }
        else {
            System.out.println(dir + " diretory already exists or failed to create.");
        }
        // criando o arquivo de saída:
        File totalValues = new File(dir, "Summary.csv");

        // instanciando a leitura do arquivo original e
        // a escrita de novo arquivo como parâmetros
        // de novo bloco 'try':
        try (BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bwFinal = new BufferedWriter(new FileWriter(totalValues))) {
        // lendo o arquivo original e processando os dados em novo
        // bloco 'try':
        // declarando variável 'String' para receber os dados de
        // cada linha a ser lida:
        String line = br.readLine();
        while (line != null) {
            // declarando vetores para receber cada linha de
            // atributos respectivos a cada produto, usando
            // as vírgulas que os separam para selecioná-los
            // como diferentes posições de cada vetor:
            String[] atts = line.split(",");
            String name = atts[0];
            double price = Double.parseDouble(atts[1]);
            int quantity = Integer.parseInt(atts[2]);

            // obtendo o valor total de cada produto
            // conforme quantidade:
            double total = price * quantity;

            // preenchendo as linhas do arquivo de saída:
            bwFinal.write(name + "," + total);
            bwFinal.newLine();

            // lendo a próxima linha até econtrar uma linha
            // vazia e concluir o loop:
            line = br.readLine();
        }

            System.out.println(totalValues + " file created successfully.");
        }
        catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        // utilizando o 'finally' para encerrar o scanner e outras
        // instâncias, caso ainda estejam abertas após eventual falha:
        finally {
            if (sc != null)
            sc.close();
        }
    }
}
