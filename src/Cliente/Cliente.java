package Cliente;

import Controller.IniciarSesionController;
import View.IniciarSesionForm;

public class Cliente {
    public static void main (String[]args){
        ServerQueryHandler serverQueryHandler = new ServerQueryHandler();

        IniciarSesionController iniciarSesionController
                = new IniciarSesionController(new IniciarSesionForm(), serverQueryHandler );
        iniciarSesionController.vista.setVisible(true);
        iniciarSesionController.vista.setLocationRelativeTo(null);
    }
}
