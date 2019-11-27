package com.mingrisoft;

import javax.swing.*;

import com.mingrisoft.login.LoginDialog;

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
	}

	
	public MainFrame() {// 缺省构造函数
		super();// 调用父类JFrame的构造器
		initialize();// 初始化主窗体的方法
	}

	private void initialize() {// 初始化主窗体的方法
		this.setSize(800, 600);// 设置主窗体的宽高
		this.setTitle("铭泰企业进销存管理系统");// 设置窗体的题目
	}

	
}