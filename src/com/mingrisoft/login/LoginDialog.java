package com.mingrisoft.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mingrisoft.*;

public class LoginDialog extends JFrame {// ��¼����
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// ��¼���
	private JLabel jLabel = null;// ���û�������ǩ
	private JTextField userField = null;// ���û������ı���
	private JLabel jLabel1 = null;// �����롱��ǩ
	private JPasswordField passwordField = null;// �����롱�ı���
	private JButton loginButton = null;// ����¼����ť
	private JButton exitButton = null;// ���˳�����ť
	private static String userStr;// ���û������ı����е�����
    private MainFrame mainFrame;// ������

	public LoginDialog() {// ��¼����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (loginPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// ���á����롱��ǩ��λ�������
			jLabel1.setText("�ܡ��룺");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// ���á��û�������ǩ��λ�������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			loginPanel.add(getPasswordField(), null);// �ѡ����롱�ı������ڵ�¼�����
			
			loginPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return loginPanel;// ���ص�¼���
	}

	private JTextField getUserField() {// ��ʼ�����û������ı���
		if (userField == null) {// ���û������ı������Ϊ��ʱ
			userField = new JTextField();// ʵ�������û������ı���
			userField.setBounds(new Rectangle(142, 39, 127, 22));// ���á��û������ı����λ�úͿ���
		}
		return userField;// ���ء��û������ı���
	}

	private JPasswordField getPasswordField() {// ��ʼ�������롱�ı���
		if (passwordField == null) {// �����롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));// ���á����롱�ı����λ�úͿ���
			passwordField.addKeyListener(new KeyAdapter() {// Ϊ�����롱�ı������Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}
		return passwordField;// ���ء����롱�ı���
	}

	
	private JButton getExitButton() {// ��ʼ�����˳�����ť
		if (exitButton == null) {// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));// ���á��˳�����ť��λ�úͿ���
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return exitButton;// ���ء��˳�����ť
	}

	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// ���õ�¼����
		setSize(296, 188);// ���õ�¼����Ŀ���
		this.setTitle("ϵͳ��¼");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}

	public String getUserStr() {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����
	}

}