package br.com.lissandro.exercicios;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome1 = sc.nextLine();
        int idade1 = sc.nextInt();
        sc.nextLine(); // consume newline
        String nome2 = sc.nextLine();
        int idade2 = sc.nextInt();
        int diff = Math.abs(idade1 - idade2);
        System.out.println("A diferença de idade entre " + nome1 + " e " + nome2 + " é " + diff + " anos");
        sc.close();
    }
}
