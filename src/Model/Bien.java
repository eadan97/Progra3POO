package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.*;

@XmlTransient
public abstract class Bien implements Serializable {

    private int numeroFinca;
    private double areaTerreno;
    private double valorMetroCuadrado;
    private double valorFiscal;
    private String direccion;
    private ArrayList<byte[]> imagenes;//despues


    private String estado;


    private ArrayList<Cliente> interesados;

    public void setImagenes(ArrayList<byte[]> pImagenes) {
        imagenes = pImagenes;
    }

    @XmlElement
    public int getNumeroFinca() {
        return numeroFinca;
    }

    public void setNumeroFinca(int numeroFinca) {
        this.numeroFinca = numeroFinca;
    }

    @XmlElement
    public String getAreaTerreno() {
        return String.valueOf(areaTerreno);
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    @XmlElement
    public String getValorMetroCuadrado() {
        return String.valueOf(valorMetroCuadrado);
    }

    public void setValorMetroCuadrado(double valorMetroCuadrado) {
        this.valorMetroCuadrado = valorMetroCuadrado;
    }

    @XmlElement
    public String getValorFiscal() {
        return String.valueOf(valorFiscal);
    }

    public void setValorFiscal(double valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    @XmlElement
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @XmlElement
    public ArrayList getImagenes() {
        return imagenes;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement(name="cliente")
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
