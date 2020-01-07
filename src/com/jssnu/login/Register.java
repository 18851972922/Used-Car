package com.jssnu.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

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
import com.jssnu.login.LoginDialog;



public class Register extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private RegisterPanel registerPanel = null; //��½����
	
	private JLabel jLabel =null; //���û�������ǩ
	private JTextField userField = null;//���û������ı���
	
	private JLabel jLabel1 =null; //���������롱��ǩ
	private JPasswordField passwordField = null;//���������롱�ı���
	
	private JLabel jLabel2 =null; //��ȷ�����롱��ǩ
	private JPasswordField passwordField2 = null;//��ȷ�����롱�ı���
	
	private JLabel jLabel3 =null; //�����䡱��ǩ
	private JTextField emailField = null;//�����䡱�ı���
	
	private JLabel jLabel4 =null; //����ϵ��ʽ����ǩ
	private JTextField phoneField = null;//����ϵ��ʽ���ı���
	
	private JLabel jLabel5 =null; //�����ڵ�������ǩ
	private JTextField areaField = null;//�����ڵ������ı���
	
	private JLabel jLabel6 =null; //������ϲ�á���ǩ
	private JTextField hobbyField = null;//������ϲ�á��ı���
	
	private static String userStr;// ���û������ı����е�����
    private MainFrame mainFrame;// ������
	
    private JButton loginButton = null;// ����¼����ť
	private JButton exitButton = null;// ���˳�����ť
    
	public Register() {// ��¼����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private RegisterPanel getRegisterPanel() {
		if(registerPanel==null) {
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setBounds(new Rectangle(100,70, 100, 18));// ���á��û�������ǩ��λ������
			jLabel.setText("*�û�����");// ���á��û�������ǩ���ı�����
			
			jLabel1 = new JLabel();// ���������롱��ǩ
			jLabel1.setText("*�������룺");// ���á��������롱��ǩ���ı�����
			jLabel1.setBounds(new Rectangle(100,120, 100, 18));// ���á��û�������ǩ��λ������
			
			jLabel2 = new JLabel();// ��ȷ�����롱��ǩ
			jLabel2.setText("*ȷ�����룺");// ���á�ȷ�����롱��ǩ���ı�����
			jLabel2.setBounds(new Rectangle(100,170, 100, 18));// ���á�ȷ�����롱��ǩ��λ������
			
			jLabel3 = new JLabel();// �����䡱��ǩ
			jLabel3.setText("���䣺");// ���á����䡱��ǩ���ı�����
			jLabel3.setBounds(new Rectangle(120, 220, 100, 18));// ���á����䡱��ǩ��λ������
			
			jLabel4 = new JLabel();// ����ϵ��ʽ����ǩ
			jLabel4.setText("*��ϵ��ʽ��");// ���á���ϵ��ʽ����ǩ���ı�����
			jLabel4.setBounds(new Rectangle(100, 270, 100, 18));// ���á���ϵ��ʽ����ǩ��λ������
			
			jLabel5 = new JLabel();// �����ڵ�������ǩ
			jLabel5.setText("���ڵ�����");// ���á����ڵ�������ǩ���ı�����
			jLabel5.setBounds(new Rectangle(100, 320, 100, 18));// ���á����ڵ�������ǩ��λ������
			
			jLabel6 = new JLabel();// ���������á���ǩ
			jLabel6.setText("�������ã�");// ���á��������á���ǩ���ı�����
			jLabel6.setBounds(new Rectangle(100, 370, 100, 18));// ���á��������á���ǩ��λ������
			
			registerPanel = new RegisterPanel();// ��¼���
			registerPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			registerPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			
			registerPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			registerPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			
			registerPanel.add(jLabel1, null);// �ѡ��������롱��ǩ���ڵ�¼�����
			registerPanel.add(getPasswordField(), null);// �ѡ��������롱�ı������ڵ�¼�����
			
			registerPanel.add(jLabel2, null);// �ѡ�ȷ�����롱��ǩ���ڵ�¼�����
			registerPanel.add(getPasswordField2(), null);// �ѡ�ȷ�����롱�ı������ڵ�¼�����
			
			registerPanel.add(jLabel3, null);// �ѡ����䡱��ǩ���ڵ�¼�����
			registerPanel.add(getEmailField(), null);// �ѡ����䡱�ı������ڵ�¼�����
			
			registerPanel.add(jLabel4, null);// �ѡ���ϵ��ʽ����ǩ���ڵ�¼�����
			registerPanel.add(getPhoneField(), null);// �ѡ���ϵ��ʽ���ı������ڵ�¼�����
			
			registerPanel.add(jLabel5, null);// �ѡ����ڵ�������ǩ���ڵ�¼�����
			registerPanel.add(getAreaField(), null);// �ѡ����ڵ������ı������ڵ�¼�����
			
			registerPanel.add(jLabel6, null);// �ѡ�����ϲ�á���ǩ���ڵ�¼�����
			registerPanel.add(getHobbyField(), null);// �ѡ�����ϲ�á��ı������ڵ�¼�����
			
			
			registerPanel.add(getloginButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
			registerPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		
		}
		return registerPanel;// ���ص�¼���
	}
	
	
	private JTextField getUserField() {
		if (userField== null) {// ���û������ı������Ϊ��ʱ
			userField = new JTextField();// ʵ�������û������ı���
			userField.setBounds(new Rectangle(180, 70, 127, 22));// ���á��û������ı����λ�úͿ��
		}
	
		return userField;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {// ���������롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(180, 120, 127, 22));// ���á��������롱�ı����λ�úͿ��
			passwordField.addKeyListener(new KeyAdapter() {// Ϊ���������롱�ı�����Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}

		
		return passwordField;
	}

	private JPasswordField getPasswordField2() {
		if (passwordField2 == null) {// ��ȷ�����롱�ı������Ϊ��ʱ
			passwordField2 = new JPasswordField();// ʵ������ȷ�����롱�ı���
			passwordField2.setBounds(new Rectangle(180, 170, 127, 22));// ���á�ȷ�����롱�ı����λ�úͿ��
			passwordField2.addKeyListener(new KeyAdapter() {// Ϊ�����롱�ı�����Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
			});
		}
		return passwordField2;
		
	}

	private JTextField getEmailField() {
		if (emailField == null) {// �����䡱�ı������Ϊ��ʱ
			emailField = new JTextField();// ʵ���������䡱�ı���
			emailField.setBounds(new Rectangle(180, 220, 127, 22));// ���á����䡱�ı����λ�úͿ��
		}

		return emailField;
	}
	private JTextField getPhoneField() {
		if (phoneField == null) {// ����ϵ��ʽ���ı������Ϊ��ʱ
			phoneField = new JTextField();// ʵ��������ϵ��ʽ���ı���
			phoneField.setBounds(new Rectangle(180, 270, 127, 22));// ���á���ϵ��ʽ���ı����λ�úͿ��
		}
		return phoneField;
	}

	private JTextField getAreaField() {
		if (areaField == null) {// �����ڵ������ı������Ϊ��ʱ
			areaField = new JTextField();// ʵ���������ڵ������ı���
			areaField.setBounds(new Rectangle(180, 320, 127, 22));// ���á����ڵ������ı����λ�úͿ��
		}
		return areaField;
	}

	private JTextField getHobbyField() {
		if (hobbyField == null) {// ������ϲ�á��ı������Ϊ��ʱ
			hobbyField = new JTextField();// ʵ����������ϲ�á��ı���
			hobbyField.setBounds(new Rectangle(180, 370, 127, 22));// ���á�����ϲ�á��ı����λ�úͿ��
		}
		return hobbyField;
	}

	private JButton getExitButton() {// ��ʼ�����˳�����ť
		if (exitButton == null) {// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(295, 450, 48, 20));// ���á��˳�����ť��λ�úͿ��
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return exitButton;// ���ء��˳�����ť
	}
	
	
	
	
	public void zhuce() {
		String username = userField.getText().trim();  //��ȡ�û����ı��������
		String password = new String(passwordField.getPassword()); //��ȡ�����ı��������
		String checkpass = new String(passwordField2.getPassword()); //��ȡȷ�������ı��������
		String email = emailField.getText().trim(); //��ȡ�����ı��������
		String phone  = phoneField.getText().trim(); //��ȡ��ϵ��ʽ�ı��������
		String area = areaField.getText().trim(); //��ȡ�����ı��������
		String hobby  = hobbyField.getText().trim(); //��ȡϲ���ı��������
		String sql = "INSERT INTO yonghu_information (user,password,email,phone,area,hobby) values('"+ username + "','"+ password +"','"+email +"','"+ phone +"','"+area+"','"+ hobby +"')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tb_usedcar?useUnicode=true&characterEncoding=UTF-8","sh123456","123456");
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			BaseDao.close();
		}
	}
	

	private JButton getloginButton() {
		if (loginButton == null) {
			loginButton = new JButton();
			loginButton.setBounds(new Rectangle(80, 450, 48, 20));
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = new String(passwordField.getPassword());
					String checkpass = new String(passwordField2.getPassword());
					if(password.equals(checkpass)) {
						zhuce(); //����У��
					setVisible(false);
					dispose();
					new HeadPage();
					JFrame page = new HeadPage(); //��ת����ҳ
					page.setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog(Register.this, "ע��ɹ�", "��ʾ",JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
					}//��������
					else {
						JOptionPane.showMessageDialog(Register.this, "�����������벻��ȷ", "��ʾ",JOptionPane.WARNING_MESSAGE);// ������ʾ��
					}
				
					
				}
			});
		}
		return loginButton;
	}

	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// ���õ�¼����
		setSize(500, 570);// ���õ�¼����Ŀ��
		this.setTitle("���ֳ�ϵͳע��");// ���õ�¼����ı���
		setContentPane(getRegisterPanel());// ����¼������ڵ�¼������
	}


}



	
	
	
	

