/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.presentation;

import cmp.data.Actividad;

/**
 *
 * @author leaca
 */
public class Controller {
    Model model;
    SimpleView view;

    public Controller(Model model, SimpleView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void agregarActividad(String id, int duracion, int x, int y){
        Actividad a = new Actividad(id, duracion, x, y);
        model.agregarAct(a);
    }
    
    
}
