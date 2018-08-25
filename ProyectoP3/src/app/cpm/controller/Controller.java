/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cpm.controller;

import app.cmp.model.Actividad;
import app.cmp.view.Model;
import app.cmp.view.simpleView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author Rachel
 */
public class Controller implements MouseListener, MouseMotionListener{
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(Actividad a : model.getR().getAcividades().values()){
            if(a.getX() == e.getX() && a.getY() == e.getY()){
                this.mouseX = e.getX();
                this.mouseY = e.getY();
                this.arrastrar = true;
                this.idActividad = a.getId();
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        arrastrar = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = model.getR().getAcividades().get(this.idActividad).getX();
        int y = model.getR().getAcividades().get(this.idActividad).getY();
        
        model.getR().getAcividades().get(this.idActividad).setX(x + (e.getX() - this.mouseX));
        model.getR().getAcividades().get(this.idActividad).setY(y + (e.getY() - this.mouseY));
        
        view.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
