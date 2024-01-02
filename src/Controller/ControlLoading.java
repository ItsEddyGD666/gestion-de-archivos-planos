/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Controller;

import View.*;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ControlLoading {

    private Loading load;

    public ControlLoading(Loading load) {
        this.load = load;
    }

    public void iniciarVista() {
        load.setTitle("Gestion de Alumnos");
        load.setLocationRelativeTo(null);
        load.setIconImage(new ImageIcon(getClass().getResource("/Images/user (2).png")).getImage());
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Images/loading.gif"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(load.jLabel4.getWidth(), load.jLabel4.getWidth(), Image.SCALE_DEFAULT));
        load.jLabel4.setIcon(fondo);
        load.jLabel4.repaint();                                        
    }

}
