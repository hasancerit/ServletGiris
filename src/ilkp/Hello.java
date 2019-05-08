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
		//SERVLET CONFÝG, SERVLET NESNESÝ ÝLK OLUÞURKEN WEB.XML ÝLE ETKÝLEÞÝME GÝRER.ÝÇERÝSÝNDE NESNE BÝLGÝLERÝNÝ VE ÝNÝT PARAMS NAME:VALUE DEÐERLERÝ TUTAR, SADECE KEDNÝ NESNESÝNDEN ERÝÞÝLEBÝLÝR
		ServletConfig servletConfig = getServletConfig();
		
		//SERVLET CONTEXT, UYGULAMA BAÞLARKEN WEB.XML ÝLE ETKÝLEÞÝME GÝRER, ÝÇERÝSÝNDE CONTEXT PARAMS NAME:VALUE'LARI TUTAR, TÜM SINIFLARDAN ERÝÞÝLEBÝLÝR.
		ServletContext servletContext = getServletContext();
		//ServletContext servletContext = servletConfig.getServletContext(); ServletContext'e, ServletConfiglerden de ulaþabiliriz.

		System.out.println(servletConfig.getInitParameter("username"));
		System.out.println(servletConfig.getInitParameter("password"));
		System.out.println(servletConfig.getServletName());

		System.out.println(servletContext.getInitParameter("email"));
		System.out.println(servletContext.getInitParameter("address"));
		
		
		//Servlet context fonksiyonlarý. getResourceAsStream proje dizinindeki bir dökümandan name:value deðerleri okumamýzý saðlar
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/myproperties.properties");
		
		Properties pro = new Properties();
		pro.load(inputStream);
		
		System.out.println(pro.get("okul"));
		System.out.println(pro.get("bolum"));
		
		//Diðer context fonksiyonlarý.
		System.out.println(servletContext.getRealPath("/WEB-INF/myproperties.properties"));
		System.out.println(servletContext.getContextPath());
		System.out.println(servletContext.getServletContextName());
		
		//BROWSERA HTML VERÝ YOLLAR
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
