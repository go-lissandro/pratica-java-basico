package br.com.lissandro.exercicios;
import java.util.Scanner;

public class ExercicioCarro {
    static class Carro {
        private boolean ligado = false;
        private int marcha = 0; // 0 = neutro
        private int velocidade = 0; // km/h

        void ligar() {
            if (!ligado) {
                ligado = true;
                System.out.println("Carro ligado.");
            } else {
                System.out.println("Carro já está ligado.");
            }
        }

        void desligar() {
            if (!ligado) {
                System.out.println("Carro já está desligado.");
                return;
            }
            if (marcha == 0 && velocidade == 0) {
                ligado = false;
                System.out.println("Carro desligado.");
            } else {
                System.out.println("Para desligar, coloque em ponto morto e pare o carro.");
            }
        }

        void acelerar() {
            if (!ligado) {
                System.out.println("Carro desligado. Não pode acelerar.");
                return;
            }
            if (marcha == 0) {
                System.out.println("Não é possível acelerar em ponto morto.");
                return;
            }
            if (velocidade < 120) {
                velocidade += 1;
                System.out.println("Velocidade atual: " + velocidade + " km/h");
            } else {
                System.out.println("Velocidade máxima atingida (120 km/h).");
            }
        }

        void frear() {
            if (!ligado) {
                System.out.println("Carro desligado. Não pode frear.");
                return;
            }
            if (velocidade > 0) {
                velocidade -= 1;
                System.out.println("Velocidade atual: " + velocidade + " km/h");
            } else {
                System.out.println("Carro já está parado.");
            }
        }

        void trocarMarcha(int novaMarcha) {
            if (!ligado) {
                System.out.println("Carro desligado. Não pode trocar marcha.");
                return;
            }
            if (novaMarcha < 0 || novaMarcha > 6) {
                System.out.println("Marcha inválida. Use 0 a 6.");
                return;
            }
            // não permite pular marchas
            if (Math.abs(novaMarcha - marcha) > 1) {
                System.out.println("Não é permitido pular marchas.");
                return;
            }
            // verifica limites de velocidade para a nova marcha
            if (novaMarcha == 0) {
                // ponto morto pode ter velocidade 0
                if (velocidade != 0) {
                    System.out.println("Só pode ir ao neutro com velocidade 0.");
                    return;
                }
            } else {
                int min, max;
                switch (novaMarcha) {
                    case 1: min = 0;   max = 20; break;
                    case 2: min = 21;  max = 40; break;
                    case 3: min = 41;  max = 60; break;
                    case 4: min = 61;  max = 80; break;
                    case 5: min = 81;  max = 100; break;
                    case 6: min = 101; max = 120; break;
                    default: min = 0; max = 120; break;
                }
                if (velocidade < min || velocidade > max) {
                    System.out.println("Velocidade atual (" + velocidade + " km/h) incompatível com a marcha " + novaMarcha + ".");
                    return;
                }
            }
            marcha = novaMarcha;
            System.out.println("Marcha trocada para " + marcha);
        }

        void virar(String direcao) {
            if (!ligado) {
                System.out.println("Carro desligado. Não pode virar.");
                return;
            }
            if (velocidade >= 1 && velocidade <= 40) {
                System.out.println("Virando para " + direcao + ".");
            } else {
                System.out.println("Velocidade inadequada para virar (deve estar entre 1 e 40 km/h).");
            }
        }

        void mostrarStatus() {
            System.out.println("--- Status do carro ---");
            System.out.println("Ligado: " + ligado);
            System.out.println("Marcha: " + marcha);
            System.out.println("Velocidade: " + velocidade + " km/h");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro();
        while (true) {
            System.out.println("\n--- Menu Carro ---");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Frear (diminuir velocidade)");
            System.out.println("5. Trocar marcha");
            System.out.println("6. Virar (esquerda/direita)");
            System.out.println("7. Verificar velocidade");
            System.out.println("8. Mostrar status");
            System.out.println("0. Sair");
            int op = sc.nextInt();
            sc.nextLine(); // consume newline
            if (op == 0) break;
            switch (op) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.frear();
                    break;
                case 5:
                    System.out.print("Digite a marcha (0-6): ");
                    int m = sc.nextInt();
                    carro.trocarMarcha(m);
                    break;
                case 6:
                    System.out.print("Direção (esquerda/direita): ");
                    String dir = sc.nextLine();
                    carro.virar(dir);
                    break;
                case 7:
                    System.out.println("Velocidade atual: " + carro.velocidade + " km/h");
                    break;
                case 8:
                    carro.mostrarStatus();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        sc.close();
        System.out.println("Programa encerrado.");
    }
}
