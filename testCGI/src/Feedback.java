import java.util.Hashtable;


public class Feedback {
	public static void main(String[] args) {
	      System.out.println(cgi_lib.Header());
	      Hashtable form_data = cgi_lib.ReadParse(System.in);
	      String name = (String)form_data.get("name");
	      String email = (String)form_data.get("email");
	      String comment = (String)form_data.get("comment");
	      System.out.println(cgi_lib.HtmlTop("Hello " + name + "!"));
	      System.out.println("<h1 align=center>Your email " + email +"</h1>");
	      System.out.println("<h1 align=center>Your comment " + comment +"</h1>");
	      /*System.out.println("Here are the name/value pairs from the form:");
	      System.out.println(cgi_lib.Variables(form_data));
	      System.out.println("Here are the CGI environment variables/value pairs passed in from the UNIX script:");
	      System.out.println(cgi_lib.Environment());*/
	      System.out.println(cgi_lib.HtmlBot());
	}
}
