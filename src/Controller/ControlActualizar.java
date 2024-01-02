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

public class ControlActualizar implements ActionListener, KeyListener {

    private Actualizar update;
    private ModelActualizar model;
    private ModelBuscar buscar;

    public ControlActualizar(Actualizar update, ModelActualizar model, ModelBuscar search) {
        this.update = update;
        this.model = model;
        this.buscar = search;
        this.update.btnBuscar.addActionListener(this);
        this.update.btnUpdate.addActionListener(this);
        this.update.btnLimpiar.addActionListener(this);
        this.update.btnRegresar.addActionListener(this);
        this.update.btnMostrar.addActionListener(this);
        this.update.jTextCuenta.addKeyListener(this);
    }

    public void iniciarVista() {
        update.setTitle("Actualizar");
        update.setLocationRelativeTo(null);
        update.setIconImage(new ImageIcon(getClass().getResource("/Images/file_change.png")).getImage());
        update.jTextAccount.setEditable(false);
        update.jTextRFC.setEditable(false);
        update.btnUpdate.setVisible(false);
        //update.btnLimpiar.setVisible(false);
    }

    public void borrar() {        
        update.jTextAccount.setText("");
        update.jTextNombre.setText("");
        update.jTextAP.setText("");
        update.jTextAM.setText("");
        update.jTextFecha.setText("");
        update.jTextRFC.setText("");
        update.jComboSem.setSelectedIndex(0);
        update.jComboLic.setSelectedIndex(0);
        update.jTextProm.setText("");
        update.btnUpdate.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();
        Icon error = new ImageIcon(getClass().getResource("/Images/file_error.png"));
        Icon corrupted = new ImageIcon(getClass().getResource("/Images/file_corrupted.png"));
        Icon star = new ImageIcon(getClass().getResource("/Images/file_star.png"));

        if (button == update.btnBuscar) {
            if (update.jTextCuenta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el No. de Cuenta", "Campo Incompleto", JOptionPane.PLAIN_MESSAGE, error);
            } else {
                int i = buscar.buscarElemento(Principal.jTextRuta.getText(), update.jTextCuenta.getText());
                if (i == 0) {
                    borrar();
                    JOptionPane.showMessageDialog(null, "El No. de Cuenta no existe", "Cuenta Inexistente", JOptionPane.PLAIN_MESSAGE, error);
                } else {
                    update.jTextAccount.setText(update.jTextCuenta.getText());
                    model.buscar(Principal.jTextRuta.getText(), update.jTextCuenta.getText());
                    update.btnUpdate.setVisible(true);
                    //update.btnLimpiar.setVisible(true);
                }
            }
        }

        if (button == update.btnUpdate) {
            if (update.jTextCuenta.getText().equals("") || update.jTextNombre.getText().equals("") || update.jTextAP.getText().equals("") || update.jTextAM.getText().equals("") || update.jTextFecha.getText().equals("") || update.jTextProm.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Campos Incompletos", JOptionPane.PLAIN_MESSAGE, error);
            } else {
                int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea actualizar el dato?", "Actualizar dato", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, star);
                if (JOptionPane.OK_OPTION == confirmar) {
                    model.eliminar(Principal.jTextRuta.getText(), update.jTextCuenta.getText());
                    model.actualizar(Principal.jTextRuta.getText());
                } else {

                }
            }
        }

        if (button == update.btnMostrar) {
            Mostrar view = new Mostrar();
            ModelMostrar mMostrar = new ModelMostrar();
            ControlMostrar cMostrar = new ControlMostrar(view, mMostrar);
            cMostrar.iniciarVista();
            view.setVisible(true);
        }

        if (button == update.btnLimpiar) {
            update.jTextCuenta.setText("");
            borrar();
        }

        if (button == update.btnRegresar) {
            update.dispose();
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
