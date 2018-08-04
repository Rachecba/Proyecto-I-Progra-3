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
	private ArrayList<String> sucesores=new ArrayList<>();
        private ArrayList<String> predecesores=new ArrayList<>();
	
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
   void agregarSucesor(String s){
        sucesores.add(s);
    }
   void agregarPredecesor(String s){
        predecesores.add(s);
    }   
	@Override
    public String toString() {
        return "\nDuracion:" + this.duracion +",\nSucesores:" +sucesores.toString()+", \nPredecesores:"+ predecesores.toString() +"\n=============\n";
    }
	
    
}
