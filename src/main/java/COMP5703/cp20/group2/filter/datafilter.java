package COMP5703.cp20.group2.filter;

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

import org.springframework.http.HttpRequest;

@WebFilter(filterName="dataFilter", urlPatterns="/chartdata/*")
public  class datafilter implements Filter{
	
	public void init(FilterConfig filterconfig) throws ServletException{
		
	}


	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		if(request.getSession().getAttribute("login")!=null) {
			chain.doFilter(servletrequest, servletresponse);
		}
		else {
			HttpServletResponse newresponse=(HttpServletResponse) servletresponse;
		   newresponse.sendRedirect("/user/login");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
