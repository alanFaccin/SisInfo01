package br.unoesc.servlets;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unoesc.dao.ArquivoDAO;
import br.unoesc.dao.ArquivoDAOImpl;
import br.unoesc.model.Arquivo;
import br.unoesc.reader.Reader;

/**
 * Servlet implementation class Servlet_index
 */
@WebServlet("/Servlet_index")
public class Servlet_index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_index() {
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
			Reader r = new Reader();
			try {
				r.read();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // carrega o arqivo, le os dados e grava no banco 
			// request.setCharacterEncoding("UTF-8"); // resolveu o problema da
			// captura de string com acento que estava bugado
			// String temp = request.getParameter("exampleInputFile");
			// ServletInputStream sis = request.getInputStream();

			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(request.getInputStream()));
			// try {
			// r.read(reader);
			// }
			// catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// tdao.salvarGenerico(time);
			response.sendRedirect("index.jsp");

			// out.println("<h1>Servlet Servlet_Alimenta_Time at " +
			// request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequest(request, response);
	}

}
