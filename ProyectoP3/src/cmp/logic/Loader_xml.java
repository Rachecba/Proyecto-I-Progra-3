/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cmp.logic;

import static cmp.logic.ReadXmlManaged.readXML;
import cmp.data.Actividad;
import cmp.data.Datos;
import cmp.data.Relacion;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author @Estudiante
 */
public class Loader_xml {
    
    //Leer el archivo y retornar un MAP con todas las actividades
    public static Map<String, Actividad> act_xml(String direccion) throws UnmarshalException, SAXParseException, JAXBException, FileNotFoundException {
        Map<String,Actividad> map = new HashMap<>();
        Datos data = readXML(direccion);
        data.getActividades().forEach((a) -> {
            map.put(a.getId(),a);
        });
        return map;
    }
    
    //Retornar todas las relaciones
    public static List<Relacion> relac_xml(String direccion) throws UnmarshalException, SAXParseException, JAXBException, FileNotFoundException, NullPointerException {
        Datos data = readXML(direccion);
        return data.getRelaciones();
    }
    
    public void agregarSucesores(Map<String, Actividad> m, List<Relacion> r) {
        String tmp;
        String tmp2;
        for (int i = 0; i < r.size(); i++) {
            tmp = r.get(i).getAct();
            tmp2 = r.get(i).getSuce();
            if (m.containsKey(tmp)) {
                m.get(tmp).agregarSucesor(m.get(tmp2));
            }
        }
    }
    
    public void agregarPredecesores(Map<String, Actividad> m, List<Relacion> r) {
        String tmp;
        String tmp2;
        for (int i = 0; i < r.size(); i++) {
            tmp = r.get(i).getAct();
            tmp2 = r.get(i).getSuce();
            if (m.containsKey(tmp2)) {
                m.get(tmp2).agregarPredecesor(m.get(tmp));
            }
        }
    }
    
    public void contruirEstructura(Map<String, Actividad> m, List<Relacion> r) {
        agregarSucesores(m, r);
        agregarPredecesores(m, r);
    }
}
