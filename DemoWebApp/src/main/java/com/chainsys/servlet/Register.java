package com.chainsys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.Sample;
import com.chainsys.model.Demo;

import com.chainsys.util.JDBCConnection;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Demo demo=new Demo();
  
    public Register() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		
		demo.setName(name);
		demo.setEmailId(emailId);
		demo.setPassword(password);
		 try {
			 Sample sample=new Sample();
			sample.insert(demo);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 try {
			 List<Demo> list = new ArrayList<>();
				Sample sample=new Sample();
				list=sample.readForm(demo);
				request.setAttribute("list", list);
			    request.getRequestDispatcher("SampleTable.jsp").forward(request, response);

				}
				catch(ClassNotFoundException | SQLException e) {
					
				e.printStackTrace();
				}
								
		 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Demo> list = new ArrayList<>();
//		try {
//			Sample sample=new Sample();
//			list=sample.readForm(demo);	
//		}
//		catch (ClassNotFoundException | SQLException e) {
//
//			e.printStackTrace();
//		}
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("SampleTable.jsp").forward(request, response);
	}

}
