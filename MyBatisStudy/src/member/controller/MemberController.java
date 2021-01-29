

package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.domain.Member;
import store.domain.Store;
import common.MultiController;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/member/*")
public class MemberController extends MultiController {
	private static final long serialVersionUID = 1L;
    
	private MemberDAO memberDAO;	
	
    /**
     * @see MultiController#MultiController()
     */
    public MemberController() {
        super();
     
        memberDAO = new MemberDAO();      
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("member list get method..................");
		
		List<Member> members = memberDAO.getAll();
		System.out.println("list generated..................");
		
		try {
			// 이거 들고 가라
			request.setAttribute("members", members);
		} catch(Exception e) {
			e.printStackTrace();
			return "re:/error/";
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














