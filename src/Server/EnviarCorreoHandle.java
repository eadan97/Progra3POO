package Server;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EnviarCorreoHandle extends Thread {

    private static EnviarCorreoHandle instance=null;
    String server, puerto, user, pass;


    public EnviarCorreoHandle(String server, String puerto, String user, String pass){
        this.server=server;
        this.puerto=puerto;
        this.user=user;
        this.pass=pass;
        instance=this;
    }

    public static EnviarCorreoHandle getInstance() {
        return instance;
    }

    public void enviarCorreo(String to, String subject, String body, boolean html) {

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", puerto);

            // Get the Session object.
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, pass);
                        }
                    });

            try {
                // Create a default MimeMessage object.
                Message message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(user));

                // Set To: header field of the header.
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));

                // Set Subject: header field
                message.setSubject(subject);

                if(!html){
                    // Now set the actual message
                    message.setText(body);
                }
                if (html){
                    // message.setText(text, "utf-8", "html");

                    MimeBodyPart textPart = new MimeBodyPart();
                    textPart.setContent(body, "text/html; charset=utf-8");

                    DataSource source = new FileDataSource("/temp.png");
                    MimeBodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName("/temp.png");

                    Multipart multipart = new MimeMultipart("mixed");
                    multipart.addBodyPart(textPart);
                    multipart.addBodyPart(messageBodyPart);

                    message.setContent(multipart);

                }

                // Send message
                Transport.send(message);

                System.out.println("Correo enviado a "+to);


            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

}
