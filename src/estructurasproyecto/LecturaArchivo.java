/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasproyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mivil
 */
public class LecturaArchivo {
    
    
        public  void  leer(){
            File archivo = new File("Datos.txt");
            Scanner flujoEntrada = null;
            String linea;
            String [] palabras ;
            Producto producto;
            int referencia;
            String nombre;
            int id;
            String marca;
            double precio;
            try{
            if (archivo.exists()){
               
                flujoEntrada = new Scanner (archivo);
                flujoEntrada.nextLine();
                while(flujoEntrada.hasNextLine()){
                    linea = flujoEntrada.nextLine();
                    palabras = linea.split(",");
                    
                    
                    
                   // System.out.println("Nombre: "+palabras[0]+"  Referencia:"+referencia);
                        }
            }
            }catch(Exception e){
                System.out.println("Error en el archivo");
            }
        }
      
}
