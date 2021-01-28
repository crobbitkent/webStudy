package org.keroro.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LanguageFilter
 */
@WebFilter("/*")
public class LanguageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LanguageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// test
		System.out.println("--------------------FILTER ON-----------------------");
		
		// request setCaracterSet 은 post에만 작동
		// get방식도 한글 전환이 필요
		HttpServletRequest req = (HttpServletRequest)request; 
		
		if (req.getMethod().equals("POST")) {
			req.setCharacterEncoding("UTF-8");
		}
		
		// pass the request along the filter chain
		// 다음 필터가 있으면 다음 필터가 가고
		// 없으면 다음으로 보낸다.
		chain.doFilter(request, response);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
