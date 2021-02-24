package org.kent.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.domain.OrderItem;

import com.google.gson.Gson;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/api/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int orderNum = 0;
	
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str;

		while( (str = br.readLine()) != null ){
			sb.append(str);
		}

		System.out.println(sb.toString());
		Gson gson = new Gson();

		OrderItem[] orderItems = gson.fromJson(sb.toString(), OrderItem[].class);
		
		// 저장한 정보를 DB로 보내기....
		
		System.out.println(Arrays.toString(orderItems));
		
		// 응답 보내기...
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("orderNum", ++orderNum);
		resultMap.put("result", "Success");
		
		// gson 설정
		Gson resGson = new Gson();
		String jsonStr = resGson.toJson(resultMap);
		System.out.println(jsonStr);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().println(jsonStr);
	}
	
	

}
