package enviocorreo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

	public static void main(String[] args) {
		
		System.out.println("hola");
		
		String email = "eowkin@gmail.com";
		String password = "gbkq uhuu zfgd zjop";
		String emailDestino = "cferreira@usb.ve";
		
		
		Properties p = new Properties();
		
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "587");
		p.setProperty("mail.smtp.user", email);
		p.setProperty("mail.smtp.auth", "true");
		System.out.println("hola 2");
		
		
		Session s = Session.getDefaultInstance(p);
		System.out.println("hola 3");
		MimeMessage mensaje = new MimeMessage(s);
		
		try {
			mensaje.setFrom(new InternetAddress(email));
			mensaje.addRecipients(Message.RecipientType.TO, emailDestino);
			
			mensaje.setSubject("Prueba de email");
			mensaje.setText("Este es un correo deesde JAVA, listo lo del correo tarde pero seguro");
			
			Transport t = s.getTransport("smtp");
			t.connect(email, password);
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();
			
					
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
		
		

		
	}

}
