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
        
        } else {
            str = getCor() + "|+2";
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