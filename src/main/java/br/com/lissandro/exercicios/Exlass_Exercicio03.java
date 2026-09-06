package br.com.lissandro.exercicios;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double altura = sc.nextDouble();
        double area = base * altura;
        System.out.println("Área do retângulo: " + area);
        sc.close();
    }
}
