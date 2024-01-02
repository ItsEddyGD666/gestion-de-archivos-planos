/**
 * GESTION DE ARCHIVOS DE TEXTO PLANO CON JAVA
 * Github: ItsEddyGD666
 */
package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import View.*;
import Controller.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InterruptedException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Loading load = new Loading();
        ControlLoading cLoad = new ControlLoading(load);
        load.setVisible(true);
        
        try {
            cLoad.iniciarVista();
            Thread.sleep(3 * 1000);                        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        load.setVisible(false);
        Principal principal = new Principal();
        ControlMain cMain = new ControlMain(principal);
        cMain.iniciarVista();
        principal.setVisible(true);
        
        
    }

}
