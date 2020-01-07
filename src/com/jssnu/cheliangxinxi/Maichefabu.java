package com.jssnu.cheliangxinxi;

import java.awt.*;
import javax.swing.*;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.dao.BaseDao;
import com.jssnu.dao.model.UCMSspinfo;
import com.jssnu.headpage.HeadPage;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Maichefabu extends JFrame {// 车辆卖车窗体
	String mession;
	private static final long serialVersionUID = 1L;
	private Maichepanel maichepanel = null;// 卖车面板
	private JLabel jLabel1 = null;// “标题”标签
	private JTextField biaotiField = null;// “标题”文本框
	private JLabel jLabel3 = null;// “车龄”标签
	private JTextField timeField = null;// “车龄”文本框
	private JLabel jLabel2 = null;// “价格”标签
	private JTextField priceField = null;// “价格”文本框
	private JLabel jLabel4 = null;// “变速器”标签
	public JComboBox<String> comboBox;//下拉选择框
	private JTextField comboField = null;// “价格”文本框
	private JLabel jLabel5 = null;// “里程”标签
	private JTextField mileageField = null;// “里程”文本框
	private JLabel jLabel6 = null;// “城市”标签
	private JTextField cityField = null;// “城市”文本框
	private JLabel jLabel7 = null;// “车型”标签
	private JTextField phoneField = null;// “联系方式”文本框
	private JButton quxiaoButton = null;// “返回”按钮
//	final JButton queding = new JButton();// “添加”按钮
	private JButton queding = null;// “确定发布”按钮
    private MainFrame mainFrame;// 主窗体

    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Maichefabu() {// 窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Maichepanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (maichepanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “标题”标签
			jLabel1.setBounds(new Rectangle(100,80, 100, 18));// 设置“标题”标签的位置与宽高
			jLabel1.setText("标题：");// 设置“标题”标签的文本内容
			jLabel3 = new JLabel();//“车龄”标签
			jLabel3.setText("车龄：");// 设置“车龄”标签的文本内容
			jLabel3.setBounds(new Rectangle(100,120, 100, 18));// 设置“上牌时间”标签的位置与宽高
			jLabel4 = new JLabel();//“变速器”标签
			jLabel4.setText("变速器：");// 设置“变速器”标签的文本内容
			jLabel4.setBounds(new Rectangle(100,160, 100, 18));// 设置“变速器”标签的位置与宽高
			jLabel5 = new JLabel();//“里程”标签
			jLabel5.setText("里程：");// 设置“里程”标签的文本内容
			jLabel5.setBounds(new Rectangle(100,200, 100, 18));// 设置“里程”标签的位置与宽高
			jLabel6 = new JLabel();//“城市”标签
			jLabel6.setText("城市：");// 设置“城市”标签的文本内容
			jLabel6.setBounds(new Rectangle(100,240, 100, 18));// 设置“城市”标签的位置与宽高
			jLabel7 = new JLabel();//“联系方式”标签
			jLabel7.setText("联系方式：");// 设置“联系方式”标签的文本内容
			jLabel7.setBounds(new Rectangle(100,280, 100, 18));// 设置“联系方式”标签的位置与宽高
			jLabel2 = new JLabel();//“联系方式”标签
			jLabel2.setText("价格：");// 设置“联系方式”标签的文本内容
			jLabel2.setBounds(new Rectangle(100,320, 100, 18));// 设置“联系方式”标签的位置与宽高
			
			maichepanel = new Maichepanel();// 登录面板
			maichepanel.setLayout(null);// 设置登录面板的布局为绝对布局
			maichepanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			maichepanel.add(jLabel1, null);// 把“标题”标签置于登录面板中
			maichepanel.add(getbiaotiField(), null);// 把“标题”文本框置于登录面板中
			maichepanel.add(jLabel2, null);// 把“上牌时间”标签置于登录面板中
			maichepanel.add(getpriceField(),null);//把“车龄”文本框置于登录面板中
			maichepanel.add(jLabel3, null);// 把“上牌时间”标签置于登录面板中
			maichepanel.add(gettimeField(),null);//把“车龄”文本框置于登录面板中
			maichepanel.add(jLabel4, null);// 把“变速器”标签置于登录面板中
			maichepanel.add(getcomboBox(), null);// 把“变速器”文本框置于登录面板中
			maichepanel.add(jLabel5, null);// 把“里程”标签置于登录面板中
			maichepanel.add(getmileageField(), null);// 把“里程”文本框置于登录面板中
			maichepanel.add(jLabel6, null);// 把“城市”标签置于登录面板中
			maichepanel.add(getcityField(),null);//把“城市”文本框置于登录面板中
			maichepanel.add(jLabel7, null);// 把“联系方式”标签置于登录面板中
			maichepanel.add(getphoneField(),null);//把“联系方式”文本框置于登录面板中
			maichepanel.add(getcomboField(),null);
			maichepanel.add(getqueding(), null);// 把“确定发布”按钮置于登录面板中
			maichepanel.add(getquxiaoButton(), null);// 把“取消”按钮置于登录面板中
		}
		return maichepanel;// 返回登录面板
	}


	private JTextField getbiaotiField() {// 初始化“标题”文本框
		if (biaotiField == null) {// “车型”文本框对象为空时
			biaotiField = new JTextField();// 实例化“车型”文本框
			biaotiField.setBounds(new Rectangle(180,80, 180, 22));// 设置“车型”文本框的位置和宽高
		}
		return biaotiField;// 返回“里程”文本框
	}
	
	private JTextField getpriceField() {// 初始化“标题”文本框
		if (priceField == null) {// “车型”文本框对象为空时
			priceField = new JTextField();// 实例化“车型”文本框
			priceField.setBounds(new Rectangle(180,320, 180, 22));// 设置“车型”文本框的位置和宽高
		}
		return priceField;// 返回“里程”文本框
	}
	private JTextField gettimeField() {// 初始化“车龄”文本框
		if (timeField == null) {// “车龄”文本框对象为空时
			timeField = new JTextField();// 实例化“车龄”文本框
			timeField.setBounds(new Rectangle(180,120, 180, 22));// 设置“车龄”文本框的位置和宽高
		}
		return timeField;// 返回“上牌时间”文本框
	}
	
	private JTextField getcomboField() {
		if (comboField == null) {
			comboField = new JTextField();
		}
		return comboField;// 初始化“车龄”文本框
	}
	private JComboBox<String> getcomboBox() {// 变速器	
			comboBox = new JComboBox<String>();// 实例化“变速器”下拉框
			 String[] select = {"不限","自动","手动"}; //	        添加选项值
	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
			comboBox.setBounds(180, 160, 180, 22);
 		    comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem()=="自动") {
						mession="1";
					}else if(comboBox.getSelectedItem()=="手动"){
						mession="2";
					}else if(comboBox.getSelectedItem()=="不限"){
						mession="0";
					}
				}});
			return comboBox;
	}
	
	private JTextField getmileageField() {// 初始化“里程”文本框
		if (mileageField == null) {// “里程”文本框对象为空时
			mileageField = new JTextField();// 实例化“里程”文本框
			mileageField.setBounds(new Rectangle(180,200, 180, 22));// 设置“里程”文本框的位置和宽高
		}
		return mileageField;// 返回“里程”文本框
	}

	private JTextField getcityField() {// 初始化“城市”文本框
		if (cityField == null) {// “城市”文本框对象为空时
			cityField = new JTextField();// 实例化“城市”文本框
			cityField.setBounds(new Rectangle(180,240, 180, 22));// 设置“城市”文本框的位置和宽高
		}			
		return cityField;// 返回“城市”文本框
	}
	
	private JTextField getphoneField() {// 初始化“联系方式”文本框
		if (phoneField == null) {// “联系方式”文本框对象为空时
			phoneField = new JTextField();// 实例化“联系方式”文本框
			phoneField.setBounds(new Rectangle(180,280, 180, 22));// 设置“联系方式”文本框的位置和宽高
		}
		return phoneField;// 返回“联系方式”文本框
	}


	private JButton getqueding() {// 初始化“确认发布”按钮
		if (queding == null) {// “确认发布”按钮对象为空时
			queding = new JButton();// 实例化“取消”按钮
			queding.setBounds(new Rectangle(180, 380, 75, 30));// 设置“确认发布”按钮的位置和宽高
			queding.setIcon(new ImageIcon(getClass().getResource("/res/queding.jpg")));// 设置“返回”按钮的图标
			queding.addActionListener(new ActionListener() {// 为“确认发布”按钮添加动作事件的监听
				public void actionPerformed(final ActionEvent e) {
					// 文本框为空时，弹出提示框
					if (biaotiField.getText().equals("") || timeField.getText().equals("") || priceField.getText().equals("")
							|| mileageField.getText().equals("") || cityField.getText().equals("") || phoneField.getText().equals("")
							) {
						JOptionPane.showMessageDialog(Maichefabu.this, "请完成未填写的信息。", "商品添加",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					ResultSet haveUser = BaseDao.query("select * from cars_message where name='" + biaotiField.getText().trim() + "'");
					try {
						if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
							System.out.println("error");// 控制台输出error
							JOptionPane.showMessageDialog(Maichefabu.this, "商品信息添加失败，存在同名商品", "客户添加信息",
									JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
							return;
						}
					} catch (Exception er) {
						er.printStackTrace();
					}

					ResultSet set = BaseDao.query("select max(product_id) from cars_message");// 执行SQL查询语句获得的结果集
					String product_id =null;// 声明产品编号
					try {
						if (set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
							String sid = set.getString(1);
							System.out.println(sid);
							if (sid == null)// 第一列数据值为空
								product_id = "1";// 为产品编号赋值
							else {
//								String str = sid.substring(1);// 从索引为2处开始截取字符串
								product_id = ""+(Integer.parseInt(sid) + 1);// 重新拼接字符串获得产品编号
							}
						}

					}catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					UCMSspinfo spInfo = new UCMSspinfo();// 商品信息
					spInfo.setProduct_id(product_id);// 设置商品编号
					spInfo.setBiaoti(biaotiField.getText().trim());// 设置包装
					spInfo.setAge(timeField.getText().trim());// 设置产地
					spInfo.setPrice(priceField.getText().trim());// 设置商品计量单位
					spInfo.setCmobo(mession.trim());// 设置供应商全称
					spInfo.setMileage(mileageField.getText().trim());// 设置商品简称
					spInfo.setCity(cityField.getText().trim());// 设置备注
					spInfo.setPhone(phoneField.getText().trim());// 设置批号
					BaseDao.addSp(spInfo);// 添加商品信息
					JOptionPane.showMessageDialog(Maichefabu.this, "商品信息已经成功添加", "商品添加",
							JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
					
				}
			});	
		}
		return queding;
			}


//	private JButton getqueding() {// 初始化“取消”按钮
//		if (queding == null) {// “取消”按钮对象为空时
//			queding = new JButton();// 实例化“取消”按钮
//			queding.setBounds(new Rectangle(250, 380, 75, 30));// 设置“取消”按钮的位置和宽高
//			queding.setIcon(new ImageIcon(getClass().getResource("/res/quxiao.jpg")));// 设置“返回”按钮的图标
//			queding.addActionListener(new ActionListener() {// 为“取消”按钮添加动作事件的监听
//				public void actionPerformed(ActionEvent e) {
//					System.exit(0);// 退出当前的应用程序
//				}
//			});
//		}
//		return quxiaoButton;// 返回“取消”按钮
//	}
	private JButton getquxiaoButton() {// 初始化“取消”按钮
		if (quxiaoButton == null) {// “取消”按钮对象为空时
			quxiaoButton = new JButton();// 实例化“取消”按钮
			quxiaoButton.setBounds(new Rectangle(300, 380, 75, 30));// 设置“取消”按钮的位置和宽高
			quxiaoButton.setIcon(new ImageIcon(getClass().getResource("/res/quxiao.jpg")));// 设置“返回”按钮的图标
			quxiaoButton.addActionListener(new ActionListener() {// 为“取消”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return quxiaoButton;// 返回“取消”按钮
	}

	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置登录窗体
		setSize(450, 500);// 设置登录窗体的宽高
		this.setTitle("车辆信息发布");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}


public void actionPerformed(final ActionEvent e) {
	// 文本框为空时，弹出提示框
	if (biaotiField.getText().equals("") || timeField.getText().equals("") || priceField.getText().equals("")
			|| mileageField.getText().equals("") || cityField.getText().equals("") || phoneField.getText().equals("")
			) {
		JOptionPane.showMessageDialog(Maichefabu.this, "请完成未填写的信息。", "商品添加",
				JOptionPane.ERROR_MESSAGE);
		return;
	}
}}
