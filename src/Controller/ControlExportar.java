/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControlExportar implements ActionListener {

    private Exportar export;
    private ModelExportar model;

    public ControlExportar(Exportar export, ModelExportar model) {
        this.export = export;
        this.model = model;
        this.export.btnRegresar.addActionListener(this);
        this.export.btnPDF.addActionListener(this);
        this.export.btnXLS.addActionListener(this);
    }

    public void iniciarVista() {
        export.setTitle("Exportar");
        export.setLocationRelativeTo(null);
        export.setIconImage(new ImageIcon(getClass().getResource("/Images/save-file.png")).getImage());
        export.jPanelXLS.setOpaque(false);
        export.jPanelPDF.setOpaque(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        if (button == export.btnPDF) {
            model.pdf(Principal.jTextRuta.getText());
        }
        
        if (button == export.btnXLS) {
            model.coma(Principal.jTextRuta.getText());
            model.xls(Principal.jTextRuta.getText());            
            model.comaRemplazo(Principal.jTextRuta.getText());            
        }
        
        if (button == export.btnRegresar) {
            export.dispose();
        }
    }

}
