

package org.kent.sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/sample/*")
public class SampleController extends MultiController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see MultiController#MultiController()
     */
    public SampleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("list get method..................");
		return "sample/list";
	}
	
	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("register get method..................");
		return "sample/register";
	}
	
	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("view get method..................");
		return "re:/0128/sample/list";
	}

}














