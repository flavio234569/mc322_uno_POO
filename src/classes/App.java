package classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App {

	public static void main(String[] args) {

		String csvFile = "instanciaCartas.csv";
        String line;
        String csvSeparator = ",";

        List<Carta> listaCartas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ler cada linha do arquivo CSV
            while ((line = br.readLine()) != null) {
                // Dividir a linha em colunas usando o separador
                String[] columns = line.split(csvSeparator);

                // Verificar se a linha tem o número correto de colunas
                if (columns.length == 3) {
                    int valor = Integer.parseInt(columns[0]);
                    boolean acao = Boolean.parseBoolean(columns[1]);
                    String cor = columns[2];

                    // Instanciar objeto com os parâmetros do CSV
                    Carta c = new CartaTipos(cor, acao, valor);

                    // Adicionar o objeto à lista
                    listaCartas.add(c);
                }
            }

            // Fazer o que desejar com a lista de objetos
            for (Carta objeto : listaCartas) {
                System.out.println(objeto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*	Am - amarelo
		 * 	Az - Azul
		 *  Vm - vermelho
		 *  Vd - verde
		 */
		
		CartaTipos c20 = new CartaTipos("Vr", false, 3);
		
		
		Baralho baralho = new Baralho(); // mudar ID (coloquei esse so pq nao sabia sua funcao)
		
		baralho.setListaCarta(listaCartas);
		Descarte descarte = new Descarte();
		descarte.adicionarCarta(c20); // primeira carta do monte do descarte (inicio de jogo sera sempre com Vr 3)
		
		JogadorHumano jogadorHumano = new JogadorHumano("Nati", baralho, true);
		JogadorRobo jogadorRobo = new JogadorRobo("Robo", baralho, false);
		
		baralho.embaralhar();
		
		// Distribuicao das cartas iniciais do jogo (aqui serao 5)
		jogadorRobo.comprarCarta(5, baralho);
		jogadorHumano.comprarCarta(5, baralho);
		System.out.println("Cartas do Robo: " + jogadorRobo.getListaCarta());
		
		Mesa mesa = new Mesa(baralho, descarte, jogadorHumano, jogadorRobo);
		
		mesa.jogo();
		
	}

}