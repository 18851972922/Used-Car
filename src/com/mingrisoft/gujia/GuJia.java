package com.mingrisoft.gujia;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mingrisoft.MainFrame;



public class GuJia extends JFrame {// 车辆估价窗体
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// 估价面板
	private JLabel jLabel = null;// “车龄”标签
	private JTextField ageField = null;// “车龄”文本框
	private JLabel jLabel1 = null;// “里程”标签
	private JTextField mileageField = null;// “里程”文本框
	private JLabel jLabel2 = null;// “变速器”标签
	public JComboBox<String> comboBox;//下拉选择框
	private JButton backButton = null;// “返回”按钮
	private JButton priceButton = null;// “估价”按钮
	private JTextField priceField = null;//估价文本框
	private static String ageStr;// “车龄”文本框中的内容
	private static String mileageStr; //“里程”文本框中的内容
    private MainFrame mainFrame;// 主窗体
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public String getUserStr() {// 获得“车龄”文本框中的内容
		return ageStr;// 返回“车龄”文本框中的内容
	}
	
	public String getMileageStr() {// 获得“里程”文本框中的内容
		return mileageStr;// 返回“里程”文本框中的内容
	}
	public GuJia() {// 窗体的构造方法
		try {
			// 设置窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (gujiaPanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “车龄”标签
			jLabel1.setBounds(new Rectangle(90,120, 100, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("车龄（年）：");// 设置“密码”标签的文本内容
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("里程（万公里）：");// 设置“里程”标签的文本内容
			jLabel.setBounds(new Rectangle(80, 170, 100, 18));// 设置“里程”标签的位置与宽高
			jLabel2 = new JLabel();//“变速器”标签
			jLabel2.setText("变速器：");// 设置“变速器”标签的文本内容
			jLabel2.setBounds(new Rectangle(100,220, 100, 18));// 设置“变速器”标签的位置与宽高
			gujiaPanel = new GujiaPanel();// 登录面板
			gujiaPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			gujiaPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			gujiaPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			gujiaPanel.add(getAgeField(), null);// 把“用户名”文本框置于登录面板中
			gujiaPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中
			gujiaPanel.add(getMileageField(), null);// 把“密码”文本框置于登录面板中
			gujiaPanel.add(jLabel2, null);// 把“变速器”标签置于登录面板中
			gujiaPanel.add(getcomboBox(),null);//把“变速器”文本框置于登录面板中
			gujiaPanel.add(getPriceField(), null);// 把“估价”文本框置于登录面板中
			gujiaPanel.add(getPriceButton(), null);// 把“估价”按钮置于登录面板中
			gujiaPanel.add(getBackButton(), null);// 把“退出”按钮置于登录面板中
		}
		return gujiaPanel;// 返回登录面板
	}

	private JTextField getAgeField() {// 初始化“车龄”文本框
		if (ageField == null) {// “年龄”文本框对象为空时
			ageField = new JTextField();// 实例化“年龄”文本框
			ageField.setBounds(new Rectangle(180, 120, 127, 22));// 设置“用户名”文本框的位置和宽高
		}
		return ageField;// 返回“车龄”文本框
	}

	private JTextField getMileageField() {// 初始化“里程”文本框
		if (mileageField == null) {// “里程”文本框对象为空时
			mileageField = new JTextField();// 实例化“里程”文本框
			mileageField.setBounds(new Rectangle(180,170, 127, 22));// 设置“里程”文本框的位置和宽高
		}
		return mileageField;// 返回“里程”文本框
	}

	private JComboBox<String> getcomboBox() {// 变速器	
			comboBox = new JComboBox<String>();// 实例化“变速器”下拉框
			 String[] select = {"不限","自动","手动"}; //	        添加选项值
	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
			comboBox.setBounds(180, 220, 127, 22);// 设置“变速器”文本框的位置和宽高
			return comboBox;
	}
	
	private JButton getPriceButton() {// 初始化“车辆估价”按钮
		if (priceButton == null) {
			priceButton = new JButton();
			priceButton.setBounds(new Rectangle(80, 270, 90, 27));
			priceButton.setIcon(new ImageIcon(getClass().getResource("/res/gujiabutton.jpg")));
			priceButton.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton == e.getSource()) {//如果是估价这个按钮被点击了,
							double ageStr=Double.valueOf(ageField.getText()).doubleValue();
							double mileageStr = Double.valueOf(mileageField.getText()).doubleValue(); //获取车龄文本框中的内容
							if(comboBox.getSelectedItem()=="自动") {
								double mission = 1;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.													
							}else if(comboBox.getSelectedItem()=="手动"){
								double mission = 2;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.							
							}else {
								double mission = 1.5;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.									
							}
								
							
							
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton;// 返回“估价”按钮
	}
	
	private JTextField getPriceField() {// 初始化“估价”文本框
		if (priceField == null) {
			priceField = new JTextField();
			priceField.setBounds(new Rectangle(180,270, 127, 27));
		}
		return priceField;// 返回“估价”文本框
	}
	
	private JButton getBackButton() {// 初始化“返回首页”按钮
		if (backButton == null) {// “返回”按钮对象为空时
			backButton = new JButton();// 实例化“返回”按钮
			backButton.setBounds(new Rectangle(215, 380, 50, 20));// 设置“返回”按钮的位置和宽高
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// 设置“返回”按钮的图标
			backButton.addActionListener(new ActionListener() {// 为“返回”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return backButton;// 返回“返回”按钮
	}

	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置登录窗体
		setSize(380, 500);// 设置登录窗体的宽高
		this.setTitle("车辆估价");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}


}
