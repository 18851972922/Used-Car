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

public class LoginDialog extends JFrame {// 登录窗体
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// 登录面板
	private JLabel jLabel = null;// “用户名”标签
	private JTextField userField = null;// “用户名”文本框
	private JLabel jLabel1 = null;// “密码”标签
	private JPasswordField passwordField = null;// “密码”文本框
	private JButton loginButton = null;// “登录”按钮
	private JButton exitButton = null;// “退出”按钮
	private static String userStr;// “用户名”文本框中的内容
    private MainFrame mainFrame;// 主窗体

	public LoginDialog() {// 登录窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getUserStr() {// 获得“用户名”文本框中的内容
		return userStr;// 返回“用户名”文本框中的内容
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public static void setUserStr(String userStr) {
		LoginDialog.userStr = userStr;
	}

	private LoginPanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (loginPanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “密码”标签
			jLabel1.setBounds(new Rectangle(80,330, 56, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("密码：");// 设置“密码”标签的文本内容
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("用户名：");// 设置“用户名”标签的文本内容
			jLabel.setBounds(new Rectangle(70, 270, 80, 38));// 设置“用户名”标签的位置与宽高
			loginPanel = new LoginPanel();// 登录面板
			loginPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			loginPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			loginPanel.add(getUserField(), null);// 把“用户名”文本框置于登录面板中
			loginPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中
			loginPanel.add(getPasswordField(), null);// 把“密码”文本框置于登录面板中
			loginPanel.add(getloginButton(), null);// 把“退出”按钮置于登录面板中
			loginPanel.add(getExitButton(), null);// 把“退出”按钮置于登录面板中
		}
		return loginPanel;// 返回登录面板
	}

	
	
	private JButton getExitButton() {// 初始化“退出”按钮
		if (exitButton == null) {// “退出”按钮对象为空时
			exitButton = new JButton();// 实例化“退出”按钮
			exitButton.setBounds(new Rectangle(240, 380, 48, 20));// 设置“退出”按钮的位置和宽高
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/zhuce.PNG")));// 设置“退出”按钮的图标
			exitButton.addActionListener(new ActionListener() {// 为“退出”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					JFrame page = new Register();
					page.setVisible(true);
					setVisible(false);
				
				}
			});
		}
		return exitButton;// 返回“退出”按钮
	}
	
	
	private JTextField getUserField() {// 初始化“用户名”文本框
		if (userField == null) {// “用户名”文本框对象为空时
			userField = new JTextField();// 实例化“用户名”文本框
			userField.setBounds(new Rectangle(130, 280, 127, 22));// 设置“用户名”文本框的位置和宽高
		}
		return userField;// 返回“用户名”文本框
	}

	private JPasswordField getPasswordField() {// 初始化“密码”文本框
		if (passwordField == null) {// “密码”文本框对象为空时
			passwordField = new JPasswordField();// 实例化“密码”文本框
			passwordField.setBounds(new Rectangle(130, 330, 127, 22));// 设置“密码”文本框的位置和宽高
			passwordField.addKeyListener(new KeyAdapter() {// 为“密码”文本框添加键盘时间的监听
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// 按下的按键是回车时
						loginButton.doClick();// “登录”按钮执行点击事件
				}
			});
		}
		return passwordField;// 返回“密码”文本框
	}

	private JButton getloginButton() {// 初始化“登录”按钮
		if (loginButton == null) {// “登录”按钮对象为空时
			loginButton = new JButton();// 实例化“登录”按钮
			loginButton.setBounds(new Rectangle(80, 380, 48, 20));// 设置“登录”按钮的位置和宽高
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/denglu.PNG")));// 设置“登录”按钮的图标
			loginButton.addActionListener(new ActionListener() {// 为“登录”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
				if(loginButton == e.getSource()) {
					try {
					BaseDao.open();
					BaseDao bd=new BaseDao();
					
					String userStr=userField.getText();//提取用户名文本框中的内容
					String passwordStr = new String(passwordField.getPassword());//提取密码文本框的内容/	
					String sql = "SELECT * FROM yonghu_information where user=\""+userStr+"\"";
					ResultSet rs=bd.query(sql);
					while(rs.next()) {	//相当于迭代器循环。判断是否存在，当存在时调用getString();方法得到值
						String password=rs.getString("password");			
						System.out.println(password);
						if(password.equals(passwordStr)) {
							JFrame page = new HeadPage();
							page.setVisible(true);
							setVisible(false);
							break;							
						}
						else {
							JOptionPane.showMessageDialog(LoginDialog.this, "密码错误", "提示",JOptionPane.WARNING_MESSAGE);// 弹出提示框
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
	return loginButton;// 返回“退出”按钮
}

	

	
	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置登录窗体
		setSize(380, 500);// 设置登录窗体的宽高
		this.setTitle("二手车系统登录");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}

	

	
}
	
