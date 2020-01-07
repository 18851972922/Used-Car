package com.jssnu.kankan;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.dao.BaseDao;
import com.jssnu.gujia.GujiaPanel;
import com.jssnu.headpage.HeadPage;


public class GaoDuan extends JFrame {// �������۴���
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// �������
	private JLabel jLabel = null;// �����䡱��ǩ
	private JScrollPane scpDemo; //������
	private JTable tabDemo;   //���ģ��
	private JButton backButton = null;// �����ء���ť
    private MainFrame mainFrame;// ������
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	

	public GaoDuan() {// ����Ĺ��췽��
		try {
			// ���ô���ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getGujiaPanel()  {// ��ʼ��loginPanel��¼���ķ���
		if (gujiaPanel == null) {// ��¼�����û�����ʱ
			
			jLabel = new JLabel();// ��ǩ
			jLabel.setText("�߶˳�");// ���á���ǩ���ı�����
			jLabel.setBounds(new Rectangle(50, 70, 100, 18));// ���ñ�ǩ��λ������
			
			gujiaPanel = new GujiaPanel();// ���
			gujiaPanel.setLayout(null);// �������Ĳ���Ϊ���Բ���
			gujiaPanel.setBackground(new Color(0xD8DDC7));// �������ı���ɫ
			gujiaPanel.add(jLabel, null);// �ѱ�ǩ���ڵ�¼�����
			scpDemo = new JScrollPane();   //�������
			scpDemo.setBounds(new Rectangle(50,100,570,350));
			gujiaPanel.add(scpDemo);
			
			gujiaPanel.add(getBackButton(), null);// �Ѱ�ť���ڵ�¼�����
			try {
    		
					BaseDao bd=new BaseDao();
    				String sql = "SELECT * FROM cars_message where price>25";
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
    		
    	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
    	}
    	}

		return gujiaPanel;// �������
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
		setLocation(320, 100);
		setSize(700, 550);// ���õ�¼����Ŀ��
		this.setTitle("�߶˳�");// ���õ�¼����ı���
		setContentPane(getGujiaPanel());// ����¼������ڵ�¼������
	}


}
