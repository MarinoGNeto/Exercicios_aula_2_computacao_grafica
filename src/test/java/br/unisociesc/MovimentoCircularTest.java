package br.unisociesc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovimentoCircularTest 
{
	 @Test
	    public void shouldBeAbleToCalculatePenduloSimples()
	    {
		 	double dVelocidadeEsperadaTangencial = 250.0;
		 	double dVelocidadeEsperadaCentripeta = 1250.0;
		 	
		 	double dVelocidadeInformada = 5.0;
		 	double dRaioInformado = 50.0;
		 	
		 	 assertEquals(dVelocidadeEsperadaTangencial, MovimentoCircular.calculaVelocidadeTangencial(dVelocidadeInformada, dRaioInformado), 0.01);
		 	 assertEquals(dVelocidadeEsperadaCentripeta, MovimentoCircular.calculaAceleracaoCentripeta(dVelocidadeInformada, dRaioInformado), 0.01);
	    }
}
