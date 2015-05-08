import java.util.Hashtable;


public class hello {
	public static void main(String[] args) {
	      System.out.println(cgi_lib.Header());
	      Hashtable form_data = cgi_lib.ReadParse(System.in);
	      String name = (String)form_data.get("name");
	      System.out.println(cgi_lib.HtmlTop("Hello There " + name + "!"));
	      System.out.println("<h1 align=center>Hello There " + name +"!</h1>");
	      System.out.println("Here are the name/value pairs from the form:");
	      System.out.println(cgi_lib.Variables(form_data));
	      System.out.println("Here are the CGI environment variables/value pairs passed in from the UNIX script:");
	      System.out.println(cgi_lib.Environment());
	      System.out.println(cgi_lib.HtmlBot());
	}
	
}
