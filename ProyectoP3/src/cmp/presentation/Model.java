/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.presentation;

import cmp.data.Actividad;
import cmp.data.Relacion;
import cmp.logic.Rutas;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.jgrapht.DirectedGraph;

/**
 *
 * @author leaca
 */
public class Model extends Observable{
    private Rutas model;
    public Actividad temporal;

    
    public Model() {
         model=new Rutas();
         temporal=new Actividad();

    }


    
    
    public Model(Rutas model) {
        this.model = model;
    }

    public Rutas getModel() {
        return model;
    }

    public void setModel(Rutas model) {
        this.model = model;
        this.setChanged();
        this.notifyObservers();
    }  

    
    
    public void agregarAct(Actividad a){
        model.getAcividades().put(a.getId(), a);
        this.setChanged();
        this.notifyObservers();
    }
    
     public void agregarRela(Relacion r){
        model.agregarRelacion(r);
        this.setChanged();
        this.notifyObservers();
    }
}
