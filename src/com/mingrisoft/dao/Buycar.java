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
	
	private JButton search=null;
	
	private JLabel jLabel1 = null;// ��Ʒ�ơ���ǩ
	private JLabel jLabel2 = null;// ����ϵ����ǩ
	private JLabel jLabel3 = null;// ���۸񡱱�ǩ
	private JLabel jLabel4 = null;// �����ࡱ��ǩ
	private JLabel jLabel5 = null;//��ע�͡���ǩ
	private static String searchStr;// �����䡱�ı����е�����
	private JScrollPane scpDemo; //������
	private JTable tabDemo;   //���ģ��
    private MainFrame mainFrame;// ������

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public static String getSearchStr() {
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

	private GujiaPanel getGujiaPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (gujiaPanel == null) {// ��¼�����û�����ʱ
			
			JTabbedPane tabbedPane = new JTabbedPane();   //�ӱ߿�
			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //���ñ߿���ɫ
			tabbedPane.setBounds(new Rectangle(70,100,555, 130));  //���ñ߿�λ�ô�С
		
			jLabel1 = new JLabel();//��Ʒ�ơ���ǩ
			jLabel1.setText("Ʒ��");// ���á�Ʒ�ơ���ǩ���ı�����
			jLabel1.setBounds(new Rectangle(90,110, 100, 18));// ���á�Ʒ�ơ���ǩ��λ������
			jLabel2 = new JLabel();//����ϵ����ǩ
			jLabel2.setText("��ϵ");
			jLabel2.setBounds(new Rectangle(90,140, 100, 18));
			jLabel3 = new JLabel();//���۸񡱱�ǩ
			jLabel3.setText("�۸�");
			jLabel3.setBounds(new Rectangle(90,170, 100, 18));
			jLabel4 = new JLabel();//�����ࡱ��ǩ
			jLabel4.setText("����");
			jLabel4.setBounds(new Rectangle(90,200, 100, 18));
			jLabel5 = new JLabel();//��ע�͡���ǩ
			jLabel5.setText("*��������Ϊ��λ�����������Ϊ��λ��������1Ϊ�Զ���2Ϊ�ֶ����۸�����ԪΪ��λ");
			jLabel5.setBounds(new Rectangle(160,220, 500, 18));
			scpDemo = new JScrollPane();   //�������
			scpDemo.setBounds(new Rectangle(70,240,570,250));
			
			
			gujiaPanel = new GujiaPanel();// ��¼���
			gujiaPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			gujiaPanel.add(jLabel1, null);// �ѡ����ޡ���ǩ���ڵ�¼�����
			gujiaPanel.add(jLabel2, null);
			gujiaPanel.add(jLabel3, null);
			gujiaPanel.add(jLabel4, null);
			gujiaPanel.add(jLabel5, null);
			gujiaPanel.add(getSearchField(), null);// ���������ı������ڵ�¼�����

			gujiaPanel.add(getcomboBox1(),null);//�ѡ����䡱�ı������ڵ�¼�����
			gujiaPanel.add(getcomboBox2(),null);//�ѡ����䡱�ı������ڵ�¼�����
			gujiaPanel.add(getcomboBox3(),null);//�ѡ���̡��ı������ڵ�¼�����
			
			gujiaPanel.add(getjb2Button(), null);// �ѡ����ڡ���ť���ڵ�¼�����
			gujiaPanel.add(getjb3Button(), null);// �ѡ������ť���ڵ�¼�����
			gujiaPanel.add(getjb4Button(), null);// �ѡ����ء���ť���ڵ�¼�����
			gujiaPanel.add(getjb5Button(), null);// �ѡ���ˡ���ť���ڵ�¼�����
			gujiaPanel.add(getjb6Button(), null);// �ѡ��µϡ���ť���ڵ�¼�����
			gujiaPanel.add(getjb7Button(), null);// �ѡ����Դ��ť���ڵ�¼�����
			
			gujiaPanel.add(getjbu2Button(), null);// �ѡ��߶��򡱰�ť���ڵ�¼�����
			gujiaPanel.add(getjbu3Button(), null);// �ѡ�����POLO����ť���ڵ�¼�����
			gujiaPanel.add(getjbu4Button(), null);// �ѡ����ڡ���ť���ڵ�¼�����
			gujiaPanel.add(getjbu5Button(), null);// �ѡ����ݡ���ť���ڵ�¼�����
			gujiaPanel.add(getjbu6Button(), null);// �ѡ�����˹����ť���ڵ�¼�����

			
			gujiaPanel.add(getjbut2Button(), null);// �ѡ�3�����¡���ť���ڵ�¼�����
			gujiaPanel.add(getjbut3Button(), null);// �ѡ�3-5�򡱰�ť���ڵ�¼�����
			gujiaPanel.add(getjbut4Button(), null);// �ѡ�5-7�򡱰�ť���ڵ�¼�����
			gujiaPanel.add(getjbut5Button(), null);// �ѡ�7-9�򡱰�ť���ڵ�¼�����
			gujiaPanel.add(getjbut6Button(), null);// �ѡ�9�����ϡ���ť���ڵ�¼�����
			
			gujiaPanel.add(getsearchButton(),null);
			gujiaPanel.add(scpDemo);

	
		}
		return gujiaPanel;// ���ص�¼���
	}

	private JTextField getSearchField() {// ��ʼ�����������ı���
		if (searchField== null) {
			searchField = new JTextField();
			searchField.setBounds(new Rectangle(350,60,150, 22));
		}
		return searchField;
	}
	private JButton getsearchButton() {// ��ʼ������������ť
		if (search == null) {
			search=new JButton("����");//�۸�-�����ޡ���ť
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		JComboBox<String> comboBox1 = new JComboBox<String>();// ʵ���������䡱������
		 String[] select = {"����","1������","1-3��","3-5��","5������"}; //	        ���ѡ��ֵ
        comboBox1.setModel(new DefaultComboBoxModel<String>(select));
		comboBox1.setBounds(150, 197, 80, 22);// ���á����䡱�ı����λ�úͿ��
		return comboBox1;// ���ء����ۡ���ť
}	

	private JComboBox<String> getcomboBox2() {// ������	
			JComboBox<String> comboBox2 = new JComboBox<String>();// ʵ��������������������
			 String[] select = {"������","�ֶ�","�Զ�"}; //	        ���ѡ��ֵ
	        comboBox2.setModel(new DefaultComboBoxModel<String>(select));
			comboBox2.setBounds(300, 197, 80, 22);// ���á����������ı����λ�úͿ��
			return comboBox2;
	}
	
	private JComboBox<String> getcomboBox3() {// ���	
		JComboBox<String> comboBox3 = new JComboBox<String>();// ʵ��������̡�������
		 String[] select = {"���","1������","3��������","5��������","7������","7��������"}; //	        ���ѡ��ֵ
        comboBox3.setModel(new DefaultComboBoxModel<String>(select));
		comboBox3.setBounds(450, 197, 80, 22);// ���á���̡��ı����λ�úͿ��
//		
		comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		
            			if(comboBox3.getSelectedItem()=="1��������") {
            		
            				BaseDao bd=new BaseDao();
            				String sql = "SELECT * FROM cars_message where miles <1";
            				ResultSet rs=bd.query(sql);
            				int count = 0;
            				while(rs.next()){
            					count++;
            					System.out.println(count);
            				}
            				rs=bd.query(sql);
					// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
					// �����ͷ
            				String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
					// ����JTable
            				tabDemo = new JTable(info,title);
            				tabDemo.getTableHeader();
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

		return comboBox3;
}
	
	private JButton getjb2Button() {// ��ʼ��Ʒ��-�����ڡ���ť
		if (jb2 == null) {
			jb2=new JButton("����");//�۸�-�����ޡ���ť
			jb2.setBounds(new Rectangle(135,108, 60, 20));
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(jb2 == e.getSource()) {
					
							BaseDao bd=new BaseDao();
							String sql = "SELECT * FROM cars_message where name like \"%����%\"";
							ResultSet rs=bd.query(sql);
							int count = 0;
							while(rs.next()){
							count++;
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jb2;// ���ء����ۡ���ť
	}	
	
	

	
	private JButton getjb3Button() {// ��ʼ��Ʒ��-�������ť
		if (jb3 == null) {
			jb3=new JButton("����");
			jb3.setBounds(new Rectangle(210,108, 60, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jb3;// ���ء����ۡ���ť
	}	
	
	private JButton getjb4Button() {// ��ʼ��Ʒ��-�����ء���ť
		if (jb4 == null) {
			jb4=new JButton("����");
			jb4.setBounds(new Rectangle(290,108, 70, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jb4;// ���ء����ۡ���ť
	}	
	
	private JButton getjb5Button() {// ��ʼ��Ʒ��-����ˡ���ť
		if (jb5 == null) {
			jb5=new JButton("���");
			jb5.setBounds(new Rectangle(385,108, 60, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jb5;// ���ء����ۡ���ť
	}	
	
	private JButton getjb6Button() {// ��ʼ��Ʒ��-���µϡ���ť
		if (jb6 == null) {
			jb6=new JButton("�µ�");
			jb6.setBounds(new Rectangle(470,108, 60, 20));
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
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
	
	private JButton getjb7Button() {// ��ʼ��Ʒ��-�����Դ��ť
		if (jb7 == null) {
			jb7=new JButton("���Դ�");
			jb7.setBounds(new Rectangle(550,108, 70, 20));
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
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
	
	private JButton getjbu2Button() {// ��ʼ����ϵ-���߶��򡱰�ť
		if (jbu2 == null) {
			jbu2=new JButton("�߶���");//�۸�-�����ޡ���ť
			jbu2.setBounds(new Rectangle(135,138, 70, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbu2;// ���ء����ۡ���ť
	}	
	
	private JButton getjbu3Button() {// ��ʼ����ϵ-������POLO����ť
		if (jbu3 == null) {
			jbu3=new JButton("����POLO");
			jbu3.setBounds(new Rectangle(230,138, 85, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbu3;// ���ء����ۡ���ť
	}	
	
	private JButton getjbu4Button() {// ��ʼ����ϵ-�����ڡ���ť
		if (jbu4 == null) {
			jbu4=new JButton("����");
			jbu4.setBounds(new Rectangle(335,138, 60, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbu4;// ���ء����ۡ���ť
	}	
	
	private JButton getjbu5Button() {// ��ʼ����ϵ-�����ݡ���ť
		if (jbu5 == null) {
			jbu5=new JButton("����");
			jbu5.setBounds(new Rectangle(410,138, 60, 20));
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
							System.out.println(count);
							   }
							rs=bd.query(sql);
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbu5;// ���ء����ۡ���ť
	}	
	
	private JButton getjbu6Button() {// ��ʼ����ϵ-������˹����ť
		if (jbu6 == null) {
			jbu6=new JButton("����˹");
			jbu6.setBounds(new Rectangle(500,138, 70, 20));
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
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
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
		
	private JButton getjbut2Button() {// ��ʼ���۸�-��3�����¡���ť
		if (jbut2 == null) {
			jbut2=new JButton("3������");//�۸�-�����ޡ���ť
			jbut2.setBounds(new Rectangle(135,168,75, 20));
			jbut2.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbut2;// ���ء����ۡ���ť
	}
	
	private JButton getjbut3Button() {// ��ʼ���۸�-��3-5�򡱰�ť
		if (jbut3 == null) {
			jbut3=new JButton("3-5��");//�۸�-�����ޡ���ť
			jbut3.setBounds(new Rectangle(235,168,75, 20));
			jbut3.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
			jbut4=new JButton("5-7��");//�۸�-�����ޡ���ť
			jbut4.setBounds(new Rectangle(340,168,75, 20));
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbut4;// ���ء����ۡ���ť
	}
	
	private JButton getjbut5Button() {// ��ʼ���۸�-��7-9�򡱰�ť
		if (jbut5 == null) {
			jbut5=new JButton("7-9��");//�۸�-�����ޡ���ť
			jbut5.setBounds(new Rectangle(440,168,75, 20));
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
			jbut6.setBounds(new Rectangle(540,168,75, 20));
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
							// �����ͷ
							String[] title = {"id","��������","����","���","������","���ұ���","���ڳ���","��ϵ��ʽ"};
							// ����JTable
							tabDemo = new JTable(info,title);
							tabDemo.getTableHeader();
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
		return jbut6;// ���ء����ۡ���ť
	}
	
	private void initialize() {// ��ʼ����¼����
		setLocation(320, 100);// ���õ�¼����λ��
		setSize(700,550);// ���õ�¼����Ŀ��
		this.setTitle("��Ҫ��");// ���õ�¼����ı���
		setContentPane(getGujiaPanel());// ����¼������ڵ�¼������
	}


}

