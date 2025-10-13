package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//===========================================================================//
        // GERAÇÃO DO ARQUIVO:
        List<String> inputLines = new ArrayList<>();

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();
        System.out.print("Enter the number of candidate lines on all ballot boxes: #");
        int ln = sc.nextInt();
        sc.nextLine();

        // coletando e ordenando os dados para o arquivo:
        for (int i = 1; i <= ln; i++) {
            System.out.print("Candidate #" + i + " name: ");
            String nameInput = sc.nextLine();
            System.out.print("Candidate #" + i + " votes quantity: ");
            Integer votesInput = sc.nextInt();
            sc.nextLine();
            inputLines.add(nameInput + "," + votesInput.toString());
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

        // instanciando a interface 'Map', recebendo um 'LinkedHashMap'
        // para armazenar os dados na ordem de leitura do arquivo:
        Map<String, Integer> votes =  new LinkedHashMap<>();

        // criando variável com o caminho do arquivo a ser lido:
        String path = file.toString();

        // instanciando a classe 'BufferedReader', com 'FileReader', no
        // objeto 'br', recebendo como parâmetro a variável 'path'
        // com o caminho para o arquivo a ser lido:
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // instanciando objeto 'lineReading' para a leitura do arquivo:
            String lineReading = br.readLine();

            // enquanto 'lineReading' não for nulo, executar:
            while (lineReading != null) {
                // criando vetor de strings para armazenar os campos/posições
                // de cada linha, usando como separador ',':
                String[] fields = lineReading.split(",");
                // criando variável 'name' para receber o conteúdo do
                // campo/posição '0' de cada linha/vetor:
                String name = fields[0];
                // criando variável 'count' para receber o conteúdo
                // string de cada posição '1' como inteiro com o método
                // 'Integer.parseInt()':
                int count = Integer.parseInt(fields[1]);

                // teste para contar o total de votos de cada chave/nome:
                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                }
                else {
                    votes.put(name, count);
                }

                // lendo a próxima linha até 'lineReading == null':
                lineReading = br.readLine();
            }

            // imprimindo na tela o resultado da quantidade de votos de
            // cada candidato:
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
