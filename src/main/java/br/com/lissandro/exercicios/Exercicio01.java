package br.com.lissandro.exercicios;
import java.util.Scanner;
import java.time.Year;
public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        int anoNascimento = sc.nextInt();
        int idade = Year.now().getValue() - anoNascimento;
        System.out.println("Olá " + nome + " você tem " + idade + " anos");
        sc.close();
    }
}
