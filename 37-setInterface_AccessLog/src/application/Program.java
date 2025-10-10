package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.LogEntry;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



//===========================================================================//
        // GERAÇÃO DO ARQUIVO:
        List<String> inputLines = new ArrayList<>();

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();
        System.out.print("Enter the number of logs: #");
        int ln = sc.nextInt();
        sc.nextLine();

        // coletando e ordenando os dados para o arquivo:
        for (int i = 1; i <= ln; i++) {
            // instanciando objeto 'lineBuilder' da classe 'StringBuilder'
            // para montar as linhas do arquivo:
            System.out.print("Log #" + i + " name: ");
            String nameInput = sc.nextLine();
            System.out.print("Log #" + i + " moment (DD/MM/YYYY HH:MM:SS): ");
            try {
                LocalDateTime momentInput = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                inputLines.add(nameInput + " " + momentInput.toString());
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid date format: " + e.getMessage());
            }
        }

        // criando o diretório de para o arquivo:
        File dir = new File(System.getProperty("user.home"), "Java_TXT_Files");
        if (dir.mkdir()) {
            System.out.println(dir + " directory created successfully.");
        }
        else {
            System.out.println(dir + " diretory already exists or failed to create.");
        }

        // criando o arquivo com a extensão *.txt:
        File file = new File(dir, fileName + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String lineWriting : inputLines) {
                bw.write(lineWriting);
                bw.newLine();
            }
            System.out.println(file + " file created successfully.");
        }
        catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }

        // FIM DA GERAÇÃO DO ARQUIVO
//===========================================================================//
        // EXERCÍCIO ORIGINAL

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            Set<LogEntry> set = new HashSet<>();

            // lendo as linhas do arquivo:
            String lineReading = br.readLine();
            // enquanto 'lineReading' for não 'null', i. e., até o final
            // do conteúdo do arquivo, executar:
            while (lineReading != null) {

                // o vetor de strings 'fields' recebe cada linha com o critério
                // para a separação dos campos definidos por 'split' na leitura
                // dos espaços em branco entre os elementos:
                String[] fields = lineReading.split(" ");
                // 'username' recebe o conteúdo da primeira posição '0' de cada
                // linha vetor 'fields':
                String username = fields[0];
                // 'moment' recebe o conteúdo da segunda posição '1':
                LocalDateTime moment = LocalDateTime.parse(fields[1]);

                set.add(new LogEntry(username, moment));

                lineReading = br.readLine();
            }
            System.out.println("Total users: " + set.size());
        }
        catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        sc.close();
    }
}
