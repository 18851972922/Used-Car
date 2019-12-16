package com.mingrisoft.dao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import com.mingrisoft.MainFrame;
import com.mingrisoft.dao.BaseDao;
import com.mingrisoft.gujia.GujiaPanel;



public class Buycar extends JFrame {// 车辆估价窗体
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// 估价面板
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
	
	private JButton search=null;
	
	private JLabel jLabel1 = null;// “品牌”标签
	private JLabel jLabel2 = null;// “车系”标签
	private JLabel jLabel3 = null;// “价格”标签
	private JLabel jLabel4 = null;// “更多”标签
	private JLabel jLabel5 = null;//“注释”标签
	private static String searchStr;// “车龄”文本框中的内容
	private JScrollPane scpDemo; //滚动框
	private JTable tabDemo;   //表格模型
    private MainFrame mainFrame;// 主窗体

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public static String getSearchStr() {
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

	private GujiaPanel getGujiaPanel() {// 初始化loginPanel登录面板的方法
		if (gujiaPanel == null) {// 登录面板中没有组件时
			
			JTabbedPane tabbedPane = new JTabbedPane();   //加边框
			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //设置边框颜色
			tabbedPane.setBounds(new Rectangle(70,100,555, 130));  //设置边框位置大小
		
			jLabel1 = new JLabel();//“品牌”标签
			jLabel1.setText("品牌");// 设置“品牌”标签的文本内容
			jLabel1.setBounds(new Rectangle(90,110, 100, 18));// 设置“品牌”标签的位置与宽高
			jLabel2 = new JLabel();//“车系”标签
			jLabel2.setText("车系");
			jLabel2.setBounds(new Rectangle(90,140, 100, 18));
			jLabel3 = new JLabel();//“价格”标签
			jLabel3.setText("价格");
			jLabel3.setBounds(new Rectangle(90,170, 100, 18));
			jLabel4 = new JLabel();//“更多”标签
			jLabel4.setText("更多");
			jLabel4.setBounds(new Rectangle(90,200, 100, 18));
			jLabel5 = new JLabel();//“注释”标签
			jLabel5.setText("*车龄以年为单位，里程以万公里为单位，变速器1为自动，2为手动，价格以万元为单位");
			jLabel5.setBounds(new Rectangle(160,220, 500, 18));
			scpDemo = new JScrollPane();   //滚动面板
			scpDemo.setBounds(new Rectangle(70,240,570,250));
			
			
			gujiaPanel = new GujiaPanel();// 登录面板
			gujiaPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			gujiaPanel.add(jLabel1, null);// 把“不限”标签置于登录面板中
			gujiaPanel.add(jLabel2, null);
			gujiaPanel.add(jLabel3, null);
			gujiaPanel.add(jLabel4, null);
			gujiaPanel.add(jLabel5, null);
			gujiaPanel.add(getSearchField(), null);// 把搜索”文本框置于登录面板中

			gujiaPanel.add(getcomboBox1(),null);//把“车龄”文本框置于登录面板中
			gujiaPanel.add(getcomboBox2(),null);//把“车龄”文本框置于登录面板中
			gujiaPanel.add(getcomboBox3(),null);//把“里程”文本框置于登录面板中
			
			gujiaPanel.add(getjb2Button(), null);// 把“大众”按钮置于登录面板中
			gujiaPanel.add(getjb3Button(), null);// 把“本田”按钮置于登录面板中
			gujiaPanel.add(getjb4Button(), null);// 把“福特”按钮置于登录面板中
			gujiaPanel.add(getjb5Button(), null);// 把“别克”按钮置于登录面板中
			gujiaPanel.add(getjb6Button(), null);// 把“奥迪”按钮置于登录面板中
			gujiaPanel.add(getjb7Button(), null);// 把“马自达”按钮置于登录面板中
			
			gujiaPanel.add(getjbu2Button(), null);// 把“高尔夫”按钮置于登录面板中
			gujiaPanel.add(getjbu3Button(), null);// 把“大众POLO”按钮置于登录面板中
			gujiaPanel.add(getjbu4Button(), null);// 把“速腾”按钮置于登录面板中
			gujiaPanel.add(getjbu5Button(), null);// 把“朗逸”按钮置于登录面板中
			gujiaPanel.add(getjbu6Button(), null);// 把“福克斯”按钮置于登录面板中

			
			gujiaPanel.add(getjbut2Button(), null);// 把“3万以下”按钮置于登录面板中
			gujiaPanel.add(getjbut3Button(), null);// 把“3-5万”按钮置于登录面板中
			gujiaPanel.add(getjbut4Button(), null);// 把“5-7万”按钮置于登录面板中
			gujiaPanel.add(getjbut5Button(), null);// 把“7-9万”按钮置于登录面板中
			gujiaPanel.add(getjbut6Button(), null);// 把“9万以上”按钮置于登录面板中
			
			gujiaPanel.add(getsearchButton(),null);
			gujiaPanel.add(scpDemo);

	
		}
		return gujiaPanel;// 返回登录面板
	}

	private JTextField getSearchField() {// 初始化“搜索”文本框
		if (searchField== null) {
			searchField = new JTextField();
			searchField.setBounds(new Rectangle(350,60,150, 22));
		}
		return searchField;
	}
	private JButton getsearchButton() {// 初始化“搜索”按钮
		if (search == null) {
			search=new JButton("搜索");//价格-“不限”按钮
			search.setBounds(new Rectangle(520,60,60, 20));
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(search == e.getSource()) {
							String searchStr=searchField.getText();
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%"+searchStr+"%\"";
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
		JComboBox<String> comboBox1 = new JComboBox<String>();// 实例化“车龄”下拉框
		 String[] select = {"车龄","1年以内","1-3年","3-5年","5年以上"}; //	        添加选项值
        comboBox1.setModel(new DefaultComboBoxModel<String>(select));
		comboBox1.setBounds(150, 197, 80, 22);// 设置“车龄”文本框的位置和宽高
		return comboBox1;// 返回“估价”按钮
}	

	private JComboBox<String> getcomboBox2() {// 变速器	
			JComboBox<String> comboBox2 = new JComboBox<String>();// 实例化“变速器”下拉框
			 String[] select = {"变速器","手动","自动"}; //	        添加选项值
	        comboBox2.setModel(new DefaultComboBoxModel<String>(select));
			comboBox2.setBounds(300, 197, 80, 22);// 设置“变速器”文本框的位置和宽高
			return comboBox2;
	}
	
	private JComboBox<String> getcomboBox3() {// 里程	
		JComboBox<String> comboBox3 = new JComboBox<String>();// 实例化“里程”下拉框
		 String[] select = {"里程","1万公里内","3万公里以内","5万公里以内","7万公里内","7万公里以上"}; //	        添加选项值
        comboBox3.setModel(new DefaultComboBoxModel<String>(select));
		comboBox3.setBounds(450, 197, 80, 22);// 设置“里程”文本框的位置和宽高
//		
		comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		
            			if(comboBox3.getSelectedItem()=="1万公里以内") {
            		
            				BaseDao bd=new BaseDao();
            				String sql = "SELECT * FROM cars_message where miles <1";
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
            			}
            		
            	catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
            	}
            	}
        });

