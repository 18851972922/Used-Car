package com.jssnu.dao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.dao.BaseDao;
import com.jssnu.gujia.GujiaPanel;
import com.jssnu.headpage.HeadPage;

public class Buycar extends JFrame {// 车辆估价窗体
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// 引入面板
	private JTextField searchField = null;// “搜索”文本框
	private JButton jb2=null;//品牌-“大众”按钮
	private JButton jb3=null;//品牌-“本田”按钮
	private JButton jb4=null;//品牌-“福特”按钮
	private JButton jb5=null;//品牌-“别克”按钮
	private JButton jb6=null;//品牌-“奥迪”按钮
	private JButton jb7=null;//品牌-“马自达”按钮
	
	private JButton jbu2=null;//车系-“高尔夫”按钮
	private JButton jbu3=null;//车系-“大众POLO”按钮
	private JButton jbu4=null;//车系-“速腾”按钮
	private JButton jbu5=null;//车系-“朗逸”按钮
	private JButton jbu6=null;//车系-“福克斯”按钮
	
	private JButton jbut2=null;//价格-“3万以下”按钮
	private JButton jbut3=null;//价格-“3-5万”按钮
	private JButton jbut4=null;//价格-“5-7万”按钮
	private JButton jbut5=null;//价格-“7-9万”按钮
	private JButton jbut6=null;//价格-“9万以上”按钮
	
	private JButton search=null;//搜索按钮
	private JButton chaxun=null;//查询按钮
	
	private JLabel jLabel1 = null;// “品牌”标签
	private JLabel jLabel2 = null;// “车系”标签
	private JLabel jLabel3 = null;// “价格”标签
	private JLabel jLabel4 = null;// “更多”标签
	private JLabel jLabel5 = null;//“注释”标签
	
	private static String searchStr;// “车龄”文本框中的内容
	private JScrollPane scpDemo; //滚动框
	private JTable tabDemo;   //表格模型
	private JButton backButton = null;// “返回首页”按钮
    private MainFrame mainFrame;// 主窗体
    JComboBox<String> comboBox1;  //车龄下拉框
    JComboBox<String> comboBox2;//变速器下拉框
    JComboBox<String> comboBox3; //里程下拉框
    private String age;//车龄全局变量
    private String mession; //变速器全局变量
    private String miles; //里程全局变量
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public static String getSearchStr() {  //get搜索文本框中的内容
		return searchStr;
	}



