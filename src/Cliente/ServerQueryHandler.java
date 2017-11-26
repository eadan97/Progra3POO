package Cliente;

import Model.Agente;
import Model.Cliente;
import Model.Mensaje;
import Util.TipoMensaje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ServerQueryHandler {
    ClienteSocket cliente;

    public ServerQueryHandler() {
        this.cliente = new ClienteSocket("192.168.1.3", 6969);
    }

    private String enviarMensajeRecibirString(Mensaje mensajeEnviar){
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

    public String iniciarSesion(String usuario, String clave) {
        Mensaje mensajeEnviar = new Mensaje(TipoMensaje.LOGIN, usuario, clave);
        return enviarMensajeRecibirString(mensajeEnviar);
    }

    public String agregarAgente(Agente agente){
        Mensaje mensajeEnviar = new Mensaje(TipoMensaje.AGREGARAGENTE, agente);
        return enviarMensajeRecibirString(mensajeEnviar);

    }

    public ArrayList<Agente> consultarAgentes() {
        ArrayList<Agente> res = new ArrayList<>();
        Mensaje mensajeEnviar = new Mensaje(TipoMensaje.CONSULTARAGENTES);
        try {
            // Abrir conexion y enviar el mensaje
            cliente.abrirConexion();
            cliente.enviarMensaje(mensajeEnviar);
            Mensaje mensaje = cliente.recibirMensaje();
            cliente.cerrarConexion();
            res= (ArrayList<Agente>) mensaje.getDato1();
        }
        catch (IOException e) {System.out.println(e);}
        return res;
    }

    public ArrayList<Cliente> consultarClientes() {
        ArrayList<Cliente> res = new ArrayList<>();
        Mensaje mensajeEnviar = new Mensaje(TipoMensaje.CONSULTARCLIENTES);
        try {
            // Abrir conexion y enviar el mensaje
            cliente.abrirConexion();
            cliente.enviarMensaje(mensajeEnviar);
            Mensaje mensaje = cliente.recibirMensaje();
            cliente.cerrarConexion();
            res= (ArrayList<Cliente>) mensaje.getDato1();
        }
        catch (IOException e) {System.out.println(e);}
        return res;
    }
}
