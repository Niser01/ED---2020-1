
package estructurasproyecto;

public class Persona {
    private String correo;
    private String contraseña;
    private String nombre;

    public Persona(String correo, String contraseña, String nombre) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }
    
}
