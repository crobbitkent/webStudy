package org.keroro.qnaboard.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keroro.common.controller.MultiController;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.qnaboard.dao.QnaBoardDAO;
import org.keroro.qnaboard.domain.QnaBoard;
import org.keroro.qnaboard.reply.dao.ReplyDAO;
import org.keroro.qnaboard.reply.domain.Reply;

import lombok.Builder;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/qnaboard/*")
public class QnaBoardController extends MultiController {
	private static final long serialVersionUID = 1L;

	QnaBoardDAO dao = new QnaBoardDAO();
	QnaBoard board = new QnaBoard();
	ReplyDAO replyDAO = new ReplyDAO();
	Reply reply = new Reply();
	
	public String listGET(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {

		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(getInt(req,1,"page"));
		pageInfo.setPerSheet(getInt(req,10,"perSheet"));
		
		board.setState(getInt(req,0,"state"));
		int category = board.getCategory();
		int state = board.getState();
		int total = dao.getTotal(state);
		
		pageInfo.setState(state);
		
		PageMaker pageMaker = new PageMaker(pageInfo, total);
		
		log.info("state:" + pageInfo.getState());
		
		List<QnaBoard> list = dao.getList(pageInfo);
	
		req.setAttribute("state", state);
		req.setAttribute("category", category);
		req.setAttribute("list", list);
		req.setAttribute("pageMaker", pageMaker);
		
		return "qnaboard/list";
	}

	public String viewGET(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		Long bno = getLong(req, 0L,"bno");
		
		QnaBoard board = dao.getOne(bno);
		List<Reply> replyList = replyDAO.getAll(bno);
		
		req.setAttribute("replyList", replyList);
		req.setAttribute("board",board);
		
		return "qnaboard/view";
	}
	
	public String viewPOST(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		Long bno = getLong(req,0L,"bno");
		String mid = req.getParameter("mid");
		String replys = req.getParameter("reply");
		
		Reply reply = Reply.builder()
				.bno(bno)
				.mid(mid)
				.reply(replys)
				.build();
		
		replyDAO.insertReply(reply);
		
		return "re:view?bno="+bno;
	}
	
	public String registerGET(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		return "qnaboard/register";
	}
	public String registerPOST(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		String mid = req.getParameter("mid");
		String title = req.getParameter("title");
		Long qno = getLong(req,0L,"qno");
		String content = req.getParameter("content");
		int category = getInt(req,1,"qno");
		int state = getInt(req,2,"state");
		String aid = req.getParameter("aid");
		QnaBoard board = QnaBoard.builder()
				.mid(mid)
				.qno(qno)
				.title(title)
				.content(content)
				.category(category)
				.state(state)
				.aid(aid)
				.build();
		dao.insertBoard(board);
		return "re:list";
	}
	
	public String removePOST(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		Long bno = getLong(req,0L,"bno");	
		dao.deleteBoard(bno);

		return "re:list";
	}

	public String modifyGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long bno = getLong(req, 0L,"bno");
		QnaBoard board = dao.getOne(bno);
		req.setAttribute("board", board);
		return "qnaboard/modify";
	}

	public String modifyPOST(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long bno = getLong(req,0L, "bno");
		String title = req.getParameter("title");
		Long qno = getLong(req,0L,"qno");
		String content = req.getParameter("content");
		int category = getInt(req,1,"category");
		int state = getInt(req,0,"state");
		QnaBoard board = QnaBoard.builder()
				.bno(bno)
				.qno(qno)
				.title(title)
				.content(content)
				.category(category)
				.state(state)
				.build();
		dao.updateBoard(board);
		
		return "re:view?bno="+bno;
	}

	public String removeReplyPOST(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {
		Long rno = getLong(req, 0L, "rno");	
		Long bno = getLong(req, 0L, "bno");
		replyDAO.deleteReply(rno);

		return "re:view?bno="+bno;
	}
	
	public String acceptAnswerPOST(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {	
		Long bno = getLong(req, 0L, "bno");
		int state = getInt(req, 1, "state");
		QnaBoard board = QnaBoard.builder()
				.bno(bno)
				.state(state)
				.build();
		dao.acceptAnswer(board);
		return "re:view?bno="+bno;
	}
}
