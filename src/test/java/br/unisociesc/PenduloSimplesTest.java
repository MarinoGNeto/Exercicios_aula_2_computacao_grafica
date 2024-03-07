package br.unisociesc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PenduloSimplesTest {

    @Test
    public void shouldBeAbleToCalculatePenduloSimples() {
        // Parâmetros para o teste
        double comprimentoCorda = 1.0;
        double massa = 1.0;
        double anguloRadiano = Math.toRadians(30);
        double tempo = 1.0;

        // Valor esperado calculado manualmente
        double valorEsperado = anguloRadiano * Math.cos(Math.sqrt((9.8 * massa / comprimentoCorda)) * tempo);

        // Chamada do método a ser testado
        double valorCalculado = PenduloSimples.calcularAngulo(comprimentoCorda, massa, anguloRadiano, tempo);

        // Verificação se o valor calculado é igual ao esperado
        assertEquals(valorEsperado, valorCalculado, 0.001); // A margem de erro é de 0.001
    }

}