package com.mingrisoft;

import javax.swing.*;

import com.mingrisoft.login.LoginDialog;

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
	}

	
	public MainFrame() {// ȱʡ���캯��
		super();// ���ø���JFrame�Ĺ�����
		initialize();// ��ʼ��������ķ���
	}

	private void initialize() {// ��ʼ��������ķ���
		this.setSize(800, 600);// ����������Ŀ��
		this.setTitle("��̩��ҵ���������ϵͳ");// ���ô������Ŀ
	}

	
}