import org.apache.commons.mail.HtmlEmail;

public class TestMail1 {
	public static void main(String[] args) {
		System.out.println(cgi_lib.Header());
		StringBuilder htmlBody =  new StringBuilder("<HTML>")
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
		System.out.println(htmlBody);
		try{
			sendMail(htmlBody.toString());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void sendMail(String htmlBody) throws Exception{
		HtmlEmail email = new HtmlEmail();

		email.setHostName("localhost");
		//email.setAuthentication(username, password);
		//email.setSmtpPort(port);
		email.setFrom("noreply-he@mheducation.com");
		email.addTo("sujoyb.tcs@gmail.com");
		email.setSubject("Feedback Form");

		//email.setTextMsg(textBody);
		
		
		email.setHtmlMsg(htmlBody.toString());

		email.setDebug(true);

		email.send();
        System.out.println("Sent message successfully....");
	}
}
