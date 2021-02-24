package org.kent.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AjaxFilter
 */
@WebFilter(urlPatterns={"/api/*"})
public class AjaxFilter implements Filter {

    public AjaxFilter() {
    }

	public void destroy() {
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		System.out.println("---------------------------- ajax filter on ----------------------------");
		// res.header("Access-Control-Allow-Origin", "*"); // 모든 도메인
		HttpServletResponse res =  (HttpServletResponse)response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "*");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers"
				, "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
		// 근데 안된다... 이미 전에 접속했을 때 캐쉬를 저장했기 때문이다. 갱신이 안된것이다.	
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}



}
