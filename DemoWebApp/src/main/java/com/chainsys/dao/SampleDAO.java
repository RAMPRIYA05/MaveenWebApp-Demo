package com.chainsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Demo;



public interface SampleDAO {
   public void insert(Demo demo) throws ClassNotFoundException, SQLException;
   public List<Demo> readForm(Demo demo) throws ClassNotFoundException, SQLException;
   public void update(Demo demo) throws ClassNotFoundException, SQLException;
   public void deleteForm(Demo demo) throws ClassNotFoundException, SQLException;
}
