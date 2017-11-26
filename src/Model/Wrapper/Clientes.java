package Model.Wrapper;

import Model.Cliente;
import Model.Usuario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@XmlRootElement(name = "clientes")
public class Clientes {

    private static ArrayList<Cliente> lista=new ArrayList<>();

    @XmlElement(name = "cliente")
    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }

    //Terminan los Getters y Setters

    /**
     * Añade un cliente a la lista de clientes.
     * @param cliente cliente a añadir.
     */
    public void add(Cliente cliente){
        cliente.generarIDusuario(lista.size()+1);
        lista.add(cliente);
        saveInXML();
    }

    /**
     * Guarda en un XML la lista de clientes.
     * @throws Exception
     */
    public void saveInXML(){

        JAXBContext contextObj = null;
        try {
            contextObj = JAXBContext.newInstance(Clientes.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(this, new File("clientesDB.xml"));
        } catch (JAXBException e) {
            System.out.println("Error al guardar archivo: "+ e.getMessage()+ Arrays.toString(e.getStackTrace()));
        }

    }

    /**
     * Carga de un XML la lista de clientes.
     * @throws JAXBException
     */
    public void loadFromXML() {
        try{
            File file = new File( "clientesDB.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Clientes.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Clientes clientes = (Clientes) jaxbUnmarshaller.unmarshal( file );
            setLista(clientes.getLista());
        }catch (Exception e){
            saveInXML();
        }
    }
}
