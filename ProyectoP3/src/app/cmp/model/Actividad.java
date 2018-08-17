/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cmp.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author @Estudiante
 */
@XmlRootElement(name = "Actividad")
@XmlType(propOrder = { "id", "duracion","x","y"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Actividad implements Comparable<Actividad> {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private int duracion;
    @XmlTransient
    private final ArrayList<Actividad> sucesores = new ArrayList<>();
    @XmlTransient
    private final ArrayList<Actividad> predecesores = new ArrayList<>();
    @XmlTransient
    private int TC;
    @XmlTransient
    private int TL; //terminoCercano y terminoLejano
    @XmlTransient
    private int numVisitas;
    @XmlTransient
    private boolean visitado;
    @XmlAttribute
    private int x;
    @XmlAttribute
    private int y;

    public Actividad(String id, int duracion, int x, int y) {
        this.id = id;
        this.duracion = duracion;
        this.TL = 0;
        this.TC = 0;
        this.numVisitas = 0;
        this.visitado = false;
        this.x = x;
        this.y = y;
    }

    public Actividad() {
        this.id = " ";
        this.duracion = 0;
        this.TL = 0;
        this.TC = 0;
        this.visitado = false;
        this.x = 0;
        this.y = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNumVisitas(int i) {
        this.numVisitas = i;
    }

    public int getNumVisitas() {
        return numVisitas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setVisi(boolean v) {
        this.visitado = v;
    }

    public boolean getVisi() {
        return visitado;
    }

    public void setTL(int tc) {
        this.TL = tc;
    }

    public int getTL() {
        return TL;
    }

    public void setTC(int tc) {
        this.TC = tc;
    }

    public int getTC() {
        return TC;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void agregarSucesor(Actividad s) {
        sucesores.add(s);
    }

    public void agregarPredecesor(Actividad s) {
        predecesores.add(s);
    }

    public int getNumPredecesores() {
        return predecesores.isEmpty() ? 0 : predecesores.size();
    }

    public int getNumSucesores() {
        return sucesores.isEmpty() ? 0 : sucesores.size();
    }

    public int calculoHolgura() {
        return TL - TC;
    }

    @Override
    public String toString() {
        return "( " + this.id + ", " + this.duracion + ", TC: " + this.TC + ", TL: " + this.TL + ", X: " + this.x + ", Y: " + this.y + " )";
    }

    @Override
    public int compareTo(Actividad o) {
        return this.getDuracion() - o.getDuracion();
    }

}
