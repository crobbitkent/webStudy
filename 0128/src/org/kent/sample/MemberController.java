

package org.kent.sample;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.dao.MemberDAO;
import org.kent.dao.StoreDAO;
import org.kent.dao.TimeDAO;
import org.kent.domain.Member;
import org.kent.domain.Store;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/member/*")
public class MemberController extends MultiController {
	private static final long serialVersionUID = 1L;
    
	private StoreDAO storeDAO;
	private MemberDAO memberDAO;
	
	
    /**
     * @see MultiController#MultiController()
     */
    public MemberController() {
        super();
        storeDAO = new StoreDAO();      
        memberDAO = new MemberDAO();      
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("member list get method..................");
	
		
		List<Member> members = memberDAO.getAll();
		
		for(Member member : members) {
			System.out.println(member);
		}	
	
		return "member/list";
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














