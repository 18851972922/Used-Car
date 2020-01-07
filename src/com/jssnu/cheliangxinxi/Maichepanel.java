package com.jssnu.cheliangxinxi;


import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Maichepanel extends JPanel {// 背景面板

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width, height;// 面板的宽高
	private Image img;// 面板的背景图片

	public Maichepanel() {// 面板的构造方法
		super();// 调用父类JPanel的构造器
		URL url = getClass().getResource("/res/cheliangfabu.jpg");// 获得面板背景图片的路径
		img = new ImageIcon(url).getImage();// 获得面板的背景图片
	}

	protected void paintComponent(Graphics g) {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(img, 0, 0, this);// 绘制图片
	}

}
