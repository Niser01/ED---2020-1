
package estructurasproyecto;


public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String referencia;
    private double precio;
    private long next;
    private long prev;
    private String categoria;
    
    public Producto(int id,String nombre,String marca,String referencia,double precio){
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precio = precio;
        this.next = 0;
        this.prev = 0;
    }
    public Producto(){
        this.id = 0;
        this.marca = null;
        this.nombre = null;
        this.referencia = null;
        this.precio = 0;
        this.next = 0;
        this.prev = 0;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public void setPrev(long prev) {
        this.prev = prev;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public long getNext() {
        return next;
    }

    public long getPrev() {
        return prev;
    }
    
}
