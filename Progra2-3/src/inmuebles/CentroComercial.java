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
public class CentroComercial extends Propiedad{
    
    private int cantidadTiendas;
    private int cantidadSalasDeCine;
    private String nombreCadenaCine;
    private int cantidadHostpotWifi;
    private int cantidadEscalerasElectricas;
    private int cantEspaciosPersonasDiscapacitadas;
    
    /**
     * Constructor de la clase CentroComercial (hereda de Propiedad)
     * @param pAreaTerreno
     * @param pValorMetroCuadrado
     * @param pValorFiscal
     * @param pUbicacion
     * @param pModalidad
     * @param pEstilo
     * @param pCantidadTiendas
     * @param pCantidadSalasDeCine
     * @param pNombreCadenaCine
     * @param pCantidadHostpotWifi
     * @param pCantidadEscalerasElectricas
     * @param pCantEspaciosPersonasDiscapacitadas 
     */
    public CentroComercial(double pAreaTerreno, double pValorMetroCuadrado, double pValorFiscal, String pUbicacion, 
            String pModalidad, String pEstilo, int pCantidadTiendas, int pCantidadSalasDeCine, String pNombreCadenaCine,
            int pCantidadHostpotWifi, int pCantidadEscalerasElectricas, int pCantEspaciosPersonasDiscapacitadas) 
    {
        super(pAreaTerreno, pValorMetroCuadrado, pValorFiscal, pUbicacion, pModalidad, pEstilo);
        cantidadTiendas = pCantidadTiendas;
        cantidadSalasDeCine = pCantidadSalasDeCine;
        nombreCadenaCine = pNombreCadenaCine;
        cantidadHostpotWifi = pCantidadHostpotWifi;
        cantidadEscalerasElectricas = pCantidadEscalerasElectricas;
        cantEspaciosPersonasDiscapacitadas = pCantEspaciosPersonasDiscapacitadas;
    }
    
    /**
     * Metodo que convierte los valores del objeto CentroComercial en String
     * @return 
     */
    public String toString(){
        String msg = super.toString() + "\n";
        msg += "Cantidad de tiendas: " + cantidadTiendas + "\n" +
               "Cantidad de salas de cine: " + cantidadSalasDeCine + "\n" +
               "Nombre de la cadena de cine: " + nombreCadenaCine + "\n" +
               "Cantidad de hostpot Wifi: " + cantidadHostpotWifi + "\n" +
               "Cantidad de escaleras electricas: " + cantidadEscalerasElectricas +  "\n" +
               "Cantidad de espacios de parqueo para personas discapacitadas" + cantEspaciosPersonasDiscapacitadas;
        return msg;
    }

    /**
     * @return the cantidadTiendas
     */
    public int getCantidadTiendas() {
        return cantidadTiendas;
    }

    /**
     * @return the cantidadSalasDeCine
     */
    public int getCantidadSalasDeCine() {
        return cantidadSalasDeCine;
    }

    /**
     * @return the nombreCadenaCine
     */
    public String getNombreCadenaCine() {
        return nombreCadenaCine;
    }

    /**
     * @return the cantidadHostpotWifi
     */
    public int getCantidadHostpotWifi() {
        return cantidadHostpotWifi;
    }

    /**
     * @return the cantidadEscalerasElectricas
     */
    public int getCantidadEscalerasElectricas() {
        return cantidadEscalerasElectricas;
    }

    /**
     * @return the cantEspaciosPersonasDiscapacitadas
     */
    public int getCantEspaciosPersonasDiscapacitadas() {
        return cantEspaciosPersonasDiscapacitadas;
    }
    
}
