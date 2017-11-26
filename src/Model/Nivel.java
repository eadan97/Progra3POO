package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nivel")
public class Nivel {

    @XmlElement
    private int cantidadResidencia;
    @XmlElement
    private String tipo;
    @XmlElement
    private int zonasComunes;
    @XmlElement
    private int cantidadTiendas;

    public Nivel(String type,int comunZone, int cantidad ) {
        zonasComunes=comunZone;
        if(type.equals("residencial")){
            tipo="residencial";
            cantidadResidencia=cantidad;
            cantidadTiendas=0;
        }else{
            tipo="comercial";
            cantidadResidencia=0;
            cantidadTiendas=cantidad;
        }
        //esta ligado a la interfaz entonces no puede haber otro caso
    }

    public void setCantidadResidencia(int cantidadResidencia) {
        this.cantidadResidencia = cantidadResidencia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidadTiendas(int cantidadTiendas) {
        this.cantidadTiendas = cantidadTiendas;
    }

    public int getCantidadResidencia() {
        return cantidadResidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAreaZonasComunes() {
        return zonasComunes;
    }

    public int getCantidadTiendas() {
        return cantidadTiendas;
    }
    
    

}//ready