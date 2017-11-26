package Cliente;

import Model.Mensaje;
import Util.TipoMensaje;

import java.io.IOException;
import java.util.Objects;

public class ServerQueryHandler {
    ClienteSocket cliente;

    public ServerQueryHandler() {
        this.cliente = new ClienteSocket("192.168.1.6", 6969);
    }

    public String iniciarSesion(String usuario, String clave) {
        Mensaje mensajeEnviar = new Mensaje(TipoMensaje.LOGIN, usuario, clave);

        try {
            // Abrir conexion y enviar el mensaje
            cliente.abrirConexion();
            cliente.enviarMensaje(mensajeEnviar);

            // Revisar el mensaje de respuesta para determinar si tiene acceso
            Mensaje mensaje = cliente.recibirMensaje();

            // Cerrar la conexion
            cliente.cerrarConexion();
            return (String) mensaje.getDato1();
        }
        catch (IOException e) {System.out.println(e);}
        return null;
    }
    
}
