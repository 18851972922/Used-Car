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

public class Maichefabu extends JFrame {// ������������
	String mession;
	private static final long serialVersionUID = 1L;
	private Maichepanel maichepanel = null;// �������
	private JLabel jLabel1 = null;// �����⡱��ǩ
	private JTextField biaotiField = null;// �����⡱�ı���
	private JLabel jLabel3 = null;// �����䡱��ǩ
	private JTextField timeField = null;// �����䡱�ı���
	private JLabel jLabel2 = null;// ���۸񡱱�ǩ
	private JTextField priceField = null;// ���۸��ı���
	private JLabel jLabel4 = null;// ������������ǩ
	public JComboBox<String> comboBox;//����ѡ���
	private JTextField comboField = null;// ���۸��ı���
	private JLabel jLabel5 = null;// ����̡���ǩ
	private JTextField mileageField = null;// ����̡��ı���
	private JLabel jLabel6 = null;// �����С���ǩ
	private JTextField cityField = null;// �����С��ı���
	private JLabel jLabel7 = null;// �����͡���ǩ
	private JTextField phoneField = null;// ����ϵ��ʽ���ı���
	private JButton quxiaoButton = null;// �����ء���ť
//	final JButton queding = new JButton();// ����ӡ���ť
	private JButton queding = null;// ��ȷ����������ť
    private MainFrame mainFrame;// ������

    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Maichefabu() {// ����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Maichepanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (maichepanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����⡱��ǩ
			jLabel1.setBounds(new Rectangle(100,80, 100, 18));// ���á����⡱��ǩ��λ������
			jLabel1.setText("���⣺");// ���á����⡱��ǩ���ı�����
			jLabel3 = new JLabel();//�����䡱��ǩ
			jLabel3.setText("���䣺");// ���á����䡱��ǩ���ı�����
			jLabel3.setBounds(new Rectangle(100,120, 100, 18));// ���á�����ʱ�䡱��ǩ��λ������
			jLabel4 = new JLabel();//������������ǩ
			jLabel4.setText("��������");// ���á�����������ǩ���ı�����
			jLabel4.setBounds(new Rectangle(100,160, 100, 18));// ���á�����������ǩ��λ������
			jLabel5 = new JLabel();//����̡���ǩ
			jLabel5.setText("��̣�");// ���á���̡���ǩ���ı�����
			jLabel5.setBounds(new Rectangle(100,200, 100, 18));// ���á���̡���ǩ��λ������
			jLabel6 = new JLabel();//�����С���ǩ
			jLabel6.setText("���У�");// ���á����С���ǩ���ı�����
			jLabel6.setBounds(new Rectangle(100,240, 100, 18));// ���á����С���ǩ��λ������
			jLabel7 = new JLabel();//����ϵ��ʽ����ǩ
			jLabel7.setText("��ϵ��ʽ��");// ���á���ϵ��ʽ����ǩ���ı�����
			jLabel7.setBounds(new Rectangle(100,280, 100, 18));// ���á���ϵ��ʽ����ǩ��λ������
			jLabel2 = new JLabel();//����ϵ��ʽ����ǩ
			jLabel2.setText("�۸�");// ���á���ϵ��ʽ����ǩ���ı�����
			jLabel2.setBounds(new Rectangle(100,320, 100, 18));// ���á���ϵ��ʽ����ǩ��λ������
			
			maichepanel = new Maichepanel();// ��¼���
			maichepanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			maichepanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			maichepanel.add(jLabel1, null);// �ѡ����⡱��ǩ���ڵ�¼�����
			maichepanel.add(getbiaotiField(), null);// �ѡ����⡱�ı������ڵ�¼�����
			maichepanel.add(jLabel2, null);// �ѡ�����ʱ�䡱��ǩ���ڵ�¼�����
			maichepanel.add(getpriceField(),null);//�ѡ����䡱�ı������ڵ�¼�����
			maichepanel.add(jLabel3, null);// �ѡ�����ʱ�䡱��ǩ���ڵ�¼�����
			maichepanel.add(gettimeField(),null);//�ѡ����䡱�ı������ڵ�¼�����
			maichepanel.add(jLabel4, null);// �ѡ�����������ǩ���ڵ�¼�����
			maichepanel.add(getcomboBox(), null);// �ѡ����������ı������ڵ�¼�����
			maichepanel.add(jLabel5, null);// �ѡ���̡���ǩ���ڵ�¼�����
			maichepanel.add(getmileageField(), null);// �ѡ���̡��ı������ڵ�¼�����
			maichepanel.add(jLabel6, null);// �ѡ����С���ǩ���ڵ�¼�����
			maichepanel.add(getcityField(),null);//�ѡ����С��ı������ڵ�¼�����
			maichepanel.add(jLabel7, null);// �ѡ���ϵ��ʽ����ǩ���ڵ�¼�����
			maichepanel.add(getphoneField(),null);//�ѡ���ϵ��ʽ���ı������ڵ�¼�����
			maichepanel.add(getcomboField(),null);
			maichepanel.add(getqueding(), null);// �ѡ�ȷ����������ť���ڵ�¼�����
			maichepanel.add(getquxiaoButton(), null);// �ѡ�ȡ������ť���ڵ�¼�����
		}
		return maichepanel;// ���ص�¼���
	}


	private JTextField getbiaotiField() {// ��ʼ�������⡱�ı���
		if (biaotiField == null) {// �����͡��ı������Ϊ��ʱ
			biaotiField = new JTextField();// ʵ���������͡��ı���
			biaotiField.setBounds(new Rectangle(180,80, 180, 22));// ���á����͡��ı����λ�úͿ��
		}
		return biaotiField;// ���ء���̡��ı���
	}
	
	private JTextField getpriceField() {// ��ʼ�������⡱�ı���
		if (priceField == null) {// �����͡��ı������Ϊ��ʱ
			priceField = new JTextField();// ʵ���������͡��ı���
			priceField.setBounds(new Rectangle(180,320, 180, 22));// ���á����͡��ı����λ�úͿ��
		}
		return priceField;// ���ء���̡��ı���
	}
	private JTextField gettimeField() {// ��ʼ�������䡱�ı���
		if (timeField == null) {// �����䡱�ı������Ϊ��ʱ
			timeField = new JTextField();// ʵ���������䡱�ı���
			timeField.setBounds(new Rectangle(180,120, 180, 22));// ���á����䡱�ı����λ�úͿ��
		}
		return timeField;// ���ء�����ʱ�䡱�ı���
	}
	
	private JTextField getcomboField() {
		if (comboField == null) {
			comboField = new JTextField();
		}
		return comboField;// ��ʼ�������䡱�ı���
	}
	private JComboBox<String> getcomboBox() {// ������	
			comboBox = new JComboBox<String>();// ʵ��������������������
			 String[] select = {"����","�Զ�","�ֶ�"}; //	        ���ѡ��ֵ
	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
			comboBox.setBounds(180, 160, 180, 22);
 		    comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem()=="�Զ�") {
						mession="1";
					}else if(comboBox.getSelectedItem()=="�ֶ�"){
						mession="2";
					}else if(comboBox.getSelectedItem()=="����"){
						mession="0";
					}
				}});
			return comboBox;
	}
	
	private JTextField getmileageField() {// ��ʼ������̡��ı���
		if (mileageField == null) {// ����̡��ı������Ϊ��ʱ
			mileageField = new JTextField();// ʵ��������̡��ı���
			mileageField.setBounds(new Rectangle(180,200, 180, 22));// ���á���̡��ı����λ�úͿ��
		}
		return mileageField;// ���ء���̡��ı���
	}

	private JTextField getcityField() {// ��ʼ�������С��ı���
		if (cityField == null) {// �����С��ı������Ϊ��ʱ
			cityField = new JTextField();// ʵ���������С��ı���
			cityField.setBounds(new Rectangle(180,240, 180, 22));// ���á����С��ı����λ�úͿ��
		}			
		return cityField;// ���ء����С��ı���
	}
	
	private JTextField getphoneField() {// ��ʼ������ϵ��ʽ���ı���
		if (phoneField == null) {// ����ϵ��ʽ���ı������Ϊ��ʱ
			phoneField = new JTextField();// ʵ��������ϵ��ʽ���ı���
			phoneField.setBounds(new Rectangle(180,280, 180, 22));// ���á���ϵ��ʽ���ı����λ�úͿ��
		}
		return phoneField;// ���ء���ϵ��ʽ���ı���
	}


	private JButton getqueding() {// ��ʼ����ȷ�Ϸ�������ť
		if (queding == null) {// ��ȷ�Ϸ�������ť����Ϊ��ʱ
			queding = new JButton();// ʵ������ȡ������ť
			queding.setBounds(new Rectangle(180, 380, 75, 30));// ���á�ȷ�Ϸ�������ť��λ�úͿ��
			queding.setIcon(new ImageIcon(getClass().getResource("/res/queding.jpg")));// ���á����ء���ť��ͼ��
			queding.addActionListener(new ActionListener() {// Ϊ��ȷ�Ϸ�������ť��Ӷ����¼��ļ���
				public void actionPerformed(final ActionEvent e) {
					// �ı���Ϊ��ʱ��������ʾ��
					if (biaotiField.getText().equals("") || timeField.getText().equals("") || priceField.getText().equals("")
							|| mileageField.getText().equals("") || cityField.getText().equals("") || phoneField.getText().equals("")
							) {
						JOptionPane.showMessageDialog(Maichefabu.this, "�����δ��д����Ϣ��", "��Ʒ���",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					ResultSet haveUser = BaseDao.query("select * from cars_message where name='" + biaotiField.getText().trim() + "'");
					try {
						if (haveUser.next()) {// �����haveUser���г���һ���ļ�¼
							System.out.println("error");// ����̨���error
							JOptionPane.showMessageDialog(Maichefabu.this, "��Ʒ��Ϣ���ʧ�ܣ�����ͬ����Ʒ", "�ͻ������Ϣ",
									JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
							return;
						}
					} catch (Exception er) {
						er.printStackTrace();
					}

					ResultSet set = BaseDao.query("select max(product_id) from cars_message");// ִ��SQL��ѯ����õĽ����
					String product_id =null;// ������Ʒ���
					try {
						if (set.next()) {// �����set��Ϊ���ҽ����set���г���һ���ļ�¼
							String sid = set.getString(1);
							System.out.println(sid);
							if (sid == null)// ��һ������ֵΪ��
								product_id = "1";// Ϊ��Ʒ��Ÿ�ֵ
							else {
//								String str = sid.substring(1);// ������Ϊ2����ʼ��ȡ�ַ���
								product_id = ""+(Integer.parseInt(sid) + 1);// ����ƴ���ַ�����ò�Ʒ���
							}
						}

					}catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					UCMSspinfo spInfo = new UCMSspinfo();// ��Ʒ��Ϣ
					spInfo.setProduct_id(product_id);// ������Ʒ���
					spInfo.setBiaoti(biaotiField.getText().trim());// ���ð�װ
					spInfo.setAge(timeField.getText().trim());// ���ò���
					spInfo.setPrice(priceField.getText().trim());// ������Ʒ������λ
					spInfo.setCmobo(mession.trim());// ���ù�Ӧ��ȫ��
					spInfo.setMileage(mileageField.getText().trim());// ������Ʒ���
					spInfo.setCity(cityField.getText().trim());// ���ñ�ע
					spInfo.setPhone(phoneField.getText().trim());// ��������
					BaseDao.addSp(spInfo);// �����Ʒ��Ϣ
					JOptionPane.showMessageDialog(Maichefabu.this, "��Ʒ��Ϣ�Ѿ��ɹ����", "��Ʒ���",
							JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
					
				}
			});	
		}
		return queding;
			}


//	private JButton getqueding() {// ��ʼ����ȡ������ť
//		if (queding == null) {// ��ȡ������ť����Ϊ��ʱ
//			queding = new JButton();// ʵ������ȡ������ť
//			queding.setBounds(new Rectangle(250, 380, 75, 30));// ���á�ȡ������ť��λ�úͿ��
//			queding.setIcon(new ImageIcon(getClass().getResource("/res/quxiao.jpg")));// ���á����ء���ť��ͼ��
//			queding.addActionListener(new ActionListener() {// Ϊ��ȡ������ť��Ӷ����¼��ļ���
//				public void actionPerformed(ActionEvent e) {
//					System.exit(0);// �˳���ǰ��Ӧ�ó���
//				}
//			});
//		}
//		return quxiaoButton;// ���ء�ȡ������ť
//	}
	private JButton getquxiaoButton() {// ��ʼ����ȡ������ť
		if (quxiaoButton == null) {// ��ȡ������ť����Ϊ��ʱ
			quxiaoButton = new JButton();// ʵ������ȡ������ť
			quxiaoButton.setBounds(new Rectangle(300, 380, 75, 30));// ���á�ȡ������ť��λ�úͿ��
			quxiaoButton.setIcon(new ImageIcon(getClass().getResource("/res/quxiao.jpg")));// ���á����ء���ť��ͼ��
			quxiaoButton.addActionListener(new ActionListener() {// Ϊ��ȡ������ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					JFrame page = new HeadPage();
					page.setVisible(true);
					setVisible(false);
				}
			});
		}
		return quxiaoButton;// ���ء�ȡ������ť
	}

	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// ���õ�¼����
		setSize(450, 500);// ���õ�¼����Ŀ��
		this.setTitle("������Ϣ����");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}


public void actionPerformed(final ActionEvent e) {
	// �ı���Ϊ��ʱ��������ʾ��
	if (biaotiField.getText().equals("") || timeField.getText().equals("") || priceField.getText().equals("")
			|| mileageField.getText().equals("") || cityField.getText().equals("") || phoneField.getText().equals("")
			) {
		JOptionPane.showMessageDialog(Maichefabu.this, "�����δ��д����Ϣ��", "��Ʒ���",
				JOptionPane.ERROR_MESSAGE);
		return;
	}
}}
