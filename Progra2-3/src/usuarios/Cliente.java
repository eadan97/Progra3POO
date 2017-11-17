/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.util.ArrayList;
import inmuebles.*;

/**
 *
 * @author Eduardo
 */
public class Cliente extends Usuario{

    private ArrayList <Propiedad> listaDeIntereses;
    private int cantPropiedadesInteres;
    
    /**
     * Constructor de la clase Cliente
     * @param pPrimerNombre
     * @param pTelefono
     * @param pCorreo 
     */
    public Cliente(String pPrimerNombre, String pTelefono, String pCorreo) {
        super(pPrimerNombre, pTelefono, pCorreo);
        listaDeIntereses = new ArrayList<>();
        cantPropiedadesInteres = 0;
    }
    
    /**
     * Retorna la informacion del Cliente en un string
     * @return 
     */
    public String toString(){
        return super.toString();
    }
    
    /**
     * Retorna el nombre del cliente
     * @return 
     */
    public String getNombre() {
        return primerNombre;
    }

    /**
     * @return the listaDeIntereses
     */
    public ArrayList <Propiedad> getListaDeIntereses() {
        return listaDeIntereses;
    }

    /**
     * @param listaDeIntereses the listaDeIntereses to set
     */
    public void setListaDeIntereses(ArrayList <Propiedad> listaDeIntereses) {
        this.listaDeIntereses = listaDeIntereses;
    }

    /**
     * @return the cantPropiedadesInteres
     */
    public int getCantPropiedadesInteres() {
        return cantPropiedadesInteres;
    }

    /**
     * @param cantPropiedadesInteres the cantPropiedadesInteres to set
     */
    public void setCantPropiedadesInteres(int cantPropiedadesInteres) {
        this.cantPropiedadesInteres = cantPropiedadesInteres;
    }
    
}
