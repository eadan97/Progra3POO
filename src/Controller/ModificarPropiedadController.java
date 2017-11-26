/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.ConsultarPropiedadAgenteForm;
import View.ModificarPropiedadForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author isfa9
 */
public class ModificarPropiedadController implements ActionListener{

    
 public ModificarPropiedadForm vista;
    public ConsultarPropiedadAgenteForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    public ModificarPropiedadController(ModificarPropiedadForm modificarPropiedadForm, ServerQueryHandler pServerQueryHandler, ConsultarPropiedadAgenteForm pVistaAnterior) {
        this.vista=modificarPropiedadForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    
    //siguiente
    //cancelar
    //agregar imagen
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Modificar Propiedad":
                JOptionPane.showMessageDialog(vista, "Modifico La propiedad");
                cerrarModificarPro(vistaAnterior); 
            case "Cancelar":
                cerrarModificarPro(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarModificarPro(ConsultarPropiedadAgenteForm vistaAnterior) {
        vista.cerrarModificarPro(vistaAnterior);
    }
}
