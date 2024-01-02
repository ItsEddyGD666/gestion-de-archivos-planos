/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControlBuscar implements ActionListener, KeyListener {

    private Buscar search;
    private ModelBuscar model;

    public ControlBuscar(Buscar buscar, ModelBuscar model) {
        this.search = buscar;
        this.model = model;
        this.search.btnBuscar.addActionListener(this);
        this.search.btnLimpiar.addActionListener(this);
        this.search.btnRegresar.addActionListener(this);
        this.search.jTextCuenta.addKeyListener(this);
    }

    public void iniciarVista() {
        search.setTitle("Buscar");
        search.setLocationRelativeTo(null);
        search.setIconImage(new ImageIcon(getClass().getResource("/Images/search_file.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        Icon error = new ImageIcon(getClass().getResource("/Images/file_error.png"));

        if (button == search.btnBuscar) {
            if (search.jTextCuenta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el número de cuenta", "Campo Incompleto", JOptionPane.PLAIN_MESSAGE, error);
            } else {
                String ruta = View.Principal.jTextRuta.getText();
                String cuenta = search.jTextCuenta.getText();
                model.Buscar(ruta, cuenta);
            }
        }

        if (button == search.btnLimpiar) {
            search.jTextCuenta.setText("");
            search.jTextNombre.setText("");
            search.jTextAP.setText("");
            search.jTextAM.setText("");
            search.jTextFecha.setText("");
            search.jTextRFC.setText("");
            search.jTextSemestre.setText("");
            search.jTextLic.setText("");
            search.jTextProm.setText("");
        }

        if (button == search.btnRegresar) {
            search.dispose();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
