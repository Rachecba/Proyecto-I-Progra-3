/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Actividad implements Comparable<Actividad> {

    private String id;
    private int duracion;
    private ArrayList<Actividad> sucesores = new ArrayList<>();
    private ArrayList<Actividad> predecesores = new ArrayList<>();
    int TC, TL;
    boolean visitado;

    public Actividad(String id, int duracion) {
        this.id = id;
        this.duracion = duracion;
        this.TL = 0;
        this.TC = 0;
        this.visitado = false;
    }

    public Actividad() {
        this.id = " ";
        this.duracion = 0;
        this.TL = 0;
        this.TC = 0;
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

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean vis) {
        this.visitado = vis;
    }

    public int getDuracion() {
        return duracion;
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
        return "( "+this.id + ", " + this.duracion + ", TC " + this.TC + ", TL " + this.TL +" )";
    }

    @Override
    public int compareTo(Actividad o) {
        return o.getDuracion() - this.getDuracion();
    }

}
