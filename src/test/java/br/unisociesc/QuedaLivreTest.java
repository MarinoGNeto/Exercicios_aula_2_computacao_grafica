package br.unisociesc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuedaLivreTest {

	@Test
    public void shouldBeAbleToCalculateQuedaLivre() 
    {
        double alturaInicial = 50;
        double intervaloTempo = 1;
        List<QuedaLivre.DadosQueda> estados = QuedaLivre.calculaExibePosicaoVelocidadeQueda(intervaloTempo, alturaInicial);

        double[][] dadosQuedaEsperados = {
                {0.0, 50.0, 0.0},
                {1.0, 45.1, 9.81},
                {2.0, 30.4, 19.6},
                {3.0, 5.9, 29.40},
                {3.20, 00.00, 31.3},
        };

        assertEquals(dadosQuedaEsperados.length, estados.size());

        for (int i = 0; i < dadosQuedaEsperados.length; i++) {
            assertEquals(dadosQuedaEsperados[i][0], estados.get(i).GetTempo(), 0.01);
            assertEquals(dadosQuedaEsperados[i][1], estados.get(i).GetAltura(), 0.01);
            assertEquals(dadosQuedaEsperados[i][2], estados.get(i).GetVelocidade(), 0.01);
        }
    }
}