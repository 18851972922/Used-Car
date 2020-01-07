package com.jssnu.UCMS;

import javax.swing.*;

import com.jssnu.headpage.HeadPage;
import com.jssnu.login.LoginDialog;
import com.jssnu.yonghuzhongxin.ShouCang;


public class MainFrame extends JFrame {// 主窗体
	private static final long serialVersionUID = 1L;
	

	/**
	 * 程序主方法，运行程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame login = new LoginDialog();// 登录窗体
		login.setVisible(true);// 使登录窗体可见
//		JFrame gujia = new GuJia();// 估价窗体
//		gujia.setVisible(true);// 使估价窗体可见
//		JFrame buycar = new Buycar();
//		buycar.setVisible(true);
//		JFrame page = new HeadPage();
//		page.setVisible(true);
//		JFrame xinshou = new XinShou();
//		xinshou.setVisible(true);
//		JFrame shoucang = new ShouCang();// 用户中心窗体
//		shoucang.setVisible(true);// 使用户中心窗体可见
//		JFrame maichefabu = new Maichefabu();
//		maichefabu.setVisible(true);
	}
	

	
	public MainFrame() {// 缺省构造函数
		super();// 调用父类JFrame的构造器
		initialize();// 初始化主窗体的方法
	}

	private void initialize() {// 初始化主窗体的方法
		this.setSize(600, 400);// 设置主窗体的宽高
		this.setTitle("二手车管理系统");// 设置窗体的题目
	}

	
}