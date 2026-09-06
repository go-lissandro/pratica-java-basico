package br.com.lissandro.exercicios;
import java.util.Scanner;
import java.time.Year;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== EXERCÍCIOS - FUNDAMENTOS DA LINGUAGEM =====");
            System.out.println("1. Saudação com nome e ano de nascimento");
            System.out.println("2. Área do quadrado");
            System.out.println("3. Área do retângulo");
            System.out.println("4. Diferença de idade entre 2 pessoas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            if (opcao == 0) break;

            switch (opcao) {
                case 1: saudacao(sc); break;
                case 2: areaQuadrado(sc); break;
                case 3: areaRetangulo(sc); break;
                case 4: diferencaIdade(sc); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }

    private static void saudacao(Scanner sc) {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu ano de nascimento: ");
        int ano = sc.nextInt();
        sc.nextLine();
        int idade = Year.now().getValue() - ano;
        System.out.println("Olá " + nome + " você tem " + idade + " anos");
    }

    private static void areaQuadrado(Scanner sc) {
        System.out.print("Digite o tamanho do lado do quadrado: ");
        double lado = sc.nextDouble();
        sc.nextLine();
        double area = lado * lado;
        System.out.println("Área do quadrado: " + area);
    }

    private static void areaRetangulo(Scanner sc) {
        System.out.print("Digite a base do retângulo: ");
        double base = sc.nextDouble();
        System.out.print("Digite a altura do retângulo: ");
        double altura = sc.nextDouble();
        sc.nextLine();
        double area = base * altura;
        System.out.println("Área do retângulo: " + area);
    }

    private static void diferencaIdade(Scanner sc) {
        System.out.print("Digite o nome da primeira pessoa: ");
        String nome1 = sc.nextLine();
        System.out.print("Digite a idade da primeira pessoa: ");
        int idade1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome da segunda pessoa: ");
        String nome2 = sc.nextLine();
        System.out.print("Digite a idade da segunda pessoa: ");
        int idade2 = sc.nextInt();
        sc.nextLine();
        int diferenca = Math.abs(idade1 - idade2);
        System.out.println("A diferença de idade entre " + nome1 + " e " + nome2 + " é " + diferenca + " anos");
    }
}