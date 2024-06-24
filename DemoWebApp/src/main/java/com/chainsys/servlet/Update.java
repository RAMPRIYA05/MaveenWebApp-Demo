package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.Sample;
import com.chainsys.model.Demo;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Update() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Demo demo=new Demo();
		String name=request.getParameter("name");
		demo.setName(name);
		String emailId=request.getParameter("emailId");
		demo.setEmailId(emailId);
		String password=request.getParameter("password");
		demo.setPassword(password);
		try {
			Sample sample=new Sample();
		   sample.update(demo);
		}
		catch(ClassNotFoundException | SQLException e){
	    	e.printStackTrace();
	    }
		try {
			Sample sample=new Sample();
			List<Demo> list=new ArrayList<>();
			list=sample.readForm(demo);
			request.setAttribute("list", list);
		    request.getRequestDispatcher("SampleTable.jsp").forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e) {
	          
	           e.printStackTrace();
	       }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sample sample=new Sample();
		Demo demo=new Demo();
		String delete = request.getParameter("delete");
        if(delete != null && delete.equals("Delete"))
        {
        	String emailId=request.getParameter("deleteemailId");
        	demo.setEmailId(emailId);
           
            try 
            {
            	
            	sample.deleteForm(demo);
                System.out.println("Row deleted");
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                e.printStackTrace();
            }
            try 
            {
            	List<Demo> list=new ArrayList<>();
            	list=sample.readForm(demo);
                System.out.println("Displayed successfully..");
                request.setAttribute("list", list);
                request.getRequestDispatcher("SampleTable.jsp").forward(request, response);
            } 
            catch (ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }
           
        }
	}

}
