/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.presentation;

import cmp.data.Actividad;
import cmp.data.Datos;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.JAXBException;
import static cmp.logic.WriteXmlManaged.writeXML;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leaca
 */
public class Controller  {
    Model model;
    SimpleView view;
    boolean arrastrar;
    int mouseX;
    int mouseY;
    String idActividad;
    boolean bool2;


    public Controller(Model model, SimpleView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        bool2=false;
    }
    
    public void agregarActividad(String id, int duracion, int x, int y){
        Actividad a = new Actividad(id, duracion, x, y);
        model.agregarAct(a);
    }
    
    public void downloadFile() throws JAXBException{        
        ArrayList<Actividad> listA = new ArrayList<>();

        model.getModel().getAcividades().values().stream().filter((a) -> (!"Root".equals(a.getId()) && !"End".equals(a.getId()))).forEachOrdered((a) -> {
            listA.add(a);
        });
        
        Datos data = new Datos(listA, new ArrayList<>(model.getModel().getRelaciones()));
        
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION && checkIfValid(data.getActividades())) {
            File selectedFile = jfc.getSelectedFile();
            writeXML(data, selectedFile.getAbsolutePath());
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos no se pudo crear XML, todas las actividades deben de tener una relacion.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //chequea que todas las actividades tengan por lo menos una relacion
    public boolean checkIfValid(ArrayList<Actividad> listA){
        return listA.stream().noneMatch((a) -> (a.getNumSucesores() == 0 && a.getNumPredecesores() == 0));
    }
}
