/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControlMain implements ActionListener {

    private Principal main;

    public ControlMain(Principal main) {
        this.main = main;
        this.main.btnMostrar.addActionListener(this);
        this.main.btnBuscar.addActionListener(this);
        this.main.btnInsertar.addActionListener(this);
        this.main.btnEliminar.addActionListener(this);
        this.main.btnActualizar.addActionListener(this);
        this.main.btnExportar.addActionListener(this);
        this.main.btnSalir.addActionListener(this);
    }

    public void iniciarVista() {
        main.setTitle("Menu");
        main.setLocationRelativeTo(null);
        main.setIconImage(new ImageIcon(getClass().getResource("/Images/add-user (4).png")).getImage());
        main.jPanel1.setOpaque(false);
    }

    public void buttonMostrar() {
        Insertar add = new Insertar();
        ModelInsertar mInsertar = new ModelInsertar();
        ControlInsertar cInsertar = new ControlInsertar(add, mInsertar);
        cInsertar.iniciarVista();
        add.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        Icon file = new ImageIcon(getClass().getResource("/Images/carpeta.png"));
        Icon exit = new ImageIcon(getClass().getResource("/Images/exit.png"));

        /*if (button == main.btnArchivo) {
            JFileChooser jf = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.DAT", "dat", "*.TXT", "txt");
            jf.setFileFilter(filtro);       

            int opcion = jf.showOpenDialog(null);            
            File archivo = jf.getSelectedFile();

            if (opcion == JFileChooser.APPROVE_OPTION) {
                main.jTextRuta.setText(archivo.getAbsolutePath());
            }

            if (opcion == JFileChooser.ERROR_OPTION) {
                System.out.println("Opcion cancelada");
            }
        }*/
        if (button == main.btnBuscar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Buscar search = new Buscar();
                ModelBuscar mBuscar = new ModelBuscar();
                ControlBuscar cBuscar = new ControlBuscar(search, mBuscar);
                cBuscar.iniciarVista();
                //main.setVisible(false);
                search.setVisible(true);
            }
        }

        if (button == main.btnMostrar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Mostrar view = new Mostrar();
                ModelMostrar mMostrar = new ModelMostrar();
                ControlMostrar cMostrar = new ControlMostrar(view, mMostrar);
                cMostrar.iniciarVista();
                view.setVisible(true);
                //main.dispose();
            }
        }

        if (button == main.btnInsertar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Insertar add = new Insertar();
                ModelInsertar mInsertar = new ModelInsertar();                
                ControlInsertar cInsertar = new ControlInsertar(add, mInsertar);
                cInsertar.iniciarVista();
                add.setVisible(true);                
            }
        }

        if (button == main.btnEliminar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Eliminar delete = new Eliminar();
                ModelEliminar mEliminar = new ModelEliminar();
                ModelBuscar mBuscar = new ModelBuscar();
                ControlEliminar cEliminar = new ControlEliminar(delete, mEliminar, mBuscar);
                cEliminar.iniciarVista();
                delete.setVisible(true);
            }
        }

        if (button == main.btnActualizar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Actualizar update = new Actualizar();
                ModelActualizar mActualizar = new ModelActualizar();
                ModelBuscar mBuscar = new ModelBuscar();
                ControlActualizar cActualizar = new ControlActualizar(update, mActualizar, mBuscar);
                cActualizar.iniciarVista();
                update.setVisible(true);
            }
        }

        if (button == main.btnExportar) {
            if (main.jTextRuta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta del archivo", "Seleccion de ruta", JOptionPane.PLAIN_MESSAGE, file);
            } else {
                Exportar export = new Exportar();
                ModelExportar mExportar = new ModelExportar();
                ControlExportar cExportar = new ControlExportar(export, mExportar);
                cExportar.iniciarVista();
                export.setVisible(true);
            }
        }

        if (button == main.btnSalir) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, exit);
            if (JOptionPane.OK_OPTION == confirmar) {
                System.exit(0);
            } else {

            }
        }
    }

}
