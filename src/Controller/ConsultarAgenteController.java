/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AdminMainForm;
import View.ConsultarAgentesForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author isfa9
 */
public class ConsultarAgenteController implements ActionListener{
    public ConsultarAgentesForm vista;
    public AdminMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    ConsultarAgenteController(ConsultarAgentesForm consultarAgentesForm, ServerQueryHandler pServerQueryHandler, AdminMainForm pVistaAnterior) {
         this.vista=consultarAgentesForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
           
    //Consultar Datos
    //Limpiar Tabla
    //Volver

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":
                //mostrar Datos de tabla
                break;
            case "Limpiar Tabla":
                //clear table
                break;
            case "Volver":
                cerrarConsultaAgente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarConsultaAgente(AdminMainForm vistaAnterior) {
        vista.cerrarConsultaAgente(vistaAnterior);
    }
    
    
    
    
}
