package com.jssnu.cheliangxinxi;


import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Maichepanel extends JPanel {// �������

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width, height;// ���Ŀ��
	private Image img;// ���ı���ͼƬ

	public Maichepanel() {// ���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		URL url = getClass().getResource("/res/cheliangfabu.jpg");// �����屳��ͼƬ��·��
		img = new ImageIcon(url).getImage();// ������ı���ͼƬ
	}

	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(img, 0, 0, this);// ����ͼƬ
	}

}
