/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO.util;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
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
        System.out.println(">>> INICIANDO ENVÍO DE CORREO DE VERIFICACIÓN <<<");
        System.out.println(">>> Destinatario: " + destinatario);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.debug", "true");
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
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println("!!!      ERROR CRÍTICO AL ENVIAR CORREO           !!!");
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace(); // Esto te dirá si fue un error de autenticación, conexión, etc.
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return false;
        }
    }
}

