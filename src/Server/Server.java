package Server;

import Model.Usuario;
import Model.Wrapper.Agentes;
import Model.Wrapper.Clientes;

public class Server{
    static String serverIP="192.168.1.6";
    static int serverPort=6969;

    static Clientes clientes=new Clientes();
    static Usuario admin = new Usuario("admin", "admin", "tareasitcr@gmail.com");
    static Agentes agentes = new Agentes();

    public static void main(String[] args){


        System.out.println("Iniciando servidor...");

        clientes.loadFromXML();

        new EnviarCorreoHandle("smtp.gmail.com", "587", "tareasitcr@gmail.com","TareasITCR2017");
        new LeerCorreoThread("pop.gmail.com","995","tareasitcr@gmail.com","TareasITCR2017");
        ServerSocketHandler server = new ServerSocketHandler(serverIP, serverPort);
        server.iniciarServidor();

    }




}
