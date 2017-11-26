package Model.Wrapper;

import Model.Agente;
import Model.Bien;

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

@XmlRootElement(name = "agentes")
public class Agentes {


    private static ArrayList<Agente> lista=new ArrayList<>();

    @XmlElement(name = "agente")
    public ArrayList<Agente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Agente> lista) {
        Agentes.lista = lista;
    }

    //Terminan los Getters y Setters

    /**
     * Añade un agente a la lista de agentes.
     * @param agente agente a añadir.
     */
    public String add(Agente agente){
        agente.generarIDusuario(lista.size()+1);
        lista.add(agente);
        saveInXML();
        return agente.getIdUsuario();
    }

    /**
     * Verifica si el agente se encuentra en la lista.
     * @param agenteVerificado Carnet del agente que se busca en la lista.
     * @return Booleano: Está en la lista?
     */
    public boolean verificarCarnet(String agenteVerificado){
        for (Agente agenteVerificar:
                getLista()) {
            if (Objects.equals(agenteVerificado, agenteVerificar.getIdUsuario()))
                return true;
        }
        return false;
    }

    /**
     * Guarda en un XML la lista de agentes.
     * @throws Exception
     */
    public void saveInXML(){

        JAXBContext contextObj = null;
        try {
            contextObj = JAXBContext.newInstance(Agentes.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(this, new File("agentesDB.xml"));
        } catch (JAXBException e) {
            System.out.println("Error al guardar archivo: "+ e.getMessage()+ Arrays.toString(e.getStackTrace()));
        }

    }

    /**
     * Carga de un XML la lista de agentes.
     * @throws JAXBException
     */
    public void loadFromXML() {
        try{
            File file = new File( "agentesDB.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Agentes.class );

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Agentes agentes = (Agentes) jaxbUnmarshaller.unmarshal( file );
            setLista(agentes.getLista());
        }catch (Exception e){
            saveInXML();
        }
    }

    public Agente getAgente(String dato1) {
        for (Agente a: lista) {
            if(a.getIdUsuario()==dato1)
                return a;
        }
        return null;
    }

    public ArrayList<Bien> getTodosLosBienes() {
        ArrayList<Bien> res = new ArrayList<>();
        for (Agente a:
             lista)
            res.addAll(a.bienes);
        return res;
    }
}
