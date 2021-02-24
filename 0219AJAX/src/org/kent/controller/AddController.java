package org.kent.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.domain.OrderItem;

import com.google.gson.Gson;


@WebServlet("/api/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddController() {
        super();
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
		System.out.println(Arrays.toString(orderItems));
	}

}
