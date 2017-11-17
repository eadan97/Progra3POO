/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import inmuebles.*;
import java.util.ArrayList;
/**
 *
 * @author Eduardo Jirón <emjironal@gmail.com>
 */
public class Agente extends Usuario{
    private String primerApellido;
    private ArrayList <Propiedad> listaDeInmuebles;
    private int cantInmuebles;

    /**
     * Constructor de la clase Agente
     * @param pPrimerNombre
     * @param pPrimerApellido
     * @param pTelefono
     * @param pCorreo 
     */
    public Agente(String pPrimerNombre, String pPrimerApellido, String pTelefono, String pCorreo) {
        super(pPrimerNombre, pTelefono, pCorreo);
        primerApellido = pPrimerApellido;
        listaDeInmuebles = new ArrayList<>();
        cantInmuebles = 0;
    }
    
    /**
     * Busca una propiedad en especifico en el catalogo (listaDeInmuebles)
     * @param idPropiedad
     * @return 
     */
    public Propiedad buscarPropiedad(int idPropiedad){
        for(Propiedad p : listaDeInmuebles)
            if(p.getIdentificadorPropiedad() == idPropiedad)
                return p;
        return null;
    }
    
    /**
     * @return the cantInmuebles
     */
    public int getCantInmuebles() {
        return cantInmuebles;
    }

    /**
     * @return the listaDeInmuebles
     */
    public ArrayList <Propiedad> getListaDeInmuebles() {
        return listaDeInmuebles;
    }

    /**
     * Retorna el nombre del objeto tipo Agente
     * @return 
     */
    public String getNombre() {
        return primerNombre + " " + getPrimerApellido();
    }
    
    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param cantInmuebles the cantInmuebles to set
     */
    public void setCantInmuebles(int cantInmuebles) {
        this.cantInmuebles = cantInmuebles;
    }
    
    /**
     * @param listaDeInmuebles the listaDeInmuebles to set
     */
    public void setListaDeInmuebles(ArrayList <Propiedad> listaDeInmuebles) {
        this.listaDeInmuebles = listaDeInmuebles;
    }

    /**
     * Convierte en string los datos de la clase Agente
     * @return 
     */
    public String toString(){
        return super.toString();
    }

}
