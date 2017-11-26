package Model;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "cliente")
@XmlType(propOrder = {"idUsuario", "nombre", "correo", "contrasenia", "numeroTel"})
public class Cliente extends Usuario implements Serializable {

    private String nombre;
    private String numeroTel;

    public Cliente(String nombre, String numeroTel, String correo) {
        this.nombre =nombre;
        this.numeroTel =numeroTel;
        this.setCorreo(correo);
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
    public void mostrarInteres(ArrayList<Interesado> intereses,String bien,String comentario) {
        intereses.add(new Interesado(this.nombre,this.numeroTel,comentario,bien));
    }*/

    public void generarIDusuario(int numero){
        this.setIdUsuario("cliente"+numero);
    }

    public String toString(){
        String s="";
        s+="Nombre: "+ nombre +"\n";
        s+="Numero Telefonico: "+numeroTel +"\n";
        return s;
    }
}

