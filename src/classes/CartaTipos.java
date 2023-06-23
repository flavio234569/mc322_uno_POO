package classes;

public class CartaTipos extends Carta{

    private int valor;

    public CartaTipos(String cor, Boolean acao, int valor) {
        super(cor, acao);
        this.valor = valor;
    }

    //toString
    public String toString(){
        String str;
        if (valor<=9){
            str = getCor() + "|" + getValor();
            return str;
        } else if (valor == CartaValoresEnum.BLOQUEIO.valor){
            str = getCor() + "|bloqueio";
            return str;
        } else if (valor == CartaValoresEnum.RETORNO.valor){
            str = getCor() + "|retorno";
            return str;
        } else if (valor == CartaValoresEnum.MAIS2.valor){
            str = getCor() + "|+2";
            return str;
        } else if (valor == CartaValoresEnum.MAIS4.valor){
            str = "+4";
            return str;
        } else { //Se valor == CORINGA
            str = "coringa";
            return str;
        }
    }

    //getters and setters
	public int getValor(){
		return valor;
	}
	public void setValor(int valor){
		this.valor = valor;
	}
}