/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author david
 */
public class Relacion {

    String act;
    String suce;

    public Relacion(String act, String suce) {
        this.act = act;
        this.suce = suce;
    }

    public Relacion() {
        this.act = null;
        this.suce = null;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getAct() {
        return act;
    }

    public void setSuce(String suce) {
        this.suce = suce;
    }

    public String getSuce() {
        return suce;
    }

    @Override
    public String toString() {
        return "( Actvidad: " + this.act + ", Sucesor: " + this.suce + " )";
    }

}
