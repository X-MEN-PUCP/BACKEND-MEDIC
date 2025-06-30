/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO.util;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pe.edu.pucp.softcitbo.BO.util.cargaConfig;

/**
 *
 * @author luisa
 */
public class ServicioCorreo {
    private static final String correoRemitente = cargaConfig.getPropiedad("email.remitente");
    private static final String contraApp = cargaConfig.getPropiedad("email.contrasena");
    
    public boolean enviarCorreoVerificacion(String destinatario, String codVerificacion){
        if(correoRemitente == null || contraApp == null){
            System.err.println("Error: Las credenciales de correo no estan correctamente configuradas");
            return false;
        }
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session sesion = Session.getInstance(prop, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(correoRemitente,contraApp);
            }
        });
        try {
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(correoRemitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Código de Verificación - Medical App");
            String contenidoHtml = "<h1>¡Bienvenido a Medical App!</h1>"
                                 + "<p>Gracias por registrarte. Tu código de verificación es:</p>"
                                 + "<h2 style='color: #0d6efd;'>" + codVerificacion + "</h2>"
                                 + "<p>Este código expirará en 10 minutos.</p>";
            message.setContent(contenidoHtml, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Correo de verificación enviado exitosamente a " + destinatario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al enviar el correo de verificación: " + e.getMessage());
            return false;
        }
    }
}

