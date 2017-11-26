/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import Model.Agente;
import View.AdminMainForm;
import View.AgregarAgenteForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author isfa9
 */
public class AgregarAgenteController implements ActionListener{
    public AgregarAgenteForm vista;
    public AdminMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    

    AgregarAgenteController(AgregarAgenteForm agregarAgenteForm, ServerQueryHandler pServerQueryHandler, AdminMainForm pVistaAnterior) {
        this.vista=agregarAgenteForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this); //To change body of generated methods, choose Tools | Templates.
    }
    //Agregar Agente
    //CAncelar

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Agente":
                //TODO: hacer validacion
                String tel=vista.txtTelefono.getText();
                String nombre=vista.txtNombreAgente.getText();
                String apellido=vista.txtApellidoAgente.getText();
                String correo=vista.txtEmail.getText();
                Agente agente= new Agente(tel, nombre, apellido, correo);
                agente.setIdUsuario(vista.txtID.getText());
                String res = serverQueryHandler.agregarAgente(agente);
                if (res!=null)
                    cerrarAgregarAgente(vistaAnterior);
                break;
            case "Cancelar":
                cerrarAgregarAgente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarAgregarAgente(AdminMainForm vistaAnterior) {
        vista.cerrarAgregarAgente(vistaAnterior);
    }
    
}
