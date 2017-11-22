package Server;

import Model.Mensaje;
import Util.TipoMensaje;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHandler {
    String serverIP;
    int serverPort;
    int cantidadDeConecciones;
    ServerSocket serverSocket;
    Socket conexion;
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    boolean isServerAbierto=false;

    public ServerSocketHandler(String serverIP, int serverPort) {
        this.serverIP=serverIP;
        this.serverPort=serverPort;
        iniciarServidor();
    }

    public void iniciarServidor(){
        try {
            serverSocket=new ServerSocket(serverPort, cantidadDeConecciones, InetAddress.getByName(serverIP));
            isServerAbierto=true;
            System.out.println("ServerSocket corriendo en "+serverIP+":"+serverPort);
            manejarPeticiones();
        } catch (IOException e) {
            System.out.println("Error al inicar el servidor: "+e.getMessage());
        }
    }

    private void manejarPeticiones() {
        while(isServerAbierto){
            try {
                esperarConexion();

                procesarConexion();

                cerrarConexion();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    private void esperarConexion() throws IOException {
        System.out.println("Esperando una conexión...");
        conexion = serverSocket.accept();
        System.out.println("Conectado a: " + conexion.getInetAddress().getHostName());
    }


    private Mensaje leerMensaje() throws IOException, ClassNotFoundException {
        entrada = new ObjectInputStream(conexion.getInputStream());//Obtiene el flujo de entrada
        Mensaje mensaje = (Mensaje) entrada.readObject();
        System.out.println("Mensaje recibido...");
        return mensaje;
    }

    private void enviarMensaje(Mensaje mensaje) throws IOException {
        System.out.println("Enviando respuesta a : " + conexion.getInetAddress());
        salida = new ObjectOutputStream(conexion.getOutputStream());
        salida.flush();
        salida.writeObject(mensaje);
        salida.flush();
    }

    private void cerrarConexion() throws IOException {
        salida.close();
        entrada.close();
        conexion.close();
    }

    private void terminarServidor() throws IOException {
        serverSocket.close();
    }

    private void procesarConexion() throws IOException, ClassNotFoundException {
        Mensaje mensaje = leerMensaje();

        switch (mensaje.getTipoMensaje()) {
            case CERRARSERVER:
                cerrarConexion();
                terminarServidor();
                break;

            case LOGIN:
                System.out.println("Verificando credenciales");
                mensaje = new Mensaje(TipoMensaje.LOGIN, "Login OK");
                enviarMensaje(mensaje);
                break;

            default:
                System.out.println("Tipo de mensaje no reconocido: " + mensaje.toString());
                break;
        }


    }

}
