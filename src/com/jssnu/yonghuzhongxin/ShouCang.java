package com.jssnu.yonghuzhongxin;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.dao.BaseDao;
import com.jssnu.headpage.HeadPage;



public class ShouCang extends JFrame {// 车辆估价窗体
	private static final long serialVersionUID = 1L;
	private ShouCangPanel shoucangPanel = null;// 收藏面板
//	private JLabel jLabel = null;// “个人中心”标签
//	private JTextField ageField = null;// “个人中心”文本框
	private JLabel jLabel1 = null;// “个人中心”标签
//	private JTextField mileageField = null;// “收藏”文本框
//	private JLabel jLabel2 = null;// “联系客服”标签
//	public JComboBox<String> comboBox;//下拉选择框
	private JLabel jLabel2 = null;// “输入用户id”标签
	private JLabel jLabel3 = null;// “输入收藏商品id”标签
	
	
	private JButton backButton = null;// “返回”按钮
	private JButton priceButton = null;// “收藏车辆”按钮
	private JButton priceButton2 = null;// “联系客服”按钮
	private JButton priceButton3 = null;// “查看收藏”按钮
	private JButton priceButton4 = null;// “删除收藏”按钮
	
	private JTextField yonghuidField = null;//输入用户id文本框
	private JTextField shoucangidField = null;//输入收藏商品id文本框
	
	private static String yonghuidStr;// “输入用户id”文本框中的内容
	private static String shoucangidStr; //“输入收藏商品id”文本框中的内容

	
	private JTable tabDemo;   //表格模型
	private JScrollPane scpDemo; //滚动框
    
	private MainFrame mainFrame;// 主窗体
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public String getyonghuStr() {// 获得“输入用户id”文本框中的内容
		return yonghuidStr;// 返回文本框中的内容
	}
	
