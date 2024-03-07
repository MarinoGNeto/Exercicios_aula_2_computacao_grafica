package br.unisociesc;

import java.util.Scanner;

public class MovimentoCircular 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*Informe o valor do raio da trajetória circular*/
        System.out.print("Digite o raio da trajetória circular (em metros): ");
        double dRaio = scanner.nextDouble();

        Boolean bContinuaPrograma = true;
        double dVelocidade = 0;
        do
        {
        	 System.out.print("Você deseja inserir a velocidade angular diretamente? (s/n): ");
             String sResposta = scanner.next();
             
             if (sResposta.equalsIgnoreCase("n")) 
             {
            	 bContinuaPrograma = false;
            	 break;
             }
             
             System.out.print("Digite a velocidade angular (em radianos por segundo): ");
             dVelocidade = scanner.nextDouble();
             
             System.out.print("Você deseja inserir o período (T) ou a frequência (f)? (T/f): ");
             sResposta = scanner.next();
                 
             if (sResposta.equalsIgnoreCase("T")) 
             {
            	 /*Vai calcular a velocidade de acordo com o valor informado do periodo*/
            	 System.out.print("Digite o período (em segundos): ");
                 double dPeriodo = scanner.nextDouble();
                 dVelocidade = 2 * Math.PI / dPeriodo;
                 bContinuaPrograma = false;
             } 
             else 
             {
            	 /*Vai calcular a velocidade de acordo com o valor informado da frequencia*/
            	 System.out.print("Digite a frequência (em hertz): ");
                 double dFrequencia = scanner.nextDouble();
                 dVelocidade = 2 * Math.PI / dFrequencia;
                 bContinuaPrograma = false;
             }
             
        } while (bContinuaPrograma == true);
        
        double velocidadeTangencial = calculaVelocidadeTangencial(dVelocidade, dRaio);
        double aceleracaoCentripeta = calculaAceleracaoCentripeta(dVelocidade, dRaio);

        System.out.println("Velocidade angular: " + dVelocidade + " m/s");
        System.out.println("Velocidade tangencial: " + velocidadeTangencial + " m/s");
        System.out.println("Aceleração centrípeta: " + aceleracaoCentripeta + " m/s²");
    }

    public static double calculaVelocidadeTangencial(double velocidadeAngular, double raio) 
    {
        return velocidadeAngular * raio;
    }

    public static double calculaAceleracaoCentripeta(double velocidadeAngular, double raio) 
    {
        return (velocidadeAngular * velocidadeAngular) * raio;
    }
}
