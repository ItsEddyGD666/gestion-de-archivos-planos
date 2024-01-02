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

public class ControlInsertar implements ActionListener, KeyListener {

    private Insertar add;
    private ModelInsertar model;

    public ControlInsertar(Insertar add, ModelInsertar model) {
        this.add = add;
        this.model = model;
        this.add.btnAgregar.addActionListener(this);
        this.add.btnLimpiar.addActionListener(this);
        this.add.btnRegresar.addActionListener(this);
        this.add.btnMostrar.addActionListener(this);
        this.add.jTextCuenta.addKeyListener(this);
    }

    public void iniciarVista() {
        add.setTitle("Insertar");
        add.setLocationRelativeTo(null);
        add.setIconImage(new ImageIcon(getClass().getResource("/Images/file_user.png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        Icon error = new ImageIcon(getClass().getResource("/Images/file_error.png"));

        if (button == add.btnAgregar) {
            if (add.jTextCuenta.getText().equals("") || add.jTextNombre.getText().equals("") || add.jTextAP.getText().equals("") || add.jTextAM.getText().equals("") || add.jTextFecha.getText().equals("") || add.jTextProm.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Campos Incompletos", JOptionPane.PLAIN_MESSAGE, error);
            } else {
                String ruta = Principal.jTextRuta.getText();
                String cuenta = add.jTextCuenta.getText();
                int regreso = model.buscar(ruta, cuenta);
                if (regreso == 1) {
                    JOptionPane.showMessageDialog(null, "Numero de cuenta existente", "Número de Cuenta", JOptionPane.PLAIN_MESSAGE, error);
                } else {
                    model.insertar(ruta);
                }
            }
        }

        if (button == add.btnLimpiar) {
            add.jTextCuenta.setText("");
            add.jTextNombre.setText("");
            add.jTextAP.setText("");
            add.jTextAM.setText("");
            add.jTextFecha.setText("");
            add.jComboSemestre.setSelectedIndex(0);
            add.jComboLic.setSelectedIndex(0);
            add.jTextProm.setText("");
        }

        if (button == add.btnMostrar) {
            Mostrar view = new Mostrar();
            ModelMostrar mMostrar = new ModelMostrar();
            ControlMostrar cMostrar = new ControlMostrar(view, mMostrar);
            cMostrar.iniciarVista();
            view.setVisible(true);
        }

        if (button == add.btnRegresar) {
            add.dispose();
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
