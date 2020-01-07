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

public class Buycar extends JFrame {// �������۴���
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// �������
	private JTextField searchField = null;// ���������ı���
	private JButton jb2=null;//Ʒ��-�����ڡ���ť
	private JButton jb3=null;//Ʒ��-�������ť
	private JButton jb4=null;//Ʒ��-�����ء���ť
	private JButton jb5=null;//Ʒ��-����ˡ���ť
	private JButton jb6=null;//Ʒ��-���µϡ���ť
	private JButton jb7=null;//Ʒ��-�����Դ��ť
	
	private JButton jbu2=null;//��ϵ-���߶��򡱰�ť
	private JButton jbu3=null;//��ϵ-������POLO����ť
	private JButton jbu4=null;//��ϵ-�����ڡ���ť
	private JButton jbu5=null;//��ϵ-�����ݡ���ť
	private JButton jbu6=null;//��ϵ-������˹����ť
	
	private JButton jbut2=null;//�۸�-��3�����¡���ť
	private JButton jbut3=null;//�۸�-��3-5�򡱰�ť
	private JButton jbut4=null;//�۸�-��5-7�򡱰�ť
	private JButton jbut5=null;//�۸�-��7-9�򡱰�ť
	private JButton jbut6=null;//�۸�-��9�����ϡ���ť
	
	private JButton search=null;//������ť
	private JButton chaxun=null;//��ѯ��ť
	
	private JLabel jLabel1 = null;// ��Ʒ�ơ���ǩ
	private JLabel jLabel2 = null;// ����ϵ����ǩ
	private JLabel jLabel3 = null;// ���۸񡱱�ǩ
	private JLabel jLabel4 = null;// �����ࡱ��ǩ
	private JLabel jLabel5 = null;//��ע�͡���ǩ
	
	private static String searchStr;// �����䡱�ı����е�����
	private JScrollPane scpDemo; //������
	private JTable tabDemo;   //���ģ��
	private JButton backButton = null;// ��������ҳ����ť
    private MainFrame mainFrame;// ������
    JComboBox<String> comboBox1;  //����������
    JComboBox<String> comboBox2;//������������
    JComboBox<String> comboBox3; //���������
    private String age;//����ȫ�ֱ���
    private String mession; //������ȫ�ֱ���
    private String miles; //���ȫ�ֱ���
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public static String getSearchStr() {  //get�����ı����е�����
		return searchStr;
	}



