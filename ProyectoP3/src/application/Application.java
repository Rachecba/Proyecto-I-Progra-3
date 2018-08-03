/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static application.Loader_xml.act_xml;
import static application.Loader_xml.relac_xml;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author david
 */
public class Application {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("Actividades: ");
	List<Actividad> actividades = act_xml();
        System.out.println(actividades);
	System.out.println("Relaciones: ");
	List<Relacion> relaciones=relac_xml();
	System.out.println(relaciones);
    }
}
