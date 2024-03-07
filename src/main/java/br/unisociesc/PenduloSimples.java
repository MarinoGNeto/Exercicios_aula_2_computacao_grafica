package br.unisociesc;

import java.util.Scanner;

public class PenduloSimples {

    /**
     * Gravidade da Terra
     */
    private static final double GRAVIDADE = 9.8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Parâmetros do pêndulo utilizados
          */
        System.out.print("Insira o comprimento da corda: ");
        double comprimentoCorda = scanner.nextDouble();

        System.out.print("Insira a massa do objeto: ");
        double massa = scanner.nextDouble();

        System.out.print("Insira o ângulo utilizado: ");
        double anguloRadiano = Math.toRadians(scanner.nextDouble());

        /**
         * Calculo de período do pêndulo utilizando formula de pêndulo simples.
         */
        double periodo = 2 * Math.PI * Math.sqrt(comprimentoCorda / (GRAVIDADE * massa));

        for (double tempo = 0; tempo <= periodo; tempo++) {
            /**
             * Calculo do ângulo
             */
            double angulo = anguloRadiano * Math.cos(Math.sqrt((GRAVIDADE * massa / comprimentoCorda)) * tempo);

            System.out.printf("Para o tempo %.2f segundos, o ângulo do pêndulo é de %.2f graus.\n", tempo, Math.toDegrees(angulo));
        }
    }

}
