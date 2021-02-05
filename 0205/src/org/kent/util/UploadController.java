package org.kent.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UploadController
 */
@WebServlet("/upload")
@MultipartConfig(location = "C:\\upload")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// input name 속성 값이 file이다.
		javax.servlet.http.Part filePart = request.getPart("file");
		
		String fileName = filePart.getSubmittedFileName();
		
		// 동일한 이름의 파일이 있는 경우 덮어쓰게 된다.
		// 따라서 1. Long값에 시간을 저장해서 파일 이름에 붙여서 고유한 이름을 만든다.
		// 또는 2. 유효 ID를 생성한다.
		filePart.write(fileName);	
	}
}
