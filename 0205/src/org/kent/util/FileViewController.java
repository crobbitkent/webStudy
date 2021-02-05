package org.kent.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.imageio.stream.FileCacheImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FileViewController
 */
@WebServlet("/fileView")
public class FileViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장해둔 파일을 보여준다.
		String fileName = request.getParameter("name");
		File file = new File("C:\\upload\\" + fileName);
		String mimeType = Files.probeContentType(file.toPath());
		
		System.out.println(fileName);
		System.out.println(mimeType);
		
		response.setContentType(mimeType);
		
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		
		while(true) {
			int count = is.read(buffer);		
			if(-1 == count) {
				break;
			}		
			os.write(buffer);
		} // end while
		
		is.close();
		os.close();
	}
}
