package com.jssnu.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.dao.BaseDao;
import com.jssnu.headpage.HeadPage;
import com.jssnu.login.Register;

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
	public String getUserStr() {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public static void setUserStr(String userStr) {
		LoginDialog.userStr = userStr;
	}

	private LoginPanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (loginPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(80,330, 56, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("���룺");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(70, 270, 80, 38));// ���á��û�������ǩ��λ������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			loginPanel.add(getPasswordField(), null);// �ѡ����롱�ı������ڵ�¼�����
			loginPanel.add(getloginButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
			loginPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return loginPanel;// ���ص�¼���
	}

	
	
	private JButton getExitButton() {// ��ʼ�����˳�����ť
		if (exitButton == null) {// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(240, 380, 48, 20));// ���á��˳�����ť��λ�úͿ��
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/zhuce.PNG")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					JFrame page = new Register();
					page.setVisible(true);
					setVisible(false);
				
				}
			});
		}
		return exitButton;// ���ء��˳�����ť
	}
	
	
	private JTextField getUserField() {// ��ʼ�����û������ı���
		if (userField == null) {// ���û������ı������Ϊ��ʱ
			userField = new JTextField();// ʵ�������û������ı���
			userField.setBounds(new Rectangle(130, 280, 127, 22));// ���á��û������ı����λ�úͿ��
		}
		return userField;// ���ء��û������ı���
	}

	private JPasswordField getPasswordField() {// ��ʼ�������롱�ı���
		if (passwordField == null) {// �����롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(130, 330, 127, 22));// ���á����롱�ı����λ�úͿ��
			passwordField.addKeyListener(new KeyAdapter() {// Ϊ�����롱�ı�����Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}
		return passwordField;// ���ء����롱�ı���
	}

	private JButton getloginButton() {// ��ʼ������¼����ť
		if (loginButton == null) {// ����¼����ť����Ϊ��ʱ
			loginButton = new JButton();// ʵ��������¼����ť
			loginButton.setBounds(new Rectangle(80, 380, 48, 20));// ���á���¼����ť��λ�úͿ��
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/denglu.PNG")));// ���á���¼����ť��ͼ��
			loginButton.addActionListener(new ActionListener() {// Ϊ����¼����ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
				if(loginButton == e.getSource()) {
					try {
					BaseDao.open();
					BaseDao bd=new BaseDao();
					
					String userStr=userField.getText();//��ȡ�û����ı����е�����
					String passwordStr = new String(passwordField.getPassword());//��ȡ�����ı��������/	
					String sql = "SELECT * FROM yonghu_information where user=\""+userStr+"\"";
					ResultSet rs=bd.query(sql);
					while(rs.next()) {	//�൱�ڵ�����ѭ�����ж��Ƿ���ڣ�������ʱ����getString();�����õ�ֵ
						String password=rs.getString("password");			
						System.out.println(password);
						if(password.equals(passwordStr)) {
							JFrame page = new HeadPage();
							page.setVisible(true);
							setVisible(false);
							break;							
						}
						else {
							JOptionPane.showMessageDialog(LoginDialog.this, "�������", "��ʾ",JOptionPane.WARNING_MESSAGE);// ������ʾ��
							break;
							}							
						}
					
					}
					catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				});
			}
	return loginButton;// ���ء��˳�����ť
}

	

	
	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// ���õ�¼����
		setSize(380, 500);// ���õ�¼����Ŀ��
		this.setTitle("���ֳ�ϵͳ��¼");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}

	

	
}
	
