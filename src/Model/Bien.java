package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "agente")
public abstract class Bien implements Serializable {

    @XmlElement
    private int numeroFinca;

    @XmlElement
    private double areaTerreno;

    @XmlElement
    private double valorMetroCuadrado;

    @XmlElement
    private double valorFiscal;

    @XmlElement
    private String direccion;

    @XmlElement
    private ArrayList<byte[]> imagenes;//despues

    @XmlElement
    private String estado;

    @XmlElement(name="interesados")
    private ArrayList<Cliente> interesados;

    public void setImagenes(ArrayList<byte[]> pImagenes) {
        imagenes = pImagenes;
    }

    public int getNumeroFinca() {
        return numeroFinca;
    }

    public void setNumeroFinca(int numeroFinca) {
        this.numeroFinca = numeroFinca;
    }

    public String getAreaTerreno() {
        return String.valueOf(areaTerreno);
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public String getValorMetroCuadrado() {
        return String.valueOf(valorMetroCuadrado);
    }

    public void setValorMetroCuadrado(double valorMetroCuadrado) {
        this.valorMetroCuadrado = valorMetroCuadrado;
    }

    public String getValorFiscal() {
        return String.valueOf(valorFiscal);
    }

    public void setValorFiscal(double valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList getImagenes() {
        return imagenes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Cliente> getInteresados() {
        return interesados;
    }

    public void setInteresados(ArrayList<Cliente> interesados) {
        this.interesados = interesados;
    }

    public String toString(){
        String s="";
        s+="Area del terreno: " +this.getAreaTerreno()+"\n";
        s+="Direccion: "+ this.getDireccion()+"\n";
        s+="Valor: "+this.getValorFiscal()+"\n";
        s+="Interesados: "+interesados.size();
        return s;
    }

}
