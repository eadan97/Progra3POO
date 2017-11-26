/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ServerQueryHandler;
import View.AdminMainForm;
import View.ConsultarClientesForm;
import Model.Cliente;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author isfa9
 */
public class ConsultarClienteController  implements ActionListener{
    public ConsultarClientesForm vista;
    public AdminMainForm vistaAnterior;
    DefaultTableModel model;
    
    ServerQueryHandler serverQueryHandler;
    
    ConsultarClienteController(ConsultarClientesForm consultarClientesForm, ServerQueryHandler pServerQueryHandler, AdminMainForm pVistaAnterior) {
        this.vista=consultarClientesForm;
        this.serverQueryHandler=pServerQueryHandler;
        this.vistaAnterior=pVistaAnterior;
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnDescargar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
        model = (DefaultTableModel) vista.jTable1.getModel();
        vista.jTable1.setModel(model);
    }
           
    //Consultar
    //Limpiar
    //Descargar
    //volver

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Consultar":

                ArrayList<Cliente> clientes= serverQueryHandler.consultarClientes();
                for (Cliente s : clientes) {
                    Object[] o = new Object[6];
                    o[0] = s.getIdUsuario();
                    o[1] = s.getNombre();
                    o[3] = s.getNumeroTel();
                    o[4] = s.getCorreo();
                    model.addRow(o);
                }
                break;
            case "Limpiar Tabla":
                model.setRowCount(0);
                break;
            case "Descargar Datos": 
                //descargar csv
                break;
            case "Volver":
                cerrarConsultarCliente(vistaAnterior);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    //funciones
    /**
     * volver a main admin
     * @param vistaAnterior 
     */
    public void cerrarConsultarCliente(AdminMainForm vistaAnterior) {
        vista.cerrarConsultarCliente(vistaAnterior);
    }
}
