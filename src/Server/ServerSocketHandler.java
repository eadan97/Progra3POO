package Server;

import Model.Agente;
import Model.Bien;
import Model.Cliente;
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
    private EnviarCorreoHandle enviarCorreoHandle=EnviarCorreoHandle.getInstance();

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
        Mensaje res;

        switch (mensaje.getTipoMensaje()) {
            case AGREGARAGENTE:
                res = new Mensaje(TipoMensaje.AGREGARAGENTE, "Agente registrado");
                Agente nuevo = (Agente) mensaje.getDato1();
                nuevo.generarIDusuario();
                Server.agentes.add(nuevo);

                enviarCorreoHandle.enviarCorreo(nuevo.getCorreo(), "Cuenta creada", "Contrasena es: "+nuevo.getContrasenia());
                System.out.println("Agente creado: \n"+nuevo+"\n");

                enviarMensaje(res);
                break;

            case CONSULTARAGENTES:
                res = new Mensaje(TipoMensaje.CONSULTARAGENTES, Server.agentes.getLista());

                System.out.println("Agentes consultados: \n"+Server.agentes.getLista().size()+"\n");

                enviarMensaje(res);
                break;

            case CONSULTARCLIENTES:
                res = new Mensaje(TipoMensaje.CONSULTARCLIENTES, Server.clientes.getLista());
                System.out.println("Clientes consultados: \n"+Server.clientes.getLista().size()+"\n");
                enviarMensaje(res);
                //todo: hacer csv
                break;

            case REGISTRARBIEN:
                res = new Mensaje(TipoMensaje.AGREGARAGENTE, "Agente registrado");
                Bien nuevoBien = (Bien) mensaje.getDato2();
                for (Agente a:Server.agentes.getLista()) {
                    if(a.getIdUsuario().compareTo((String) mensaje.getDato1())==0){
                        a.bienes.add(nuevoBien);
                        System.out.println("Bien agregado a: \n"+a.getIdUsuario()+"\n");
                        break;
                    }
                }
                enviarMensaje(res);
                break;
            case MODIFICARBIEN:
                break;

            case CERRARSERVER:
                cerrarConexion();
                terminarServidor();
                break;

            case LOGIN:
                System.out.println("Verificando credenciales");
                res= new Mensaje(TipoMensaje.LOGIN, null);
                for (Cliente u : Server.clientes.getLista())
                    if(u.getIdUsuario().compareTo((String) mensaje.getDato1())==0&&u.getContrasenia().compareTo((String) mensaje.getDato2())==0)
                        res= new Mensaje(TipoMensaje.LOGIN,  "Usuario");
                /*todo: agente for (ClienteSocket u : Server.clientes.getLista())
                    if(u.getIdUsuario().compareTo(mensaje.getDato1())==0&&u.getContrasenia().compareTo(mensaje.getDato2())==0)
                        res= new Mensaje(TipoMensaje.LOGIN, "Login OK");
                */
                if(Server.admin.getIdUsuario().compareTo((String) mensaje.getDato1())==0
                        &&Server.admin.getContrasenia().compareTo((String) mensaje.getDato2())==0)
                    res= new Mensaje(TipoMensaje.LOGIN,  "Admin");
                enviarMensaje(res);
                break;

            default:
                System.out.println("Tipo de mensaje no reconocido: " + mensaje.toString());
                break;
        }


    }

}
