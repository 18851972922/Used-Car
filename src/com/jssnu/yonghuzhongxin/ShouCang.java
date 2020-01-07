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



public class ShouCang extends JFrame {// �������۴���
	private static final long serialVersionUID = 1L;
	private ShouCangPanel shoucangPanel = null;// �ղ����
//	private JLabel jLabel = null;// ���������ġ���ǩ
//	private JTextField ageField = null;// ���������ġ��ı���
	private JLabel jLabel1 = null;// ���������ġ���ǩ
//	private JTextField mileageField = null;// ���ղء��ı���
//	private JLabel jLabel2 = null;// ����ϵ�ͷ�����ǩ
//	public JComboBox<String> comboBox;//����ѡ���
	private JLabel jLabel2 = null;// �������û�id����ǩ
	private JLabel jLabel3 = null;// �������ղ���Ʒid����ǩ
	
	
	private JButton backButton = null;// �����ء���ť
	private JButton priceButton = null;// ���ղس�������ť
	private JButton priceButton2 = null;// ����ϵ�ͷ�����ť
	private JButton priceButton3 = null;// ���鿴�ղء���ť
	private JButton priceButton4 = null;// ��ɾ���ղء���ť
	
	private JTextField yonghuidField = null;//�����û�id�ı���
	private JTextField shoucangidField = null;//�����ղ���Ʒid�ı���
	
	private static String yonghuidStr;// �������û�id���ı����е�����
	private static String shoucangidStr; //�������ղ���Ʒid���ı����е�����

	
	private JTable tabDemo;   //���ģ��
	private JScrollPane scpDemo; //������
    
	private MainFrame mainFrame;// ������
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public String getyonghuStr() {// ��á������û�id���ı����е�����
		return yonghuidStr;// �����ı����е�����
	}
	
