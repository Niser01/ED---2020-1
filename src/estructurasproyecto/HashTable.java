
package estructurasproyecto;


public class HashTable {
    private int size;
    private int counter;
    private float porcentajeUtil;
    private Producto[] vectorHash;
    
    public HashTable(){
        this.size=7;
        vectorHash = new Producto[size];
    } 

    public int getSize() {
        return size;
    }
    
    public void redimensionar(){
        this.size = size*2;
        while(!esPrimo(size)){
            size--;
        }
        Producto[] nuevo = vectorHash;
        this.vectorHash = new Producto[size];
        this.counter=0;
        this.porcentajeUtil= calcularPorcentajeUtil();
        for(int i=0;i<nuevo.length;i++){
            if(nuevo[i]!=null){
                insertar(nuevo[i]);
            }
        }
        
    }
    public void insertar(Producto producto){
        if(porcentajeUtil<= 65.00f){
            String nombre = producto.getNombre();
            int codigoString = generarClave(nombre);
            int codigoGenerado = funcion1(codigoString);    
            if(vectorHash [codigoGenerado]==null){
                vectorHash[codigoGenerado]=producto;//si la primer posicion del hash no está ocupada
                porcentajeUtil=calcularPorcentajeUtil();
                counter++;
            }else{
                int posicionCorrecta = h1(codigoGenerado);
                vectorHash[posicionCorrecta]=producto;
                porcentajeUtil=calcularPorcentajeUtil();
                counter++;
            }
        }else{
            //redimensionar
            redimensionar();
            insertar(producto);
        }
    }
    public ListaEnlazada<Producto> buscar(String nombre){
        
        int codigoString = generarClave(nombre);
        int codigoGenerado = funcion1(codigoString);
        int i =1;
        int f=0;
        ListaEnlazada<Producto> listaEncontrada= new ListaEnlazada();
        int resultado=codigoGenerado;
        while(vectorHash[resultado]!=null && vectorHash[resultado].getNombre().equals('b')==false){
            if(vectorHash[resultado].getNombre().equals(nombre)){
               listaEncontrada.add(vectorHash[resultado]);
            }
            f=i*h2(codigoGenerado);
            resultado=(funcion1(codigoGenerado)+f)%size;
            i++;
        }
        return listaEncontrada;
    }
    public boolean isfull(){
        return(this.counter==this.size);
    }
    
    public float calcularPorcentajeUtil(){
        return (counter*100)/size;
    }
    private int funcion1(int clave){
        return clave%size;
    }
    private int h1(int x){
        int i=1;
        int f=i*h2(x);
        int resultado = (funcion1(x)+f)%size;
        while(vectorHash[resultado]!=null && vectorHash[resultado].getNombre().equals('b')==false){
            i++;
            f=i*h2(x);
            resultado=(funcion1(x)+f)%size;
        }
        return resultado;
    }
    
    private int h2(int x){
        int primomenor=size-1;
        while(!esPrimo(primomenor)){
            primomenor=primomenor-1;
        }
        int resultado =primomenor-(x%primomenor);
        return resultado;
    }
    
    
    private int generarClave(String id){
        String codigo="";
        int tmp=0;
        
        for(int i=0;i<id.length();i++){
            codigo+=id.codePointAt(i);
        }
        if(codigo.length()>9){
            return reduccion(codigo);
        }else{
            return Integer.parseInt(codigo);
        }
    }
    
    private int reduccion(String codigo){
        int tmp=0;
        while(codigo.length()>9){
            String aux="";
            for (int i = 0; i < codigo.length()/2; i++) {
                aux+=codigo.charAt(i);
            }
            if(aux.length()>9){
                tmp=reduccion(aux);
                aux="";
            }else{
                tmp=Integer.parseInt(aux);
                aux="";
            }
            
            for(int i = codigo.length()/2;i<codigo.length();i++){
                aux+=codigo.charAt(i);
            }
            if(aux.length()>9){
                tmp=reduccion(aux);
                aux="";
            }else{
                tmp=Integer.parseInt(aux);
                aux="";
            }
            codigo=tmp+"";
        }
        return tmp;
    }
    
    private boolean esPrimo(int n){
        boolean p=true;
        int d=2;
        if(n<2){
            p=false;
        }else{
            while(p && d<=Math.sqrt(n)){
                if(n%d ==0){
                    p=false;
                }
                d++;
            }
        }
        return p;
    }
    
  
}
