/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import com.thoughtworks.xstream.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Eduardo
 */
public class ManejoXML {
    
    public ManejoXML(){}
    
    /**
     * Crea los archivos xml
     * @param O
     * @param nombre 
     */
    public static void guardarXML(Object O, String nombre)
    {
        XStream xstream = new XStream();
        XStream.setupDefaultSecurity(xstream); //Metodo necesario para seguridad
        String xml = xstream.toXML(O);
        try{
        PrintWriter writer = new PrintWriter(nombre + ".xml", "UTF-8");
        writer.println(xml);
        writer.close();
        } catch (IOException e) {
           System.out.println("Ocurrió un error al guardar el archivo");
        }
    }
    
    /**
     * Lee los archivos xml
     * @param pNombreArchivo
     * @return 
     */
    public static Object leerXML(String pNombreArchivo)
    {
        String nombreArchivo = pNombreArchivo + ".xml";
        String xml = "";
        String line; 
        try {
            StringBuilder auxXml = new StringBuilder();
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                auxXml.append(line);
            }
            // Se cierra el archivo despues de leerse
            bufferedReader.close();
            xml = auxXml.toString();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                nombreArchivo + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + nombreArchivo + "'");
        }
        XStream xstream = new XStream();
        XStream.setupDefaultSecurity(xstream);
        //xstream.allowTypesByWildcard(new String[] {
        //Estudiante.class.getPackage().getName()+".*"});
        Object newObject =(Object) xstream.fromXML(xml);
        return newObject;
    }
}
