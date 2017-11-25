package Model;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cliente")
@XmlType(propOrder = {"idUsuario", "nombre", "correo", "contrasenia", "numeroTel"})
public class Cliente extends Usuario {

    public static int contador=0;
    private String nombre;
    private String numeroTel;

    public Cliente(String nombre, String numeroTel, String correo) {
        this.nombre =nombre;
        this.numeroTel =numeroTel;
        this.setCorreo(correo);
        generarIDusuario();
        this.generarClave();
    }
    public Cliente(){
        nombre="";
        numeroTel="";
        this.setCorreo("");
        this.setIdUsuario("");
        this.setContrasenia("");
    }

    @XmlElement (name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    @XmlTransient
    public int getContador() {
        return contador;
    }

    public void setContador(int pContador) {
        contador = pContador;
    }

    @XmlElement (name="telefono")
    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String pNumeroTel) {
        numeroTel = pNumeroTel;
    }

    /*public void consultaBienes() {
        //esperar a armar todo mejor

    }

    public void descargarFichaBien() {
        //falta esto
    }
    public void mostrarInteres(ArrayList<Interes> intereses,String bien,String comentario) {
        intereses.add(new Interes(this.nombre,this.numeroTel,comentario,bien));
    }*/

    public void generarIDusuario(){
        this.setIdUsuario("cliente"+getContador());
        setContador(getContador()+1);
    }

    public String toString(){
        String s="";
        s+="Nombre: "+ nombre +"\n";
        s+="Numero Telefonico: "+numeroTel +"\n";
        return s;
    }
}

