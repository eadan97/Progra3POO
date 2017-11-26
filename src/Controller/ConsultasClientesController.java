/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.ClienteMainForm;
import View.ConsultasClientesForm;
import View.MostrarInteresForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author isfa9
 */
public class ConsultasClientesController implements ActionListener{

    public ConsultasClientesForm vista;
    public ClienteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    ConsultasClientesController(ConsultasClientesForm consultasClientesForm, ServerQueryHandler pServerQueryHandler, ClienteMainForm pVistaAnterior) {
        this.vista=consultasClientesForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnSolicitarFicha.addActionListener(this);
        this.vista.btnMostrarInteres.addActionListener(this);
    }
    
    
    
   
    
    //Consultar 
    //Volver
    //Solicitar Ficha
    //Mostrar Interes

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":
                //segun tipo bien lleva a cada controller
                String filtroBusqueda=(String) this.vista.boxFiltro.getSelectedItem();
                switch(filtroBusqueda){
                    case "Tipo":
                        //muestra las propiedades con el tipo buscado
                        break;
                    case "Modalidad":
                        //muestra las propiedades con modalidad buscado
                        break;
                    case "Precio":
                        //muestra las propiedades con precio buscado
                        break;
                    case "Provincia":
                        //muestra las propiedades con provincia buscado
                        break;
                    default:
                        System.out.println(e.getActionCommand()+" no esta soportado");
                }
                break;
            case "Volver":
                cerrarConsultasClientes(vistaAnterior);//cerrar la vista vuelve a main agente
                break;
                
            case "Solicitar Ficha":
                //llama a funcion solicitar Ficha
                break;
            
            case "Mostrar Interes":
                //llamada funcion mostrar interes
                vista.setVisible(false);
                MostrarInteresController mostrarInteresController=new MostrarInteresController(new MostrarInteresForm(),serverQueryHandler,vista);
                mostrarInteresController.vista.setVisible(true);
                mostrarInteresController.vista.setLocationRelativeTo(null);
                break;
                
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main cliente
     * @param vistaAnterior 
     */
    private void cerrarConsultasClientes(ClienteMainForm vistaAnterior) {
        vista.cerrarConsultasClientes(vistaAnterior);
    }
    
}




