package org.keroro.controller.store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.dao.StoreDAO;
import org.keroro.domain.Store;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/store/view")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StoreDAO storeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewController() {
		super();
		storeDAO = new StoreDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)			throws ServletException, IOException {

		try {
			// url 연결
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/store/view.jsp");

			Long sno = Long.parseLong(request.getParameter("sno"));

			Store store = storeDAO.selectOne(sno);
			
			request.setAttribute("store", store);

			// browser로 전달
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error");
		}

		
	}

}
