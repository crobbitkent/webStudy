
package org.keroro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.dao.ReviewDAO;
import org.keroro.dao.StoreDAO;
import org.keroro.domain.Review;
import org.keroro.domain.Store;
import org.keroro.dto.ReviewDTO;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/review/*")
public class ReviewController extends MultiController {
	private static final long serialVersionUID = 1L;

	private StoreDAO storeDAO;
	private ReviewDAO reviewDAO;

	/**
	 * @see MultiController#MultiController()
	 */
	public ReviewController() {
		super();
		// TODO Auto-generated constructor stub

		storeDAO = new StoreDAO();
		reviewDAO = new ReviewDAO();
	}

	

	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register get method..................");

		Long sno = Long.parseLong(request.getParameter("sno"));
		
		try {
			Store store = storeDAO.selectOne(sno);
			request.setAttribute("store", store);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "review/register";
	}

	public String registerPOST(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("registerPOST run.............");
		Long sno = Long.parseLong(request.getParameter("sno"));
		Long score = Long.parseLong(request.getParameter("score"));
		String mid = request.getParameter("mid");
		String text = request.getParameter("text");
		
		try {
			Review review = Review.builder().sno(sno).mid(mid).score(score).text(text).build();	
			System.out.println(review);
			reviewDAO.insert(review);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		// /store/list?sno=${store.storeCode}
		return "re:/store/view?sno=" + sno;
	}

//	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
//		
//		try {
//			Long sno = Long.parseLong(request.getParameter("sno"));
//
//			Store store = storeDAO.selectOne(sno);
//			
//			List<ReviewDTO> list = reviewDAO.selectAll(sno);
//			
//			request.setAttribute("store", store);
//			request.setAttribute("reviewList", list);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "re:/error/";
//		}
//	
//		return "store/view";
//	}

}
