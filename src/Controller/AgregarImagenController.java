/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgregarBienForm;
import View.AgregarImagenForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author isfa9
 */
public class AgregarImagenController implements ActionListener{

    public AgregarImagenForm vista;
    public AgregarBienForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    

    AgregarImagenController(AgregarImagenForm agregarImagenForm, ServerQueryHandler pServerQueryHandler, AgregarBienForm pVistaAnterior) {
        this.vista=agregarImagenForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        //this.vista.btnRegistrar.addActionListener(this);
        //this.vista.addActionListener(this); //To change body of generated methods, choose Tools | Templates.
    }
    //Agregar Agente
    //CAncelar

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Aceptar":
                
                break;
            case "Cancelar":
                //cerrarAgregarAgente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    
}
