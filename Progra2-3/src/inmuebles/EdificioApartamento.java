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
public class EdificioApartamento extends Propiedad{
    
    public boolean poseePiscina;
    public boolean poseeRancho;
    private int espaciosParqueoVisitas;
    private int cantNiveles;
    private ArrayList <Nivel> listaDeNiveles;
    
    /**
     * Constructor de la clase EdificioApartamento (hereda de Propiedad)
     * @param pAreaTerreno
     * @param pValorMetroCuadrado
     * @param pValorFiscal
     * @param pUbicacion
     * @param pModalidad
     * @param pEstilo
     * @param pPoseePiscina
     * @param pPoseeRancho
     * @param pEspaciosParqueoVisitas
     * @param pCantNiveles
     * @param pListaDeNiveles 
     */
    public EdificioApartamento(double pAreaTerreno, double pValorMetroCuadrado, double pValorFiscal, String pUbicacion,
            String pModalidad, String pEstilo, boolean pPoseePiscina, boolean pPoseeRancho, int pEspaciosParqueoVisitas,
            int pCantNiveles, ArrayList <Nivel> pListaDeNiveles) 
    {
        super(pAreaTerreno, pValorMetroCuadrado, pValorFiscal, pUbicacion, pModalidad, pEstilo);
        poseePiscina = pPoseePiscina;
        poseeRancho = pPoseeRancho;
        espaciosParqueoVisitas = pEspaciosParqueoVisitas;
        cantNiveles = pCantNiveles;
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
     * Convierte los objetos EdificioApartamento en string (deja un \n al final)
     * @return 
     */
    public String toString(){
        String msg = super.toString() + "\n";
        if(poseePiscina)
            msg += "Posee piscina" + "\n";
        else
            msg += "No posee piscina" + "\n";
        if(poseeRancho)
            msg += "Posee rancho" + "\n";
        else
            msg += "No posee piscina" + "\n";
        msg += "Espacios de parqueo de visitas: " + espaciosParqueoVisitas + "\n" +
               "Cantidad de niveles" + cantNiveles + "\n" +
               "Niveles: " + "\n";
        for(Nivel nivel : listaDeNiveles)
            msg += nivel.toString() + "\n";
        return msg;
    }

    /**
     * @return the espaciosParqueoVisitas
     */
    public int getEspaciosParqueoVisitas() {
        return espaciosParqueoVisitas;
    }

    /**
     * @return the cantNiveles
     */
    public int getCantNiveles() {
        return cantNiveles;
    }

    /**
     * @return the listaDeNiveles
     */
    public ArrayList <Nivel> getListaDeNiveles() {
        return listaDeNiveles;
    }
}
