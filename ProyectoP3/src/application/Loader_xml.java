/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author david
 */
public class Loader_xml {
    public static Map<String,Actividad> act_xml() throws ParserConfigurationException, SAXException, IOException{	  
	Map<String,Actividad> actividades =new HashMap<>();  
        Actividad acti = null;
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(new File("C://Users//david//Desktop//Progra//PRYOYECTO1/datos.xml"));
			
	doc.getDocumentElement().normalize();
			
	NodeList nList = doc.getElementsByTagName("Actividad");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Element nNode =(Element)nList.item(temp);
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			acti=new Actividad();
			acti.setId(eElement.getAttribute("id"));
			acti.setDuracion(Integer.parseInt(eElement.getAttribute("duracion")));
			
			actividades.put(acti.getId(),acti);
		}
	}
	return actividades;
  }
  
  public static List<Relacion> relac_xml() throws ParserConfigurationException, SAXException, IOException{	  
        List<Relacion> relaciones =new ArrayList<>();  
        Relacion rela = null;
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(new File("C://Users//david//Desktop//Progra//PRYOYECTO1/datos.xml"));
			
	doc.getDocumentElement().normalize();
			
	NodeList nList = doc.getElementsByTagName("Relacion");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Element nNode =(Element)nList.item(temp);
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			rela=new Relacion();
			rela.setAct(eElement.getAttribute("actividad"));
			rela.setSuce(eElement.getAttribute("sucesor"));
			
			relaciones.add(rela);
		}
	}
	return relaciones;
  }
  
  public void agregarSucesores(Map<String,Actividad> m,List<Relacion> r){
      String tmp=" ";
      String tmp2=" ";
      for(int i=0;i<r.size()-1;i++){
        tmp = r.get(i).getAct();
        tmp2 = r.get(i).getSuce();
      if(m.containsKey(tmp))
          m.get(tmp).agregarSucesor(tmp2);
      }
  
  }
  
  public void agregarPredecesores(Map<String,Actividad> m,List<Relacion> r){
      String tmp=" ";
      String tmp2=" ";
      for(int i=0;i<r.size()-1;i++){
        tmp = r.get(i).getAct();
        tmp2 = r.get(i).getSuce();
      if(m.containsKey(tmp2))
          m.get(tmp2).agregarPredecesor(tmp);
      }
  
  }
}
