package com.mingrisoft;

import javax.swing.*;

import com.mingrisoft.cheliangxinxi.Maichefabu;
import com.mingrisoft.gujia.GuJia;
import com.mingrisoft.headpage.HeadPage;
import com.mingrisoft.login.LoginDialog;

public class MainFrame extends JFrame {// 主窗体
	private static final long serialVersionUID = 1L;
	

	/**
	 * 程序主方法，运行程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
//		JFrame login = new LoginDialog();// 登录窗体
//		login.setVisible(true);// 使登录窗体可见
//		JFrame gujia = new GuJia();// 登录窗体
//		gujia.setVisible(true);// 使登录窗体可见
		JFrame maiche = new Maichefabu();
		maiche.setVisible(true);
//		JFrame page = new HeadPage();
//		page.setVisible(true);
	}
	

	
	public MainFrame() {// 缺省构造函数
		super();// 调用父类JFrame的构造器
		initialize();// 初始化主窗体的方法
	}

	private void initialize() {// 初始化主窗体的方法
		this.setSize(600, 500);// 设置主窗体的宽高
		this.setTitle("二手车管理系统");// 设置窗体的题目
	}

	
}