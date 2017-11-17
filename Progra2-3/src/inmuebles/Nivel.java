/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmuebles;

/**
 *
 * @author Eduardo
 */
public class Nivel {

    private String tipoNivel;
    private int cantResidencias;
    private int cantZonasComunes;
    
    /**
     * Constructor de Nivel
     * @param pTipo
     * @param pCantResidencias
     * @param pCantZonasComunes 
     */
    public Nivel(String pTipo, int pCantResidencias, int pCantZonasComunes) {
        tipoNivel = pTipo;
        cantResidencias = pCantResidencias;
        cantZonasComunes = pCantZonasComunes;
    }
    
    /**
     * Convierte el objeto Nivel en string
     * @return 
     */
    public String toString(){
        String msg = "\t" + "Tipo :" + getTipoNivel() + "\n" +
                "\t" + "Cantidad de residencias: " + getCantResidencias() + "\n" +
                "\t" + "Cantidad de zonas comunes: " + getCantZonasComunes();
        return msg;
    }

    /**
     * @return the tipoNivel
     */
    public String getTipoNivel() {
        return tipoNivel;
    }

    /**
     * @return the cantResidencias
     */
    public int getCantResidencias() {
        return cantResidencias;
    }

    /**
     * @return the cantZonasComunes
     */
    public int getCantZonasComunes() {
        return cantZonasComunes;
    }
}
