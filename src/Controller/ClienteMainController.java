/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.ClienteMainForm;
import View.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author isfa9
 */
public class ClienteMainController implements ActionListener{
    public ClienteMainForm vista;
    public IniciarSesionForm vistaAnterior;
    
    ServerQueryHandler serverQueryHandler;
    
    ClienteMainController(ClienteMainForm clienteMainForm, ServerQueryHandler pServerQueryHandler, IniciarSesionForm pVistaAnterior) {
        this.vista=clienteMainForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultarPropiedades.addActionListener(this);
        this.vista.btnCerrarSesion.addActionListener(this);
    }
    
    //consultar propiedades
    //cerrar sesion
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar Propiedades":
                vista.setVisible(false);
                ConsultasClientesController consultarPropiedadesController=new ConsultasClientesController(new ConsultasClientesForm(),serverQueryHandler,vista);
                consultarPropiedadesController.vista.setVisible(true);
                consultarPropiedadesController.vista.setLocationRelativeTo(null);
                break;            
            case "Cerrar Sesion":
                cerrarSesion(vistaAnterior);
                
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }

    private void cerrarSesion(IniciarSesionForm vistaAnterior) {
        vista.cerrarSesion(vistaAnterior); 
    }

}
