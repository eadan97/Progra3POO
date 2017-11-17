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
public class AgenteDAO {
    
    private ArrayList <Propiedad> tempListaDeInmuebles;
    private int tempCantInmuebles;
    
    /**
     * Agrega una CentroComercial al arraylist de propiedades e incrementa la cantidad actual de inmuebles
     * @param agente
     * @param nuevo 
     */
    public void registrarCentroComercial(Agente agente, CentroComercial nuevo){
        tempListaDeInmuebles = agente.getListaDeInmuebles();
        tempCantInmuebles = agente.getCantInmuebles();
        tempListaDeInmuebles.add(nuevo);
        tempCantInmuebles++;
        agente.setListaDeInmuebles(tempListaDeInmuebles);
        agente.setCantInmuebles(tempCantInmuebles);
    }
    
    /**
     * Agrega un EdificioApartamento al arraylist de inmuebles e incrementa el actual
     * @param agente
     * @param nuevo 
     */
    public void registrarEdificioApartamento(Agente agente, EdificioApartamento nuevo){
        tempListaDeInmuebles = agente.getListaDeInmuebles();
        tempCantInmuebles = agente.getCantInmuebles();
        tempListaDeInmuebles.add(nuevo);
        tempCantInmuebles++;
        agente.setCantInmuebles(tempCantInmuebles);
        agente.setListaDeInmuebles(tempListaDeInmuebles);
    }
    
    /**
     * Agrega a la lista de inmuebles una Casa e incrementa el contador de inmuebles
     * @param agente
     * @param nuevo 
     */
    public void registrarCasa(Agente agente, Casa nuevo){
        tempListaDeInmuebles = agente.getListaDeInmuebles();
        tempCantInmuebles = agente.getCantInmuebles();
        tempListaDeInmuebles.add(nuevo);
        tempCantInmuebles++;
        agente.setListaDeInmuebles(tempListaDeInmuebles);
        agente.setCantInmuebles(tempCantInmuebles);
    }
    
    /**
     * Modifica si esta disponible para ser vista por los clientes
     * @param agente
     * @param idPropiedad
     * @param cambio 
     */
    public void modificarPropiedad(Agente agente, int idPropiedad, boolean cambio){
        tempListaDeInmuebles = agente.getListaDeInmuebles();
        Propiedad propiedad = agente.buscarPropiedad(idPropiedad);
        if(propiedad != null)
            propiedad.setIsDisponible(cambio);
    }
    
    /**
     * Consulta todos las propiedades que existen en el catalogo del agente
     * @param agente
     * @return 
     */
    public ArrayList<Propiedad> consultarMisPropiedades(Agente agente){
        return agente.getListaDeInmuebles();
    }
    
    /**
     * Elimina la propiedad deseada del catalogo (listaDeInmuebles)
     * @param agente
     * @param idPropiedad
     * @return 
     */
    public Propiedad eliminarPropiedad(Agente agente, int idPropiedad){
        tempListaDeInmuebles = agente.getListaDeInmuebles();
        tempCantInmuebles = agente.getCantInmuebles();
        Propiedad propiedad = agente.buscarPropiedad(idPropiedad);
        if(propiedad != null){
            tempListaDeInmuebles.remove(propiedad);
            tempCantInmuebles--;
        }
        agente.setListaDeInmuebles(tempListaDeInmuebles);
        agente.setCantInmuebles(tempCantInmuebles);
        return propiedad;
    }
    
    /**
     * Busca la propiedad y retorna la lista de clientes interesados
     * @param agente
     * @param idPropiedad
     * @return 
     */
    public ArrayList<Cliente> consultarClientesInteresados(Agente agente, int idPropiedad){
        return agente.buscarPropiedad(idPropiedad).getListaDeInteresados();
    }
}
