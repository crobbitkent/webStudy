

package store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.dto.ReviewDTO;

import store.dao.StoreDAO;
import store.domain.Store;

import common.MultiController;

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
        storeDAO = new StoreDAO();
        reviewDAO = new ReviewDAO();
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store list get method..................");
		
		List<Store> stores = storeDAO.getAll();
		System.out.println("list generated..................");
		
		try {
			// 이거 들고 가라
			request.setAttribute("stores", stores);
		} catch(Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}
		
		return "store/list";
	}
	
	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store register get method..................");
		return "sample/register";
	}
	
	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Long sno = Long.parseLong(request.getParameter("sno"));
			Store store = storeDAO.getOne(sno);
			
			List<ReviewDTO> list = reviewDAO.getAll(sno);
			
			request.setAttribute("store", store);
			request.setAttribute("reviewList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}	
		
		return "store/view";
	}

}














