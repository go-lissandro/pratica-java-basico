package br.com.lissandro.exercicios;
import java.util.Scanner;

public class ExercicioPetshop {
    static class Maquina {
        private int agua = 0;
        private int shampoo = 0;
        private boolean temPet = false;
        private boolean petLimpo = false;
        private boolean precisaLimpeza = false;

        void colocarPet() {
            if (temPet) {
                System.out.println("Já existe um pet na máquina.");
            } else if (precisaLimpeza) {
                System.out.println("A máquina precisa ser limpa antes de colocar outro pet.");
            } else {
                temPet = true;
                petLimpo = false;
                System.out.println("Pet colocado na máquina.");
            }
        }

        void retirarPet() {
            if (!temPet) {
                System.out.println("Não há pet na máquina.");
                return;
            }
            temPet = false;
            if (petLimpo) {
                System.out.println("Pet retirado da máquina (já limpo).");
            } else {
                precisaLimpeza = true;
                System.out.println("Pet retirado sem estar limpo. A máquina precisa de limpeza antes do próximo banho.");
            }
        }

        void darBanho() {
            if (!temPet) {
                System.out.println("Não há pet na máquina para dar banho.");
            } else if (agua < 10) {
                System.out.println("Água insuficiente (necessário 10 litros). Disponível: " + agua);
            } else if (shampoo < 2) {
                System.out.println("Shampoo insuficiente (necessário 2 litros). Disponível: " + shampoo);
            } else {
                agua -= 10;
                shampoo -= 2;
                petLimpo = true;
                System.out.println("Banho realizado! O pet está limpo.");
            }
        }

        void abastecerAgua() {
            if (agua >= 30) {
                System.out.println("Reservatório de água já está cheio (30 litros).");
            } else {
                agua += 2;
                if (agua > 30) agua = 30;
                System.out.println("Água abastecida. Nível atual: " + agua + " litros.");
            }
        }

        void abastecerShampoo() {
            if (shampoo >= 10) {
                System.out.println("Reservatório de shampoo já está cheio (10 litros).");
            } else {
                shampoo += 2;
                if (shampoo > 10) shampoo = 10;
                System.out.println("Shampoo abastecido. Nível atual: " + shampoo + " litros.");
            }
        }

        void limparMaquina() {
            if (agua < 3) {
                System.out.println("Água insuficiente para limpeza (necessário 3 litros). Disponível: " + agua);
            } else if (shampoo < 1) {
                System.out.println("Shampoo insuficiente para limpeza (necessário 1 litro). Disponível: " + shampoo);
            } else {
                agua -= 3;
                shampoo -= 1;
                precisaLimpeza = false;
                System.out.println("Máquina limpa!");
            }
        }

        void verificarNivelAgua() {
            System.out.println("Nível de água: " + agua + " litros (máx. 30).");
        }

        void verificarNivelShampoo() {
            System.out.println("Nível de shampoo: " + shampoo + " litros (máx. 10).");
        }

        void verificarPetNoBanho() {
            System.out.println(temPet ? "Há pet na máquina." : "Não há pet na máquina.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Maquina m = new Maquina();
        while (true) {
            System.out.println("\n===== MÁQUINA DE BANHO - PETSHOP =====");
            System.out.println("1. Dar banho no pet");
            System.out.println("2. Abastecer com água");
            System.out.println("3. Abastecer com shampoo");
            System.out.println("4. Verificar nível de água");
            System.out.println("5. Verificar nível de shampoo");
            System.out.println("6. Verificar se tem pet no banho");
            System.out.println("7. Colocar pet na máquina");
            System.out.println("8. Retirar pet da máquina");
            System.out.println("9. Limpar máquina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int op = sc.nextInt();
            if (op == 0) break;
            switch (op) {
                case 1: m.darBanho(); break;
                case 2: m.abastecerAgua(); break;
                case 3: m.abastecerShampoo(); break;
                case 4: m.verificarNivelAgua(); break;
                case 5: m.verificarNivelShampoo(); break;
                case 6: m.verificarPetNoBanho(); break;
                case 7: m.colocarPet(); break;
                case 8: m.retirarPet(); break;
                case 9: m.limparMaquina(); break;
                default: System.out.println("Opção inválida.");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }
}