package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Interes")
public class Interes {

    @XmlElement
    private String nombre;
    @XmlElement
    private String numTel;
    @XmlElement
    private String comentario;
    @XmlElement
    private String idBien;
    @XmlElement
    private String idInteres;

    private static int contador=0;

    public Interes(String namae, String tel, String comentary, String idBien){
        nombre=namae;
        numTel=tel;
        comentario=comentary;
        this.idBien =idBien;
        idInteres ="IN"+String.valueOf(contador);
        contador++;
    }

    public String infoInteres(){
        String s="";
        s+=nombre+"\n"+numTel+"\n"+"Comentario:"+comentario+"\n";
        return s;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdBien() {
        return idBien;
    }

    public void setIdBien(String idBien) {
        this.idBien = idBien;
    }

    public String getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(String idInteres) {
        this.idInteres = idInteres;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Interes.contador = contador;
    }

    public String toString(){
        String s="";
        s+=this.getNombre()+"\n";
        s+=this.getNumTel()+"\n";
        s+=this.getIdBien()+"\n";
        return s;
    }
}
