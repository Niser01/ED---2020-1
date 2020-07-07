
package estructurasproyecto;


public class Nodo <T>{
    private T key;
    private Nodo next;
    private Nodo prev;

    public Nodo() {
        this.key = null;
        this.next = null;
    }
    public Nodo(T key) {
        this.key = key;
        this.next = null;
    }
    public Nodo(T key,Nodo sig,Nodo prev) {
        this.key = key;
        this.next = sig;
        this.prev = prev;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    public void setprev(Nodo prev){
        this.prev = prev;
    }

    public Nodo getPrev() {
        return prev;
    }

    
    public T getKey() {
        return key;
    }

    public Nodo getNext() {
        return next;
    }
    
    
}
