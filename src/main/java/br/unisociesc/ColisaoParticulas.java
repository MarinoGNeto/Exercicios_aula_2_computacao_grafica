package br.unisociesc;

import java.util.Scanner;

public class ColisaoParticulas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe a massa da partícula 1 (em Kg): ");
		double dMassaPart1 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 1 (Linha x) em m/s: ");
		double dVelocidadeX1 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 1 (Linha y) em m/s: ");
		double dVelocidadeY1 = scanner.nextDouble();

		System.out.print("Informe a massa da partícula 2 (em Kg): ");
		double dMassaPart2 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 2 (Linha x) em m/s: ");
		double dVelocidadeX2 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 2 (Linha y) em m/s: ");
		double dVelocidadeY2 = scanner.nextDouble();

		double[] velocidadesFinaisParticula1 = calcularVelocidadesFinais(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);
		double[] velocidadesFinaisParticula2 = calcularVelocidadesFinais(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);

		System.out.println("Velocidade final após impacto da partícula 1 (Linha x): " + velocidadesFinaisParticula1[0]);
		System.out.println("Velocidade final após impacto da partícula 1 (Linha y): " + velocidadesFinaisParticula1[1]);
		System.out.println("Velocidade final após impacto da partícula 2 (Linha x): " + velocidadesFinaisParticula2[0]);
		System.out.println("Velocidade final após impacto da partícula 2 (Linha y): " + velocidadesFinaisParticula2[1]);

		scanner.close();
	}

	public static double[] calcularVelocidadesFinais(double dMassaPart1, double dVelocidadeX1, double dVelocidadeY1,
													 double dMassaPart2, double dVelocidadeX2, double dVelocidadeY2) {
		double[] velocidadesFinais = new double[2];
		velocidadesFinais[0] = ((dMassaPart1) * dVelocidadeX1 + 2 * dMassaPart2 * dVelocidadeX2) / (dMassaPart1 + dMassaPart2);
		velocidadesFinais[1] = ((dMassaPart1 - dMassaPart2) * dVelocidadeY1 + 2 * dMassaPart2 * dVelocidadeY2) / (dMassaPart1 + dMassaPart2);
		return velocidadesFinais;
	}
}
