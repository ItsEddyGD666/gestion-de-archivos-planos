/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import View.*;
import Model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ModelExportar {

    JFileChooser seleccion = new JFileChooser();
    Date fecha = new Date();

    public void pdf(String ruta) {
        Icon done = new ImageIcon(getClass().getResource("/Images/file_star.png"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PDF", "pdf");
        seleccion.setFileFilter(filtro);
        int opcion = seleccion.showSaveDialog(null);
        if (opcion == seleccion.APPROVE_OPTION) {

            String linea;

            try {                

                FileReader archivo = new FileReader(ruta);
                BufferedReader filtroF = new BufferedReader(archivo);
                linea = filtroF.readLine();

                OutputStream texto_salida = new FileOutputStream(seleccion.getSelectedFile() + ".pdf");
                Document doc = new Document();
                PdfWriter.getInstance(doc, texto_salida);
                doc.open();
                doc.add(new Paragraph("LISTA DE ALUMNOS \n\n"));
                while (linea != null) {
                    doc.add(new Paragraph(linea + "\n"));
                    linea = filtroF.readLine();
                }
                DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");                  
                doc.add(new Paragraph("\nHora y fecha de creacion del archivo: " + hourdateFormat.format(fecha)));                
                filtroF.close();
                doc.close();
                texto_salida.close();
                JOptionPane.showMessageDialog(null, "Archivo PDF creado correctamente", "Archivo creado", JOptionPane.PLAIN_MESSAGE, done);                

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (DocumentException ex) {
                Logger.getLogger(Exportar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void xls(String ruta) {
        Icon done = new ImageIcon(getClass().getResource("/Images/file_star.png"));
        FileInputStream origen = null;
        FileOutputStream destino = null;

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.CSV", "csv");
        seleccion.setFileFilter(filtro);
        int opcion = seleccion.showSaveDialog(null);
        if (opcion == seleccion.APPROVE_OPTION) {

            File rutaXLS = seleccion.getSelectedFile();
            String fin = rutaXLS.getAbsolutePath();

            try {
                origen = new FileInputStream(ruta);
                destino = new FileOutputStream(fin + ".csv");
                DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");   
                String hoy = hourdateFormat.format(fecha);
                int i = origen.read();
                while (i != -1) {
                    destino.write(i);
                    i = origen.read();                    
                }                     
                origen.close();
                destino.close();
                JOptionPane.showMessageDialog(null, "Archivo XLS creado correctamente", "Archivo creado", JOptionPane.PLAIN_MESSAGE, done);
            } catch (IOException e) {
                System.out.println("Error al leer la fuente");
            }
        }

    }

    public void coma(String ruta) {
        RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice = 0;

        try {
            fichero = new RandomAccessFile(ruta, "rw");

            palabra = "|";

            //lectura del archivo
            cadena = fichero.readLine();
            while (cadena != null) {
                indice = cadena.indexOf(palabra); // busca la palabra en la linea leida
                while (indice != -1) {

                    auxBuilder = new StringBuilder(cadena);
                    auxBuilder.replace(indice, indice + palabra.length(), ",");
                    cadena = auxBuilder.toString();

                    fichero.seek(pos);
                    fichero.writeBytes(cadena);
                    //comprobar si se repite la misma palabra dentro del renglon o la linea
                    indice = cadena.indexOf(palabra);

                }
                pos = fichero.getFilePointer(); //posicion de la linea actual donde voy a leer
                cadena = fichero.readLine(); // lectura de la linea
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }

            } catch (IOException e) {

            }

        }
    }

    public void comaRemplazo(String ruta) {
        RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice = 0;

        try {
            fichero = new RandomAccessFile(ruta, "rw");

            palabra = ",";

            //lectura del archivo
            cadena = fichero.readLine();
            while (cadena != null) {
                indice = cadena.indexOf(palabra); // busca la palabra en la linea leida
                while (indice != -1) {

                    auxBuilder = new StringBuilder(cadena);
                    auxBuilder.replace(indice, indice + palabra.length(), "|");
                    cadena = auxBuilder.toString();

                    fichero.seek(pos);
                    fichero.writeBytes(cadena);
                    //comprobar si se repite la misma palabra dentro del renglon o la linea
                    indice = cadena.indexOf(palabra);

                }
                pos = fichero.getFilePointer(); //posicion de la linea actual donde voy a leer
                cadena = fichero.readLine(); // lectura de la linea
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }

            } catch (IOException e) {

            }

        }
    }

}
