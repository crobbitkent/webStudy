package org.keroro.user.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/home/*")
public class UserController extends MultiController{
	private static final long serialVersionUID = 1L;
	
	public String mainGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("user mainGET"); // log.debug();
		
		return "home/main";
	}
}
