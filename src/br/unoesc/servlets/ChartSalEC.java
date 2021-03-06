package br.unoesc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unoesc.dao.ChartData;
import br.unoesc.dao.ChartData.KeyValue;

/**
 * Servlet implementation class ChartSalEC
 */
@WebServlet("/ChartSalEC")
public class ChartSalEC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartSalEC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChartData cd = new ChartData(); 
		List<KeyValue> pieDataList = cd.getSalEC();
	        request.setAttribute("pieDataList", pieDataList);
	        RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("/ChartSalEC.jsp");
	        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
