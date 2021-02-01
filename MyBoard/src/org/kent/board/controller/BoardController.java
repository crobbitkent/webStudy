

package org.kent.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.board.dao.BoardDAO;
import org.kent.board.domain.Board;
import org.kent.common.controller.MultiController;

import lombok.extern.log4j.Log4j;


/**
 * Servlet implementation class SampleController
 */
@Log4j
@WebServlet("/board/*")
public class BoardController extends MultiController {
	private static final long serialVersionUID = 1L;
    
	private BoardDAO boardDAO;
    /**
     * @see MultiController#MultiController()
     */
    public BoardController() {
        super();
        boardDAO = new BoardDAO();
    }

    // 게시판 목록 출력
	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("board listGET"); // log.debug();	

		try {
			List<Board> boards = boardDAO.getAll();

			log.info("boardDAO.getAll()");
			// 이거 들고 가라
			request.setAttribute("boards", boards);
		} catch(Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}
		
		return "board/list";
	}

	public String viewGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("board viewGET");
		try {
			Long bno = Long.parseLong(request.getParameter("bno"));
			Board board = boardDAO.getOne(bno);
			
			log.info("boardDAO.getOne()");
			log.info(bno);
			
			request.setAttribute("board", board);
			request.setAttribute("bno", bno);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error/";
		}	
		
		return "board/view";
	}

	
	public String postGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("board postGET");
		
		return "board/post";
	}
	
	public String postPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("board postPOST");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			Board board = Board.builder().title(title).content(content).writer(writer).build();
			
			boardDAO.insert(board);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/board/list";
	}
	
	
	public String modifyGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("board modifyGET");
		
		String bnoString = request.getParameter("bno");
		
		if (null == bnoString) {
			log.info("board modifyGET : String is null (bno=" + bnoString + ")");
			return "re:/board/list";
		}
		
		Long bno = Long.parseLong(bnoString);
		
		try {
			Board board = boardDAO.getOne(bno);
			request.setAttribute("board", board);
		} catch(Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "board/modify";
	}
	
	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("board postPOST");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			Long bno = Long.parseLong(request.getParameter("bno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			Board board = Board.builder().bno(bno).title(title).content(content).writer(writer).build();
			
			boardDAO.update(board);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/board/list";
	}
	
	
	public String deleteGET(HttpServletRequest request, HttpServletResponse response) {
		log.info("board deleteGET");
		
		try {
			String bnoString = request.getParameter("bno");
			log.info(bnoString);
			if(null == bnoString) {
				return "re:/board/list";
			}			
			
			Long bno = Long.parseLong(bnoString);
		
			Board board = boardDAO.getOne(bno);
			request.setAttribute("board", board);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/delete";
	}
	
	public String deletePOST(HttpServletRequest request, HttpServletResponse response) {
		log.info("board deletePOST");
		
		try {		
			String bnoString = request.getParameter("bno");
			log.info(bnoString);
//			if(null == bnoString) {
//				return "re:/board/list";
//			}			
			
			Long bno = Long.parseLong(bnoString);
					
			boardDAO.delete(bno);

		} catch (Exception e) {
			e.printStackTrace();
			return "re:/error";
		}
		
		return "re:/board/list";
	}
}














