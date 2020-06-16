
package UI;


import estructurasproyecto.ArbolAVL;
import estructurasproyecto.ListaEnlazada;
import estructurasproyecto.Producto;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Buscar_prod extends javax.swing.JFrame {
    
    static ListaEnlazada<Producto> productos = new ListaEnlazada<>();
    static ArbolAVL<Producto> arbolProductos = new ArbolAVL<>();
    
    public Buscar_prod() {
        initComponents();
         this.setLocation(400, 200);
    }

   
   
   
   public void  leer(){
            long inicio = System.currentTimeMillis(),fin;
            double tiempo;
            File archivo = new File("Datos10000.csv");
            Scanner flujoEntrada;
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
                    palabras = linea.split(";");
                    id = Integer.parseInt(palabras[0]);
                    nombre = palabras[1];
                    referencia = palabras[3];
                    precio = Double.parseDouble(palabras[4]); 
                    marca = palabras[2];
                   
                     producto = new Producto(id,nombre,marca,referencia,precio);
                    
                    productos.add(producto);
                    arbolProductos.insertar(id, producto);
                }
                fin = System.currentTimeMillis();
                tiempo = (double)((fin-inicio)/1000);
                System.out.println("Tiempo en leer y cargar en memoria los productos:"+tiempo
                                        +"segundos");
            }
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error en el archivo");
            }
        }
    
 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        LabeldeBusqueda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Busqueda de Productos:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese el nombre del producto:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        LabeldeBusqueda.setForeground(new java.awt.Color(102, 0, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabeldeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(LabeldeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UI_Main return_ui = new UI_Main();
        UI_Main.jLabel7.setText(LabeldeBusqueda.getText());
        this.setVisible(false);
        return_ui.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Buscar_prod_resultados mostrar = new Buscar_prod_resultados();
        
        if(productos.getSize()== 0){
           leer(); 
           
           long inicio = System.currentTimeMillis(), fin;
            double tiempo;    
            int resultado =0;
            Producto[] arreglo = new Producto[productos.getSize()];
            String busqueda = jTextField1.getText();

            if(busqueda.isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto que desea buscar: ");
            }else{    
                for (int i = 0; i < productos.getSize(); i++) {
            
                    if(productos.obtener(i).getNombre().equals(busqueda)){
                        arreglo[resultado]=productos.obtener(i);
                        resultado=resultado+1;
                                   
                } 
                
            }
            fin = System.currentTimeMillis();
            tiempo = (double)((fin-inicio)/1000);
            System.out.println("Restultados de la búsqueda:"+resultado);
            System.out.println("tiempo para ejecutar la busqueda:"+tiempo+"segundos");
             
             
            Producto[] info_filtrada = new Producto[resultado];
        
            for(int j=0;j<resultado;j++){
                info_filtrada[j]=arreglo[j];
            }
            
            if(resultado == 0){
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto.");
            }else{
                mostrar.print(info_filtrada);
                mostrar.setVisible(true);
                Buscar_prod_resultados.jLabel2.setText(LabeldeBusqueda.getText());
                this.setVisible(false);
            }
        }
           
           
           
        }else{         
            long inicio = System.currentTimeMillis(), fin;
            double tiempo;    
            int resultado =0;
            Producto[] arreglo = new Producto[productos.getSize()];
            String busqueda = jTextField1.getText();

            if(busqueda.isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese producto en la barra");
            }else{    
                for (int i = 0; i < productos.getSize(); i++) {
            
                    if(productos.obtener(i).getNombre().equals(busqueda)){
                        arreglo[resultado]=productos.obtener(i);
                        resultado=resultado+1;
                                   
                } 
                
            }
            fin = System.currentTimeMillis();
            tiempo = (double)((fin-inicio)/1000);
            System.out.println("Restultados de la búsqueda:"+resultado);
            System.out.println("tiempo para ejecutar la busqueda:"+tiempo+"segundos");
             
             
            Producto[] info_filtrada = new Producto[resultado];
        
            for(int j=0;j<resultado;j++){
                info_filtrada[j]=arreglo[j];
            }
            
            if(resultado == 0){
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto.");
            }else{
                mostrar.print(info_filtrada);
                mostrar.setVisible(true);
                Buscar_prod_resultados.jLabel2.setText(LabeldeBusqueda.getText());
                this.setVisible(false);
            }
        }            
            
            
            
        }
        
        


 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buscar_prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar_prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar_prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_prod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LabeldeBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
