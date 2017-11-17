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
 * @author Eduardo Jirón <emjironal@gmail.com>
 */
public class ClienteDAO {
    private ArrayList <Propiedad> tempListaDeInteres;
    
    /**
     * Agrega a la lista de interes de un cliente una propiedad y agrega a la lista de interesados de la propiedad el cliente
     * @param cliente
     * @param propiedad 
     */
    public void mostrarInteresPropiedad(Cliente cliente, Propiedad propiedad){
        //Relacionado con el Cliente
        tempListaDeInteres = cliente.getListaDeIntereses(); //Agarra la lista de intereses del cliente
        int tempCantInteres = cliente.getCantPropiedadesInteres(); //agarra la cantidad de intereses del cliente
        tempListaDeInteres.add(propiedad); //agrega la propiedad a la lista de instereses del cliente
        tempCantInteres++; //incrementa la cantidad de intereses del cliente en una variable temporal
        cliente.setCantPropiedadesInteres(tempCantInteres); //establece la nueva cantidad de intereses del cliente
        cliente.setListaDeIntereses(tempListaDeInteres); //establece la nueva lista de intereses del cliente
        //Relacionado con la Propiedad
        ArrayList <Cliente> tempListaDeInteresados = propiedad.getListaDeInteresados(); //agarra la lista de interesados de la propiedad
        tempListaDeInteresados.add(cliente); //agrega el cliente a la lista de interesados de la propiedad
        propiedad.setListaDeInteresados(tempListaDeInteresados); //establece la nueva lista de interesados a la propiedad
    }
}
