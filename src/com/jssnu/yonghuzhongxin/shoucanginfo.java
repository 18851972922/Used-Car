package com.jssnu.yonghuzhongxin;

import javax.swing.JTextField;

public class shoucanginfo implements java.io.Serializable {// 收藏信息（实现序列化接口）
	
	
	private String user_id;  //声明用户id
	private JTextField user_id2;  
	private String product1;  //声明收藏商品id
//	private String product2;
//	private String product3;

	public shoucanginfo() {// 缺省构造函数
	}

	

	public shoucanginfo(String user_id,JTextField user_id2,String product1) {// 完整构造函数
		
		this.user_id2 = user_id2;
		this.user_id = user_id;
		this.product1 = product1;
//		this.product2 = product2;
//		this.product3 = product3;
	}
	// 使用Getters and Setters方法将收藏信息类的私有属性封装起来
	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String string) {
		this.user_id = string;
	}

	public String getProduct1() {
		return product1;
	}

	public void setProduct1(String string) {
		this.product1 = string;
	}

//	public String getProduct2() {
//		return product2;
//	}
//
//	public void setProduct2(String string) {
//		this.product2 = string;
//	}
//
//	public String getProduct3() {
//		return product3;
//	}
//
//	public void setProduct3(String string) {
//		this.product3 = string;
//	}



	public void setUser_id(JTextField user_id2) {
		// TODO Auto-generated method stub
		this.user_id2 = user_id2;
	}



	
	


}