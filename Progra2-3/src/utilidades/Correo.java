/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

/**
 *
 * @author Eduardo
 */
public class Correo {
    private String emisor;
    private String contraseña;
    private ArrayList<String> receptores;
    private String texto;
    private String asunto;
    private Properties propiedades;
    private Session sesion;
    private final static Correo instance = new Correo("edjiron@gmail.com", "jqalrtwrjxnkhpic");
    
    /**
     * Constructor
     * @param pEmisor
     * @param pContraseña
     */
    public Correo(String pEmisor,String pContraseña){
        emisor = pEmisor;
        contraseña = pContraseña;
    }
    
    /**
     * Es el metodo encargado de enviar el correo
     * @throws MessagingException 
     */
    public void sendCorreo() throws MessagingException{
        propiedades = new Properties();
        propiedades.put("mail.smtp.host","smtp.gmail.com"); //selecciona la plataforma de correo a usar
        propiedades.put("mail.smtp.starttls.enable","true");
        propiedades.put("mail.smtp.auth","true");
        sesion=Session.getDefaultInstance(propiedades);
        
        MimeMessage mensaje=new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor)); //pone el emisor
        for(String i:receptores){
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(i)); //añade receptores
        }
        mensaje.setSubject(asunto);
        mensaje.setText(texto);
        
        Transport enviando=sesion.getTransport("smtp");
        enviando.connect("smtp.gmail.com",587, emisor, contraseña); //se inicia la sesion
        enviando.sendMessage(mensaje,mensaje.getAllRecipients());
        enviando.close();
    }
    
    public void leerCorreo() throws NoSuchProviderException, MessagingException, IOException{
        propiedades = System.getProperties();
        propiedades.setProperty("mail.store.protocol", "imaps");
            
        Session session = Session.getDefaultInstance(propiedades, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", "edjiron@gmail.com", "jqalrtwrjxnkhpic");
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);// PODEMOS LEER Y ESCRIBIR
        FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
        Message messages[] = inbox.search(ft);

        String[] mensajeSplit;
        String numero;
        boolean validoNombre;
        boolean validoNumero;
        String content;
        char caractEspecial;

        for (Message message : messages) {
            if(message.getSubject().equals("Nuevo cliente")){
                validoNumero = false;
                validoNombre = true;
                content = message.getContent().toString();
                if(content.contains(",")){
                    if(content.contains("\n"))
                        content = content.replaceAll("\n", "");
                    mensajeSplit = content.split(",");
                    mensajeSplit[0] = mensajeSplit[0].trim();
                    for(int i = 33; i <= 255; i++){
                        if(i == 65)
                            i = 91;
                        if(i == 97)
                            i = 123;
                        if(i == 128)
                            i = 155;
                        if(i == 160)
                            i = 166;
                        caractEspecial = (char) i;
                        if(mensajeSplit[0].contains("" + caractEspecial)){
                            validoNombre = false;
                            break;
                        }
                    }
                    if(validoNombre){
                        numero = mensajeSplit[1];
                        numero = numero.trim();
                        if(numero.length() == 8){
                            try{
                                Integer.parseInt(numero);
                                validoNumero = true;
                            }catch(NumberFormatException e){
                                System.out.println(e);
                            }

                        }
                    }
                    if(validoNumero){ //Cambiar para agregar el cliente
                        System.out.println("---------------------------------------------");
                        System.out.println("Subject: " + message.getSubject());
                        System.out.println("DE: " + message.getFrom()[0].toString());
                        System.out.println("Contenido: " + message.getContent().toString());
                        System.out.println("FECHA :" + message.getSentDate().toString());
                        System.out.println("MENSAJE NUMERO :" + message.getMessageNumber());
                    }
                }
            }
            message.setFlag(Flags.Flag.SEEN, true);//SEEN MARCA COMO VISTO LOS MENSAJES NO LEIDOS,FLAGGED LES PONE UNA ESTRELLITA
        }
    }

    /**
     * @param pTexto
     */
    public void setTexto(String pTexto) {
        texto = pTexto;
    }

    /**
     * @param pAsunto
     */
    public void setAsunto(String pAsunto) {
        asunto = pAsunto;
    }

    /**
     * @param pReceptores
     */
    public void setReceptores(ArrayList<String> pReceptores) {
        receptores = pReceptores;
    }
}
