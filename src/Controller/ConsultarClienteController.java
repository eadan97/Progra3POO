/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AdminMainForm;
import View.ConsultarClientesForm;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author isfa9
 */
public class ConsultarClienteController  implements ActionListener{
    public ConsultarClientesForm vista;
    public AdminMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    ConsultarClienteController(ConsultarClientesForm consultarClientesForm, ServerQueryHandler pServerQueryHandler, AdminMainForm pVistaAnterior) {
        this.vista=consultarClientesForm;
        this.serverQueryHandler=pServerQueryHandler;
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnDescargar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
           
    //Consultar
    //Limpiar
    //Descargar
    //volver

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":
                //mostrar Datos de tabla
                break;
            case "Limpiar Tabla":
                //clear table
                break;
            case "Descargar Datos": 
                //descargar csv
                break;
            case "Volver":
                cerrarConsultarCliente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    //funciones
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarConsultarCliente(AdminMainForm vistaAnterior) {
        vista.cerrarConsultarCliente(vistaAnterior);
    }
}
