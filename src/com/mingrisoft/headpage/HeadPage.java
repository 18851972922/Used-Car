package com.mingrisoft.headpage;

import java.awt.*;
import javax.swing.*;
import com.mingrisoft.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeadPage extends JFrame {// 车辆首页窗体
	private static final long serialVersionUID = 1L;
	private PagePanel pagepanel = null;// 首页面板
	private JButton shouye = null;// “首页”按钮
	private JButton maiche = null;// “卖车”按钮
	private JButton kanche = null;// “卖车”按钮
	private JButton gujia = null;// “汽车估价”按钮
	private JButton yonghu = null;// “用户中心”按钮
	private JButton sousuo = null;// “搜索”按钮
	private JButton woyaokanche = null;// “我要买车”按钮
	private JButton laren = null;// “拉人拉货”按钮
	private JButton xinshou = null;// “新手上路”按钮
	private JButton xinche = null;// “准新车”按钮
	private JButton pianyi = null;// “便宜”按钮
	private JButton woyaomaiche = null;// “我要卖车”按钮
	private JTextField sousuoField = null;// “搜索”文本框
	private JButton aiche = null;// “爱车”文本框
    private MainFrame mainFrame;// 主窗体
    private JLabel jLabel1 = null;// “装饰”标签
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	
	public HeadPage() {// 窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PagePanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (pagepanel == null) {// 登录面板中没有组件时
			pagepanel = new PagePanel();// 登录面板
			jLabel1 = new JLabel();// “装饰”标签
			jLabel1.setBounds(new Rectangle(300,190, 20, 200));// 设置“密码”标签的位置与宽高
			jLabel1.setIcon(new ImageIcon(getClass().getResource("/res/zhuangshi.jpg")));// 设置“买车”按钮的图标
			pagepanel.setLayout(null);// 设置登录面板的布局为绝对布局
			pagepanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			pagepanel.add(jLabel1, null);// 把“用户名”标签置于登录面板中
			pagepanel.add(getshouye(), null);// 把“首页”按钮置于登录面板中
			pagepanel.add(getmaiche(), null);// 把“卖车”按钮置于登录面板中
			pagepanel.add(getkanche(), null);// 把“买车”按钮置于登录面板中
			pagepanel.add(getgujia(), null);// 把“估价”按钮置于登录面板中
			pagepanel.add(getyonghu(), null);// 把“用户”按钮置于登录面板中
			pagepanel.add(getsousuo(), null);// 把“搜索”按钮置于登录面板中
			pagepanel.add(getwoyaokanche(), null);// 把“我要看车”按钮置于登录面板中
			pagepanel.add(getlaren(), null);// 把“拉人”按钮置于登录面板中
			pagepanel.add(getxinshou(), null);// 把“新手”按钮置于登录面板中
			pagepanel.add(getxinche(), null);// 把“新车”按钮置于登录面板中
			pagepanel.add(getpianyi(), null);// 把“便宜”按钮置于登录面板中
			pagepanel.add(getwoyaomaiche(), null);// 把“我要卖车”按钮置于登录面板中
			pagepanel.add(getaiche(), null);// 把“爱车估价”按钮置于登录面板中
			pagepanel.add(getsousuoField(), null);//添加搜索文本框
		}
		return pagepanel;// 返回登录面板
	}


	private JTextField getsousuoField() {// 初始化“搜索”文本框
		if (sousuoField == null) {// “搜索”文本框对象为空时
			sousuoField = new JTextField();// 实例化“搜索”文本框
			sousuoField.setBounds(new Rectangle(120,120, 200, 30));// 设置“搜索”文本框的位置和宽高
		}
		return sousuoField;// 返回“搜索”文本框
	}
	

	private JButton getmaiche() {// 初始化“买车”按钮
		if (maiche == null) {// “买车”按钮对象为空时
			maiche = new JButton();// 实例化“买车”按钮
			maiche.setIcon(new ImageIcon(getClass().getResource("/res/maiche.jpg")));// 设置“买车”按钮的图标
			maiche.setBounds(new Rectangle(270,48, 70, 25));// 设置“买车”按钮的位置和宽高
			maiche.addActionListener(new ActionListener() {// 为“买车”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return maiche;// 返回“买车”按钮
	}
	
	private JButton getkanche() {// 初始化“首页”按钮
		if (kanche == null) {// “确认发布”按钮对象为空时
			kanche = new JButton();// 实例化“确认发布”按钮
			kanche.setBounds(new Rectangle(340,45, 70, 25));// 设置“确认发布”按钮的位置和宽高
			kanche.setIcon(new ImageIcon(getClass().getResource("/res/kanche.jpg")));// 设置“返回”按钮的图标
			kanche.addActionListener(new ActionListener() {// 为“确认发布”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return kanche;// 返回“确认发布”按钮
	}
	
	private JButton getgujia() {// 初始化“首页”按钮
		if (gujia == null) {// “确认发布”按钮对象为空时
			gujia = new JButton();// 实例化“确认发布”按钮
			gujia.setBounds(new Rectangle(410, 50,70, 25));// 设置“确认发布”按钮的位置和宽高
			gujia.setIcon(new ImageIcon(getClass().getResource("/res/gujia.jpg")));// 设置“返回”按钮的图标
			gujia.addActionListener(new ActionListener() {// 为“确认发布”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return gujia;// 返回“确认发布”按钮
	}
	
	private JButton getyonghu() {// 初始化“用户中心”按钮
		if (yonghu == null) {
			yonghu = new JButton();
			yonghu.setBounds(new Rectangle(500, 48, 70, 25));
			yonghu.setIcon(new ImageIcon(getClass().getResource("/res/yonghu.jpg")));
			yonghu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return yonghu;// 返回“确认发布”按钮
	}
	
	private JButton getsousuo() {// 初始化“搜索”按钮
		if (sousuo == null) {
			sousuo = new JButton();
			sousuo.setBounds(new Rectangle(380, 120, 70, 30));
			sousuo.setIcon(new ImageIcon(getClass().getResource("/res/sousuo.jpg")));
			sousuo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return sousuo;
	}
	
	private JButton getshouye() {// 初始化“首页”按钮
		if (shouye == null) {// “确认发布”按钮对象为空时
			shouye = new JButton();// 实例化“确认发布”按钮
			shouye.setBounds(new Rectangle(225, 50, 45, 20));// 设置“确认发布”按钮的位置和宽高
			shouye.setIcon(new ImageIcon(getClass().getResource("/res/shouye.jpg")));// 设置“返回”按钮的图标
			shouye.addActionListener(new ActionListener() {// 为“确认发布”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return shouye;// 返回“确认发布”按钮
	}

	private JButton getlaren() {// 初始化“拉人载货”按钮
		if (laren == null) {
			laren = new JButton();
			laren.setBounds(new Rectangle(60, 250, 100, 40));
			laren.setIcon(new ImageIcon(getClass().getResource("/res/laren.jpg")));
			laren.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return laren;// 返回“取消”按钮
	}
	
	private JButton getxinshou() {// 初始化“新手上路”按钮
		if (xinshou == null) {
			xinshou = new JButton();
			xinshou.setBounds(new Rectangle(180, 250, 100, 40));
			xinshou.setIcon(new ImageIcon(getClass().getResource("/res/xinshou.jpg")));
			xinshou.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return xinshou;// 返回“取消”按钮
	}

	private JButton getxinche() {// 初始化“准新车”按钮
		if (xinche == null) {
			xinche = new JButton();
			xinche.setBounds(new Rectangle(60, 310, 100, 40));
			xinche.setIcon(new ImageIcon(getClass().getResource("/res/xinche.jpg")));
			xinche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return xinche;// 返回“取消”按钮
	}

	private JButton getpianyi() {// 初始化“便宜”按钮
		if (pianyi == null) {
			pianyi = new JButton();
			pianyi.setBounds(new Rectangle(180, 310, 100, 40));
			pianyi.setIcon(new ImageIcon(getClass().getResource("/res/pianyi.jpg")));
			pianyi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return pianyi;// 返回“取消”按钮
	}

	
	private JButton getwoyaomaiche() {// 初始化“我要卖车”按钮
		if (woyaomaiche == null) {
			woyaomaiche = new JButton();
			woyaomaiche.setBounds(new Rectangle(360, 192, 145, 35));
			woyaomaiche.setIcon(new ImageIcon(getClass().getResource("/res/woyaomaiche.jpg")));
			woyaomaiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return woyaomaiche;// 返回“取消”按钮
	}

	private JButton getwoyaokanche() {// 初始化“我要买车”按钮
		if (woyaokanche == null) {
			woyaokanche = new JButton();
			woyaokanche.setBounds(new Rectangle(100, 195, 140, 35));
			woyaokanche.setIcon(new ImageIcon(getClass().getResource("/res/woyaokanche.jpg")));
			woyaokanche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return woyaokanche;// 返回“取消”按钮
	}

	private JButton getaiche() {// 初始化“爱车”按钮
		if (aiche == null) {
			aiche = new JButton();
			aiche.setBounds(new Rectangle(380, 280, 100, 40));
			aiche.setIcon(new ImageIcon(getClass().getResource("/res/aiche.jpg")));
			aiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return aiche;// 返回“取消”按钮
	}
	
	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置登录窗体
		setSize(600, 500);// 设置登录窗体的宽高
		this.setTitle("车辆信息发布");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}


}
