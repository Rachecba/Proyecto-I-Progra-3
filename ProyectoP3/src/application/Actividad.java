/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Actividad {
    	private String id;
	private int duracion;
	private ArrayList<String> sucesores=new ArrayList<String>();
	
   public Actividad( String id, int duracion){
      this.id = id;
      this.duracion=duracion;
   }

   public Actividad(){
      this.id = " ";
      this.duracion = 0;
   } 
   
   public void setId( String id )
   {
      this.id = id;
   } 

   public String getId()
   {
      return id;
   }

   public void setDuracion( int duracion )
   {
      this.duracion = duracion;
   } 

   public int getDuracion()
   {
      return duracion;
   } 
   void agregarSucesor(String c){
        sucesores.add(c);

    }   
	@Override
    public String toString() {
        return "( ID: "+this.id+", Duracion: " + this.duracion +", Sucesores: " +sucesores.toString()+" )";
    }
	
    
}
