/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.IniciarSesionForm;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author isfa9
 */
public class AgenteMainController implements ActionListener{
    public AgenteMainForm vista;
    public IniciarSesionForm vistaAnterior;
    
    ServerQueryHandler serverQueryHandler;

    public AgenteMainController(AgenteMainForm agenteMainForm, ServerQueryHandler pServerQueryHandler, IniciarSesionForm pVistaAnterior) {
        this.vista=agenteMainForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnAgregarPropiedad.addActionListener(this);
        this.vista.btnConsultarPropiedad.addActionListener(this);
        this.vista.btnConsultarInteresados.addActionListener(this);
        this.vista.btnCerrarSesion.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Propiedad":
                vista.setVisible(false);
                AgregarBienController agregarBienController=new AgregarBienController(new AgregarBienForm(), serverQueryHandler,vista);
                agregarBienController.vista.setVisible(true);
                agregarBienController.vista.setLocationRelativeTo(null);
                break;
            case "Consultar Propiedades":
                vista.setVisible(false);
                ConsultarPropiedadesAgenteController consultarPropiedadesAgenteController=new ConsultarPropiedadesAgenteController(new ConsultarPropiedadAgenteForm(),serverQueryHandler,vista);
                consultarPropiedadesAgenteController.vista.setVisible(true);
                consultarPropiedadesAgenteController.vista.setLocationRelativeTo(null);
                break;
            case "Consultar Interesados":
                vista.setVisible(false);
                ConsultarInteresadosController consultarInteresadosController=new ConsultarInteresadosController(new ConsultarClientesInteresadosForm(),serverQueryHandler,vista);
                consultarInteresadosController.vista.setVisible(true);
                consultarInteresadosController.vista.setLocationRelativeTo(null);
                break;              
            case "Cerrar Cesion":
                //cerrarSesion
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}
