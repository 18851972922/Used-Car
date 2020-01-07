package com.jssnu.dao.model;

import com.jssnu.cheliangxinxi.Maichefabu;

public class UCMSspinfo implements java.io.Serializable {// 商品信息（实现序列化接口）

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String product_id;// 商品编号
	private String biaoti;// 车型
	private String age;// 车龄
	private String price;//价格
	private String combo;// 变速箱
	private String mileage;// 里程
	private String city;// 城市
	private String phone;// 联系方式
	
	// 使用Getters and Setters方法将商品信息类的私有属性封装起来
	public UCMSspinfo() {
	}
	
	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCmobo() {
		return combo;
	}
	public void setCmobo(String cmobo) {
		this.combo = cmobo;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int hashCode() {// 重写hashCode方法
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = PRIME * result + ((biaoti == null) ? 0 : biaoti.hashCode());
		result = PRIME * result + ((age == null) ? 0 : age.hashCode());
		result = PRIME * result + ((price == null) ? 0 : price.hashCode());
		result = PRIME * result + ((combo == null) ? 0 : combo.hashCode());
		result = PRIME * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = PRIME * result + ((city == null) ? 0 : city.hashCode());
		result = PRIME * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}



}
	

