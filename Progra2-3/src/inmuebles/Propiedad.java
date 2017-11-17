/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmuebles;

import java.util.ArrayList;
import usuarios.Cliente;

/**
 *
 * @author Eduardo
 */
public class Propiedad {

    /**
     * @param listaDeInteresados the listaDeInteresados to set
     */
    public void setListaDeInteresados(ArrayList <Cliente> listaDeInteresados) {
        this.listaDeInteresados = listaDeInteresados;
    }
    private static int cantPropiedades;
    private int identificadorPropiedad; //Se asigna automatico por el sistema
    protected double areaTerreno;
    protected double valorMetroCuadrado;
    protected double valorFiscal;
    protected String ubicacion;
    //Imagen qr QrCode
    protected String modalidad; //Alquiler o Venta
    protected String estiloConstruccion;
    protected ArrayList <Cliente> listaDeInteresados;
    protected boolean isDisponible;
    
    /**
     * Constructor propiedades
     * @param pAreaTerreno
     * @param pValorMetroCuadrado
     * @param pValorFiscal
     * @param pUbicacion
     * @param pModalidad
     * @param pEstilo 
     */
    public Propiedad(double pAreaTerreno, double pValorMetroCuadrado, double pValorFiscal, String pUbicacion, 
            String pModalidad, String pEstilo)
    {
        identificadorPropiedad = cantPropiedades;
        areaTerreno = pAreaTerreno;
        valorMetroCuadrado = pValorMetroCuadrado;
        valorFiscal = pValorFiscal;
        ubicacion = pUbicacion;
        modalidad = pModalidad;
        estiloConstruccion = pEstilo;
        listaDeInteresados = new ArrayList<>();
        cantPropiedades++;
        isDisponible = true;
        //Crear el codigo qr con la informacion del objeto
    }
    
    /**
     * Agrega un cliente a la lista de clientes interesados
     * @param pCliente 
     */
    public void agregarInteresado(Cliente pCliente){
        listaDeInteresados.add(pCliente);
    }
    
    /**
     * Convierte a string los objetos tipo Propiedad
     * @return 
     */
    public String toString(){
        String msg = "Id: " + identificadorPropiedad + "\n" +
                "Área del terreno: " + areaTerreno + "\n" +
                "Valor del metro cuadrado: " + valorMetroCuadrado + "\n" +
                "Valor fiscal: " + valorFiscal + "\n" +
                "Ubicación: " + ubicacion + "\n" +
                "Modalidad: " + modalidad + "\n" +
                "Estilo de construcción: " + estiloConstruccion;
        return msg;
    }

    /**
     * @return the areaTerreno
     */
    public double getAreaTerreno() {
        return areaTerreno;
    }

    /**
     * @return the valorMetroCuadrado
     */
    public double getValorMetroCuadrado() {
        return valorMetroCuadrado;
    }

    /**
     * @return the valorFiscal
     */
    public double getValorFiscal() {
        return valorFiscal;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @return the modalidad
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * @return the estiloConstruccion
     */
    public String getEstiloConstruccion() {
        return estiloConstruccion;
    }

    /**
     * @return the listaDeInteresados
     */
    public ArrayList <Cliente> getListaDeInteresados() {
        return listaDeInteresados;
    }

    /**
     * @return the cantPropiedades
     */
    public static int getCantPropiedades() {
        return cantPropiedades;
    }

    /**
     * @return the identificadorPropiedad
     */
    public int getIdentificadorPropiedad() {
        return identificadorPropiedad;
    }

    /**
     * @return the isDisponible
     */
    public boolean isDisponible() {
        return isDisponible;
    }

    /**
     * @param isDisponible the isVendida to set
     */
    public void setIsDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
}
