package com.mingrisoft.kankan;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mingrisoft.MainFrame;
import com.mingrisoft.dao.BaseDao;
import com.mingrisoft.headpage.HeadPage;
import com.mingrisoft.gujia.GujiaPanel;


public class XinShou extends JFrame {// 车辆估价窗体
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// 估价面板
	private JLabel jLabel = null;// “车龄”标签
	private JScrollPane scpDemo; //滚动框
	private JTable tabDemo;   //表格模型
	private JButton backButton = null;// “返回”按钮
    private MainFrame mainFrame;// 主窗体
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public XinShou() {// 窗体的构造方法
		try {
			// 设置窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getGujiaPanel()  {// 初始化loginPanel登录面板的方法
		if (gujiaPanel == null) {// 登录面板中没有组件时
			
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("新手上路");// 设置“里程”标签的文本内容
			jLabel.setBounds(new Rectangle(50, 70, 100, 18));// 设置“里程”标签的位置与宽高
			
			gujiaPanel = new GujiaPanel();// 登录面板
			gujiaPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			gujiaPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			gujiaPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			scpDemo = new JScrollPane();   //滚动面板
			scpDemo.setBounds(new Rectangle(50,100,570,350));
			gujiaPanel.add(scpDemo);
			
			gujiaPanel.add(getBackButton(), null);// 把“退出”按钮置于登录面板中
			try {
    		
					BaseDao bd=new BaseDao();
    				String sql = "SELECT * FROM cars_message where price <5 and miles<9 and age<7";
    				ResultSet rs=bd.query(sql);
    				int count = 0;
    				while(rs.next()){
    					count++;
    					System.out.println(count);
    				}
    				rs=bd.query(sql);
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
    				Object[][] info = new Object[count][8];
    				count = 0;
    				while(rs.next()){
    					info[count][0] = rs.getString("id");	
    					info[count][1] = rs.getString("name");
    					info[count][2] = rs.getDouble("age");
    					info[count][3] = rs.getDouble("miles");
    					info[count][4] = rs.getInt("comboBox");
    					info[count][5] = rs.getDouble("price");
    					info[count][6] = rs.getString("city");
    					info[count][7] = rs.getLong("phone");
    					count++;
    				}
			// 定义表头
    				String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
			// 创建JTable
    				tabDemo = new JTable(info,title);
    				tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
    				scpDemo.getViewport().add(tabDemo);
    				}
    		
    	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
    	}
    	}

		return gujiaPanel;// 返回登录面板
	}

	
	
	private JButton getBackButton() {// 初始化“返回首页”按钮
		if (backButton == null) {// “返回”按钮对象为空时
			backButton = new JButton();// 实例化“返回”按钮
			backButton.setBounds(new Rectangle(550,25,60, 20));// 设置“返回”按钮的位置和宽高
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// 设置“返回”按钮的图标
			backButton.addActionListener(new ActionListener() {// 为“返回”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return backButton;// 返回“返回”按钮
	}

	private void initialize() {// 初始化登录窗体
		setLocation(320, 100);
		setSize(700, 550);// 设置登录窗体的宽高
		this.setTitle("新手上路");// 设置登录窗体的标题
		setContentPane(getGujiaPanel());// 将登录面板置于登录窗体中
	}


}
