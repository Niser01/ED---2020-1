
package estructurasproyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class EstructurasProyecto {

   static ListaEnlazada<Producto> productos = new ListaEnlazada<>();
   static ListaEnlazada<Producto> carrito = new ListaEnlazada<>();
   static ListaEnlazada<Persona> personas = new ListaEnlazada<>();
   public static void  leer(){
            File archivo = new File("Datos.txt");
            Scanner flujoEntrada = null;
            String linea;
            String [] palabras ;
            Producto producto;
            String referencia;
            String nombre;
            int id;
            String marca;
            double precio;
            try{
            if (archivo.exists()){
               
                flujoEntrada = new Scanner (archivo);
                while(flujoEntrada.hasNextLine()){
                    linea = flujoEntrada.nextLine();
                    palabras = linea.split(",");
                    id = Integer.parseInt(palabras[0]);
                    nombre = palabras[1];
                    referencia = palabras[2];
                    precio = Double.parseDouble(palabras[3]); 
                    marca = palabras[4];
                   
                     producto = new Producto(id,nombre,marca,referencia,precio);
                    
                    productos.add(producto);
                   
                        }
            }
            }catch(Exception e){
                System.out.println("Error en el archivo");
            }
        }
    public static void main(String[] args) {
        leer();
        menu();     
       
    }
    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println("Bienvenido a TiendaOnline.co");
        System.out.println("1)Buscar producto");
        System.out.println("2)Ver el carrito");
        System.out.println("3)Vender");
        System.out.println("4)Iniciar sesion");
        opcion = entrada.nextInt();
        switch(opcion){
            case 1:
                buscar();
                break;
            case 2:
                verCarrito();
                break;
            case 3:
                vender();
                break;
            case 4:
                iniciarSesion();
                break;
            default :System.out.println("Elección inválida");    
        }
    }
    public static void agregarCarro(int a){
        for (int i = 0; i < productos.getSize(); i++) {
            if (productos.obtener(i).getId() == a){
                carrito.add(productos.obtener(i));
                break;
            }
        }
    }
    public static void mostrarProducto(Producto a){
        System.out.println("\n\n\t||"+a.getNombre()+"||");
        System.out.println("|$"+a.getPrecio()+"|   |Marca:"+a.getMarca()+"|");
        System.out.println("|Referencia:"+a.getReferencia()+"|   |"+a.getId()+"|");
    }
    public static void buscar (){
        Scanner entrada = new Scanner (System.in);
        String busqueda;
        String decision;
        int resultado =0;
        int id;
        System.out.println("Ingrese el nombre del producto:");
        busqueda = entrada.next();
        for (int i = 0; i < productos.getSize(); i++) {
            if(productos.obtener(i).getNombre().equals(busqueda)){
                mostrarProducto(productos.obtener(i));
                resultado++;
            }
        }
        System.out.println("Restultados de la búsqueda:"+resultado);
        
        if(resultado == 0){
            System.out.println("Presione 1 para volver");
            entrada.next();
            menu();
        }
        System.out.println("¿Desea agregar al carrito?(s/n)");
        decision= entrada.next();
        if(decision.equals("s")){
            System.out.println("Ingrese el id:");
            id = entrada.nextInt();
            agregarCarro(id);
            System.out.println("Agregado al carrito");
            menu();
        }else{
            menu();
        }
       
    }
    public static void verCarrito(){
       int opcion;
       char decision;
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Cantidad de productos en el carrito:"+carrito.getSize());
            for (int i = 0; i < carrito.getSize(); i++) {
                mostrarProducto(carrito.obtener(i));
            }
            System.out.println("1)Comprar\n2)Retirar\n3)Volver");
            opcion = entrada.nextInt();
            if (opcion == 1){
                if(carrito.getSize()!=0){
                    for (int i = 0; i < carrito.getSize(); i++) {
                        for (int j = 0; j < productos.getSize(); j++) {
                            if(carrito.obtener(i).getId()==productos.obtener(i).getId()){
                                productos.eliminar(i);
                            }
                        }
                    }
                    System.out.println("vendido");
                }else{
                    System.out.println("el carrito está vacío");
                }
            }
            if(opcion == 2){
                Producto key = carrito.eliminarUltimo();
                System.out.println("se eliminó el último elemento agregado");
                mostrarProducto(key);
                System.out.println("¿Deshacer?(s/n)");
                decision=entrada.next().charAt(0);
                if(decision == 's'){
                    carrito.add(key);
                }else{
                    System.out.println("volver");
                    entrada.next();
                }
            }
        }while(opcion != 3);
         menu();
        
    }
    public static void vender(){
       try{
            Scanner entrada = new Scanner(System.in);
            String nombre;
            String marca;
            String referencia;
            double precio;
            System.out.println("Nombre del producto:");
            nombre = entrada.nextLine();
            System.out.println("Precio:");
            precio= entrada.nextDouble();
            System.out.println("Referencia:");
            referencia = entrada.next();
            System.out.println("Marca:");
            marca = entrada.nextLine();
            marca = entrada.nextLine();
            FileWriter fw = new FileWriter("Datos.txt");
            Producto producto = new Producto(productos.getSize()+1,nombre,marca,
            referencia,precio);
            productos.add(producto);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < productos.getSize(); i++) {
              pw.print(productos.obtener(i).getId()+","+productos.obtener(i).getNombre()+
                      ","+productos.obtener(i).getReferencia()+","+productos.obtener(i).getPrecio()+
                      ","+productos.obtener(i).getMarca()+"\n");
               
           }
            pw.flush();
            pw.close();
            System.out.println("Se ha agregado un producto");
       }catch(Exception e){
           System.out.println("No se encontró el archivo o error en el ingreso de un archivo ");
       }
        
    }
    public static void iniciarSesion(){
      
        Scanner entrada = new Scanner (System.in);
        int opcion;
        System.out.println("1)Login");
        System.out.println("2)Registrarse");
        System.out.println("3)volver");
        opcion = entrada.nextInt();
        switch(opcion){
            case 1 :
                    try{
                        String correo1,correo2;
                        String contraseña1,contraseña2;
                        boolean existe = false;
                        Scanner leer ;
                        File archivo = new File("usuario.txt");
                        String linea;
                        String[] palabras; 
                        System.out.println("Usuario:");
                        correo1 = entrada.next();
                        System.out.println("Contraseña:");
                        contraseña1= entrada.next();
                        if(archivo.exists()){
                            leer = new Scanner(archivo);
                            while(leer.hasNextLine()){
                                linea = leer.nextLine();
                                palabras = linea.split(",");
                                correo2 = palabras[0];
                                contraseña2 = palabras[1];
                                if(correo1.equals(correo2)){
                                    System.out.println("El usuario existe");
                                    existe = true;
                                    if(contraseña1.equals(contraseña2)){
                                        System.out.println("Acceso correcto");
                                        break;
                                    }else{
                                        System.out.println("contraseña incorrecta");
                                        break;
                                    }
                                }
                                
                            }
                            if(existe == false){
                                System.out.println("No se encontró una cuenta con este usuario");  
                            }
                        }
                    }catch(Exception e){
                        System.out.println("Error el archivo no existe");
                    }
                    
                break;
            case 2 :
                try{
                    leerUsusarios();
                    String correo;
                    String contraseña,contraseña2;
                    String nombre;
                    System.out.println("REGISTRO");
                    System.out.println("Direccion de correo");
                    correo = entrada.next();
                    do{
                    System.out.println("Contraseña");
                    contraseña = entrada.next();
                    System.out.println("Confirmar contraseña");
                    contraseña2 = entrada.next();
                    if(contraseña.equals(contraseña2)==false){
                        System.out.println("las contraseñas no coinciden");
                    }
                    }while(contraseña.equals(contraseña2)==false);
                    entrada.nextLine();
                    System.out.println("Nombre de usuario:");
                    nombre = entrada.nextLine();
                    FileWriter fw = new FileWriter("usuario.txt");
                    Persona persona = new Persona(correo, contraseña, nombre);
                    personas.add(persona);
                    for (int i = 0; i < personas.getSize(); i++) {
                        System.out.println(personas.obtener(i).getNombre());
                    }
                    PrintWriter pw = new PrintWriter(fw);
                    for (int i = 0; i < personas.getSize(); i++) {
                        pw.print(personas.obtener(i).getCorreo()+","+
                                  personas.obtener(i).getContraseña()+","+
                                   personas.obtener(i).getNombre()+"\n");
                        
                    }
                    pw.flush();
                    pw.close();
                }catch(Exception e){
                    System.out.println("No se encontró la dirección del archivo");
                }
                break;  
            case 3 :
                menu();
                break;
            default : System.out.println(opcion+" no es una opcion");
                iniciarSesion();
        }
        
        
    }

    public static void  leerUsusarios(){
       try{ 
            Scanner leer;
            String linea;
            String[] palabras;
            String usuario,correo,contraseña;
            File archivo = new File("usuario.txt");
            if(archivo.exists()){
                leer = new Scanner(archivo);
                while(leer.hasNextLine()){
                    linea = leer.nextLine();
                    palabras = linea.split(",");
                    correo = palabras[0];
                    contraseña = palabras[1];
                    usuario = palabras[2];
                    Persona persona = new Persona(correo, contraseña, usuario);
                    personas.add(persona);
                }
            }
       }catch (Exception e){
           System.out.println("Error en leer usuarios al leer los usuarios");
       }
    }
    
}
