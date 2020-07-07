
package estructurasproyecto;


public class ListaEnlazada <T>{
    private Nodo cabeza;
    private Nodo cola;
    private int size;
    
    public ListaEnlazada(){
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public Nodo getCola() {
        return cola;
    }
    public void add(T a){
        if (cabeza == null){
            Nodo uno = new Nodo (a);
            this.cabeza = uno;
            this.cola = uno;
        }else if(cabeza == cola){
            Nodo uno = new Nodo(a);
            this.cabeza.setNext(uno);
            this.cola = uno; 
            this.cola.setprev(cabeza);
        }else{
            Nodo nuevo = new Nodo(a);
            Nodo temp = cola;
            this.cola.setNext(nuevo);
            this.cola = nuevo;
            this.cola.setprev(temp);              
        }
        size++;
    }

    public int getSize() {
        return size;
    }
    public T obtener(int index){
         int contador = 0;
         Nodo temporal = cabeza;
         while(contador<index){
             temporal = temporal.getNext();
             contador++;
         }
         return (T)temporal.getKey();
     }
    public boolean isEmpty(){
         return (cabeza == null);
     }
    public void eliminarPrimero(){
        if(cabeza==cola){
            cabeza=cola=null;
            size--;
        }
        if(!isEmpty()){    
            this.cabeza = cabeza.getNext();
            size--;
        }    
     }
    public T eliminarUltimo(){
        Nodo temp = cola;
        if(cabeza==cola){
            cabeza=cola=null;
            size--;
        }
        if(isEmpty()==false){
            this.cola = cola.getPrev();
            size--;
        }
        return (T)temp.getKey();
    }
    public void eliminar(int index){
        if(isEmpty()==false){ 
            if (index == 0){
                this.cabeza = cabeza.getNext();
             }else{
             int contador = 0;
             Nodo temp = this.cabeza;
             while (contador < index-1 ){
                 temp = temp.getNext();
                 contador++;
             }
             temp.setNext(temp.getNext().getNext());
             }
             size--;
         }else{
            System.out.println("Lista vacía");
        }
    }
}