	public Buycar() {// 窗体的构造方法
		try {
			// 设置窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getGujiaPanel() {// 初始化Buycar面板的方法
		if (gujiaPanel == null) {// 面板中没有组件时
			
			JTabbedPane tabbedPane = new JTabbedPane();   //加查询条件边框，美化界面
			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //设置边框颜色
			tabbedPane.setBounds(new Rectangle(70,100,555, 130));  //设置边框位置大小
		
			jLabel1 = new JLabel();//“品牌”标签
			jLabel1.setText("品牌");// 设置“品牌”标签的文本内容
			jLabel1.setBounds(new Rectangle(90,110, 110, 18));// 设置“品牌”标签的位置与宽高
			jLabel2 = new JLabel();//“车系”标签
			jLabel2.setText("车系");
			jLabel2.setBounds(new Rectangle(90,140, 110, 18));
			jLabel3 = new JLabel();//“价格”标签
			jLabel3.setText("价格");
			jLabel3.setBounds(new Rectangle(90,170, 110, 18));
			jLabel4 = new JLabel();//“更多”标签
			jLabel4.setText("更多");
			jLabel4.setBounds(new Rectangle(90,200, 110, 18));
			jLabel5 = new JLabel();//“注释”标签
			jLabel5.setText("*车龄以年为单位，里程以万公里为单位，变速器1为自动，2为手动，价格以万元为单位");
			jLabel5.setBounds(new Rectangle(160,220, 500, 18));
			
			scpDemo = new JScrollPane();   //滚动面板位置
			scpDemo.setBounds(new Rectangle(70,240,570,250));
			
			gujiaPanel = new GujiaPanel();// 买车面板
			gujiaPanel.setLayout(null);// 设置面板的布局为绝对布局
			gujiaPanel.add(jLabel1, null);// 把“品牌”标签置于面板中
			gujiaPanel.add(jLabel2, null);// 把“车系”标签置于面板中
			gujiaPanel.add(jLabel3, null);// 把“价格”标签置于面板中
			gujiaPanel.add(jLabel4, null);// 把“更多”标签置于面板中
			gujiaPanel.add(jLabel5, null);// 把“注释”标签置于面板中
			
			gujiaPanel.add(getSearchField(), null);// 把搜索”文本框置于面板中
			gujiaPanel.add(getcomboBox1(),null);//把“车龄”文本框置于面板中
			gujiaPanel.add(getcomboBox2(),null);//把“变速器”文本框置于面板中
			gujiaPanel.add(getcomboBox3(),null);//把“里程”文本框置于面板中
			
			gujiaPanel.add(getjb2Button(), null);// 把“大众”按钮置于面板中
			gujiaPanel.add(getjb3Button(), null);// 把“本田”按钮置于面板中
			gujiaPanel.add(getjb4Button(), null);// 把“福特”按钮置于面板中
			gujiaPanel.add(getjb5Button(), null);// 把“别克”按钮置于面板中
			gujiaPanel.add(getjb6Button(), null);// 把“奥迪”按钮置于面板中
			gujiaPanel.add(getjb7Button(), null);// 把“马自达”按钮置于面板中
			
			gujiaPanel.add(getjbu2Button(), null);// 把“高尔夫”按钮置于面板中
			gujiaPanel.add(getjbu3Button(), null);// 把“大众POLO”按钮置于面板中
			gujiaPanel.add(getjbu4Button(), null);// 把“速腾”按钮置于面板中
			gujiaPanel.add(getjbu5Button(), null);// 把“朗逸”按钮置于面板中
			gujiaPanel.add(getjbu6Button(), null);// 把“福克斯”按钮置于面板中

			
			gujiaPanel.add(getjbut2Button(), null);// 把“3万以下”按钮置于面板中
			gujiaPanel.add(getjbut3Button(), null);// 把“3-5万”按钮置于面板中
			gujiaPanel.add(getjbut4Button(), null);// 把“5-7万”按钮置于面板中
			gujiaPanel.add(getjbut5Button(), null);// 把“7-9万”按钮置于面板中
			gujiaPanel.add(getjbut6Button(), null);// 把“9万以上”按钮置于面板中
			gujiaPanel.add(getchaxunButton(),null);//把查询按钮置于面板中
			gujiaPanel.add(getsearchButton(),null);//把搜索按钮置于面板中
			gujiaPanel.add(scpDemo);     //把滚动面板置于面板中
			gujiaPanel.add(getBackButton(), null);// 把“返回首页”按钮置于登录面板中

	
		}
		return gujiaPanel;// 返回面板
	}

	private JTextField getSearchField() {// 初始化“搜索”文本框
		if (searchField== null) {
			searchField = new JTextField();
			searchField.setBounds(new Rectangle(350,60,150, 22));  //设置位置
		}
		return searchField;
	}
	private JButton getsearchButton() {// 初始化“搜索”按钮
		if (search == null) {
			search=new JButton("搜索");
			search.setBounds(new Rectangle(530,55,60,27));
			search.addActionListener(new ActionListener() {   //添加监听事件
				public void actionPerformed(ActionEvent e) {
					try{
						if(search == e.getSource()) {  //若搜索按钮被点击
							String searchStr=searchField.getText();  //获取搜索框中的文本内容
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%"+searchStr+"%\"";//查询语句
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){    //获取查询数据的条数
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return search;
	}	

	private JComboBox<String> getcomboBox1() {// 车龄		
		comboBox1 = new JComboBox<String>();// 实例化“车龄”下拉框
		 String[] select = {"车龄","1年以内","1-3年","3-5年","5年以上"}; //	        添加选项值
        comboBox1.setModel(new DefaultComboBoxModel<String>(select));
		comboBox1.setBounds(150, 197, 90, 22);// 设置“车龄”文本框的位置和宽高
		return comboBox1;// 返回下拉框
}

	private JComboBox<String> getcomboBox2() {// 变速器	
			comboBox2 = new JComboBox<String>();// 实例化“变速器”下拉框
			 String[] select = {"变速器","手动","自动"}; //	        添加选项值
	        comboBox2.setModel(new DefaultComboBoxModel<String>(select));
			comboBox2.setBounds(300, 197, 90, 22);// 设置“变速器”文本框的位置和宽高
			return comboBox2;
	}
	
	private JComboBox<String> getcomboBox3() {// 里程	
		comboBox3 = new JComboBox<String>();// 实例化“里程”下拉框
		 String[] select = {"里程","1万公里内","3万公里以内","5万公里以内","7万公里内","7万公里以上"}; //	        添加选项值
        comboBox3.setModel(new DefaultComboBoxModel<String>(select));
		comboBox3.setBounds(450, 197, 90, 22);// 设置“里程”文本框的位置和宽高
		return comboBox3;
}

	private JButton getchaxunButton() {// 初始化“查询”按钮
		if (chaxun == null) {
			chaxun=new JButton("查询");
			chaxun.setBounds(new Rectangle(555,195,60,25));
			chaxun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(chaxun == e.getSource()) {
						   
							String com1=(String) comboBox1.getSelectedItem(); //获取下拉框中的内容
							if(com1=="1年以内") {   //如果下拉框内容是一年以内则设置语句age<1 ,以便于sql语句的拼接
								age="age<1";
							}else if(com1=="1-3年") {
								age="1<age<3";
							}else if(com1=="3-5年") {
								age="3<age<5";
							}else if(com1=="5年以上") {
								age="age>5";
							}
							String com2=(String) comboBox2.getSelectedItem();
							if(com2=="手动") {
								mession="comboBox=1";
							}else if(com2=="自动") {
								mession="comboBox=2";
							}
							String com3=(String) comboBox3.getSelectedItem();
							if(com3=="1万公里以内") {
								miles="miles<1";
							}else if(com3=="3万公里以内") {
								miles="miles<3";
							}else if(com3=="5万公里以内") {
								miles="miles<5";
							}else if(com3=="7万公里以内") {
								miles="miles<7";
							}else if(com3=="7万公里以上") {
								miles="miles>7";
							}
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where "+age+" and "+mession+" and "+miles;//sql语句拼接
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return chaxun;
	}		
	
	private JButton getjb2Button() {// 初始化品牌-“大众”按钮
		if (jb2 == null) {
			jb2=new JButton("大众");
			jb2.setBounds(new Rectangle(135,108, 70, 20));
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%大众%\"";//sql模糊查询
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb2;
	}	
	
	

	
	private JButton getjb3Button() {// 初始化品牌-“本田”按钮
		if (jb3 == null) {
			jb3=new JButton("本田");
			jb3.setBounds(new Rectangle(210,108, 70, 20));
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb3 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%本田%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb3;
	}	
	
	private JButton getjb4Button() {// 初始化品牌-“福特”按钮
		if (jb4 == null) {
			jb4=new JButton("福特");
			jb4.setBounds(new Rectangle(290,108, 80, 20));
			jb4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb4 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%福特%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb4;
	}	
	
	private JButton getjb5Button() {// 初始化品牌-“别克”按钮
		if (jb5 == null) {
			jb5=new JButton("别克");
			jb5.setBounds(new Rectangle(385,108,70, 20));
			jb5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb5 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%别克%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb5;
	}	
	
	private JButton getjb6Button() {// 初始化品牌-“奥迪”按钮
		if (jb6 == null) {
			jb6=new JButton("奥迪");
			jb6.setBounds(new Rectangle(470,108, 70, 20));
			jb6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb6 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%奥迪%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
							info[count][1] = rs.getString("name");
							info[count][2] = rs.getDouble("age");
							info[count][3] = rs.getDouble("miles");
							info[count][4] = rs.getInt("comboBox");
							info[count][5] = rs.getDouble("price");
							info[count][6] = rs.getString("city");
							info[count][7] = rs.getLong("phone");
							count++;
							}
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb6;
	}	
	
	private JButton getjb7Button() {// 初始化品牌-“马自达”按钮
		if (jb7 == null) {
			jb7=new JButton("马自达");
			jb7.setBounds(new Rectangle(550,108,80, 20));
			jb7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb7 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%马自达%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
						
							   }
							rs=bd.query(sql);
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
							info[count][1] = rs.getString("name");
							info[count][2] = rs.getDouble("age");
							info[count][3] = rs.getDouble("miles");
							info[count][4] = rs.getInt("comboBox");
							info[count][5] = rs.getDouble("price");
							info[count][6] = rs.getString("city");
							info[count][7] = rs.getLong("phone");
							count++;
							}
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jb7;
	}	
	
	private JButton getjbu2Button() {// 初始化车系-“高尔夫”按钮
		if (jbu2 == null) {
			jbu2=new JButton("高尔夫");
			jbu2.setBounds(new Rectangle(135,138,80, 20));
			jbu2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%高尔夫%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbu2;
	}	
	
	private JButton getjbu3Button() {// 初始化车系-“大众POLO”按钮
		if (jbu3 == null) {
			jbu3=new JButton("大众POLO");
			jbu3.setBounds(new Rectangle(230,138,95, 20));
			jbu3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu3 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%大众POLO%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbu3;
	}	
	
	private JButton getjbu4Button() {// 初始化车系-“速腾”按钮
		if (jbu4 == null) {
			jbu4=new JButton("速腾");
			jbu4.setBounds(new Rectangle(335,138,70, 20));
			jbu4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu4 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%速腾%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbu4;
	}	
	
	private JButton getjbu5Button() {// 初始化车系-“朗逸”按钮
		if (jbu5 == null) {
			jbu5=new JButton("朗逸");
			jbu5.setBounds(new Rectangle(410,138,70, 20));
			jbu5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu5 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%朗逸%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbu5;
	}	
	
	private JButton getjbu6Button() {// 初始化车系-“福克斯”按钮
		if (jbu6 == null) {
			jbu6=new JButton("福克斯");
			jbu6.setBounds(new Rectangle(500,138,80, 20));
			jbu6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu6 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%福克斯%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
							info[count][1] = rs.getString("name");
							info[count][2] = rs.getDouble("age");
							info[count][3] = rs.getDouble("miles");
							info[count][4] = rs.getInt("comboBox");
							info[count][5] = rs.getDouble("price");
							info[count][6] = rs.getString("city");
							info[count][7] = rs.getLong("phone");
							count++;
							}
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbu6;
	}	
		
	private JButton getjbut2Button() {// 初始化价格-“3万以下”按钮
		if (jbut2 == null) {
			jbut2=new JButton("3万以下");
			jbut2.setBounds(new Rectangle(135,168,85, 20));
			jbut2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<3";//条件查询
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
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
		return jbut2;
	}
	
	private JButton getjbut3Button() {// 初始化价格-“3-5万”按钮
		if (jbut3 == null) {
			jbut3=new JButton("3-5万");
			jbut3.setBounds(new Rectangle(235,168,85, 20));
			jbut3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut3 == e.getSource()) {
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<5 and price>3";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
							// 将JTable加入到带滚动条的面板中
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut3;// 返回“估价”按钮
	}
	
	private JButton getjbut4Button() {// 初始化价格-“3-7万”按钮
		if (jbut4 == null) {
			jbut4=new JButton("5-7万");
			jbut4.setBounds(new Rectangle(340,168,85, 20));
			jbut4.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut4 == e.getSource()) {
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<7 and price>5";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
							// 将JTable加入到带滚动条的面板中
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut4;
	}
	
	private JButton getjbut5Button() {// 初始化价格-“7-9万”按钮
		if (jbut5 == null) {
			jbut5=new JButton("7-9万");//价格-“不限”按钮
			jbut5.setBounds(new Rectangle(440,168,85, 20));
			jbut5.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut5 == e.getSource()) {
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<9 and price>7";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
							// 将JTable加入到带滚动条的面板中
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut5;// 返回“估价”按钮
	}
	
	private JButton getjbut6Button() {// 初始化价格-“7-9万”按钮
		if (jbut6 == null) {
			jbut6=new JButton("9万以上");//价格-“不限”按钮
			jbut6.setBounds(new Rectangle(540,168,85, 20));
			jbut6.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut6 == e.getSource()) {
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price>9";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// 将查询获得的记录数据，转换成适合生成JTable的数据形式
							Object[][] info = new Object[count][8];
							count = 0;
							while(rs.next()){
							info[count][0] = rs.getString("product_id");	
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
							tabDemo.setEnabled(false);// 设置表格模型无法响应用户输入
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 不自动调整列的宽度；使用滚动条
							// 将JTable加入到带滚动条的面板中
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut6;
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
		setLocation(320, 100);// 设置登录窗体位置
		setSize(700,550);// 设置登录窗体的宽高
		this.setTitle("我要买车");// 设置登录窗体的标题
		setContentPane(getGujiaPanel());// 将登录面板置于登录窗体中
	}


}

