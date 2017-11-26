package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "agente")
@XmlType(propOrder = {"idUsuario", "nombre", "correo", "contrasenia", "numeroTel", "bienes"})
public class Agente extends Usuario implements Serializable {

    public static int contador=0;
    private String numeroTel;
    private String nombre;
    private String apellido;
    public ArrayList<Bien> bienes;



    public Agente(String tel, String pNombre,String apellido, String correo) {
        this.apellido=apellido;
        this.numeroTel=tel;
        nombre=pNombre;
        bienes=new ArrayList<>();
        this.generarClave();
    }

    public Agente(){
        this.apellido="";
        this.numeroTel="";
        nombre="";
        bienes=new ArrayList<>();
        this.setContrasenia("");
        this.setIdUsuario("");
    }

    @XmlTransient
    public static int getContador() {
        return contador;
    }

    public static void setContador(int pContador) {
        contador = pContador;
    }

    @XmlElement(name = "bienes")
    public ArrayList<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(ArrayList<Bien> pBienes) {
        bienes = pBienes;
    }

    @XmlElement(name = "numeroTel")
    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void generarIDusuario(int numero) {
        this.setIdUsuario("agente"+numero);
    }

    public void anadirBien(Bien bien) {
        bienes.add(bien);
    }

    /*public Bien seleccionarBien(String bien) {
        int posicion=0;
        boolean encontrado=false;
        for(int i=0;encontrado;i++){
            if(bienes.get(i).getNumeroFinca().equals(bien)){
                encontrado=true;
                posicion=i;
            }
        }
        if(encontrado){
            Bien selected=bienes.get(posicion);
            return selected;
        }else{
            System.out.println("Bien: "+bien+"no encontrado \n");
            return null;
        }
    }*/

    /*public void consultarBienes() {
        for(int i=0;i>bienes.size();i++){
            System.out.print(bienes.get(i).print());
        }
    }*/

    /*public void eliminarBien(String idBien) {
        Bien bien=seleccionarBien(idBien);
        bienes.remove(bien);
    }


    public String consultarInteresados(String idBien) {
        Bien bien=seleccionarBien(idBien);
        ArrayList<Interesado> interesados;
        interesados=bien.getInteresados();
        String s="";
        for(int i=0;i>interesados.size();i++){
            s+=interesados.get(i).infoInteres();
        }
        return s;
    }*/

    public String toString(){
        String s="";
        s+="Nombre del Agente: "+this.nombre+" "+this.apellido+"\n";
        s+="Numero telefonico: "+this.getNumeroTel()+"\n";
        s+="Correo electronico: "+this.getCorreo();
        return s;
    }

    public Bien getBien(int dato2) {
        for (Bien b:bienes) {
            if (b.getNumeroFinca()==dato2)
                    return b;
        }
        return null;
    }
}
