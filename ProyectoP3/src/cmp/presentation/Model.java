/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.presentation;

import cmp.data.Actividad;
import cmp.logic.Rutas;
import java.util.Observable;

/**
 *
 * @author leaca
 */
public class Model extends Observable{
    private Rutas model;

    public Model() {
    }
    
    public Model(Rutas model) {
        this.model = model;
    }

    public Rutas getModel() {
        return model;
    }

    public void setModel(Rutas model) {
        this.model = model;
    }    
    
    public void agregarAct(Actividad a){
        model.agregarActividad(a);
        this.setChanged();
        this.notifyObservers();
    }
}
