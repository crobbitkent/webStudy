package org.keroro.member.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.keroro.common.controller.MultiController;
import org.keroro.member.dao.MemberDAO;
import org.keroro.member.domain.Member;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;


@Log4j
@WebServlet("/login/*")
public class LoginController extends MultiController {
	private static final long serialVersionUID = 1L;
	
	@Default
	private MemberDAO dao = new MemberDAO();
	
	public String logoutPOST(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();		
		return "re:/user/login/check";
	}
	
	public String checkGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("login checkGET");
		String mid = request.getParameter("mid");
		String loginFail = request.getParameter("loginFail");
		String signupFail = request.getParameter("signupfail");
		
		log.info("mid : " + mid);
		log.info("loginFail : " + loginFail);
		log.info("signupFail : " + signupFail);
		
		request.setAttribute("mid", mid);
		request.setAttribute("loginFail", loginFail);
		request.setAttribute("signupFail", signupFail);
		
		return "login/check";
	}
	
	public String checkPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("login checkPOST");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		// Member member = Admin.builder().aid(mid).apw(mpw).build();
		
		Member result = dao.selectMember(mid, mpw);
		log.info(result);

		// 로그인 되었다는 뜻
		if(null != result) {			
			// remeber me 확인
			String remember = request.getParameter("remember");
			if(null != remember &&  remember.equals("ok")) {
				log.info("cookie ok");
				
				// 쿠키 발행
				Cookie ck = new Cookie("mid", mid);
				// 1시간 유통기한
				ck.setMaxAge(60*60);				
				response.addCookie(ck);			
			}	
			
			// 세션
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
			
			log.info("login success");
			return "re:/user/home/main";
		}
		
		log.info("login fail");
		// 로그인 실패		
		return "re:/user/login/check?loginFail=1&mid=" + mid;
	}
}
