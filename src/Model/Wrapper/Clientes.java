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
    @XmlAttribute (name = "static")
    private int staticToSave=0;

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
        if (!verificarCarnet(cliente.getIdUsuario())){
            lista.add(cliente);
            staticToSave= Cliente.contador;
            saveInXML();
        }
    }

    /**
     * Verifica si el cliente se encuentra en la lista.
     * @param clienteVerificado Carnet del cliente que se busca en la lista.
     * @return Booleano: Está en la lista?
     */
    public boolean verificarCarnet(String clienteVerificado){
        for (Cliente clienteVerificar:
                getLista()) {
            if (Objects.equals(clienteVerificado, clienteVerificar.getIdUsuario()))
                return true;
        }
        return false;
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
            staticToSave=clientes.staticToSave;
        }catch (Exception e){
            saveInXML();
        }
    }
}
