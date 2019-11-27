package car;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class LoginDialog extends JFrame {// 登录窗体
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// 登录面板


	private LoginPanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (loginPanel == null) {// 登录面板中没有组件时
			JLabel jLabel1 = new JLabel();// “密码”标签
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("密　码：");// 设置“密码”标签的文本内容
			JLabel jLabel = new JLabel();// “用户名”标签
			jLabel.setText("用户名：");// 设置“用户名”标签的文本内容
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// 设置“用户名”标签的位置与宽高
			loginPanel = new LoginPanel();// 登录面板
			loginPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			loginPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			loginPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中

		}
		return loginPanel;// 返回登录面板
		
	}
	public static void main(String[] args) {
		JFrame login = new LoginDialog();
		login.setVisible(true);
		login.setSize(600,650);
		}
	}