	public String getshoucangStr() {// 获得“输入收藏商品id”文本框中的内容
		return shoucangidStr;// 返回文本框中的内容
	}
	public ShouCang() {// 窗体的构造方法
		try {
			// 设置窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ShouCangPanel getShouCangPanel() {// 初始化收藏面板的方法
		if (shoucangPanel == null) {// 收藏面板中没有组件时
//			JTabbedPane tabbedPane = new JTabbedPane();   //加边框
//			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //设置边框颜色
//			tabbedPane.setBounds(new Rectangle(2200,2200,600, 130));  //设置边框位置大小
			
			jLabel1 = new JLabel();// “个人中心”标签
			jLabel1.setBounds(new Rectangle(60,68, 100,95));// 设置“个人中心”标签的位置与宽高
//			jLabel1.setText("个人中心");// 设置“个人中心”标签的文本内容
			jLabel1.setIcon(new ImageIcon(getClass().getResource("/res/gerenzhongxin2.jpg")));
//			jLabel = new JLabel();// “用户名”标签
//			jLabel.setText("收藏车辆");// 设置“收藏车辆”标签文本内容
//			jLabel.setBounds(new Rectangle(90, 170, 100, 18));// 设置“收藏车辆”标签的位置与宽高
			
			jLabel2 = new JLabel();//“输入用户id”标签
			jLabel2.setText("收藏商品id");// 设置“输入用户id”标签的文本内容
			jLabel2.setBounds(new Rectangle(300,165, 100, 18));// 设置“输入用户id”标签的位置与宽高
			
			
			jLabel3 = new JLabel();//“输入收藏id”标签
			jLabel3.setText("您的用户id");// 设置标签的文本内容
			jLabel3.setBounds(new Rectangle(300,50, 88, 24));// 设置标签的位置与宽高
//			jLabel4 = new JLabel();//“查询收藏”标签
//			jLabel4.setText("删除收藏");// 设置“删除收藏”标签的文本内容
//			jLabel4.setBounds(new Rectangle(300,120, 100, 18));// 设置“删除收藏”标签的位置与宽高
			scpDemo = new JScrollPane();   //显示收藏面板
			scpDemo.setBounds(new Rectangle(70,252,570,250));
			
			
			shoucangPanel = new ShouCangPanel();// 收藏面板
			shoucangPanel.setLayout(null);// 设置收藏面板的布局为绝对布局
			shoucangPanel.setBackground(new Color(0xD8DDC7));// 设置收藏面板的背景色
//			shoucangPanel.add(jLabel, null);// 把“个人中心”标签置于收藏面板中
//			shoucangPanel.add(getAgeField(), null);// 把“个人中心”文本框置于收藏面板中
			
			shoucangPanel.add(jLabel1, null);// 把“个人中心”标签置于收藏面板中
			shoucangPanel.add(jLabel2, null);// 把“请输入用户id”标签置于收藏面板中
			shoucangPanel.add(jLabel3, null);// 把“请输入收藏id”标签置于收藏面板中

			shoucangPanel.add(getyonghuidField(), null);// 把“输入用户id”文本框置于收藏面板中
			shoucangPanel.add(getshoucangidField(), null);// 把“输入用户id”文本框置于收藏面板中
//			shoucangPanel.add(jLabel2, null);// 把“联系客服”标签置于收藏面板中
//			shoucangPanel.add(getcomboBox(),null);//把“联系客服”文本框置于收藏面板中
//			shoucangPanel.add(getPriceField(), null);// 把“估价”文本框置于登录面板中
			
			shoucangPanel.add(getPriceButton(), null);// 把“收藏车辆”按钮置于收藏面板中
//			shoucangPanel.add(getPriceButton2(), null);// 把“联系客服”按钮置于收藏面板中
			shoucangPanel.add(getPriceButton2(), null);// 把“联系客服”按钮置于收藏面板中
			shoucangPanel.add(getBackButton(), null);// 把“退出”按钮置于登录面板中
//			shoucangPanel.add(jLabel3, null);// 把“查询收藏”标签置于收藏面板中
//			shoucangPanel.add(jLabel4, null);// 把“删除收藏”标签置于收藏面板中
			shoucangPanel.add(getPriceButton3(), null);// 把“查看收藏”按钮置于收藏面板中
			shoucangPanel.add(getPriceButton4(), null);// 把“删除收藏”按钮置于收藏面板中
			
			
			shoucangPanel.add(scpDemo);
//			shoucangPanel.add(tabDemo);
			
			
		}
		return shoucangPanel;// 返回收藏面板
	}

	private JTextField getshoucangidField() {// 初始化“输入收藏id”文本框
		if (shoucangidField == null) {// 文本框对象为空时
			shoucangidField = new JTextField();// 实例化文本框
			shoucangidField.setBounds(new Rectangle(400, 160,88 , 24));// 设置文本框的位置和宽高
		}
		return shoucangidField;// 返回“车龄”文本框
	}

	private JTextField getyonghuidField() {// 初始化“输入用户id”文本框
		if (yonghuidField == null) {// 文本框对象为空时
			yonghuidField = new JTextField();// 实例化“里程”文本框
			yonghuidField.setBounds(new Rectangle(400,50, 88, 24));// 设置“里程”文本框的位置和宽高
		}
		return yonghuidField;// 返回“里程”文本框
	}

//	private JComboBox<String> getcomboBox() {// 变速器	
//			comboBox = new JComboBox<String>();// 实例化“变速器”下拉框
//			 String[] select = {"不限","自动","手动"}; //	        添加选项值
//	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
//			comboBox.setBounds(180, 220, 127, 22);// 设置“变速器”文本框的位置和宽高
//			return comboBox;
//	}
	
	private JButton getPriceButton() {// 初始化“收藏车辆”按钮
		if (priceButton == null) {
			priceButton = new JButton();
			priceButton.setBounds(new Rectangle(70, 160,77, 35));
			priceButton.setIcon(new ImageIcon(getClass().getResource("/res/shoucangcheliang2.PNG")));
//			priceButton.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
//				public void actionPerformed(ActionEvent e) {
//					try {
//						if (priceButton == e.getSource()) {//如果是估价这个按钮被点击了,
//							double ageStr=Double.valueOf(ageField.getText()).doubleValue();
//							double mileageStr = Double.valueOf(mileageField.getText()).doubleValue(); //获取车龄文本框中的内容
//							if(comboBox.getSelectedItem()=="自动") {
//								double mission = 1;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.													
//							}else if(comboBox.getSelectedItem()=="手动"){
//								double mission = 2;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.							
//							}else {
//								double mission = 1.5;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"万元");//把按钮的文字显示到估价文本框中.									
//							}
//								
//							
//							
//				        }
//						
//					} catch (NumberFormatException e1) {
//					    e1.printStackTrace();
//
//					} 
//				}
//			});
		}
		return priceButton;// 返回“估价”按钮
	}
	
	private JButton getPriceButton2() {// 初始化“联系客服”按钮
		if (priceButton2 == null) {
			priceButton2 = new JButton();
			priceButton2.setBounds(new Rectangle(70, 200,77,35));
			priceButton2.setIcon(new ImageIcon(getClass().getResource("/res/lianxikefu2.PNG")));
			priceButton2.addActionListener(new ActionListener() {// 为“联系客服”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton2 == e.getSource()) {//如果是联系客服这个按钮被点击了,
							
//							JFrame frame = new JFrame("联系客服");
//							frame.setLayout(null);
//							frame.setBounds(600, 600, 500, 300);
//							frame.setVisible(true);
//							frame.add(new JLabel("zhesasfdafsrgrghdghhjy"));
							JOptionPane.showInputDialog(this,"请输入您宝贵的建议或意见");
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton2;// 返回“联系客服”按钮
	}
	
	private JButton getPriceButton3() {// 初始化“查看收藏”按钮
		if (priceButton3 == null) {
			priceButton3 = new JButton();
			priceButton3.setBounds(new Rectangle(200, 50,88,24));
			priceButton3.setIcon(new ImageIcon(getClass().getResource("/res/chakanshoucang.jpg")));
			priceButton3.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try{
						
						if(priceButton3 == e.getSource()) {
							
							String yonghuidStr=yonghuidField.getText();
							BaseDao bd=new BaseDao();
							String sql = "select * from tb_shoucang inner join cars_message on product1 = product_id and user_id = " + yonghuidStr;
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][9];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("id");
							info[count][1] = rs.getString("user_id");
							info[count][2] = rs.getString("product1");
							info[count][3] = rs.getString("name");
							info[count][4] = rs.getString("price");
							info[count][5] = rs.getString("age");
							info[count][6] = rs.getString("comboBox");
							info[count][7] = rs.getString("city");
							info[count][8] = rs.getString("phone");
							count++;
							}
							
							// 定义表头
							String[] title = {"收藏id","用户id","商品id","品牌","车价","卖价","变速器","城市","电话"};
							 //创建JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							// 将JTable加入到带滚动条的面板中
							scpDemo.getViewport().add(tabDemo);
							}
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return priceButton3;// 返回“估价”按钮
	}
	
	
	private JButton getPriceButton4() {// 初始化“删除收藏”按钮
		if (priceButton4 == null) {
			priceButton4 = new JButton();
			priceButton4.setBounds(new Rectangle(200, 150,88,34));
			priceButton4.setIcon(new ImageIcon(getClass().getResource("/res/shanchushoucang.jpg")));
			priceButton4.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton4 == e.getSource()) {//如果是估价这个按钮被点击了,
							
							String yonghuidStr=yonghuidField.getText();
							String shoucangidStr = shoucangidField.getText();
							BaseDao bd=new BaseDao();
							String sql = "delete from tb_shoucang where user_id = ? and product1 = ?";		
							bd.update(sql,yonghuidStr,shoucangidStr);	
							JOptionPane.showMessageDialog(ShouCang.this, "收藏商品已经成功删除", "删除收藏",
									JOptionPane.INFORMATION_MESSAGE);// 弹出提示框
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton4;// 返回“删除收藏”按钮
	}
//	
//	private JTextField getPriceField() {// 初始化“估价”文本框
//		if (priceField == null) {
//			priceField = new JTextField();
//			priceField.setBounds(new Rectangle(180,270, 127, 27));
//		}
//		return priceField;// 返回“估价”文本框
//	}
	
	private JButton getBackButton() {// 初始化“返回首页”按钮
		if (backButton == null) {// “返回”按钮对象为空时
			backButton = new JButton();// 实例化“返回”按钮
			backButton.setBounds(new Rectangle(540, 515, 50, 20));// 设置“返回”按钮的位置和宽高
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// 设置“返回”按钮的图标
			backButton.addActionListener(new ActionListener() {// 为“返回”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
//					System.exit(0);// 退出当前的应用程序
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return backButton;// 返回“返回”按钮
	}

	private void initialize() {// 初始化收藏窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
//		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// 设置收藏窗体
		setLocation(320, 100);
		setSize(700, 600);// 设置窗体的宽高
		this.setTitle("个人中心");// 设置窗体的标题
		setContentPane(getShouCangPanel());// 将收藏面板置于收藏窗体中
	}


}
