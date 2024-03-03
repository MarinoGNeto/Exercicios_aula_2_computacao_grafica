package br.unisociesc;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ColisaoParticulasTest {

    @Test
    public void shouldBeAbleToCalculateColisao() {
        double dMassaPart1 = 10.0;
        double dVelocidadeX1 = 5.0;
        double dVelocidadeY1 = 2.0;

        double dMassaPart2 = 5.0;
        double dVelocidadeX2 = 3.0;
        double dVelocidadeY2 = 4.0;

        double[] esperadoParticula1 = {((dMassaPart1) * dVelocidadeX1 + 2 * dMassaPart2 * dVelocidadeX2) / (dMassaPart1 + dMassaPart2),
                ((dMassaPart1 - dMassaPart2) * dVelocidadeY1 + 2 * dMassaPart2 * dVelocidadeY2) / (dMassaPart1 + dMassaPart2)};

        double[] esperadoParticula2 = {((dMassaPart1) * dVelocidadeX1 + 2 * dMassaPart2 * dVelocidadeX2) / (dMassaPart1 + dMassaPart2),
                ((dMassaPart1 - dMassaPart2) * dVelocidadeY1 + 2 * dMassaPart2 * dVelocidadeY2) / (dMassaPart1 + dMassaPart2)};

        double[] resultadoParticula1 = ColisaoParticulas.calcularVelocidadesFinais(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);
        double[] resultadoParticula2 = ColisaoParticulas.calcularVelocidadesFinais(dMassaPart1, dVelocidadeX1, dVelocidadeY1, dMassaPart2, dVelocidadeX2, dVelocidadeY2);

        assertArrayEquals(esperadoParticula1, resultadoParticula1, 0.001);
        assertArrayEquals(esperadoParticula2, resultadoParticula2, 0.001);
    }

}