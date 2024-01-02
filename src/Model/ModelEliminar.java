/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import View.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelEliminar {

    public void del(String file, String cuenta) {
        Icon error = new ImageIcon(getClass().getResource("/Images/file_error.png"));
        Icon done = new ImageIcon(getClass().getResource("/Images/file_star.png"));

        try {
            File f = new File(file);
            if (!f.isFile()) {
                JOptionPane.showMessageDialog(null, "Parametro no corresponde a un archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }

            File temporal = new File(f.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(new FileWriter(temporal));

            String line = "";
            StringTokenizer st;

            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, "|");
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    if (!str.trim().equals(cuenta)) {
                        pw.println(line);
                        break;
                    } else {
                        break;
                    }
                }
            }

            pw.close();
            br.close();

            if (!f.delete()) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo", "ERROR", JOptionPane.PLAIN_MESSAGE, error);
                return;
            }

            if (!temporal.renameTo(f)) {
                JOptionPane.showMessageDialog(null, "No se pudo cambiar el nombre del archivo", "ERROR", JOptionPane.PLAIN_MESSAGE, error);
            }

            JOptionPane.showMessageDialog(null, "Elemento Eliminado", "Eliminado", JOptionPane.PLAIN_MESSAGE, done);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
