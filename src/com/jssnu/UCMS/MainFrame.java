package com.jssnu.UCMS;

import javax.swing.*;

import com.jssnu.headpage.HeadPage;
import com.jssnu.login.LoginDialog;
import com.jssnu.yonghuzhongxin.ShouCang;


public class MainFrame extends JFrame {// ������
	private static final long serialVersionUID = 1L;
	

	/**
	 * ���������������г�������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame login = new LoginDialog();// ��¼����
		login.setVisible(true);// ʹ��¼����ɼ�
//		JFrame gujia = new GuJia();// ���۴���
//		gujia.setVisible(true);// ʹ���۴���ɼ�
//		JFrame buycar = new Buycar();
//		buycar.setVisible(true);
//		JFrame page = new HeadPage();
//		page.setVisible(true);
//		JFrame xinshou = new XinShou();
//		xinshou.setVisible(true);
//		JFrame shoucang = new ShouCang();// �û����Ĵ���
//		shoucang.setVisible(true);// ʹ�û����Ĵ���ɼ�
//		JFrame maichefabu = new Maichefabu();
//		maichefabu.setVisible(true);
	}
	

	
	public MainFrame() {// ȱʡ���캯��
		super();// ���ø���JFrame�Ĺ�����
		initialize();// ��ʼ��������ķ���
	}

	private void initialize() {// ��ʼ��������ķ���
		this.setSize(600, 400);// ����������Ŀ��
		this.setTitle("���ֳ�����ϵͳ");// ���ô������Ŀ
	}

	
}