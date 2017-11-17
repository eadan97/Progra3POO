/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmuebles;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Casa extends Propiedad{
    
    private int cantNiveles;
    private String color;
    private int annoConstruccion;
    private ArrayList <Nivel> listaDeNiveles;
    
    public Casa(double pAreaTerreno, double pValorMetroCuadrado, double pValorFiscal, String pUbicacion, 
            String pModalidad, String pEstilo, int pCantNiveles, String pColor, int pAnnoConstruccion, 
            ArrayList <Nivel> pListaDeNiveles) 
    {
        super(pAreaTerreno, pValorMetroCuadrado, pValorFiscal, pUbicacion, pModalidad, pEstilo);
        cantNiveles = pCantNiveles;
        color = pColor;
       annoConstruccion = pAnnoConstruccion;
       listaDeNiveles = pListaDeNiveles;
    }
    
    /**
     * Metodo para agregar niveles a un EdificioApartamento
     * @param pTipo
     * @param pCantResidencias
     * @param pCantZonasComunes 
     */
    public void agregarNivel(String pTipo, int pCantResidencias, int pCantZonasComunes){
        listaDeNiveles.add(new Nivel(pTipo, pCantResidencias, pCantZonasComunes));
        cantNiveles++;
    }
    
    /**
     * Convierte el objeto tipo Casa en string (deja un \n al final)
     * @return 
     */
    public String toString(){
        String msg = super.toString() + "\n";
        msg += "Color: " + color + "\n" +
               "Anno de construcción: " + annoConstruccion + "\n" +
               "Cantidad de niveles: " + cantNiveles + "\n" +
               "Niveles: " + "\n";
        for(Nivel nivel : listaDeNiveles)
            msg += nivel.toString() + "\n";
        return msg;
    }

    /**
     * @return the cantNiveles
     */
    public int getCantNiveles() {
        return cantNiveles;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the annoConstruccion
     */
    public int getAnnoConstruccion() {
        return annoConstruccion;
    }

    /**
     * @return the listaDeNiveles
     */
    public ArrayList <Nivel> getListaDeNiveles() {
        return listaDeNiveles;
    }
}
