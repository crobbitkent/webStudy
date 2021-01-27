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
 * Servlet implementation class RegisterController
 */
@WebServlet("/store/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/store/register.jsp");

			rd.forward(request, response);

			// response.sendRedirect(getServletInfo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/store/registerAction.jsp");
			
			String name = request.getParameter("name");
			double lat = Double.parseDouble(request.getParameter("lat"));
			double lng = Double.parseDouble(request.getParameter("lng"));
			String menu = request.getParameter("menu");
			
			Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();
			 // response.get
			
			StoreDAO.getInstance().insert(store);
			
			response.sendRedirect("/store/list");

			rd.forward(request, response);

			// response.sendRedirect(getServletInfo());

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
