/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import View.Buscar;
import View.Insertar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModelInsertar {

    public String Licenciatura(String lice) {
        String lic = "";
        switch (lice) {
            case "Ingeniería en Computacion":
                lic = "ICO";
                break;
            case "Licenciatura en Administración":
                lic = "ADM";
                break;
            case "Licenciatura en Contabilidad":
                lic = "CON";
                break;
            case "Licenciatura en Ciencias Politicas y Administración Publilca":
                lic = "POL";
                break;
            case "Licenciatura en Turismo":
                lic = "TUR";
                break;
            case "Licenciatura en Informática Administrativa":
                lic = "IAD";
                break;
        }
        return lic;
    }

    public void insertar(String ruta) {

        try {
            Icon done = new ImageIcon(getClass().getResource("/Images/file_star.png"));

            File f = new File(ruta);
            String fecha = Insertar.jTextFecha.getText();
            String segundoAP = Insertar.jTextAP.getText().substring(0, 2);
            String inicialAM = Insertar.jTextAM.getText().substring(0, 1);
            String inicialNom = Insertar.jTextNombre.getText().substring(0, 1);

            char vectorFecha[] = fecha.toCharArray();
            String año = Character.toString(vectorFecha[8]);
            String año1 = Character.toString(vectorFecha[9]);
            String mes = Character.toString(vectorFecha[3]);
            String mes1 = Character.toString(vectorFecha[4]);
            String dia = Character.toString(vectorFecha[0]);
            String dia1 = Character.toString(vectorFecha[1]);

            String RFC = segundoAP + inicialAM + inicialNom + año + año1 + mes + mes1 + dia + dia1;
            String semestre = (String) Insertar.jComboSemestre.getSelectedItem();
            String lic = (String) Insertar.jComboLic.getSelectedItem();

            ModelInsertar lice = new ModelInsertar();

            String alumno = Insertar.jTextCuenta.getText() + "|" + Insertar.jTextNombre.getText() + "|" + Insertar.jTextAP.getText() + "|" + Insertar.jTextAM.getText() + "|" + Insertar.jTextFecha.getText() + "|" + RFC.toUpperCase() + "|" + semestre + "|" + lice.Licenciatura(lic) + "|" + Insertar.jTextProm.getText();

            if (!f.exists()) {
                f.createNewFile();
            }

            BufferedWriter Fescrbir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            Fescrbir.write(alumno + "\r\n");
            Fescrbir.close();

            JOptionPane.showMessageDialog(null, "Dato agregado exitosamente", "Guardado Exitoso", JOptionPane.PLAIN_MESSAGE, done);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int buscar(String ruta, String cuenta) {
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

            /*if (i == 1) {                
                JOptionPane.showMessageDialog(null, "Numero de cuenta existente", "Número de Cuenta", JOptionPane.PLAIN_MESSAGE, error);
            }*/                     
            
            reader.close();                        
            
        } catch (IOException e) {
            System.out.println(e);
        }        
          
        return i;
    }

}
