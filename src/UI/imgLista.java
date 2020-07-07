
package UI;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class imgLista extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
       if(o instanceof JLabel){
           JLabel lbl= (JLabel)o;
           return lbl;
       }
        return super.getListCellRendererComponent(jlist, o, i, bln, bln1); //To change body of generated methods, choose Tools | Templates.
    } 
}
