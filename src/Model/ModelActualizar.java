/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import View.Actualizar;
import View.Insertar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModelActualizar {

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
   
    public void actualizar(String ruta) {  
        try {
            Icon done = new ImageIcon(getClass().getResource("/Images/file_star.png"));

            File f = new File(ruta);
            String fecha = Actualizar.jTextFecha.getText();
            String segundoAP = Actualizar.jTextAP.getText().substring(0, 2);
            String inicialAM = Actualizar.jTextAM.getText().substring(0, 1);
            String inicialNom = Actualizar.jTextNombre.getText().substring(0, 1);

            char vectorFecha[] = fecha.toCharArray();
            String año = Character.toString(vectorFecha[8]);
            String año1 = Character.toString(vectorFecha[9]);
            String mes = Character.toString(vectorFecha[3]);
            String mes1 = Character.toString(vectorFecha[4]);
            String dia = Character.toString(vectorFecha[0]);
            String dia1 = Character.toString(vectorFecha[1]);

            String RFC = segundoAP + inicialAM + inicialNom + año + año1 + mes + mes1 + dia + dia1;
            String semestre = (String) Actualizar.jComboSem.getSelectedItem();
            String lic = (String) Actualizar.jComboLic.getSelectedItem();

            ModelInsertar lice = new ModelInsertar();

            String alumno = Actualizar.jTextCuenta.getText() + "|" + Actualizar.jTextNombre.getText() + "|" + Actualizar.jTextAP.getText() + "|" + Actualizar.jTextAM.getText() + "|" + Actualizar.jTextFecha.getText() + "|" + RFC.toUpperCase() + "|" + semestre + "|" + lice.Licenciatura(lic) + "|" + Actualizar.jTextProm.getText();

            if (!f.exists()) {
                f.createNewFile();
            }

            BufferedWriter Fescrbir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            Fescrbir.write(alumno + "\r\n");
            Fescrbir.close();

            Actualizar.jTextRFC.setText(RFC.toUpperCase());
            JOptionPane.showMessageDialog(null, "Dato actualizado exitosamente", "Actualizado Exitoso", JOptionPane.PLAIN_MESSAGE, done);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscar(String ruta, String cuenta) {
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
                        Actualizar.jTextNombre.setText(st.nextToken());
                        Actualizar.jTextAP.setText(st.nextToken());
                        Actualizar.jTextAM.setText(st.nextToken());
                        Actualizar.jTextFecha.setText(st.nextToken());
                        Actualizar.jTextRFC.setText(st.nextToken());
                        Actualizar.jComboSem.setSelectedItem(st.nextToken());
                        String token = st.nextToken();
                        if (token.equals("ICO")) {
                            Actualizar.jComboLic.setSelectedIndex(1);
                        } else if (token.equals("ADM")) {
                            Actualizar.jComboLic.setSelectedIndex(2);
                        } else if (token.equals("CON")) {
                            Actualizar.jComboLic.setSelectedIndex(3);
                        } else if (token.equals("POL")) {
                            Actualizar.jComboLic.setSelectedIndex(4);
                        } else if (token.equals("TUR")) {
                            Actualizar.jComboLic.setSelectedIndex(5);
                        } else if (token.equals("IAD")) {
                            Actualizar.jComboLic.setSelectedIndex(6);
                        }                                              
                        Actualizar.jTextProm.setText(st.nextToken());
                        i++;
                        break;
                    }
                }
            }

//            if (i == 0) {                
//                JOptionPane.showMessageDialog(null, "No se encontro el registro", "Registro NO encontrado", JOptionPane.PLAIN_MESSAGE, error);
//            }
            //jTextFieldRegistros.setText(Integer.toString(i));
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void eliminar(String file, String cuenta) {
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

            //JOptionPane.showMessageDialog(null, "Elemento Eliminado", "Eliminado", JOptionPane.PLAIN_MESSAGE, done);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
