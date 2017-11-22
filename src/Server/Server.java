package Server;

import java.net.ServerSocket;

public class Server{
    static String serverIP="192.168.1.2";
    static int serverPort=6969;


    public static void main(String[] args){
        System.out.println("Iniciando servidor...");
        EmailHandler emailHandler = new EmailHandler();
        emailHandler.start();
        ServerSocketHandler server = new ServerSocketHandler(serverIP, serverPort);
        server.iniciarServidor();

    }


}
