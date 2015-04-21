package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class PrintCoucouTest
 */
public class PrintCoucouTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log = LoggerFactory
			.getLogger("fr.utbm.info.gl52.busnetworksimulator.servlet");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintCoucouTest() {
		super();
		System.out.println("Coucou Constructor");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("Coucou");
		response.getWriter().println("Coucou");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
