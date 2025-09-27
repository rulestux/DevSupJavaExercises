package application;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of lines: ");
    int m = sc.nextInt();
    System.out.print("Enter the number of columns: ");
    int n = sc.nextInt();
    sc.nextLine();

    // instanciando a matriz com o número de linhas e colunas;
    // cada linha é um vetor cujas posições são novas colunas:
    int[][] mat = new int[m][n];

    // para cada 'i' forma-se uma coluna com posilções 'j':
    for (int i=0; i<mat.length; i++) {
        for (int j=0; j<mat[i].length; j++) {
            mat[i][j] = sc.nextInt();
        }
    }

    System.out.println("\nMain diagonal: ");
    for (int i=0; i<mat.length; i++) {
        System.out.print(mat[i][i] + " ");
    }

    // contando os negativos:
    int count = 0;
    for (int i=0; i<mat.length; i++) {
        for (int j=0; j<mat[i].length; j++) {
            if (mat[i][j] < 0) {
                count++;
            }
        }
    }
    System.out.println("\nNegative numbers: " + count);

    // inserindo um número para encontrar sua posição na matriz:
    System.out.print("Enter the number to find its position: ");
	int x = sc.nextInt();

    // buscando as posições na matriz:
    for (int i=0; i<mat.length; i++) {
		for (int j=0; j<mat[i].length; j++) {
			if (mat[i][j] == x) {
				System.out.println("Position " + i + "," + j + ":");
				if (j > 0) {
					System.out.println("Left: " + mat[i][j-1]);
				}
				if (i > 0) {
					System.out.println("Up: " + mat[i-1][j]);
				}
				if (j < mat[i].length-1) {
					System.out.println("Right: " + mat[i][j+1]);
				}
				if (i < mat.length-1) {
					System.out.println("Down: " + mat[i+1][j]);
				}
			}
		}
	}

    sc.close();
    }
}
