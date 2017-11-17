/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.util.Random;

/**
 *
 * @author Eduardo
 */
public abstract class Usuario {
    private static int cantUsuarios;
    protected String idUsuario;
    protected String primerNombre;
    protected String telefono;
    protected String correo;
    protected String password;
    private final Random caracter = new Random();
    private final Random numero = new Random();
    
    /**
     * Constructor de la clase Usuario
     * @param pPrimerNombre
     * @param pTelefono
     * @param pCorreo 
     */
    public Usuario(String pPrimerNombre, String pTelefono, String pCorreo){
        idUsuario = "" + cantUsuarios;
        cantUsuarios++;
        primerNombre = pPrimerNombre;
        telefono = pTelefono;
        correo = pCorreo;
        setPassword();
    }
    
    public String toString(){
        String msg = "Identificacion: " + idUsuario + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Correo: " +correo;
        return msg;
    }

    /**
     * Crear la contraseña creando randoms y transformandolos a char
     */
    private void setPassword() {
        for(int i = 0; i < 3; i++)
           password += (char) (caracter.nextInt(25) + 65);
        for(int i = 0; i < 3; i++)
           password += (char) (numero.nextInt(9) + 48);
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @return the primerNombre
     */
    public abstract String getNombre();

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
