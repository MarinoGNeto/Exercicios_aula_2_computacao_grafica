package br.unisociesc;

import java.util.Scanner;

public class ColisaoParticulas 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe a massa da partícula 1 (em kg): ");
		double dMassaPart1 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 1 (Linha X) em m/s: ");
		double dVelocidadeX1 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 1 (Linha Y) em m/s: ");
		double dVelocidadeY1 = scanner.nextDouble();

		System.out.print("Informe a massa da partícula 2 (em kg): ");
		double dMassaPart2 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 2 (Linha X) em m/s: ");
		double dVelocidadeX2 = scanner.nextDouble();
		System.out.print("Informe a velocidade inicial da partícula 2 (Linha Y) em m/s: ");
		double dVelocidadeY2 = scanner.nextDouble();

		double[] adVelocidadesFinaisParticula1 = calcularVelocidadeFinal(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);
		System.out.println("Velocidade final após impacto da partícula 1 (Linha X): " + adVelocidadesFinaisParticula1[0]);
		System.out.println("Velocidade final após impacto da partícula 1 (Linha Y): " + adVelocidadesFinaisParticula1[1]);

		double[] adVelocidadesFinaisParticula2 = calcularVelocidadeFinal(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);
		System.out.println("Velocidade final após impacto da partícula 2 (Linha X): " + adVelocidadesFinaisParticula2[0]);
		System.out.println("Velocidade final após impacto da partícula 2 (Linha Y): " + adVelocidadesFinaisParticula2[1]);

		scanner.close();
	}

	public static double[] calcularVelocidadeFinal(double dMassaPart1, double dVelocidadeX1, double dVelocidadeY1, double dMassaPart2, double dVelocidadeX2, double dVelocidadeY2) 
	{
		double[] adVelocidadeFinal = new double[2];
		
		adVelocidadeFinal[0] = ((dMassaPart1) * dVelocidadeX1 + 2 * dMassaPart2 * dVelocidadeX2) / (dMassaPart1 + dMassaPart2);
		adVelocidadeFinal[1] = ((dMassaPart1 - dMassaPart2) * dVelocidadeY1 + 2 * dMassaPart2 * dVelocidadeY2) / (dMassaPart1 + dMassaPart2);
		return adVelocidadeFinal;
	}
}
