package classes;

public enum CartaValoresEnum {
    BLOQUEIO(10),
    MAIS2(11),;

    public final int valor;

    CartaValoresEnum(int valor){
        this.valor = valor;
    }

    public int getvalor(){
        return this.valor;
    }
}