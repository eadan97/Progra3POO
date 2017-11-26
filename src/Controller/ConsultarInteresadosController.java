/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.ConsultarClientesInteresadosForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author isfa9
 */
public class ConsultarInteresadosController implements ActionListener{
    public ConsultarClientesInteresadosForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    public ConsultarInteresadosController(ConsultarClientesInteresadosForm consultarInteresadosForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=consultarInteresadosForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
   
    
    //consultar
    //volver
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":
                //obtiene el id propiedad del box, luego agrega a la tabla 
                break;
            case "Volver":
                cerrarConsultaInteresados(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarConsultaInteresados(AgenteMainForm vistaAnterior) {
        vista.cerrarConsultaInteresados(vistaAnterior);
    }
    
}
