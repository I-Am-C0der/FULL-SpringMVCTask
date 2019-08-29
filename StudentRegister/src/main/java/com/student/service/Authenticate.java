package com.student.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.dao.QueryDao;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter(filterName="Filter", value="/*")
public class Authenticate implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (req.getRequestURI().startsWith("/_ah/") || req.getRequestURI().equals("/loginpage")
				|| req.getRequestURI().equals("/signuppage"))
			chain.doFilter(request, response);
		else {

			if (session != null) {
				String username = (String) session.getAttribute("username");
				String password = (String) session.getAttribute("password");
				System.out.println(username);
				boolean correctCredentials = false;
				correctCredentials = QueryDao.checkCredentials(username, password);

				if (correctCredentials) {
					if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/")
							|| req.getRequestURI().equals("/signup"))
						res.sendRedirect("/home");
					else
						chain.doFilter(request, response);
				} else {
					session.invalidate();
					if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/signup"))
						chain.doFilter(request, response);
					else
						res.sendRedirect("/login");
				}

			} else {

				if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/signup"))
					chain.doFilter(request, response);

			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
