/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cpm.controller;

import app.cmp.model.Actividad;
import app.cmp.view.Model;
import app.cmp.view.simpleView;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author Rachel
 */
public class Controller{
    Model model;
    simpleView view;
    boolean arrastrar;
    int mouseX;
    int mouseY;
    String idActividad;

    public Controller(Model model, simpleView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        
    }

    public Model getModel() {
        return model;
    }

    public simpleView getsimpleView() {
        return view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setsimpleView(simpleView view) {
        this.view = view;
    }
    
    public void agregarActividad(String id, int duracion, int x, int y){
        Actividad act = new Actividad(id, duracion, x, y);
        model.agregarActividad(act);
    }
}
