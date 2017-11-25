package Server;
import Model.Cliente;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;

public class LeerCorreoThread extends Thread {

    EnviarCorreoHandle enviarCorreoHandle = EnviarCorreoHandle.getInstance();
    String server, puerto, user, pass;
    public LeerCorreoThread(String server, String puerto, String user, String pass){
        this.server=server;
        this.puerto=puerto;
        this.user=user;
        this.pass=pass;
        this.start();
    }
    @Override
    public void run() {
        while(true){
                try {
                    // create properties field
                    Properties properties = new Properties();
                    properties.put("mail.store.protocol", "pop3");
                    properties.put("mail.pop3.host", server);
                    properties.put("mail.pop3.port", puerto);
                    properties.put("mail.pop3.starttls.enable", "true");
                    Session emailSession = Session.getDefaultInstance(properties);
                    // emailSession.setDebug(true);

                    // create the POP3 store object and connect with the pop server
                    Store store = emailSession.getStore("pop3s");

                    store.connect(server, user, pass);

                    // create the folder object and open it
                    Folder emailFolder = store.getFolder("INBOX");
                    emailFolder.open(Folder.READ_ONLY);


                    // retrieve the messages from the folder in an array and print it
                    Message[] messages = emailFolder.getMessages();
                    System.out.println("Mensajes nuevos: " + messages.length);

                    for (int i = 0; i < messages.length; i++) {
                        Message message = messages[i];
                        if (message.isMimeType("multipart/*")) {
                            try{
                            System.out.println("This is a Multipart");
                            System.out.println("---------------------------");
                            String subject = message.getSubject();
                            String body = (String) ((Multipart)message.getContent()).getBodyPart(0).getContent();

                            String correo=((InternetAddress)message.getFrom()[0]).getAddress();
                            String nombre=body.substring(0, body.indexOf(","));
                            String telefono=body.substring(body.indexOf(",")+2, body.length()-2);

                            if(subject.contains("Nuevo cliente")) {

                                crearCliente( correo,
                                        nombre,
                                        telefono);
                            }}
                            catch (Exception e){
                                System.out.println("Hubo un error leyendo el correo: "+e.getMessage());
                            }

                        }
                        else{
                            System.out.println("Correo en formato invalido");
                        }

                    }

                    // close the store and folder objects
                    emailFolder.close(false);
                    store.close();

                    sleep(300000);
                } catch (MessagingException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    System.out.println("Hubo un problema al pausar el hilo de LeerCorreoThread: " + e.getMessage());
                }catch (Exception e) {
                    System.out.println("Hubo un problema al leer el correo: " +e.getMessage());
            }
        }
    }

    private void crearCliente(String correo, String nombre, String telefono) {

        Cliente nuevo = new Cliente(nombre, telefono, correo);
        Server.clientes.add(nuevo);

        enviarCorreoHandle.enviarCorreo(correo, "Cuenta creada", "Contrasena es: "+nuevo.getContrasenia()); //no tengo enies
        System.out.println("ClienteSocket creado: \n"+nuevo+"\n");

    }
}
