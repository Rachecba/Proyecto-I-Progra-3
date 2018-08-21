/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp;

import cmp.presentation.SimpleView;
import cmp.logic.Rutas;
import cmp.presentation.Controller;
import cmp.presentation.Model;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author david
 */
public class Application {
    public static void main(String[] args) {        
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                Rutas rutas = new Rutas(selectedFile.getAbsolutePath());
                System.out.println(rutas.cpm(rutas.getAcividades()));
                
                SimpleView view = new SimpleView();
                Model model = new Model(rutas);
                Controller controller = new Controller(model, view);   
                view.setVisible(true);
                
                //System.in.read(); //esto es para esperar hasta que el usuario haga enter
            } catch (Exception e) {
                System.out.print("\n\n\nERROR CON EL PROGRAMA!!!!");
                e.printStackTrace();
            }
        }
    }
}
