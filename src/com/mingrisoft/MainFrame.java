package com.mingrisoft;

import javax.swing.*;

import com.mingrisoft.cheliangxinxi.Maichefabu;
import com.mingrisoft.gujia.GuJia;
import com.mingrisoft.headpage.HeadPage;
import com.mingrisoft.login.LoginDialog;

public class MainFrame extends JFrame {// ������
	private static final long serialVersionUID = 1L;
	

	/**
	 * ���������������г�������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
//		JFrame login = new LoginDialog();// ��¼����
//		login.setVisible(true);// ʹ��¼����ɼ�
//		JFrame gujia = new GuJia();// ��¼����
//		gujia.setVisible(true);// ʹ��¼����ɼ�
		JFrame maiche = new Maichefabu();
		maiche.setVisible(true);
//		JFrame page = new HeadPage();
//		page.setVisible(true);
	}
	

	
	public MainFrame() {// ȱʡ���캯��
		super();// ���ø���JFrame�Ĺ�����
		initialize();// ��ʼ��������ķ���
	}

	private void initialize() {// ��ʼ��������ķ���
		this.setSize(600, 500);// ����������Ŀ��
		this.setTitle("���ֳ�����ϵͳ");// ���ô������Ŀ
	}

	
}