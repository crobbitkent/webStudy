//package org.keroro.controller.store;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.keroro.dao.StoreDAO;
//
///**
// * Servlet implementation class ListController
// */
//@WebServlet("/store/list")
//public class ListController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private StoreDAO storeDAO;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ListController() {
//		super();
//		storeDAO = new StoreDAO();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		try {
//			// jsp 로 파견 보내기
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/store/list.jsp");
//			
//			// 이거 들고 가라
//			request.setAttribute("stores", storeDAO.selectAll());
//
//			// 이제 요이 땅
//			rd.forward(request, response);
//
//			
//			
//			
//			
//			
//			
//			// response.sendRedirect(getServletInfo());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//	}
//
//}