	public Buycar() {// ����Ĺ��췽��
		try {
			// ���ô���ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getGujiaPanel() {// ��ʼ��Buycar���ķ���
		if (gujiaPanel == null) {// �����û�����ʱ
			
			JTabbedPane tabbedPane = new JTabbedPane();   //�Ӳ�ѯ�����߿���������
			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //���ñ߿���ɫ
			tabbedPane.setBounds(new Rectangle(70,100,555, 130));  //���ñ߿�λ�ô�С
		
			jLabel1 = new JLabel();//��Ʒ�ơ���ǩ
			jLabel1.setText("Ʒ��");// ���á�Ʒ�ơ���ǩ���ı�����
			jLabel1.setBounds(new Rectangle(90,110, 110, 18));// ���á�Ʒ�ơ���ǩ��λ������
			jLabel2 = new JLabel();//����ϵ����ǩ
			jLabel2.setText("��ϵ");
			jLabel2.setBounds(new Rectangle(90,140, 110, 18));
			jLabel3 = new JLabel();//���۸񡱱�ǩ
			jLabel3.setText("�۸�");
			jLabel3.setBounds(new Rectangle(90,170, 110, 18));
			jLabel4 = new JLabel();//�����ࡱ��ǩ
			jLabel4.setText("����");
			jLabel4.setBounds(new Rectangle(90,200, 110, 18));
			jLabel5 = new JLabel();//��ע�͡���ǩ
			jLabel5.setText("*��������Ϊ��λ�����������Ϊ��λ��������1Ϊ�Զ���2Ϊ�ֶ����۸�����ԪΪ��λ");
			jLabel5.setBounds(new Rectangle(160,220, 500, 18));
			
			scpDemo = new JScrollPane();   //�������λ��
			scpDemo.setBounds(new Rectangle(70,240,570,250));
			
			gujiaPanel = new GujiaPanel();// �����
			gujiaPanel.setLayout(null);// �������Ĳ���Ϊ���Բ���
			gujiaPanel.add(jLabel1, null);// �ѡ�Ʒ�ơ���ǩ���������
			gujiaPanel.add(jLabel2, null);// �ѡ���ϵ����ǩ���������
			gujiaPanel.add(jLabel3, null);// �ѡ��۸񡱱�ǩ���������
			gujiaPanel.add(jLabel4, null);// �ѡ����ࡱ��ǩ���������
			gujiaPanel.add(jLabel5, null);// �ѡ�ע�͡���ǩ���������
			
			gujiaPanel.add(getSearchField(), null);// ���������ı������������
			gujiaPanel.add(getcomboBox1(),null);//�ѡ����䡱�ı������������
			gujiaPanel.add(getcomboBox2(),null);//�ѡ����������ı������������
			gujiaPanel.add(getcomboBox3(),null);//�ѡ���̡��ı������������
			
			gujiaPanel.add(getjb2Button(), null);// �ѡ����ڡ���ť���������
			gujiaPanel.add(getjb3Button(), null);// �ѡ������ť���������
			gujiaPanel.add(getjb4Button(), null);// �ѡ����ء���ť���������
			gujiaPanel.add(getjb5Button(), null);// �ѡ���ˡ���ť���������
			gujiaPanel.add(getjb6Button(), null);// �ѡ��µϡ���ť���������
			gujiaPanel.add(getjb7Button(), null);// �ѡ����Դ��ť���������
			
			gujiaPanel.add(getjbu2Button(), null);// �ѡ��߶��򡱰�ť���������
			gujiaPanel.add(getjbu3Button(), null);// �ѡ�����POLO����ť���������
			gujiaPanel.add(getjbu4Button(), null);// �ѡ����ڡ���ť���������
			gujiaPanel.add(getjbu5Button(), null);// �ѡ����ݡ���ť���������
			gujiaPanel.add(getjbu6Button(), null);// �ѡ�����˹����ť���������

			
			gujiaPanel.add(getjbut2Button(), null);// �ѡ�3�����¡���ť���������
			gujiaPanel.add(getjbut3Button(), null);// �ѡ�3-5�򡱰�ť���������
			gujiaPanel.add(getjbut4Button(), null);// �ѡ�5-7�򡱰�ť���������
			gujiaPanel.add(getjbut5Button(), null);// �ѡ�7-9�򡱰�ť���������
			gujiaPanel.add(getjbut6Button(), null);// �ѡ�9�����ϡ���ť���������
			gujiaPanel.add(getchaxunButton(),null);//�Ѳ�ѯ��ť���������
			gujiaPanel.add(getsearchButton(),null);//��������ť���������
			gujiaPanel.add(scpDemo);     //�ѹ���������������
			gujiaPanel.add(getBackButton(), null);// �ѡ�������ҳ����ť���ڵ�¼�����

	
		}
		return gujiaPanel;// �������
	}

	private JTextField getSearchField() {// ��ʼ�����������ı���
		if (searchField== null) {
			searchField = new JTextField();
			searchField.setBounds(new Rectangle(350,60,150, 22));  //����λ��
		}
		return searchField;
	}
	private JButton getsearchButton() {// ��ʼ������������ť
		if (search == null) {
			search=new JButton("����");
			search.setBounds(new Rectangle(530,55,60,27));
			search.addActionListener(new ActionListener() {   //��Ӽ����¼�
				public void actionPerformed(ActionEvent e) {
					try{
						if(search == e.getSource()) {  //��������ť�����
							String searchStr=searchField.getText();  //��ȡ�������е��ı�����
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%"+searchStr+"%\"";//��ѯ���
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){    //��ȡ��ѯ���ݵ�����
							count++;
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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

	private JComboBox<String> getcomboBox1() {// ����		
		comboBox1 = new JComboBox<String>();// ʵ���������䡱������
		 String[] select = {"����","1������","1-3��","3-5��","5������"}; //	        ���ѡ��ֵ
        comboBox1.setModel(new DefaultComboBoxModel<String>(select));
		comboBox1.setBounds(150, 197, 90, 22);// ���á����䡱�ı����λ�úͿ��
		return comboBox1;// ����������
}

	private JComboBox<String> getcomboBox2() {// ������	
			comboBox2 = new JComboBox<String>();// ʵ��������������������
			 String[] select = {"������","�ֶ�","�Զ�"}; //	        ���ѡ��ֵ
	        comboBox2.setModel(new DefaultComboBoxModel<String>(select));
			comboBox2.setBounds(300, 197, 90, 22);// ���á����������ı����λ�úͿ��
			return comboBox2;
	}
	
	private JComboBox<String> getcomboBox3() {// ���	
		comboBox3 = new JComboBox<String>();// ʵ��������̡�������
		 String[] select = {"���","1������","3��������","5��������","7������","7��������"}; //	        ���ѡ��ֵ
        comboBox3.setModel(new DefaultComboBoxModel<String>(select));
		comboBox3.setBounds(450, 197, 90, 22);// ���á���̡��ı����λ�úͿ��
		return comboBox3;
}

	private JButton getchaxunButton() {// ��ʼ������ѯ����ť
		if (chaxun == null) {
			chaxun=new JButton("��ѯ");
			chaxun.setBounds(new Rectangle(555,195,60,25));
			chaxun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(chaxun == e.getSource()) {
						   
							String com1=(String) comboBox1.getSelectedItem(); //��ȡ�������е�����
							if(com1=="1������") {   //���������������һ���������������age<1 ,�Ա���sql����ƴ��
								age="age<1";
							}else if(com1=="1-3��") {
								age="1<age<3";
							}else if(com1=="3-5��") {
								age="3<age<5";
							}else if(com1=="5������") {
								age="age>5";
							}
							String com2=(String) comboBox2.getSelectedItem();
							if(com2=="�ֶ�") {
								mession="comboBox=1";
							}else if(com2=="�Զ�") {
								mession="comboBox=2";
							}
							String com3=(String) comboBox3.getSelectedItem();
							if(com3=="1��������") {
								miles="miles<1";
							}else if(com3=="3��������") {
								miles="miles<3";
							}else if(com3=="5��������") {
								miles="miles<5";
							}else if(com3=="7��������") {
								miles="miles<7";
							}else if(com3=="7��������") {
								miles="miles>7";
							}
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where "+age+" and "+mession+" and "+miles;//sql���ƴ��
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjb2Button() {// ��ʼ��Ʒ��-�����ڡ���ť
		if (jb2 == null) {
			jb2=new JButton("����");
			jb2.setBounds(new Rectangle(135,108, 70, 20));
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";//sqlģ����ѯ
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	

	
	private JButton getjb3Button() {// ��ʼ��Ʒ��-�������ť
		if (jb3 == null) {
			jb3=new JButton("����");
			jb3.setBounds(new Rectangle(210,108, 70, 20));
			jb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb3 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjb4Button() {// ��ʼ��Ʒ��-�����ء���ť
		if (jb4 == null) {
			jb4=new JButton("����");
			jb4.setBounds(new Rectangle(290,108, 80, 20));
			jb4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb4 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjb5Button() {// ��ʼ��Ʒ��-����ˡ���ť
		if (jb5 == null) {
			jb5=new JButton("���");
			jb5.setBounds(new Rectangle(385,108,70, 20));
			jb5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb5 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%���%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjb6Button() {// ��ʼ��Ʒ��-���µϡ���ť
		if (jb6 == null) {
			jb6=new JButton("�µ�");
			jb6.setBounds(new Rectangle(470,108, 70, 20));
			jb6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb6 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%�µ�%\"";
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
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
	
	private JButton getjb7Button() {// ��ʼ��Ʒ��-�����Դ��ť
		if (jb7 == null) {
			jb7=new JButton("���Դ�");
			jb7.setBounds(new Rectangle(550,108,80, 20));
			jb7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb7 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%���Դ�%\"";
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
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
	
	private JButton getjbu2Button() {// ��ʼ����ϵ-���߶��򡱰�ť
		if (jbu2 == null) {
			jbu2=new JButton("�߶���");
			jbu2.setBounds(new Rectangle(135,138,80, 20));
			jbu2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%�߶���%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbu3Button() {// ��ʼ����ϵ-������POLO����ť
		if (jbu3 == null) {
			jbu3=new JButton("����POLO");
			jbu3.setBounds(new Rectangle(230,138,95, 20));
			jbu3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu3 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����POLO%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbu4Button() {// ��ʼ����ϵ-�����ڡ���ť
		if (jbu4 == null) {
			jbu4=new JButton("����");
			jbu4.setBounds(new Rectangle(335,138,70, 20));
			jbu4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu4 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbu5Button() {// ��ʼ����ϵ-�����ݡ���ť
		if (jbu5 == null) {
			jbu5=new JButton("����");
			jbu5.setBounds(new Rectangle(410,138,70, 20));
			jbu5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu5 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbu6Button() {// ��ʼ����ϵ-������˹����ť
		if (jbu6 == null) {
			jbu6=new JButton("����˹");
			jbu6.setBounds(new Rectangle(500,138,80, 20));
			jbu6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbu6 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����˹%\"";
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
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
		
	private JButton getjbut2Button() {// ��ʼ���۸�-��3�����¡���ť
		if (jbut2 == null) {
			jbut2=new JButton("3������");
			jbut2.setBounds(new Rectangle(135,168,85, 20));
			jbut2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jbut2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message WHERE price<3";//������ѯ
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbut3Button() {// ��ʼ���۸�-��3-5�򡱰�ť
		if (jbut3 == null) {
			jbut3=new JButton("3-5��");
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut3;// ���ء����ۡ���ť
	}
	
	private JButton getjbut4Button() {// ��ʼ���۸�-��3-7�򡱰�ť
		if (jbut4 == null) {
			jbut4=new JButton("5-7��");
			jbut4.setBounds(new Rectangle(340,168,85, 20));
			jbut4.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getjbut5Button() {// ��ʼ���۸�-��7-9�򡱰�ť
		if (jbut5 == null) {
			jbut5=new JButton("7-9��");//�۸�-�����ޡ���ť
			jbut5.setBounds(new Rectangle(440,168,85, 20));
			jbut5.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
							scpDemo.getViewport().add(tabDemo);
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return jbut5;// ���ء����ۡ���ť
	}
	
	private JButton getjbut6Button() {// ��ʼ���۸�-��7-9�򡱰�ť
		if (jbut6 == null) {
			jbut6=new JButton("9������");//�۸�-�����ޡ���ť
			jbut6.setBounds(new Rectangle(540,168,85, 20));
			jbut6.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
							tabDemo.setEnabled(false);// ���ñ��ģ���޷���Ӧ�û�����
							tabDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
							// ��JTable���뵽���������������
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
	
	private JButton getBackButton() {// ��ʼ����������ҳ����ť
		if (backButton == null) {// �����ء���ť����Ϊ��ʱ
			backButton = new JButton();// ʵ���������ء���ť
			backButton.setBounds(new Rectangle(550,25,60, 20));// ���á����ء���ť��λ�úͿ��
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// ���á����ء���ť��ͼ��
			backButton.addActionListener(new ActionListener() {// Ϊ�����ء���ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return backButton;// ���ء����ء���ť
	}
	
	private void initialize() {// ��ʼ����¼����
		setLocation(320, 100);// ���õ�¼����λ��
		setSize(700,550);// ���õ�¼����Ŀ��
		this.setTitle("��Ҫ��");// ���õ�¼����ı���
		setContentPane(getGujiaPanel());// ����¼������ڵ�¼������
	}


}

