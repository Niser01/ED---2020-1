
package estructurasproyecto;

public class ArbolAVL<T> {

    private NodoArbol raiz;
    public  ArbolAVL(){
        this.raiz=null;
    }
    //Buscar
    public NodoArbol buscar(int d,NodoArbol r){
        if(raiz==null){
            return null;
        }
        if(r.getKey()==d){
            return r;
        }else if(r.getKey()<d){
            return buscar(d,r.getRight());
        }else{
            return buscar(d,r.getLeft());
        }
    }
    //Obtener el factor de equilibrio
    public int obtenerFE (NodoArbol x){
        if(x==null){
            return -1;
        }else{
            return x.getFe();
        }
    }
    
    //rotacion simple a a la izquierda
     public NodoArbol rotacionIzquierda(NodoArbol c){
         NodoArbol aux = c.getLeft();
         c.setLeft(aux.getRight());
         aux.setRight(c);
         c.setFe(Math.max(obtenerFE(c.getLeft()), obtenerFE(c.getRight()))+1);
         aux.setFe(Math.max(obtenerFE(aux.getLeft()), obtenerFE(aux.getRight()))+1);
         return aux;
     } 
     //Rotacion simple a la derecha
    public NodoArbol rotacionDerecha(NodoArbol c){
         NodoArbol aux = c.getRight();
         c.setRight(aux.getLeft());
         aux.setLeft(c);
         c.setFe(Math.max(obtenerFE(c.getLeft()), obtenerFE(c.getRight()))+1);
         aux.setFe(Math.max(obtenerFE(aux.getLeft()), obtenerFE(aux.getRight()))+1);
         return aux;
     } 
    //Rotacion doble izquierda
    public NodoArbol rotacionDobleIzquierda(NodoArbol c){
        NodoArbol temporal;
        c.setLeft(rotacionDerecha(c.getLeft()));
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    //rotacion doble derecha
    public NodoArbol rotacionDobleDerecha(NodoArbol c){
        NodoArbol temporal;
        c.setRight(rotacionIzquierda(c.getRight()));
        temporal=rotacionDerecha(c);
        return temporal;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }
    //Metodo para insertar avl
    public NodoArbol insertarAVL(NodoArbol nuevo,NodoArbol subAr){
        NodoArbol nuevoPadre = subAr;
        if(nuevo.getKey()<subAr.getKey()){
            if(subAr.getLeft()==null){
                subAr.setLeft(nuevo);
            }else{
                subAr.setLeft(insertarAVL(nuevo, subAr.getLeft()));
                if((obtenerFE(subAr.getLeft())-obtenerFE(subAr.getRight()))==2){
                    if(nuevo.getKey()<subAr.getLeft().getKey()){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.getKey()>subAr.getKey()){
            if(subAr.getRight()==null){
                subAr.setRight(nuevo);
            }else{
                subAr.setRight(insertarAVL(nuevo, subAr.getRight()));
                if((obtenerFE(subAr.getRight())-obtenerFE(subAr.getLeft()))==2){
                    if(nuevo.getKey()>subAr.getRight().getKey()){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre= rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo duplicado");
        }
        //Actualizando la altura
        if((subAr.getLeft()==null)&&(subAr.getRight()!=null)){
            subAr.setFe(subAr.getRight().getFe()+1);
        }else if((subAr.getRight()==null)&&(subAr.getLeft()!=null)){
            subAr.setFe(subAr.getLeft().getFe()+1);
        }else{
            subAr.setFe((Math.max(obtenerFE(subAr.getLeft()), obtenerFE(subAr.getRight())))+1);
        }
        return nuevoPadre;
    }
    //Metodo para insertar 
    public void insertar(int d,T valor){
        NodoArbol nuevo= new NodoArbol(d);
        nuevo.setValor(valor);
        if(this.raiz==null){
            this.raiz=nuevo;
        }else{
            this.raiz=insertarAVL(nuevo, this.raiz);
        }
    }
    //Recorridos:
    //Inorder
    public void inOrden(NodoArbol x){
        if(x!=null){
            inOrden(x.getLeft());
            System.out.println(x.getKey());
            inOrden(x.getRight());
        }
    }
    //preoder
    public void preOrder(NodoArbol x){
        if(x!=null){
            System.out.println(x.getKey());
            preOrder(x.getLeft());
            preOrder(x.getRight());
        }
    }
    //postOrder
    public void PostOrder(NodoArbol x){
        if(x!=null){
            PostOrder(x.getLeft());
            PostOrder(x.getRight());
            System.out.println(x.getKey());
        }
    }
    ///Eliminar
    public boolean eliminar(int d){
        NodoArbol nodoPadre=this.raiz;
        NodoArbol aux=this.raiz;
        boolean esHijoIzquierdo =false;
        while(aux.getKey()!=d){
            nodoPadre=aux;
            if(d<aux.getKey()){
                aux=aux.getLeft();
                esHijoIzquierdo=true;
            }else{
                aux=aux.getRight();
                esHijoIzquierdo=false;
            }if(aux==null){
                return false;
            }
        }
        //fin del while 
        if(aux.getLeft()==null && aux.getRight()==null){
            if(aux==raiz){
                this.raiz=null;
            }else if(esHijoIzquierdo){
                nodoPadre.setLeft(null);
            }else{
                nodoPadre.setRight(null);
            }
        }else if(aux.getRight()==null){
            if(aux==raiz){
                this.raiz=aux.getLeft() ;
            }else if(esHijoIzquierdo){
                nodoPadre.setLeft(aux.getLeft());
            }else{
                nodoPadre.setRight(aux.getLeft());
            }
        }else if(aux.getLeft()==null){
            if(aux==raiz){
                this.raiz=aux.getRight() ;
            }else if(esHijoIzquierdo){
                nodoPadre.setLeft(aux.getRight());
            }else{
                nodoPadre.setRight(aux.getRight());
            }
        }else{
            NodoArbol reemplazo=obtenerNodoReemplazo(aux);
            if(aux==raiz){
                raiz=reemplazo;
            }else if(esHijoIzquierdo){
                nodoPadre.setLeft(reemplazo);
            }else{
                nodoPadre.setRight(reemplazo);
            }
            reemplazo.setLeft(aux.getLeft());
        }
        return true;
    }
    //Motodo encargado de devolernos el nodo reemplazo
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodorem){
        NodoArbol reemplazarPadre=nodorem;
        NodoArbol reemplazo=nodorem;
        NodoArbol aux=nodorem.getRight();
        while(aux!= null){
            reemplazarPadre=reemplazo;
            reemplazo=aux;
            aux=aux.getLeft();
        }      
        if(reemplazo!=nodorem.getRight()){
            reemplazarPadre.setLeft(reemplazo.getRight());
            reemplazo.setRight(nodorem.getRight());
        }
        System.out.println("El nodo reemplazo es:"+reemplazo);
        return reemplazo;
    }
    
}
