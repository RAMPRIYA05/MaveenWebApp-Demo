package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Demo;
import com.chainsys.util.JDBCConnection;

public class Sample implements SampleDAO {

	@Override
	public void insert(Demo demo) throws ClassNotFoundException, SQLException {
		
			Connection connection=JDBCConnection.getConnection();
			
			
			String register="insert into demo(name,email_id,password)values(?,?,?)";
			PreparedStatement prepareStatement=connection.prepareStatement(register);
			prepareStatement.setString(1,demo.getName());
			prepareStatement.setString(2,demo.getEmailId());
			prepareStatement.setString(3,demo.getPassword());
			prepareStatement.executeUpdate();
			
		
	}

	@Override
	public void update(Demo demo) throws ClassNotFoundException, SQLException {
		Connection connection=JDBCConnection.getConnection();
		String update="update demo set name=? where email_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1,demo.getName());
		prepareStatement.setString(2,demo.getEmailId());
		prepareStatement.executeUpdate();
	}

	@Override
	public List<Demo> readForm(Demo demo) throws ClassNotFoundException, SQLException {
		
		List<Demo> list=new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		try {
		String read="SELECT name,email_id,password from demo";
		PreparedStatement prepareStatement = connection.prepareStatement(read);
        ResultSet rows = prepareStatement.executeQuery();
        while(rows.next())
        {
        	
        	 String name=rows.getString(1);
             String emailId=rows.getString(2);
             String password=rows.getString(3);
             
             
             Demo demo1=new Demo();
          demo1.setName(name);
          demo1.setEmailId(emailId);
          demo1.setPassword(password);
          list.add(demo1);
        }	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
      return list;
	}

	@Override
	public void deleteForm(Demo demo) throws ClassNotFoundException, SQLException {
	
		try {
			Connection connection=JDBCConnection.getConnection();
			String delete="delete from demo where email_id=?";
			PreparedStatement prepareStatement=connection.prepareStatement(delete);
			prepareStatement.setString(1,demo.getEmailId());
			prepareStatement.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		
	

}
