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
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.xml.sax.SAXException;

/**
 *
 * @author david
 */
public class Application {
    public static void main(String[] args){
        try{
         Loader_xml l=new Loader_xml();
        //System.out.println("Actividades: ");
	Map<String,Actividad> actividades = act_xml();
        //System.out.println(actividades);
	//System.out.println("Relaciones: ");
	List<Relacion> relaciones=relac_xml();
        l.agregarSucesores(actividades,relaciones);
        l.agregarPredecesores(actividades, relaciones);
	//System.out.println(relaciones);
        
        System.out.println(actividades);

        
        }
        catch(IOException | ParserConfigurationException | SAXException e){}
    }
}
