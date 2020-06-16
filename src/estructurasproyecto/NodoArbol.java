
package estructurasproyecto;

public class NodoArbol <T>{
    private int key,fe;
    private NodoArbol left;
    private NodoArbol Right;
    private T valor;
    
    public NodoArbol(int a){
        this.key =a;
        this.left=null;
        this.Right=null;
        this.fe=0;
        this.valor=null;
    }

    public int getKey() {
        return key;
    }

    public int getFe() {
        return fe;
    }

    public NodoArbol getLeft() {
        return left;
    }

    public NodoArbol getRight() {
        return Right;
    }

    public T getValor() {
        return valor;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public void setLeft(NodoArbol left) {
        this.left = left;
    }

    public void setRight(NodoArbol Right) {
        this.Right = Right;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
}
