package cmp.data;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Datos.java" is the root-element of our example
@XmlRootElement(name = "datos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Datos {

    // XmlElement sets the name of the entities
    @XmlElement(name = "Actividad")
    private ArrayList<Actividad> actividades;
    @XmlElement(name = "Relacion")
    private ArrayList<Relacion> relaciones;

    public Datos() {
    }
    
    public Datos(ArrayList<Actividad> actividades, ArrayList<Relacion> relaciones) {
        this.actividades = actividades;
        this.relaciones = relaciones;
    }
    
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<Relacion> getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(ArrayList<Relacion> relaciones) {
        this.relaciones = relaciones;
    }
    
}