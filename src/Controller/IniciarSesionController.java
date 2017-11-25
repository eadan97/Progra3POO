package Controller;

import Cliente.ServerQueryHandler;
import View.IniciarSesionForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesionController implements ActionListener{
    public IniciarSesionForm vista;
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

                //todo:si es error, mostrar mensaje
                //todo: segun usuario, ir a esa vista
                break;
            case "Cancelar":
                System.exit(0);
                break;
            default:
                System.out.println(e.getActionCommand()+" no esta soportado");
        }
    }
}
