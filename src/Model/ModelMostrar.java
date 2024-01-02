/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Model;

import View.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModelMostrar {

    public void mostrar(String ruta) {
        int contador = 0;
        String linea;

        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader filtro = new BufferedReader(archivo);
            linea = filtro.readLine();            

            while (linea != null) {                
                Mostrar.jTextArea.append(linea);
                Mostrar.jTextArea.append(System.getProperty("line.separator")); 
                linea = filtro.readLine();
                ++contador;
            }
                       
            Mostrar.jTextAlumnos.setText(String.valueOf(contador));
            filtro.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo :(");
        }
    }

    public int registros(String ruta) {
        int contador = 0;
        String linea;

        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader filtro = new BufferedReader(archivo);
            linea = filtro.readLine();            

            while (linea != null) {                                
                ++contador;
            }
                                   
            filtro.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo :(");
        }
        return contador;
    }
    
}
