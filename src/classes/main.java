package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class main {
	
	

	public static void main(String[] args) {
		
		Baralho baralho = new Baralho("10000"); // mudar ID (coloquei esse so pq nao sabia sua funcao)
		
			// TODO Auto-generated method stub
	        String csvFile = "instanciaCartas.csv";
	        String line;
	        String dados = "";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            while ((line = br.readLine()) != null) {
	                dados = dados + line + ";";
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	        String[] dadosSplit = dados.split(";");
	        System.out.print(dados);

			for (String a : dadosSplit) {
				String splitA[] = a.split(",");
				try {
        			Boolean acao;
        			if (splitA[1] == "false") {
        				acao = false;
        			}
        			else {
        				acao = true;
        			}
	            	
        			
        			
	            	CartaTipos cartaTipos = new CartaTipos(splitA[2], acao, Integer.valueOf(splitA[0]));
	            	baralho.adicionarCarta(cartaTipos);
	            	
				}catch (NumberFormatException ex){
	                ex.printStackTrace();
	            }

			}
			
		
		
		
		
		
		
		/* TESTE PRIMITIVO SO PRA VER SE TAVA RODANDO!
		 * 
		 */
		
		// atribuicao das cartas para o baralho (nao tem todas as cartas aqui)/ pode mudar para um jeito de declarar mais eficiente qualquer coisa
		
		/*	Am - amarelo
		 * 	Az - Azul
		 *  Vm - vermelho
		 *  Vd - verde
		 */
//		CartaTipos c1 = new CartaTipos("Vm", false, 0);
//		CartaTipos c2 = new CartaTipos("Vm", false,1);
//		CartaTipos c3 = new CartaTipos("Vm", false,2);
//		CartaTipos c4 = new CartaTipos("Vm", false,3);
//		CartaTipos c5 = new CartaTipos("Vm", false,4);
//		CartaTipos c6 = new CartaTipos("Am", false, 0);
//		CartaTipos c7 = new CartaTipos("Am", false, 1);
//		CartaTipos c8 = new CartaTipos("Am", false, 2);
//		CartaTipos c9 = new CartaTipos("Am", false, 3);
//		CartaTipos c10 = new CartaTipos("Am", false, 4);
//		CartaTipos c11 = new CartaTipos("Az", false, 0);
//		CartaTipos c12 = new CartaTipos("Az", false, 1);
//		CartaTipos c13 = new CartaTipos("Az", false, 2);
//		CartaTipos c14 = new CartaTipos("Az", false, 3);
//		CartaTipos c15 = new CartaTipos("Az", false, 4);
//		CartaTipos c16 = new CartaTipos("Vr", false, 5);
//		CartaTipos c17 = new CartaTipos("Vr", false, 0);
//		CartaTipos c18 = new CartaTipos("Vr", false, 1);
//		CartaTipos c19 = new CartaTipos("Vr", false, 2);
//		CartaTipos c20 = new CartaTipos("Vr", false, 3);
//		CartaTipos c21 = new CartaTipos("Pr", true, 13);
//		CartaTipos c22 = new CartaTipos("Pr", true, 14);
//		
//		
//		baralho.adicionarCarta(c1);
//		baralho.adicionarCarta(c2);
//		baralho.adicionarCarta(c3);
//		baralho.adicionarCarta(c4);
//		baralho.adicionarCarta(c5);
//		baralho.adicionarCarta(c6);
//		baralho.adicionarCarta(c7);
//		baralho.adicionarCarta(c8);
//		baralho.adicionarCarta(c9);
//		baralho.adicionarCarta(c10);
//		baralho.adicionarCarta(c11);
//		baralho.adicionarCarta(c12);
//		baralho.adicionarCarta(c13);
//		baralho.adicionarCarta(c14);
//		baralho.adicionarCarta(c15);
//		baralho.adicionarCarta(c16);
//		baralho.adicionarCarta(c17);
//		baralho.adicionarCarta(c18);
//		baralho.adicionarCarta(c19);
//		baralho.adicionarCarta(c21);
//		baralho.adicionarCarta(c22);
		
		System.out.print(baralho.getListaCarta().toString());
		baralho.embaralhar();
		
		Descarte descarte = new Descarte();
		//descarte.adicionarCarta(c20); // primeira carta do monte do descarte (inicio de jogo sera sempre com Vr 3)
		
		JogadorHumano jogadorHumano = new JogadorHumano("Nati", baralho, true);
		JogadorRobo jogadorRobo = new JogadorRobo("Robo", baralho, false);
		
		// Distribuicao das cartas iniciais do jogo (aqui serao 5)
		jogadorRobo.comprarCarta(5, baralho);
		jogadorHumano.comprarCarta(5, baralho);
		System.out.println("Cartas do Robo: " + jogadorRobo.getListaCarta());
		
		Mesa mesa = new Mesa(baralho, descarte, jogadorHumano, jogadorRobo);
		
		mesa.jogo();
		
		
	}

}