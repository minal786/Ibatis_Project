package com.mybatis.source;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisInsert { 

   public static void main(String args[]) throws IOException{
      
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession();
      
      //Create a new student object
      Student student = new Student("rety","MEC", 90, 98765431, "renu123@gmail.com" ); 
            
      //Insert student data      
      session.insert("Student.insert", student);
      System.out.println("record inserted successfully");
      session.commit();
      session.close();
			
   }
   
}
