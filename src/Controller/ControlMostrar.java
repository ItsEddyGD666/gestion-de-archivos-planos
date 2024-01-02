/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ControlMostrar implements ActionListener{
    
    private Mostrar view;
    private ModelMostrar model;    
    
    public ControlMostrar(Mostrar mos, ModelMostrar model) {
        this.view = mos;
        this.model = model;
        this.view.btnRegresar.addActionListener(this);
    }
    
    public void iniciarVista() {
        view.setTitle("Mostrar");
        view.setLocationRelativeTo(null);
        view.setIconImage(new ImageIcon(getClass().getResource("/Images/printer.png")).getImage());                
        
        view.jTextAlumnos.setEditable(false);
        model.mostrar(Principal.jTextRuta.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        if (button == view.btnRegresar) {
            view.dispose();
        }
        
    }
    
}
