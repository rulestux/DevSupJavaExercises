package application;

import java.text.ParseException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Program {

    // programa para entrar quantidades, por turma, de alunos, cujos IDs serão
    // inseridos e armazenados em grupos 'set<Integer>', que representam
    // as turmas, recebendo 'HashSet<>()' para habilitar a comparação que
    // poderá resultar no total de alunos de um professor, sem repetir
    // IDs:
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        System.out.print("How many students for course A? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=1; i <= n; i++) {
            System.out.print("student #" + i + " ");
            int number = sc.nextInt();
            a.add(number);
        }
        System.out.print("How many students for course B? ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i=1; i <= n; i++) {
            System.out.print("student #" + i + " ");
            int number = sc.nextInt();
            b.add(number);
        }
        System.out.print("How many students for course C? ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i=1; i <= n; i++) {
            System.out.print("student #" + i + " ");
            int number = sc.nextInt();
            c.add(number);
        }

        // variável de comparação 'total':

        Set<Integer> total = new HashSet<>(a);
        total.addAll(b);
        total.addAll(c);

        System.out.println("Total students: " + total.size());

        sc.close();
    }
}
