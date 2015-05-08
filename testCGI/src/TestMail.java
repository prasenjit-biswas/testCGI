import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class TestMail {
	public static void main(String[] args) {
		try{
			sendMail();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void sendMail() throws Exception{
		// Recipient's email ID needs to be mentioned.
	    String to = "biswas.prasenjit@tcs.com";

	    // Sender's email ID needs to be mentioned
	    String from = "noreply-he@mheducation.com";

	    // Assuming you are sending email from localhost
	    String host = "localhost";

	    // Get system properties
	    //Properties properties = new Properties();
	    Properties properties = System.getProperties();

	    // Setup mail server
	    properties.setProperty("mail.smtp.host", host);

	    // Get the default Session object.
	    Session session = Session.getDefaultInstance(properties);

         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Feedback Form");

         // Send the actual HTML message, as big as you like
         StringBuilder mailBody =  new StringBuilder("<HTML>")
									         .append("<HEAD>")
									         .append("<TITLE>Feedback!</TITLE>")
									         .append("</HEAD>")
									         .append("<BODY>")
									         .append("<h1 align=center>Feedback</h1>")
									         .append("<hr/>")
									         .append("<form method=\"POST\" ACTION=\"http://ezto-dev2.mhecloud.mhhe.com/cgi-bin/feedback.cgi\">")
									         .append("	Your name: <input type=\"text\" name=\"name\"/><br/>")
									         .append("	Your email: <input type=\"text\" name=\"email\"/><br/>")
									         .append("	Your comment    : <textarea name=\"comment\"></textarea><br/>")
									         .append("	<input type=\"submit\" value = \"submit\" />")
									         .append("</form>")
									         .append("<hr/>")
									         .append("</body>")
									         .append("</html>");
         							;
         message.setContent(mailBody.toString(), "text/html" );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
	}
}
