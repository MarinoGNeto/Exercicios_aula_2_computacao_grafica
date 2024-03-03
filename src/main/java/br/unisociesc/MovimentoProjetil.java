package br.unisociesc;

import java.util.Scanner;

public class MovimentoProjetil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a velocidade inicial (em m/s): ");
        double velocidadeInicial = scanner.nextDouble();

        System.out.print("Insira o ângulo de lançamento (em graus): ");
        double angulo = Math.toRadians(scanner.nextDouble());

        System.out.print("Insira a massa do projétil (em kg): ");
        double massaProjetil = scanner.nextDouble();

        double gravidade = 9.81;

        double velocidadeInicialHorizontal = velocidadeInicial * Math.cos(angulo);
        double velocidadeInicialVertical = velocidadeInicial * Math.sin(angulo);

        double intervaloDeTempo = 0.1;
        double tempoTotal = 0;

        double posicaoX;
        double posicaoY = 0;

        System.out.println("Simulação do movimento do projétil:");
        System.out.println("-----------------------------------");
        System.out.println("Tempo\t\tPosição X\tPosição Y");
        while (posicaoY >= 0) {
            double forcaGravitacional = massaProjetil * gravidade;
            posicaoX = velocidadeInicialHorizontal * tempoTotal;
            posicaoY = (velocidadeInicialVertical * tempoTotal) - (0.5 * forcaGravitacional / massaProjetil * Math.pow(tempoTotal, 2));

            System.out.printf("%.2f s\t\t%.2f m\t\t%.2f m%n", tempoTotal, posicaoX, posicaoY);

            tempoTotal += intervaloDeTempo;
        }
        System.out.println("-----------------------------------");
        System.out.println("O projétil atingiu o solo.");
    }
}
