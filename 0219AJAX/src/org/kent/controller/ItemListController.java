package org.kent.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.domain.Item;
import org.kent.domain.Store;

import com.google.gson.Gson;


@WebServlet("/api/itemlist")
public class ItemListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// mime type : json
		// 1. arrayList에 store 담고 json 문자열로 만들고 확인
		// 2. mime type 붙이고 응답 메시지로 보내기, 브라우저에서 확인
		// 3. filter 설정, AJAX로 호출 가능
		// 4. WebStorm에서 버튼에서 누르면 보이도록 설정
		
		// 1단계 시작...
		List<Item> itemList = new ArrayList<>();
		
		itemList.add(Item.builder().num(0).name("메뉴1").img("hu2.jpg").price(4000).build());
		itemList.add(Item.builder().num(1).name("메뉴2").img("hu3.jpg").price(5500).build());
		itemList.add(Item.builder().num(2).name("메뉴3").img("hu4.jpg").price(6000).build());
		itemList.add(Item.builder().num(3).name("메뉴4").img("hu5.jpg").price(4200).build());
		itemList.add(Item.builder().num(4).name("메뉴5").img("hu6.jpg").price(7400).build());

		Gson gson = new Gson();
		String jsonString = gson.toJson(itemList);
		
		System.out.println(jsonString);
		
		// 브라우저에서 보여주는 단계
		// 1. mime type, UTF-8
		response.setContentType("application/json; charset=UTF-8");
		// 2. respose로 밀어주기
		response.getWriter().println(jsonString);
		
	}



}
