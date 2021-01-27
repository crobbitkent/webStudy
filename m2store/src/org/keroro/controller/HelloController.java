package org.keroro.controller;

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
 * Servlet implementation class HelloController
 */
@WebServlet("/hello")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StoreDAO storeDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloController() {
        super();
        storeDAO = StoreDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(storeDAO);
		System.out.println(this);
		System.out.println(Thread.currentThread().getName());
		System.out.println("-------------------------------------------------");
		//	url 연결
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/hello2.jsp");

		request.setAttribute("msg", "Hong GilDong");
		
		// browser로 전달
		rd.forward(request, response);
	}

}
