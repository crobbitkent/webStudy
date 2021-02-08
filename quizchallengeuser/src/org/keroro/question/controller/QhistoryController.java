package org.keroro.question.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.question.dao.QuestionDAO;
import org.keroro.question.dto.QhistoryDTO;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/myhistory/*")
public class QhistoryController extends MultiController{	
	private static final long serialVersionUID = 1L;
	@Default
	private QuestionDAO dao = new QuestionDAO();
	
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		
		int page = getInt(request, 1, "page");
		int perSheet = getInt(request, 10, "perSheet");
		String mid = request.getParameter("mid");
		// test mid
		mid = "hj";
		

		PageInfo info = new PageInfo();
		info.setPage(page);
		info.setPerSheet(perSheet);

		log.info("qhistory listGET PageInfo : " + info);

		PageMaker pageMaker = new PageMaker(info, dao.getTotalOfMyHistory(mid));
		
		List<QhistoryDTO> list = dao.getPageListOfMyHistory(mid, info);
		
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("list", list);
		
		return "myhistory/list";
	}
	
	
	
}
