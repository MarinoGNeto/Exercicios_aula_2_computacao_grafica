package br.unisociesc;

import junit.framework.TestCase;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuedaLivreTest {

	@Test
    public void shouldBeAbleToCalculateQuedaLivre() 
    {
    	  double alturaInicial = 100;
          double intervaloTempo = 1;
          List<QuedaLivre.DadosQueda> listaDadosQueda = QuedaLivre.calculaExibePosicaoVelocidadeQueda(intervaloTempo, alturaInicial);

          double[][] listaDadosEntrada = {
              {0.0, 200.0, 0.0},
              {1.0, 95.1, 9.81},
              {2.0, 80.38, 19.62},
              {3.0, 55.85, 29.43},
              {4.0, 21.51, 39.24},
              {4.51, 0.0, 44.29}
          };

          assertEquals(listaDadosEntrada.length, listaDadosQueda.size());

          for (int i = 0; i < listaDadosEntrada.length; i++) 
          {
              assertEquals(listaDadosEntrada[i][0], listaDadosQueda.get(i).GetTempo());
              assertEquals(listaDadosEntrada[i][1], listaDadosQueda.get(i).GetAltura());
              assertEquals(listaDadosEntrada[i][2], listaDadosQueda.get(i).GetVelocidade());
          }
    }
}