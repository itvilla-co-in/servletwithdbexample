package com.controller;
import javax.servlet.ServletContext; 
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class countofusers
 *
 */
@WebListener
public class countofusers implements HttpSessionListener, HttpSessionAttributeListener {

	 ServletContext ctx=null;  
	    static int total=0,current=0;  
	
    /**
     * Default constructor. 
     */
    public countofusers() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
 
    	
    	
    	    total++;  
    	    current++;  
    	      
    	    ctx=se.getSession().getServletContext();  
    	    ctx.setAttribute("totalusers", total);  
    	    ctx.setAttribute("currentusers", current);  
    	      
    	      	
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	
    	 current--;  
         ctx.setAttribute("currentusers",current);  
         
         
         
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}
