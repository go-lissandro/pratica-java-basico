package br.com.lissandro.exercicios;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o tamanho do lado do quadrado: ");
        double lado = sc.nextDouble();
        double area = lado * lado;
        System.out.printf("Área do quadrado: %.2f%n", area);
        sc.close();
    }
}
