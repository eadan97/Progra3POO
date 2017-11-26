/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.AgregarBienForm;
import View.AgregarEdificioForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author isfa9
 */
public class AgregarEdificioController implements ActionListener{

    
    public AgregarEdificioForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    AgregarEdificioController(AgregarEdificioForm agregarEdificioForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=agregarEdificioForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnAgregarEdificio.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    //Agregar Casa
    //cancelar
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Agregar Edificio":
                //agregar casa
                JOptionPane.showMessageDialog(vista, "Agrego un edificio");
                cerrarAgregarEdi(vistaAnterior);
                break;
            case "Agregar Nivel":
                
                break;
            case "Eliminar Nivel":
                break;
            case "Cancelar":
                cerrarAgregarEdi(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarAgregarEdi(AgenteMainForm vistaAnterior) {
        vista.cerrarAgregarEdi(vistaAnterior);
    }
}
