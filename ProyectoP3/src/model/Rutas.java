/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author david
 */
public class Rutas {

    public static Actividad root = new Actividad("Root", 0);
    public static Actividad end;

    /*
    Agrega root al hashmap 
    Y luego verifica cuales de las Actividades del hashmap no tiene predecesores excluyendo root (sino se haria un root apunta a root)
    Y luego agrega el camino de root a la Actividad
     */
    public void asignarRoot(Map<String, Actividad> m, DirectedGraph g) {
        m.put(root.getId(), root);
        for (Map.Entry<String, Actividad> entrada : m.entrySet()) {
            if (entrada.getValue().getNumPredecesores() == 0 && !"Root".equals(entrada.getValue().getId())) {
                root.agregarSucesor(entrada.getValue());
                g.addEdge(root, entrada.getValue());
            }

        }
    }

    /*
    Agrega end al hashmap 
    Lo mismo que en el asignar root solo que con sucesores
     */
    public void asignarEnd(Map<String, Actividad> m, DirectedGraph g) {
        end = new Actividad("End", 0);
        g.addVertex(end);
        m.put(end.getId(), end);
        for (Map.Entry<String, Actividad> entrada : m.entrySet()) {
            if (entrada.getValue().getNumSucesores() == 0 && !"End".equals(entrada.getValue().getId())) {
                end.agregarPredecesor(entrada.getValue());
                g.addEdge(entrada.getValue(), end);
            }

        }
    }

    //Contruye el Grafo
    public DirectedGraph construirGrafo(Map<String, Actividad> m, List<Relacion> r) {
        String tmp;
        String tmp2;
        DirectedGraph<Actividad, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        g.addVertex(root);
        for (int i = 0; i < r.size(); i++) {
            tmp = r.get(i).getAct();
            tmp2 = r.get(i).getSuce();
            if (m.containsKey(tmp)) {
                g.addVertex(m.get(tmp));
            }
            g.addVertex(m.get(tmp2));
            g.addEdge(m.get(tmp), m.get(tmp2));
        }
        return g;
    }

    /*Recorre el grafo desde el inicio 
    1) Saca lista de sucesores 
    2) Ordena por duracion de mayor a menor (ver clase Actividad se implemento interfaz comparable)
    3) Setea valor de TC al mayor con la duracion de si mismo mas la de la actividad anterior 
    4) Repite jajaja.
    5) Se llama al recorreGrafoIn ya que estamos usando la variable privada root por parametro, en recorre Grafo Final es igual.
     */
    public void recorreGrafoInicio(DirectedGraph g, Actividad r) {

        List<Actividad> l;
        l = Graphs.successorListOf(g, r);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i).getVisitado()) {
                l.get(i).setTC(l.get(i).getDuracion() + r.getTC());
                l.get(i).setVisitado(true);
                System.out.println(l.get(i));
                recorreGrafoInicio(g, l.get(i));
            }
        }

    }

    public void recorreGrafoIn(DirectedGraph g) {
        recorreGrafoInicio(g, root);
    }

    /*Recorre el grafo desde el final 
    1) Saca lista de predecesores
    2) Setea valor de la diferencia entre el TC y la duracion del actual al TL al predecesor  
    4) Repite jajaja.
     */
    public void recorreGrafoF(DirectedGraph g) {
        recorreGrafoFinal(g, end);
    }

    public void recorreGrafoFinal(DirectedGraph g, Actividad r) {

        List<Actividad> l;
        l = Graphs.predecessorListOf(g, r);
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getVisitado()) {
                l.get(i).setTL(r.getTC() - r.getDuracion());
                System.out.println(l.get(i));
                recorreGrafoFinal(g, l.get(i));
                l.get(i).setVisitado(false);
            }
        }

    }

    public List<Actividad> cpm(Map<String, Actividad> m) {
        List<Actividad> t = new ArrayList<>();
        for (Map.Entry<String, Actividad> entrada : m.entrySet()) {
            if (entrada.getValue().calculoHolgura() == 0 && !"Root".equals(entrada.getValue().getId())) {
                t.add(entrada.getValue());
            }
        }
        return t;

    }

}