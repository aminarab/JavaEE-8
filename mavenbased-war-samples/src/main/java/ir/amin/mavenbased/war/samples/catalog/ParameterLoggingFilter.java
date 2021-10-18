package ir.amin.mavenbased.war.samples.catalog;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ParameterLoggingFilter
 */
@WebFilter("/*")
public class ParameterLoggingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ParameterLoggingFilter() {
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
		System.out.println("From ParameterLoggingFilter : ");
		request.getParameterMap().entrySet().stream().forEach(entry ->{
			System.out.println(String.format("%s:%s", entry.getKey(), entry.getValue()[0]));
		});
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println( "filterConfig.getInitParameter() : " + filterConfig.getInitParameter("timeout"));
		System.out.println("filterConfig.getServletContext().getInitParameter() : " +filterConfig.getServletContext().getInitParameter("timeout"));
	}

}
