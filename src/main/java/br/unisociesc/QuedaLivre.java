package br.unisociesc;

import java.util.Scanner;

public class QuedaLivre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double ACELERACAO_GRAVIDADE = 9.8;

        System.out.print("Digite a altura inicial do objeto (metros): ");
        double dPosicaoInicial = scanner.nextDouble();

        System.out.print("Digite o intervalo de tempo (segundos): ");
        double dIntervaloTempo = scanner.nextDouble();

        double dTempo = 0;
        double dPosicaoCalculada = dPosicaoInicial;
        double dVelocidadeCalculada = 0;

        System.out.println("Tempo (s)\tPosição (m)\tVelocidade (m/s)");

        while (dPosicaoCalculada >= 0) {
            dPosicaoCalculada = dPosicaoInicial - 0.5 * ACELERACAO_GRAVIDADE * Math.pow(dTempo, 2);
            dVelocidadeCalculada = ACELERACAO_GRAVIDADE * dTempo;

            System.out.printf("%.2f\t\t%.2f\t\t%.2f%n", dTempo, dPosicaoCalculada, dVelocidadeCalculada);

            dTempo += dIntervaloTempo;
        }

        scanner.close();
    }
}