	public String getshoucangStr() {// ��á������ղ���Ʒid���ı����е�����
		return shoucangidStr;// �����ı����е�����
	}
	public ShouCang() {// ����Ĺ��췽��
		try {
			// ���ô���ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ShouCangPanel getShouCangPanel() {// ��ʼ���ղ����ķ���
		if (shoucangPanel == null) {// �ղ������û�����ʱ
//			JTabbedPane tabbedPane = new JTabbedPane();   //�ӱ߿�
//			tabbedPane.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //���ñ߿���ɫ
//			tabbedPane.setBounds(new Rectangle(2200,2200,600, 130));  //���ñ߿�λ�ô�С
			
			jLabel1 = new JLabel();// ���������ġ���ǩ
			jLabel1.setBounds(new Rectangle(60,68, 100,95));// ���á��������ġ���ǩ��λ������
//			jLabel1.setText("��������");// ���á��������ġ���ǩ���ı�����
			jLabel1.setIcon(new ImageIcon(getClass().getResource("/res/gerenzhongxin2.jpg")));
//			jLabel = new JLabel();// ���û�������ǩ
//			jLabel.setText("�ղس���");// ���á��ղس�������ǩ�ı�����
//			jLabel.setBounds(new Rectangle(90, 170, 100, 18));// ���á��ղس�������ǩ��λ������
			
			jLabel2 = new JLabel();//�������û�id����ǩ
			jLabel2.setText("�ղ���Ʒid");// ���á������û�id����ǩ���ı�����
			jLabel2.setBounds(new Rectangle(300,165, 100, 18));// ���á������û�id����ǩ��λ������
			
			
			jLabel3 = new JLabel();//�������ղ�id����ǩ
			jLabel3.setText("�����û�id");// ���ñ�ǩ���ı�����
			jLabel3.setBounds(new Rectangle(300,50, 88, 24));// ���ñ�ǩ��λ������
//			jLabel4 = new JLabel();//����ѯ�ղء���ǩ
//			jLabel4.setText("ɾ���ղ�");// ���á�ɾ���ղء���ǩ���ı�����
//			jLabel4.setBounds(new Rectangle(300,120, 100, 18));// ���á�ɾ���ղء���ǩ��λ������
			scpDemo = new JScrollPane();   //��ʾ�ղ����
			scpDemo.setBounds(new Rectangle(70,252,570,250));
			
			
			shoucangPanel = new ShouCangPanel();// �ղ����
			shoucangPanel.setLayout(null);// �����ղ����Ĳ���Ϊ���Բ���
			shoucangPanel.setBackground(new Color(0xD8DDC7));// �����ղ����ı���ɫ
//			shoucangPanel.add(jLabel, null);// �ѡ��������ġ���ǩ�����ղ������
//			shoucangPanel.add(getAgeField(), null);// �ѡ��������ġ��ı��������ղ������
			
			shoucangPanel.add(jLabel1, null);// �ѡ��������ġ���ǩ�����ղ������
			shoucangPanel.add(jLabel2, null);// �ѡ��������û�id����ǩ�����ղ������
			shoucangPanel.add(jLabel3, null);// �ѡ��������ղ�id����ǩ�����ղ������

			shoucangPanel.add(getyonghuidField(), null);// �ѡ������û�id���ı��������ղ������
			shoucangPanel.add(getshoucangidField(), null);// �ѡ������û�id���ı��������ղ������
//			shoucangPanel.add(jLabel2, null);// �ѡ���ϵ�ͷ�����ǩ�����ղ������
//			shoucangPanel.add(getcomboBox(),null);//�ѡ���ϵ�ͷ����ı��������ղ������
//			shoucangPanel.add(getPriceField(), null);// �ѡ����ۡ��ı������ڵ�¼�����
			
			shoucangPanel.add(getPriceButton(), null);// �ѡ��ղس�������ť�����ղ������
//			shoucangPanel.add(getPriceButton2(), null);// �ѡ���ϵ�ͷ�����ť�����ղ������
			shoucangPanel.add(getPriceButton2(), null);// �ѡ���ϵ�ͷ�����ť�����ղ������
			shoucangPanel.add(getBackButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
//			shoucangPanel.add(jLabel3, null);// �ѡ���ѯ�ղء���ǩ�����ղ������
//			shoucangPanel.add(jLabel4, null);// �ѡ�ɾ���ղء���ǩ�����ղ������
			shoucangPanel.add(getPriceButton3(), null);// �ѡ��鿴�ղء���ť�����ղ������
			shoucangPanel.add(getPriceButton4(), null);// �ѡ�ɾ���ղء���ť�����ղ������
			
			
			shoucangPanel.add(scpDemo);
//			shoucangPanel.add(tabDemo);
			
			
		}
		return shoucangPanel;// �����ղ����
	}

	private JTextField getshoucangidField() {// ��ʼ���������ղ�id���ı���
		if (shoucangidField == null) {// �ı������Ϊ��ʱ
			shoucangidField = new JTextField();// ʵ�����ı���
			shoucangidField.setBounds(new Rectangle(400, 160,88 , 24));// �����ı����λ�úͿ��
		}
		return shoucangidField;// ���ء����䡱�ı���
	}

	private JTextField getyonghuidField() {// ��ʼ���������û�id���ı���
		if (yonghuidField == null) {// �ı������Ϊ��ʱ
			yonghuidField = new JTextField();// ʵ��������̡��ı���
			yonghuidField.setBounds(new Rectangle(400,50, 88, 24));// ���á���̡��ı����λ�úͿ��
		}
		return yonghuidField;// ���ء���̡��ı���
	}

//	private JComboBox<String> getcomboBox() {// ������	
//			comboBox = new JComboBox<String>();// ʵ��������������������
//			 String[] select = {"����","�Զ�","�ֶ�"}; //	        ���ѡ��ֵ
//	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
//			comboBox.setBounds(180, 220, 127, 22);// ���á����������ı����λ�úͿ��
//			return comboBox;
//	}
	
	private JButton getPriceButton() {// ��ʼ�����ղس�������ť
		if (priceButton == null) {
			priceButton = new JButton();
			priceButton.setBounds(new Rectangle(70, 160,77, 35));
			priceButton.setIcon(new ImageIcon(getClass().getResource("/res/shoucangcheliang2.PNG")));
//			priceButton.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
//				public void actionPerformed(ActionEvent e) {
//					try {
//						if (priceButton == e.getSource()) {//����ǹ��������ť�������,
//							double ageStr=Double.valueOf(ageField.getText()).doubleValue();
//							double mileageStr = Double.valueOf(mileageField.getText()).doubleValue(); //��ȡ�����ı����е�����
//							if(comboBox.getSelectedItem()=="�Զ�") {
//								double mission = 1;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.													
//							}else if(comboBox.getSelectedItem()=="�ֶ�"){
//								double mission = 2;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.							
//							}else {
//								double mission = 1.5;
//								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
//								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.									
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
		return priceButton;// ���ء����ۡ���ť
	}
	
	private JButton getPriceButton2() {// ��ʼ������ϵ�ͷ�����ť
		if (priceButton2 == null) {
			priceButton2 = new JButton();
			priceButton2.setBounds(new Rectangle(70, 200,77,35));
			priceButton2.setIcon(new ImageIcon(getClass().getResource("/res/lianxikefu2.PNG")));
			priceButton2.addActionListener(new ActionListener() {// Ϊ����ϵ�ͷ�����ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton2 == e.getSource()) {//�������ϵ�ͷ������ť�������,
							
//							JFrame frame = new JFrame("��ϵ�ͷ�");
//							frame.setLayout(null);
//							frame.setBounds(600, 600, 500, 300);
//							frame.setVisible(true);
//							frame.add(new JLabel("zhesasfdafsrgrghdghhjy"));
							JOptionPane.showInputDialog(this,"������������Ľ�������");
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton2;// ���ء���ϵ�ͷ�����ť
	}
	
	private JButton getPriceButton3() {// ��ʼ�����鿴�ղء���ť
		if (priceButton3 == null) {
			priceButton3 = new JButton();
			priceButton3.setBounds(new Rectangle(200, 50,88,24));
			priceButton3.setIcon(new ImageIcon(getClass().getResource("/res/chakanshoucang.jpg")));
			priceButton3.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
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
							// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
							
							// �����ͷ
							String[] title = {"�ղ�id","�û�id","��Ʒid","Ʒ��","����","����","������","����","�绰"};
							 //����JTable
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
		return priceButton3;// ���ء����ۡ���ť
	}
	
	
	private JButton getPriceButton4() {// ��ʼ����ɾ���ղء���ť
		if (priceButton4 == null) {
			priceButton4 = new JButton();
			priceButton4.setBounds(new Rectangle(200, 150,88,34));
			priceButton4.setIcon(new ImageIcon(getClass().getResource("/res/shanchushoucang.jpg")));
			priceButton4.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton4 == e.getSource()) {//����ǹ��������ť�������,
							
							String yonghuidStr=yonghuidField.getText();
							String shoucangidStr = shoucangidField.getText();
							BaseDao bd=new BaseDao();
							String sql = "delete from tb_shoucang where user_id = ? and product1 = ?";		
							bd.update(sql,yonghuidStr,shoucangidStr);	
							JOptionPane.showMessageDialog(ShouCang.this, "�ղ���Ʒ�Ѿ��ɹ�ɾ��", "ɾ���ղ�",
									JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton4;// ���ء�ɾ���ղء���ť
	}
//	
//	private JTextField getPriceField() {// ��ʼ�������ۡ��ı���
//		if (priceField == null) {
//			priceField = new JTextField();
//			priceField.setBounds(new Rectangle(180,270, 127, 27));
//		}
//		return priceField;// ���ء����ۡ��ı���
//	}
	
	private JButton getBackButton() {// ��ʼ����������ҳ����ť
		if (backButton == null) {// �����ء���ť����Ϊ��ʱ
			backButton = new JButton();// ʵ���������ء���ť
			backButton.setBounds(new Rectangle(540, 515, 50, 20));// ���á����ء���ť��λ�úͿ��
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// ���á����ء���ť��ͼ��
			backButton.addActionListener(new ActionListener() {// Ϊ�����ء���ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
//					System.exit(0);// �˳���ǰ��Ӧ�ó���
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return backButton;// ���ء����ء���ť
	}

	private void initialize() {// ��ʼ���ղش���
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
//		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// �����ղش���
		setLocation(320, 100);
		setSize(700, 600);// ���ô���Ŀ��
		this.setTitle("��������");// ���ô���ı���
		setContentPane(getShouCangPanel());// ���ղ���������ղش�����
	}


}
