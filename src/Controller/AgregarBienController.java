/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.AgregarBienForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author isfa9
 */
public class AgregarBienController implements ActionListener{
    public AgregarBienForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    AgregarBienController(AgregarBienForm agregarBienForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=agregarBienForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnSiguiente.addActionListener(this);
        this.vista.btnAgregarImagen.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }
    
    //siguiente
    //cancelar
    //agregar imagen
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Siguiente":
                //segun tipo bien lleva a cada controller
                String tipoBien=(String) this.vista.boxTipoPropiedad.getSelectedItem();
                switch(tipoBien){
                    case "Casa":
                        //con casa
                        break;
                    case "Edificio de Apartamentos":
                        //con edifi
                        break;
                    case "Centro Comercial":
                        //con comer
                        break;
                    case "Lote":
                        //agregarBien/
                        break;
                }
                break;
            case "Agregar Imagen":
                //controller agregar imagen
                break;
            case "Cancelar":
                cerrarAgregarBien(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarAgregarBien(AgenteMainForm vistaAnterior) {
        vista.cerrarAgregarBien(vistaAnterior);
    }
    
    
}
