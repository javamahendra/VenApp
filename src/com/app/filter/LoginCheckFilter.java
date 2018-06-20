package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCheckFilter implements Filter {
	private List<String> avoidUrls=null;
	
	
    public void init(FilterConfig fConfig) throws ServletException {
    	String urls=fConfig.getInitParameter("avoid-urls");
    	StringTokenizer st=new StringTokenizer(urls, ",");
    	avoidUrls=new ArrayList<String>();
    	while(st.hasMoreTokens()){
    		avoidUrls.add(st.nextToken());
    	}
    	
    }
    public void doFilter(ServletRequest request, ServletResponse response,
    		FilterChain arg2) throws IOException, ServletException {
    	HttpServletRequest req=(HttpServletRequest)request;
    	HttpServletResponse res=(HttpServletResponse)response;
    	
    	res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		res.setHeader("Pragma", "no-cache");	
		res.setDateHeader("Expires", 0); 
    	
    	String rp=req.getRequestURI();
    	System.out.println(rp);
    	boolean flag=avoidUrls.contains(rp);
    	try {
			if(!flag){
				HttpSession ses=req.getSession(false);
				if(ses==null || ses.getAttribute("userName")==null)
					res.sendRedirect(req.getContextPath()+"/mvc/login");
					
			}
    		
		} catch (Exception e) {	}
    	
    	arg2.doFilter(request, response);
    }
    
    public void destroy() {
    	
    }
  
	

}



