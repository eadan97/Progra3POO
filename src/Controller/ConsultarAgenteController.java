/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import Model.Agente;
import View.AdminMainForm;
import View.ConsultarAgentesForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author isfa9
 */
public class ConsultarAgenteController implements ActionListener{
    public ConsultarAgentesForm vista;
    public AdminMainForm vistaAnterior;
    DefaultTableModel model;

    ServerQueryHandler serverQueryHandler;
    
    ConsultarAgenteController(ConsultarAgentesForm consultarAgentesForm, ServerQueryHandler pServerQueryHandler, AdminMainForm pVistaAnterior) {
         this.vista=consultarAgentesForm;
        this.serverQueryHandler=pServerQueryHandler;//To change body of generated methods, choose Tools | Templates.
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);

        model = (DefaultTableModel) vista.jTable1.getModel();
        vista.jTable1.setModel(model);

    }
           
    //Consultar Datos
    //Limpiar Tabla
    //Volver

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":

                ArrayList<Agente> agentes= serverQueryHandler.consultarAgentes();
                for (Agente s : agentes) {
                    Object[] o = new Object[6];
                    o[0] = s.getIdUsuario();
                    o[1] = s.getNombre();
                    o[2] = s.getApellido();
                    o[3] = s.getNumeroTel();
                    o[4] = s.getCorreo();
                    o[5] = s.bienes.size();
                    model.addRow(o);
                }
                break;
            case "Limpiar Tabla":
                model.setRowCount(0);
                break;
            case "Volver":
                cerrarConsultaAgente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarConsultaAgente(AdminMainForm vistaAnterior) {
        vista.cerrarConsultaAgente(vistaAnterior);
    }
    
    
    
    
}
