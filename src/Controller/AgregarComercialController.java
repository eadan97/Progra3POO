/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.AgregarBienForm;
import View.AgregarComercialForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author isfa9
 */
public class AgregarComercialController implements ActionListener{
    public AgregarComercialForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    AgregarComercialController(AgregarComercialForm agregarComercialForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=agregarComercialForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnAgregarComercial.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    //Agregar Casa
    //cancelar
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Comercial":
                //agregar casa
                JOptionPane.showMessageDialog(vista, "Agrego un Comercial");
                cerrarAgregarCom(vistaAnterior);
                break;
            case "Cancelar":
                cerrarAgregarCom(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarAgregarCom(AgenteMainForm vistaAnterior) {
        vista.cerrarAgregarCom(vistaAnterior);
    }
}
