package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Random;

@XmlTransient
public class Usuario {

    private String idUsuario;
    private String contrasenia;
    private String correo;

    public Usuario() {
    }

    public Usuario(String idUsuario, String contrasenia, String correo) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    @XmlElement (name = "idUsuario")
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlElement (name = "contrasenia")
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlElement(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void generarClave() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        this.contrasenia =saltStr;
    }

}

