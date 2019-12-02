package com.mingrisoft.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class test {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		BaseDao.open();
		BaseDao bd=new BaseDao();
		boolean b1 = false;
		String sql = "SELECT * FROM sheet1 WHERE price<4 and milge>6";
		ResultSet rs=bd.query(sql);
		while(rs.next()) {	//相当于迭代器循环。判断是否存在，当存在时调用getString();方法得到值。
			String name=rs.getString("name");
			double age=rs.getDouble("age");
			double price=rs.getDouble("price");
			System.out.println(name+" "+age+" "+price);
		}

//		List list=new ArrayList();
//		while(rs.next()) {
//			result res = new result();
//			res.setName(rs.getString("name"));
//			res.setPrice(rs.getDouble("price"));
//			res.setAge(rs.getDouble("age"));
//			res.setMilge(rs.getDouble("milge"));
//			res.setMession(rs.getInt("mession"));
//			list.add(res);}
//		for(int i=0; i<list.size(); i++)
//		{ Result res = (Result) list.get(i);}
		
		}
	}

