/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp;

import cmp.presentation.simpleView;
import cmp.data.Rutas;
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
                
                simpleView view = new simpleView();
                view.setModel(rutas);
                view.setVisible(true);

            } catch (Exception e) {
                System.out.print("\n\n\nERROR CON EL PROGRAMA!!!!");
            }
        }
    }
}
