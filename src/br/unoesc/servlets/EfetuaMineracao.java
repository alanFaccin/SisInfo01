package br.unoesc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unoesc.dao.ArquivoDAO;
import br.unoesc.dao.ArquivoDAOImpl;
import br.unoesc.dao.ChartData;
import br.unoesc.dao.ChartData.KeyValue;
import br.unoesc.reader.Reader;

/**
 * Servlet implementation class EfetuaMineracao
 */
@WebServlet("/EfetuaMineracao")
public class EfetuaMineracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuaMineracao() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet teste</title>");
			out.println("</head>");
			out.println("<body>");
			ArquivoDAO a = new ArquivoDAOImpl();
			a.efetuaMinercao();
			response.sendRedirect("index.jsp");
			out.println("</body>");
			out.println("</html>");
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

}