		return comboBox3;
}
	
	private JButton getjb2Button() {// 初始化品牌-“大众”按钮
		if (jb2 == null) {
			jb2=new JButton("大众");//价格-“不限”按钮
			jb2.setBounds(new Rectangle(135,108, 60, 20));
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%大众%\"";
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jb2;// 返回“估价”按钮
	}	
	
	

	
	private JButton getjb3Button() {// 初始化品牌-“本田”按钮
		if (jb3 == null) {
			jb3=new JButton("本田");
			jb3.setBounds(new Rectangle(210,108, 60, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jb3;// 返回“估价”按钮
	}	
	
	private JButton getjb4Button() {// 初始化品牌-“福特”按钮
		if (jb4 == null) {
			jb4=new JButton("福特");
			jb4.setBounds(new Rectangle(290,108, 70, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jb4;// 返回“估价”按钮
	}	
	
	private JButton getjb5Button() {// 初始化品牌-“别克”按钮
		if (jb5 == null) {
			jb5=new JButton("别克");
			jb5.setBounds(new Rectangle(385,108, 60, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jb5;// 返回“估价”按钮
	}	
	
	private JButton getjb6Button() {// 初始化品牌-“奥迪”按钮
		if (jb6 == null) {
			jb6=new JButton("奥迪");
			jb6.setBounds(new Rectangle(470,108, 60, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
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
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
			jb7.setBounds(new Rectangle(550,108, 70, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
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
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
			jbu2=new JButton("高尔夫");//价格-“不限”按钮
			jbu2.setBounds(new Rectangle(135,138, 70, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbu2;// 返回“估价”按钮
	}	
	
	private JButton getjbu3Button() {// 初始化车系-“大众POLO”按钮
		if (jbu3 == null) {
			jbu3=new JButton("大众POLO");
			jbu3.setBounds(new Rectangle(230,138, 85, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbu3;// 返回“估价”按钮
	}	
	
	private JButton getjbu4Button() {// 初始化车系-“速腾”按钮
		if (jbu4 == null) {
			jbu4=new JButton("速腾");
			jbu4.setBounds(new Rectangle(335,138, 60, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbu4;// 返回“估价”按钮
	}	
	
	private JButton getjbu5Button() {// 初始化车系-“朗逸”按钮
		if (jbu5 == null) {
			jbu5=new JButton("朗逸");
			jbu5.setBounds(new Rectangle(410,138, 60, 20));
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbu5;// 返回“估价”按钮
	}	
	
	private JButton getjbu6Button() {// 初始化车系-“福克斯”按钮
		if (jbu6 == null) {
			jbu6=new JButton("福克斯");
			jbu6.setBounds(new Rectangle(500,138, 70, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
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
							String[] title = {"id","车辆标题","车龄","里程","变速器","卖家报价","所在城市","联系方式"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
			jbut2=new JButton("3万以下");//价格-“不限”按钮
			jbut2.setBounds(new Rectangle(135,168,75, 20));
			jbut2.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<3";
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
					}
		
				catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut2;// 返回“估价”按钮
	}
	
	private JButton getjbut3Button() {// 初始化价格-“3-5万”按钮
		if (jbut3 == null) {
			jbut3=new JButton("3-5万");//价格-“不限”按钮
			jbut3.setBounds(new Rectangle(235,168,75, 20));
			jbut3.addActionListener(new ActionListener() {// 为“估价”按钮天津爱动作事件的监听
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
			jbut4=new JButton("5-7万");//价格-“不限”按钮
			jbut4.setBounds(new Rectangle(340,168,75, 20));
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
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut4;// 返回“估价”按钮
	}
	
	private JButton getjbut5Button() {// 初始化价格-“7-9万”按钮
		if (jbut5 == null) {
			jbut5=new JButton("7-9万");//价格-“不限”按钮
			jbut5.setBounds(new Rectangle(440,168,75, 20));
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
			jbut6.setBounds(new Rectangle(540,168,75, 20));
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
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut6;// 返回“估价”按钮
	}
	
	private void initialize() {// 初始化登录窗体
		setLocation(320, 100);// 设置登录窗体位置
		setSize(700,550);// 设置登录窗体的宽高
		this.setTitle("我要买车");// 设置登录窗体的标题
		setContentPane(getGujiaPanel());// 将登录面板置于登录窗体中
	}


}

