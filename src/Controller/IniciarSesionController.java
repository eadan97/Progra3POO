package Controller;

import Cliente.ServerQueryHandler;
import View.IniciarSesionForm;
import View.AdminMainForm;
import View.AgenteMainForm;
import View.ClienteMainForm;
import Controller.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesionController implements ActionListener{
    public IniciarSesionForm vista;
    public AdminMainForm adminVista;
    public AgenteMainForm agenteVista;
    public ClienteMainForm clienteVista;
    
    ServerQueryHandler serverQueryHandler;
   

    public IniciarSesionController(IniciarSesionForm iniciarSesionForm, ServerQueryHandler serverQueryHandler) {
        vista=iniciarSesionForm;
        this.serverQueryHandler=serverQueryHandler;
        vista.btIniciar.addActionListener(this);
        vista.btCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Iniciar Sesion":
                String inicio=serverQueryHandler.iniciarSesion(vista.txtCorreo.getText(),
                        new String(vista.txtPassword.getPassword()));
                System.out.println(inicio);
                //ir a cada vista
                switch(inicio){
                    case "Admin":
                        vista.setVisible(false);
                        AdminMainController adminMainController=new AdminMainController(new AdminMainForm(), serverQueryHandler,vista);
                        adminMainController.vista.setVisible(true);
                        adminMainController.vista.setLocationRelativeTo(null);
                        break;
                    case "Agente":
                        vista.setVisible(false);
                        AgenteMainController agenteMainController=new AgenteMainController(new AgenteMainForm(),serverQueryHandler,vista);
                        agenteMainController.vista.setVisible(true);
                        agenteMainController.vista.setLocationRelativeTo(null);
                        break;
                    case "Cliente":
                        vista.setVisible(false);
                        ClienteMainController clienteMainController=new ClienteMainController(new ClienteMainForm(),serverQueryHandler,vista);
                        clienteMainController.vista.setVisible(true);
                        clienteMainController.vista.setLocationRelativeTo(null);
                        break;
                            
                }
                //todo:si es error, mostrar mensaje
                break;
            case "Cancelar":
                System.exit(0);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }
    }
}
