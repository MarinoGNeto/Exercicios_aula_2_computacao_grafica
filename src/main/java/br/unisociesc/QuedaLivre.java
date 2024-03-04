package br.unisociesc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuedaLivre 
{
	final static double ACELERACAO_GRAVIDADE = 9.8;
	
	public static class DadosQueda
	{
		 private final double dTempo;
		 private final double dAltura;
		 private final double dVelocidade;
		 
		 public DadosQueda(double tempo, double altura, double velocidade) 
		 {
		        this.dTempo = tempo;
		        this.dAltura = altura;
		        this.dVelocidade = velocidade;
		 }

		 public double GetTempo() 
		 {
			 return dTempo;
		 }

		 public double GetAltura() 
		 {
			 return dAltura;
		 }

		 public double GetVelocidade() 
		 {
			 return dVelocidade;
		 }
	};
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a altura inicial do objeto (metros): ");
        double dPosicaoInicial = scanner.nextDouble();

        System.out.print("Digite o intervalo de tempo (segundos): ");
        double dIntervaloTempo = scanner.nextDouble();

        List<DadosQueda> listaDadosQueda = calculaExibePosicaoVelocidadeQueda(dPosicaoInicial, dIntervaloTempo);
        exibeResultadosQuedaLivre(listaDadosQueda);
        
        scanner.close();
    }
    
    public static List<DadosQueda> calculaExibePosicaoVelocidadeQueda(double intervaloTempo, double alturaInicial) 
    {
    	 List<DadosQueda> listaDadosQueda = new ArrayList<>();
    	
        double dAlturaAtual = alturaInicial;
        double dTempo = 0;
        double dVelocidade = 0;

        listaDadosQueda.add(new DadosQueda(dTempo, dAlturaAtual, dVelocidade));
        
        while (dAlturaAtual > 0) 
        {
        	dTempo += intervaloTempo;
            double dProximaAltura = alturaInicial - ACELERACAO_GRAVIDADE * Math.pow(dTempo, 2) / 2;
            dVelocidade =  ACELERACAO_GRAVIDADE * dTempo;

            listaDadosQueda.add(new DadosQueda(dTempo, dProximaAltura, dVelocidade));
            
            if (dProximaAltura <= 0) 
            {
            	dTempo = Math.sqrt((2 * alturaInicial) / ACELERACAO_GRAVIDADE);
            	dAlturaAtual = 0;
            	dVelocidade = ACELERACAO_GRAVIDADE * dTempo;
                
            	listaDadosQueda.add(new DadosQueda(dTempo, dProximaAltura, dVelocidade));
            } 
            else 
            {
            	listaDadosQueda.add(new DadosQueda(dTempo, dProximaAltura, dVelocidade));
            	 dAlturaAtual = dProximaAltura;
            }
        }
        
        return listaDadosQueda;
    }
    
    private static void exibeResultadosQuedaLivre(List<DadosQueda> listaDadosQueda) 
    {
        System.out.println("Tempo (s)\tPosição (m)\tVelocidade (m/s)");
        for (DadosQueda dadosQueda : listaDadosQueda) 
        {
        	System.out.printf("%.2f\t\t%.2f\t\t%.2f%n", dadosQueda.GetTempo(), dadosQueda.GetAltura(), dadosQueda.GetVelocidade());
        }
    }
}
