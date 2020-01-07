package com.jssnu.login;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel {// ��¼���

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width, height;// ���Ŀ��
	private Image img;// ��¼���ı���ͼƬ

	public RegisterPanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		URL url = getClass().getResource("/res/newback.JPG");// ��õ�¼��屳��ͼƬ��·��
		img = new ImageIcon(url).getImage();// ��õ�¼���ı���ͼƬ
	}

	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(img, 0, 0, this);// ����ͼƬ
	}

}