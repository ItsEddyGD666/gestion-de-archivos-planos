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

public class ControlEliminar implements ActionListener, KeyListener {

    private Eliminar delete;
    private ModelEliminar model;
    private ModelBuscar search;

    public ControlEliminar(Eliminar delete, ModelEliminar model, ModelBuscar buscar) {
        this.delete = delete;
        this.model = model;
        this.search = buscar;
        this.delete.btnEliminar.addActionListener(this);
        this.delete.btnRegresar.addActionListener(this);
        this.delete.btnMostrar.addActionListener(this);
        this.delete.jTextCuenta.addKeyListener(this);
    }

    public void iniciarVista() {
        delete.setTitle("Eliminar");
        delete.setLocationRelativeTo(null);
        delete.setIconImage(new ImageIcon(getClass().getResource("/Images/file_delete(2).png")).getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();
        Icon error = new ImageIcon(getClass().getResource("/Images/file_error.png"));
        Icon corrupted = new ImageIcon(getClass().getResource("/Images/file_corrupted.png"));
        Icon delete_file = new ImageIcon(getClass().getResource("/Images/file_delete_64.png"));

        if (button == delete.btnEliminar) {
            if (delete.jTextCuenta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el No. de cuenta", "Campos Incompletos", JOptionPane.PLAIN_MESSAGE, error);
            } else {
                int i = search.buscarElemento(Principal.jTextRuta.getText(), delete.jTextCuenta.getText());
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "El No. de cuenta NO Existe", "Cuenta Inexistente", JOptionPane.PLAIN_MESSAGE, corrupted);
                } else {
                    int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el registro?", "Eliminar elemento", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, delete_file);
                    if (JOptionPane.OK_OPTION == confirmar) {
                        model.del(Principal.jTextRuta.getText(), delete.jTextCuenta.getText());
                    } else {

                    }
                }
            }
        }

        if (button == delete.btnRegresar) {
            delete.dispose();
        }

        if (button == delete.btnMostrar) {
            Mostrar view = new Mostrar();
            ModelMostrar mMostrar = new ModelMostrar();
            ControlMostrar cMostrar = new ControlMostrar(view, mMostrar);
            cMostrar.iniciarVista();
            view.setVisible(true);
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
