package org.keroro.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TempServlet
 */
@WebServlet("/temp")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		
		HttpSession session = request.getSession();
		
		int random = (int)(Math.random() * 10000);
		
		session.setAttribute("captcha", random);
		
		// random 숫자를 베이스로 captcha 이미지 생성
		BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.BLACK);

		Font f = new Font("Gothic", Font.ITALIC, 60);
		g.setFont(f);
		
		g.drawString(""+random, 80, 160);
		
		ImageIO.write(image, "JPEG", os);
		
		// random 숫자를 session 에 넣는다. => jsp로 간다.
		// 사용자가 login 버튼을 누른다.
		// loginAction.jsp로 넘어간다. => value와 입력값을 비교, 통과시킨다.
		// 
		
		// 이미지 프로세싱을 방해하기 위해
		// 그라데이션, 다양한 폰트, 글자색, 위치 조절 추가 
		
		
		// Debug
		System.out.println(random);
	}



}
