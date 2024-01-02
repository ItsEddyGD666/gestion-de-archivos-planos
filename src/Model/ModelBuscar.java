/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import View.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelBuscar {

    public void Buscar(String ruta, String cuenta) {

        Icon error = new ImageIcon(getClass().getResource("/Images/file_corrupted.png"));

        try {

            File inFile = new File(ruta);
            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            String busqueda = cuenta;
            String line = "";
            StringTokenizer st;
            int i = 0;

            while ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line, "|");
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    if (str.equals(busqueda)) {
                        Buscar.jTextNombre.setText(st.nextToken());
                        Buscar.jTextAP.setText(st.nextToken());
                        Buscar.jTextAM.setText(st.nextToken());
                        Buscar.jTextFecha.setText(st.nextToken());
                        Buscar.jTextRFC.setText(st.nextToken());
                        Buscar.jTextSemestre.setText("Semestre " + st.nextToken());
                        Buscar.jTextLic.setText(st.nextToken());
                        Buscar.jTextProm.setText(st.nextToken());
                        i++;
                        break;
                    }
                }
            }

            if (i == 0) {
                Buscar.jTextNombre.setText("");
                Buscar.jTextAP.setText("");
                Buscar.jTextAM.setText("");
                Buscar.jTextFecha.setText("");
                Buscar.jTextRFC.setText("");
                Buscar.jTextSemestre.setText("");
                Buscar.jTextLic.setText("");
                Buscar.jTextProm.setText("");
                JOptionPane.showMessageDialog(null, "No se encontro el registro", "Registro NO encontrado", JOptionPane.PLAIN_MESSAGE, error);
            }
            
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public int buscarElemento(String ruta, String cuenta) {
        Icon error = new ImageIcon(getClass().getResource("/Images/file_corrupted.png"));
        int i = 0;
        try {

            File inFile = new File(ruta);
            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            String busqueda = cuenta;
            String line = "";
            StringTokenizer st;

            while ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line, "|");
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    if (str.equals(busqueda)) {
                        i++;
                        break;
                    }
                }
            }
            
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return i;
    }

}
