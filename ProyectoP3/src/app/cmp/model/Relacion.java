/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cmp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author @Estudiante
 */
@XmlRootElement(name = "Relacion")
@XmlType(propOrder = { "actividad", "sucesor"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Relacion {

    @XmlAttribute
    String actividad;
    @XmlAttribute
    String sucesor;

    public Relacion(String actividad, String sucesor) {
        this.actividad = actividad;
        this.sucesor = sucesor;
    }

    public Relacion() {
        this.actividad = null;
        this.sucesor = null;
    }

    public void setAct(String actividad) {
        this.actividad = actividad;
    }

    public String getAct() {
        return actividad;
    }

    public void setSuce(String sucesor) {
        this.sucesor = sucesor;
    }

    public String getSuce() {
        return sucesor;
    }

    @Override
    public String toString() {
        return "( Actvidad: " + this.actividad + ", Sucesor: " + this.sucesor + " )";
    }

}
