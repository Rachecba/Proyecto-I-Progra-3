/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import model.Loader_xml;
import model.Actividad;
import model.Relacion;
import model.Rutas;
import static model.Loader_xml.act_xml;
import static model.Loader_xml.relac_xml;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.ParserConfigurationException;
import org.jgrapht.DirectedGraph;
import org.xml.sax.SAXException;

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

                Loader_xml l = new Loader_xml();
                Rutas r = new Rutas();
                Map<String, Actividad> actividades = act_xml(selectedFile.getAbsolutePath());
                DirectedGraph h;
                List<Relacion> relaciones = relac_xml();
                l.contruirEstructura(actividades, relaciones);

                h = r.construirGrafo(actividades, relaciones);
                r.asignarRoot(actividades, h);
                r.asignarEnd(actividades, h);
                System.out.println("Recorrido desde root");

                r.recorreGrafoIn(h);
                System.out.println("Recorrido viceversa");

                r.recorreGrafoF(h);
                System.out.println("CPM:");
                System.out.println(r.cpm(actividades));

            } catch (IOException | ParserConfigurationException | SAXException e) {
            }
        }
    }
}
