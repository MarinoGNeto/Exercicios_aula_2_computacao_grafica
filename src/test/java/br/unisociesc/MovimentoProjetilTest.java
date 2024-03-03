package br.unisociesc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovimentoProjetilTest {

    @Test
    public void shouldBeAbleToCalculateMovimentoProjetil() {
        double velocidadeInicial = 20;
        double angulo = Math.toRadians(45);
        double massaProjetil = 0.1;

        double[][] posicoes = MovimentoProjetil.calculoMovimentoProjetil(velocidadeInicial, angulo, massaProjetil);

        assertTrue(posicoes.length > 0);
        assertEquals(3, posicoes[0].length);

        assertEquals(0, posicoes[0][2], 0.01);

        int lastIndex = posicoes.length - 1;
        assertTrue(posicoes[lastIndex][2] < 0);
    }

}