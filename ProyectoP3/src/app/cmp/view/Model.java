/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cmp.view;

import app.cmp.model.Actividad;
import app.cmp.model.Rutas;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Rachel
 */
public class Model extends Observable{
    Rutas r;

    public Model(Rutas r) {
        this.r = r;
    }

    public Rutas getR() {
        return r;
    }

    public void setR(Rutas r) {
        this.r = r;
    }
    
    public void agregarActividad(Actividad A){ //throws Exception{
        r.agregarActividad(A);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void addObserver(Observer o){
    super.addObserver(o);
    setChanged();
    notifyObservers(null);    
    }
    
}
