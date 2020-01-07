package com.jssnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jssnu.dao.model.UCMSspinfo;


public class BaseDao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/tb_usedcar?useUnicode=true&characterEncoding=UTF-8";
	private static final String UNAME = "sh123456";
	private static final String PWD = "123456";
	private static Connection con = null;
	private static ResultSet rs = null;	
	private static PreparedStatement ps = null;
		
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//閼惧嘲褰囨潻鐐村复
	public static void open(){
		try {
			con = DriverManager.getConnection(URL, UNAME, PWD);
			if (null==con) {
				System.out.println("failed");
			}else {
				System.out.println("success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int update(String sql, Object... params){    //澧炲姞鍒犻櫎
		int count=0;

		try {
			open();
			ps = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			count = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			count=-1;
		}finally{
			close();
		}
		return count;		
	}

	public static ResultSet query(String sql, Object... params){   //鏌ヨ鏁版嵁

		try {
			open();
			ps = con.prepareStatement(sql);
	
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//2.5 閹笛嗩攽
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;		
	}

	public static void close(){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

//	// 条件查询后获得的结果集
//	public static ResultSet findForResultSet(String sql) {
//		if (con == null)
//			return null;
//		long time = System.currentTimeMillis();
//		ResultSet rs = null;
//		try {
//			Statement stmt = null;
//			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = stmt.executeQuery(sql);
//			second = ((System.currentTimeMillis() - time) / 1000d) + "";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public static ResultSet query(String QueryStr) {
//		ResultSet set = findForResultSet(QueryStr);
//		return set;
//	}


	public static boolean addSp(UCMSspinfo spInfo) {
		// TODO Auto-generated method stub
		if (spInfo == null)
			return false;
		return insert("insert into cars_message(Product_id, name, price, age,miles,comboBox,city,phone) values('"+spInfo.getProduct_id() + "','" + 
				 spInfo.getBiaoti() + "','" + spInfo.getPrice() + "','" + 
				 spInfo.getAge() + "','" + spInfo.getMileage()  + "','"+ 
			 spInfo.getCmobo()+ "','"+ spInfo.getCity() + "','" + 
			 spInfo.getPhone() + "')");

//		System.out.println(insert);
		
	}

 //添加数据
public static boolean insert(String sql) {
	boolean result = false;
	try {
		Statement stmt = con.createStatement();
		result = stmt.execute(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
}

// 更新数据
public static int update(String sql) {
	int result = 0;
	try {
		Statement stmt = con.createStatement();
		result = stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
}}

