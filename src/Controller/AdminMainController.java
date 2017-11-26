/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Cliente.ServerQueryHandler;
import View.*;
import View.AdminMainForm;
import View.AgregarAgenteForm;
import View.ConsultarAgentesForm;
import View.ConsultarClientesForm;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author isfa9
 */
public class AdminMainController implements ActionListener{
    public AdminMainForm vista;
    public IniciarSesionForm vistaAnterior;
    
    ServerQueryHandler serverQueryHandler;

    public AdminMainController(AdminMainForm adminMainForm, ServerQueryHandler pServerQueryHandler, IniciarSesionForm pVistaAnterior) {
        this.vista=adminMainForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnAgregarAgente.addActionListener(this);
        this.vista.btnConsultarAgentes.addActionListener(this);
        this.vista.btnConsultarCleintes.addActionListener(this);
        this.vista.btnCerrarSesion.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Agente":
                vista.setVisible(false);
                AgregarAgenteController agregarAgenteController=new AgregarAgenteController(new AgregarAgenteForm(), serverQueryHandler,vista);
                agregarAgenteController.vista.setVisible(true);
                agregarAgenteController.vista.setLocationRelativeTo(null);
                break;
            case "Consultar Agentes":
                vista.setVisible(false);
                ConsultarAgenteController consultarAgentesController=new ConsultarAgenteController(new ConsultarAgentesForm(),serverQueryHandler,vista);
                consultarAgentesController.vista.setVisible(true);
                consultarAgentesController.vista.setLocationRelativeTo(null);
                break;
            case "Consultar Clientes":
                vista.setVisible(false);
                ConsultarClienteController consultarClienteController=new ConsultarClienteController(new ConsultarClientesForm(),serverQueryHandler,vista);
                consultarClienteController.vista.setVisible(true);
                consultarClienteController.vista.setLocationRelativeTo(null);
                break;              
            case "Cerrar Cesion":
                //cerrarSesion
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
}
