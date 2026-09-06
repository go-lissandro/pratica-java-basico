package br.com.lissandro.exercicios;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lado = sc.nextDouble();
        double area = lado * lado;
        System.out.println("Área do quadrado: " + area);
        sc.close();
    }
}
