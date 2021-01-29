

package org.kent.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.dao.StoreDAO;
import org.kent.dao.TimeDAO;
import org.kent.domain.Store;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/store/*")
public class StoreController extends MultiController {
	private static final long serialVersionUID = 1L;
    
	private TimeDAO timeDAO;
	private StoreDAO storeDAO;
	
    /**
     * @see MultiController#MultiController()
     */
    public StoreController() {
        super();
        timeDAO = new TimeDAO();      
        storeDAO = new StoreDAO();      
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store list get method..................");
		
		// test
		String now = timeDAO.getNow();
		System.out.println(now);
		
		List<Store> stores = storeDAO.getAll();
		
		for(Store store : stores) {
			System.out.println(store);
		}
		
		
		return "sample/list";
	}
	
	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store register get method..................");
		return "sample/register";
	}
	
	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("store view get method..................");
		return "re:/0128/sample/list";
	}

}














