/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author Eduardo
 */
public class Administrador extends Usuario{
    private final static Administrador administrador = new Administrador("Administrador", "57061626", "emjironal@gmail.com");

    private Administrador(String pPrimerNombre, String pTelefono, String pCorreo) {
        super(pPrimerNombre, pTelefono, pCorreo);
    } 

    /**
     * Retorna el nombre del administrador
     * @return 
     */
    public String getNombre() {
        return primerNombre;
    }
    
    /**
     * Retorna la instancia de la clase Administrador
     * @return 
     */
    public Administrador getInstance(){
        return administrador;
    }
    
    /**
     * Convierte a string la informacion del administrador
     * @return 
     */
    public String toString(){
        return super.toString();
    }
}
