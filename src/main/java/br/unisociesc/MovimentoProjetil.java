package br.unisociesc;

import java.util.ArrayList;
import java.util.List;
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

        double[][] posicoes = calculoMovimentoProjetil(velocidadeInicial, angulo, massaProjetil);

        System.out.println("Simulação do movimento do projétil:");
        System.out.println("-----------------------------------");
        System.out.println("Tempo\t\tPosição X\tPosição Y");
        for (double[] posicao : posicoes) {
            System.out.printf("%.2f s\t\t%.2f m\t\t%.2f m%n", posicao[0], posicao[1], posicao[2]);
        }
        System.out.println("-----------------------------------");
        System.out.println("O projétil atingiu o solo.");

        scanner.close();
    }

    public static double[][] calculoMovimentoProjetil(double velocidadeInicial, double angulo, double massaProjetil) {
        double gravidade = 9.81;
        double velocidadeInicialHorizontal = velocidadeInicial * Math.cos(angulo);
        double velocidadeInicialVertical = velocidadeInicial * Math.sin(angulo);

        double intervaloDeTempo = 0.1;
        double tempoTotal = 0;

        List<double[]> posicoesList = new ArrayList<>();

        while (true) {
            double forcaGravitacional = massaProjetil * gravidade;
            double posicaoX = velocidadeInicialHorizontal * tempoTotal;
            double posicaoY = (velocidadeInicialVertical * tempoTotal) - (0.5 * forcaGravitacional / massaProjetil * Math.pow(tempoTotal, 2));

            posicoesList.add(new double[]{tempoTotal, posicaoX, posicaoY});

            if (posicaoY < 0) {
                break;
            }

            tempoTotal += intervaloDeTempo;
        }

        double[][] posicoes = new double[posicoesList.size()][3];
        for (int i = 0; i < posicoesList.size(); i++) {
            posicoes[i] = posicoesList.get(i);
        }

        return posicoes;
    }
}
