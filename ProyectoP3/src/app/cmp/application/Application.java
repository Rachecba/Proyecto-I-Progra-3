/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cmp.application;

import app.cmp.gui.simpleView;
import app.cmp.model.Actividad;
import app.cmp.model.Relacion;
import app.cmp.model.Rutas;
import app.cmp.managed.Loader_xml;
import static app.cmp.managed.Loader_xml.act_xml;
import static app.cmp.managed.Loader_xml.relac_xml;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.jgrapht.DirectedGraph;

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
