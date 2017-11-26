package Server;

import Model.*;
import Util.TipoMensaje;
import Util.Utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
        String id;
        switch (mensaje.getTipoMensaje()) {
            case AGREGARAGENTE://id del agente o n ull
                try {
                    Agente nuevo = (Agente) mensaje.getDato1();
                    id= Server.agentes.add(nuevo);

                    enviarCorreoHandle.enviarCorreo(nuevo.getCorreo(), "Cuenta creada", "Contrasena es: " + nuevo.getContrasenia());
                    res = new Mensaje(TipoMensaje.AGREGARAGENTE, id);
                    System.out.println("Agente creado: \n" + nuevo + "\n");
                }catch (Exception e){
                    res = new Mensaje(TipoMensaje.AGREGARAGENTE, null);
                }
                enviarMensaje(res);
                break;

            case CONSULTARAGENTES: //retorna ArrayList<Agente> en dato 1
                res = new Mensaje(TipoMensaje.CONSULTARAGENTES, Server.agentes.getLista());

                System.out.println("Agentes consultados: \n"+Server.agentes.getLista().size()+"\n");

                enviarMensaje(res);
                break;

            case CONSULTARCLIENTES://retorna ArrayList<Ciente> en dato 1
                res = new Mensaje(TipoMensaje.CONSULTARCLIENTES, Server.clientes.getLista());
                System.out.println("Clientes consultados: \n"+Server.clientes.getLista().size()+"\n");
                enviarMensaje(res);
                //todo: hacer csv
                break;

            case REGISTRARBIEN: //retorna true o false
                res = new Mensaje(TipoMensaje.AGREGARAGENTE, false);
                try {
                    Bien nuevoBien = (Bien) mensaje.getDato2();
                    Agente a=Server.agentes.getAgente((String) mensaje.getDato1());
                    if(a!=null){
                        a.bienes.add(nuevoBien);
                        res = new Mensaje(TipoMensaje.AGREGARAGENTE, true);
                        System.out.println("Bien agregado a: \n"+a.getIdUsuario()+"\n");
                    }
                }catch (Exception e){
                    System.out.println("Error al guardar el bien");
                }
                enviarMensaje(res);
                break;
            case MODIFICARBIEN:
                //todo: hacer
                break;
            case CONSULTARBIENESAGENTE://Debe recibir en dato 1 el id del agente... devulve arraylist de bienes
                res = new Mensaje(TipoMensaje.CONSULTARBIENESAGENTE, Server.agentes.getAgente((String) mensaje.getDato1()).bienes);
                System.out.println("Bienes consultados: \n"+Server.agentes.getAgente((String) mensaje.getDato1()).bienes.size()+"\n");
                enviarMensaje(res);
                break;
            case ELIMINARBIEN:
                //todo: hacer eliminarBien
                break;
            case CONSULTARPROSPECTOS://recibir idagente y idbien envia lista de cliente
                try {
                    res = new Mensaje(TipoMensaje.CONSULTARPROSPECTOS, Server.agentes.getAgente((String) mensaje.getDato1()).getBien((int) mensaje.getDato2()).getInteresados());
                }catch (NullPointerException e){
                    res= new Mensaje(TipoMensaje.CONSULTARPROSPECTOS, new ArrayList<Cliente>());
                }
                System.out.println("Bienes consultados: \n"+((ArrayList)res.getDato1()).size()+"\n");
                enviarMensaje(res);
                break;
            case CONSULTARBIENESCLIENTE:
                res = new Mensaje(TipoMensaje.CONSULTARBIENESCLIENTE, Server.agentes.getTodosLosBienes());
                System.out.println("Bienes consultados: \n"+Server.agentes.getTodosLosBienes().size()+"\n");
                enviarMensaje(res);
                break;
            case SOLICITARFICHAPROPIEDAD://recibe correo y propiedad envia bool
                res = new Mensaje(TipoMensaje.SOLICITARFICHAPROPIEDAD, false);
                for (Agente a: Server.agentes.getLista()
                     ) {
                    Bien bien=a.getBien((int)mensaje.getDato2());
                    if (bien!=null){
                        ArrayList<byte[]>imagenes = new ArrayList<byte[]>();
                        imagenes.add(Utils.generarQr(a));
                        imagenes.addAll(bien.getImagenes());
                        EnviarCorreoHandle.getInstance().enviarCorreoHtml((String) mensaje.getDato1(),
                                "Ficha de propiedad",
                                Utils.bienToHtml(bien),
                                imagenes);
                        res = new Mensaje(TipoMensaje.SOLICITARFICHAPROPIEDAD, true);
                    }
                }
                enviarMensaje(res);
                break;
            case MOSTRARINTERES: //recibe usuario y propiedad
                res = new Mensaje(TipoMensaje.MOSTRARINTERES, false);
                for (Agente a: Server.agentes.getLista()
                        ) {
                    Bien bien=a.getBien((int)mensaje.getDato2());
                    if (bien!=null){
                        ArrayList interesados =bien.getInteresados();
                        interesados.add((Cliente)mensaje.getDato1());
                        bien.setInteresados(interesados);
                        res = new Mensaje(TipoMensaje.MOSTRARINTERES, true);
                    }
                }
                enviarMensaje(res);
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
                        res= new Mensaje(TipoMensaje.LOGIN,  "Cliente");
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
