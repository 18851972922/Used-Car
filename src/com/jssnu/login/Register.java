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
	
	private RegisterPanel registerPanel = null; //登陆界面
	
	private JLabel jLabel =null; //“用户名”标签
	private JTextField userField = null;//“用户名”文本框
	
	private JLabel jLabel1 =null; //“输入密码”标签
	private JPasswordField passwordField = null;//“输入密码”文本框
	
	private JLabel jLabel2 =null; //“确认密码”标签
	private JPasswordField passwordField2 = null;//“确认密码”文本框
	
	private JLabel jLabel3 =null; //“邮箱”标签
	private JTextField emailField = null;//“邮箱”文本框
	
	private JLabel jLabel4 =null; //“联系方式”标签
	private JTextField phoneField = null;//“联系方式”文本框
	
	private JLabel jLabel5 =null; //“所在地区”标签
	private JTextField areaField = null;//“所在地区”文本框
	
	private JLabel jLabel6 =null; //“车辆喜好”标签
	private JTextField hobbyField = null;//“车辆喜好”文本框
	
	private static String userStr;// “用户名”文本框中的内容
    private MainFrame mainFrame;// 主窗体
	
    private JButton loginButton = null;// “登录”按钮
	private JButton exitButton = null;// “退出”按钮
    
	public Register() {// 登录窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private RegisterPanel getRegisterPanel() {
		if(registerPanel==null) {
			jLabel = new JLabel();// “用户名”标签
			jLabel.setBounds(new Rectangle(100,70, 100, 18));// 设置“用户名”标签的位置与宽高
			jLabel.setText("*用户名：");// 设置“用户名”标签的文本内容
			
			jLabel1 = new JLabel();// “输入密码”标签
			jLabel1.setText("*输入密码：");// 设置“输入密码”标签的文本内容
			jLabel1.setBounds(new Rectangle(100,120, 100, 18));// 设置“用户名”标签的位置与宽高
			
			jLabel2 = new JLabel();// “确认密码”标签
			jLabel2.setText("*确认密码：");// 设置“确认密码”标签的文本内容
			jLabel2.setBounds(new Rectangle(100,170, 100, 18));// 设置“确认密码”标签的位置与宽高
			
			jLabel3 = new JLabel();// “邮箱”标签
			jLabel3.setText("邮箱：");// 设置“邮箱”标签的文本内容
			jLabel3.setBounds(new Rectangle(120, 220, 100, 18));// 设置“邮箱”标签的位置与宽高
			
			jLabel4 = new JLabel();// “联系方式”标签
			jLabel4.setText("*联系方式：");// 设置“联系方式”标签的文本内容
			jLabel4.setBounds(new Rectangle(100, 270, 100, 18));// 设置“联系方式”标签的位置与宽高
			
			jLabel5 = new JLabel();// “所在地区”标签
			jLabel5.setText("所在地区：");// 设置“所在地区”标签的文本内容
			jLabel5.setBounds(new Rectangle(100, 320, 100, 18));// 设置“所在地区”标签的位置与宽高
			
			jLabel6 = new JLabel();// “车辆爱好”标签
			jLabel6.setText("车辆爱好：");// 设置“车辆爱好”标签的文本内容
			jLabel6.setBounds(new Rectangle(100, 370, 100, 18));// 设置“车辆爱好”标签的位置与宽高
			
			registerPanel = new RegisterPanel();// 登录面板
			registerPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			registerPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			
			registerPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			registerPanel.add(getUserField(), null);// 把“用户名”文本框置于登录面板中
			
			registerPanel.add(jLabel1, null);// 把“输入密码”标签置于登录面板中
			registerPanel.add(getPasswordField(), null);// 把“输入密码”文本框置于登录面板中
			
			registerPanel.add(jLabel2, null);// 把“确认密码”标签置于登录面板中
			registerPanel.add(getPasswordField2(), null);// 把“确认密码”文本框置于登录面板中
			
			registerPanel.add(jLabel3, null);// 把“邮箱”标签置于登录面板中
			registerPanel.add(getEmailField(), null);// 把“邮箱”文本框置于登录面板中
			
			registerPanel.add(jLabel4, null);// 把“联系方式”标签置于登录面板中
			registerPanel.add(getPhoneField(), null);// 把“联系方式”文本框置于登录面板中
			
			registerPanel.add(jLabel5, null);// 把“所在地区”标签置于登录面板中
			registerPanel.add(getAreaField(), null);// 把“所在地区”文本框置于登录面板中
			
			registerPanel.add(jLabel6, null);// 把“车辆喜好”标签置于登录面板中
			registerPanel.add(getHobbyField(), null);// 把“车辆喜好”文本框置于登录面板中
			
			
			registerPanel.add(getloginButton(), null);// 把“退出”按钮置于登录面板中
			registerPanel.add(getExitButton(), null);// 把“退出”按钮置于登录面板中
		
		}
		return registerPanel;// 返回登录面板
	}
	
	
	private JTextField getUserField() {
		if (userField== null) {// “用户名”文本框对象为空时
			userField = new JTextField();// 实例化“用户名”文本框
			userField.setBounds(new Rectangle(180, 70, 127, 22));// 设置“用户名”文本框的位置和宽高
		}
	
		return userField;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {// “输入密码”文本框对象为空时
			passwordField = new JPasswordField();// 实例化“密码”文本框
			passwordField.setBounds(new Rectangle(180, 120, 127, 22));// 设置“输入密码”文本框的位置和宽高
			passwordField.addKeyListener(new KeyAdapter() {// 为“输入密码”文本框添加键盘时间的监听
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// 按下的按键是回车时
						loginButton.doClick();// “登录”按钮执行点击事件
				}
			});
		}

		
		return passwordField;
	}

	private JPasswordField getPasswordField2() {
		if (passwordField2 == null) {// “确认密码”文本框对象为空时
			passwordField2 = new JPasswordField();// 实例化“确认密码”文本框
			passwordField2.setBounds(new Rectangle(180, 170, 127, 22));// 设置“确认密码”文本框的位置和宽高
			passwordField2.addKeyListener(new KeyAdapter() {// 为“密码”文本框添加键盘时间的监听
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// 按下的按键是回车时
						loginButton.doClick();// “登录”按钮执行点击事件
				}
			});
		}
		return passwordField2;
		
	}

	private JTextField getEmailField() {
		if (emailField == null) {// “邮箱”文本框对象为空时
			emailField = new JTextField();// 实例化“邮箱”文本框
			emailField.setBounds(new Rectangle(180, 220, 127, 22));// 设置“邮箱”文本框的位置和宽高
		}

		return emailField;
	}
	private JTextField getPhoneField() {
		if (phoneField == null) {// “联系方式”文本框对象为空时
			phoneField = new JTextField();// 实例化“联系方式”文本框
			phoneField.setBounds(new Rectangle(180, 270, 127, 22));// 设置“联系方式”文本框的位置和宽高
		}
		return phoneField;
	}

	private JTextField getAreaField() {
		if (areaField == null) {// “所在地区”文本框对象为空时
			areaField = new JTextField();// 实例化“所在地区”文本框
			areaField.setBounds(new Rectangle(180, 320, 127, 22));// 设置“所在地区”文本框的位置和宽高
		}
		return areaField;
	}

	private JTextField getHobbyField() {
		if (hobbyField == null) {// “车辆喜好”文本框对象为空时
			hobbyField = new JTextField();// 实例化“车辆喜好”文本框
			hobbyField.setBounds(new Rectangle(180, 370, 127, 22));// 设置“车辆喜好”文本框的位置和宽高
		}
		return hobbyField;
	}

	private JButton getExitButton() {// 初始化“退出”按钮
		if (exitButton == null) {// “退出”按钮对象为空时
			exitButton = new JButton();// 实例化“退出”按钮
			exitButton.setBounds(new Rectangle(295, 450, 48, 20));// 设置“退出”按钮的位置和宽高
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// 设置“退出”按钮的图标
			exitButton.addActionListener(new ActionListener() {// 为“退出”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return exitButton;// 返回“退出”按钮
	}
	
	
	
	
	public void zhuce() {
		String username = userField.getText().trim();  //获取用户名文本框的内容
		String password = new String(passwordField.getPassword()); //获取密码文本框的内容
		String checkpass = new String(passwordField2.getPassword()); //获取确认密码文本框的内容
		String email = emailField.getText().trim(); //获取邮箱文本框的内容
		String phone  = phoneField.getText().trim(); //获取联系方式文本框的内容
		String area = areaField.getText().trim(); //获取地区文本框的内容
		String hobby  = hobbyField.getText().trim(); //获取喜好文本框的内容
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
						zhuce(); //密码校验
					setVisible(false);
					dispose();
					new HeadPage();
					JFrame page = new HeadPage(); //跳转到首页
					page.setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog(Register.this, "注册成功", "提示",JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
					}//跳出弹窗
					else {
						JOptionPane.showMessageDialog(Register.this, "两次输入密码不正确", "提示",JOptionPane.WARNING_MESSAGE);// 弹出提示框
					}
				
					
				}
			});
		}
		return loginButton;
	}

	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置登录窗体
		setSize(500, 570);// 设置登录窗体的宽高
		this.setTitle("二手车系统注册");// 设置登录窗体的标题
		setContentPane(getRegisterPanel());// 将登录面板置于登录窗体中
	}


}



	
	
	
	

