package Cliente;
import Model.Mensaje;

import java.io.*;
import java.net.*;
/**
 * @author lpsoto Gracias profe!
 */
public class ClienteSocket {
    private String servidorIP;
    private int servidorPuerto;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Mensaje mensajeES;
    private Socket cliente;

    public ClienteSocket(String pDireccionIP, int pPuerto) {
        this.servidorIP = pDireccionIP;
        this.servidorPuerto = pPuerto;
    }

    public void abrirConexion() {
        try {
            cliente = new Socket(this.servidorIP, this.servidorPuerto);
        }
        catch (IOException e) {System.out.println(e);}
    }

    public void cerrarConexion() {
        try {
            cliente.close();
        }
        catch (IOException e) {System.out.println(e);}
    }

    @Deprecated
    public void obtenerFlujos() throws IOException {
        //salida.flush();
    }


    public void enviarMensaje(Mensaje miMensaje) throws IOException {
        // Create the ObjectOutputStream
        salida = new ObjectOutputStream(cliente.getOutputStream());
        try {
            // Write the myTextMessage object to the OutputStream
            salida.writeObject(miMensaje);
            salida.flush();
        }
        catch (IOException e) {System.out.println(e);}
    }

    public Mensaje recibirMensaje() throws IOException {
        entrada = new ObjectInputStream(cliente.getInputStream());
        mensajeES = new Mensaje();
        try {
            mensajeES = (Mensaje) entrada.readObject();
        }
        catch (ClassNotFoundException e) {System.out.println(e);}
        catch (IOException e) {System.out.println(e);}
        catch (Exception e) {System.out.println(e);}
        finally {
            return mensajeES;
        }
    }

}