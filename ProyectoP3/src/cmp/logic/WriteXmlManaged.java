/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.logic;

import cmp.data.Datos;
import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;

/**
 *
 * @author leaca
 */
public class WriteXmlManaged {
    public static void writeXML(Datos data, String FilePath) throws JAXBException, UnmarshalException{
        JAXBContext context = JAXBContext.newInstance(Datos.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        //print XML to see if its correct
        m.marshal(data, System.out);
        
        m.marshal(data, new File(FilePath + ".xml"));
    }
}
