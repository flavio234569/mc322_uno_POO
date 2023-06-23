package classes;

public enum CartaValoresEnum {
    BLOQUEIO(10),
    RETORNO(11),
    MAIS2(12),
    MAIS4(13),
    CORINGA(14);

    public final int valor;

    CartaValoresEnum(int valor){
        this.valor = valor;
    }

    public int getvalor(){
        return this.valor;
    }
}
