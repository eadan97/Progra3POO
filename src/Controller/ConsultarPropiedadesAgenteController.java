/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AgenteMainForm;
import View.ConsultarPropiedadAgenteForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author isfa9
 */
public class ConsultarPropiedadesAgenteController implements ActionListener{
    public ConsultarPropiedadAgenteForm vista;
    public AgenteMainForm vistaAnterior;
    
    
    ServerQueryHandler serverQueryHandler;
    
    ConsultarPropiedadesAgenteController(ConsultarPropiedadAgenteForm consultarPropiedadAgenteForm, ServerQueryHandler pServerQueryHandler, AgenteMainForm pVistaAnterior) {
        this.vista=consultarPropiedadAgenteForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
    }
    
   
    
    //Consultar Volver
    //modificar Eliminar

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":
                //segun tipo bien lleva a cada controller
                String filtroBusqueda=(String) this.vista.boxFiltros.getSelectedItem();
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
                cerrarConsultaPropiedadAgente(vistaAnterior);//cerrar la vista vuelve a main agente
                break;
                
            case "Modificar":
                //controlador a modificar propiedad
                break;
            
            case "Eliminar":
                //llamada funcion eliminar propiedad
                break;
                
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main agente
     * @param vistaAnterior 
     */
    public void cerrarConsultaPropiedadAgente(AgenteMainForm vistaAnterior) {
        vista.cerrarConsultaPropiedadAgente(vistaAnterior);
    }
}
