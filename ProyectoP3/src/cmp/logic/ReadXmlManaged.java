/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmp.logic;

import cmp.data.Datos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author leaca
 */
public class ReadXmlManaged {
    public static Datos readXML (String FilePath) throws JAXBException, FileNotFoundException{
        JAXBContext context = JAXBContext.newInstance(Datos.class);
        Unmarshaller um = context.createUnmarshaller();
        Datos data = (Datos) um.unmarshal(new FileReader(FilePath));
        
        return data;
    }
}
