/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.MostrarInteresForm;
import View.ConsultasClientesForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author isfa9
 */
public class MostrarInteresController implements ActionListener{
    
    public MostrarInteresForm vista;
    public ConsultasClientesForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    public MostrarInteresController(MostrarInteresForm mostrarInteresForm, ServerQueryHandler pServerQueryHandler, ConsultasClientesForm pVistaAnterior) {
        this.vista=mostrarInteresForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnMostrarInteres.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
 
    //Mostrar Interes
    //cancelar

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Mostrar Interes":
                //funcion mostrar interes
                JOptionPane.showMessageDialog(vista, "Agregado a Lista de Interes");
                cerrarMostrarInteres(vistaAnterior);
                break;
            case "Cancelar":
                cerrarMostrarInteres(vistaAnterior);//cerrar la vista vuelve a main agente
                break; 
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main cliente
     * @param vistaAnterior 
     */
    private void cerrarMostrarInteres(ConsultasClientesForm vistaAnterior) {
        vista.cerrarMostrarInteres(vistaAnterior);
    }
}
