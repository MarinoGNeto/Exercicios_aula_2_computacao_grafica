package br.unisociesc;

public class PenduloSimples {

    private static final double GRAVIDADE = 9.8;

    // Método para calcular a posição angular do pêndulo em relação ao tempo
    public static double calcularPosicaoAngular(double comprimento, double massa, double tempo) {
        // Calculando o período do pêndulo
        double periodo = 2 * Math.PI * Math.sqrt(comprimento / (GRAVIDADE * massa));

        // Calculando o ângulo usando a fórmula do pêndulo
        double angulo = Math.cos((2 * Math.PI * tempo) / periodo);

        return angulo;
    }

    public static void main(String[] args) {
        // Parâmetros do pêndulo
        double comprimento = 1.0; // comprimento da corda em metros
        double massa = 1.0; // massa do objeto em kg

        // Simulação do movimento do pêndulo por 5 segundos
        System.out.println("Simulação do Movimento do Pêndulo Simples por 5 segundos:");
        System.out.println("Comprimento da corda: " + comprimento + " metros");
        System.out.println("Massa do objeto: " + massa + " kg");
        System.out.println("---------------------------------------------------------");
        System.out.println("Tempo(s)     Ângulo(rad)");
        for (double t = 0; t <= 5; t += 0.1) {
            double angulo = calcularPosicaoAngular(comprimento, massa, t);
            System.out.printf("%.2f          %.2f\n", t, angulo);
        }
    }

}
