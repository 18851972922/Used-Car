package com.jssnu.login;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel {// 登录面板

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width, height;// 面板的宽高
	private Image img;// 登录面板的背景图片

	public RegisterPanel() {// 登录面板的构造方法
		super();// 调用父类JPanel的构造器
		URL url = getClass().getResource("/res/newback.JPG");// 获得登录面板背景图片的路径
		img = new ImageIcon(url).getImage();// 获得登录面板的背景图片
	}

	protected void paintComponent(Graphics g) {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(img, 0, 0, this);// 绘制图片
	}

}