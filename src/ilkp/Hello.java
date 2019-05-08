package ilkp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet{
	private static final long serialVersionUID = 1L;
	  
	@Override
	public void init() throws ServletException {
		System.out.println("Hello init() method");
		System.out.println("Hello init() method");
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		//SERVLET CONF�G, SERVLET NESNES� �LK OLU�URKEN WEB.XML �LE ETK�LE��ME G�RER.��ER�S�NDE NESNE B�LG�LER�N� VE �N�T PARAMS NAME:VALUE DE�ERLER� TUTAR, SADECE KEDN� NESNES�NDEN ER���LEB�L�R
		ServletConfig servletConfig = getServletConfig();
		
		//SERVLET CONTEXT, UYGULAMA BA�LARKEN WEB.XML �LE ETK�LE��ME G�RER, ��ER�S�NDE CONTEXT PARAMS NAME:VALUE'LARI TUTAR, T�M SINIFLARDAN ER���LEB�L�R.
		ServletContext servletContext = getServletContext();
		//ServletContext servletContext = servletConfig.getServletContext(); ServletContext'e, ServletConfiglerden de ula�abiliriz.

		System.out.println(servletConfig.getInitParameter("username"));
		System.out.println(servletConfig.getInitParameter("password"));
		System.out.println(servletConfig.getServletName());

		System.out.println(servletContext.getInitParameter("email"));
		System.out.println(servletContext.getInitParameter("address"));
		
		
		//Servlet context fonksiyonlar�. getResourceAsStream proje dizinindeki bir d�k�mandan name:value de�erleri okumam�z� sa�lar
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/myproperties.properties");
		
		Properties pro = new Properties();
		pro.load(inputStream);
		
		System.out.println(pro.get("okul"));
		System.out.println(pro.get("bolum"));
		
		//Di�er context fonksiyonlar�.
		System.out.println(servletContext.getRealPath("/WEB-INF/myproperties.properties"));
		System.out.println(servletContext.getContextPath());
		System.out.println(servletContext.getServletContextName());
		
		//BROWSERA HTML VER� YOLLAR
		PrintWriter pw = resp.getWriter();
		Date today = new Date();
		String msg = "ServletLifecycle";

		pw.print("<html><body> <h1>" + msg + "</h1>");
		pw.print("<p>today:" + today + "<p>");
		pw.print("<a href=	http://www.injavawetrust.com/>injavawetrust </a>");
		pw.print("</body></html>");
		
	}

	@Override
	public void destroy() {
		System.out.println("####destroy");
	}
}
