package Model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlTransient
public abstract class Construccion extends Bien {

    @XmlElement
    private String areaConstruccion;
    @XmlElement
    private String estiloConstruccion;
    @XmlElement(name = "nivel")
    private ArrayList<Nivel> niveles;
    
    public String getAreaConstruccion() {
        return areaConstruccion;
    }

    public void setAreaConstruccion(String areaConstruccion) {
        this.areaConstruccion = areaConstruccion;
    }

    public String getEstiloConstruccion() {
        return estiloConstruccion;
    }

    public void setEstiloConstruccion(String estiloConstruccion) {
        this.estiloConstruccion = estiloConstruccion;
    }

    public ArrayList<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }
    
    public String toString(){
        String s="";
        s+="Estilo de construccion: "+estiloConstruccion+"\n";
        s+="AreaConstruccion: "+areaConstruccion+"\n";
        return s;
    }
}