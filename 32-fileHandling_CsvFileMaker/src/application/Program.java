package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> csvLines = new ArrayList<>();

        // coletando dados sobre o arquivo:
        System.out.println("Enter the file name:");
        String fileName = sc.nextLine();
        System.out.print("Enter the number of lines: #");
        int ln = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the number of columns: #");
        int cn = sc.nextInt();
        sc.nextLine();

        // coletando e ordenando os dados para o arquivo CSV:
        for (int i = 1; i <= ln; i++) {
            System.out.println("Line #" + i + ":");
            // instanciando objeto 'lineBuilder' da classe 'StringBuilder'
            // para montar as linhas do arquivo:
            StringBuilder lineBuilder = new StringBuilder();

            for (int j = 1; j <= cn; j++) {
                System.out.print("Enter column #" + j + " data: ");
                String cData = sc.nextLine();
                lineBuilder.append(cData);
                // apensando vírgulas entre as 'colunas' até o penúltimo dado:
                if (j < cn) {
                    lineBuilder.append(",");
                }
            }
            // adicionando o objeto 'lineBuilder', convertido em string pelo
            // método 'toString()' como nó da lista 'csvLines':
            csvLines.add(lineBuilder.toString());
        }

        // criando o diretório de trabalho, incluindo 'System.getProperty()',
        // para o java rastrear diretório de usuário no Debian ou qualquer
        // outra plataforma:
        File dir = new File(System.getProperty("user.home"), "Java_CSV_Files");
        // efetivando e testando a criação do diretório:
        if (dir.mkdir()) {
            System.out.println(dir + " directory created successfully.");
        }
        else {
            System.out.println(dir + " diretory already exists or failed to create.");
        }

        // criando o arquivo com a extensão *.csv:
        File file = new File(dir, fileName + ".csv");
        // como parâmetros do 'try', entram as instanciações de:
        // 'FileWriter' e 'BufferedWriter':
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            // implementação do 'for each' para a lista 'csvLines'
            // para escrever as linhas no arquivo:
            for (String line : csvLines) {
                // escrevendo cada linha usando o conteúdo da variável 'line'
                // através do método 'BufferedWriter.write()':
                bw.write(line);
                bw.newLine();
            }
            System.out.println(file + " file created successfully.");
        }
        // tratando exceção usando recursos nativos do Java:
        catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }
        sc.close();
    }
}
