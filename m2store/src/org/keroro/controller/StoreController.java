

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
import org.keroro.domain.Store;
import org.keroro.dto.ReviewDTO;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/store/*")
public class StoreController extends MultiController {
	private static final long serialVersionUID = 1L;
       
	private StoreDAO storeDAO;
	private ReviewDAO reviewDAO;
	
    /**
     * @see MultiController#MultiController()
     */
    public StoreController() {
        super();
        // TODO Auto-generated constructor stub
        
        storeDAO = new StoreDAO();
        reviewDAO = new ReviewDAO();
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("list get method..................");
		
		try {
			// 이거 들고 가라
			request.setAttribute("stores", storeDAO.selectAll());
		} catch(Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}
		
		return "store/list";
	}
	
	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register get method..................");

		return "store/register";
	}
	
	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long sno = Long.parseLong(request.getParameter("sno"));

			Store store = storeDAO.selectOne(sno);
			
			List<ReviewDTO> list = reviewDAO.selectAll(sno);
			
			request.setAttribute("store", store);
			request.setAttribute("reviewList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}
	
		return "store/view";
	}

	
	public String registerPOST(HttpServletRequest request, HttpServletResponse response) {
		
		try {			 
			String name = request.getParameter("name");
			double lat = Double.parseDouble(request.getParameter("lat"));
			double lng = Double.parseDouble(request.getParameter("lng"));
			String menu = request.getParameter("menu");
			
			Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();
			
			storeDAO.insert(store);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/store/list";
	}
	
	
	
}














