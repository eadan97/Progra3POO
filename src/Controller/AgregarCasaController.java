/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.AgregarBienForm;
import View.AgregarCasaForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author isfa9
 */
public class AgregarCasaController implements ActionListener{
    public AgregarCasaForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    AgregarCasaController(AgregarCasaForm agregarCasaForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=agregarCasaForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnAgregarCasa.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
 
    //Agregar Casa
    //cancelar
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Casa":
                //agregar casa
                JOptionPane.showMessageDialog(vista, "Agrego una Casa");
                cerrarAgregarCasa(vistaAnterior);
                break;
            case "Cancelar":
                cerrarAgregarCasa(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarAgregarCasa(AgenteMainForm vistaAnterior) {
        vista.cerrarAgregarCasa(vistaAnterior);
    }
    
}
