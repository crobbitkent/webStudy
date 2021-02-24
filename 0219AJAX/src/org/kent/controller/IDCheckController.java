package org.kent.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/api/idcheck")
public class IDCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IDCheckController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("tempId");
		System.out.println(id);
		
		// 다시 응답 메시지 보내기
		// 텍스트, xml, json
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("result", "Success");
		
		
		// 날짜 추가
		Date now = new Date();
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String nowStr = format2.format(now);	
		resultMap.put("time", nowStr);
		
		// gson 설정
		Gson gson = new Gson();
		String jsonStr = gson.toJson(resultMap);
		System.out.println(jsonStr);
		
		// 다시 보내기
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().println(jsonStr);
		
	}

}
