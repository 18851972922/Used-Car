package com.mingrisoft.gujia;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mingrisoft.MainFrame;



public class GuJia extends JFrame {// �������۴���
	private static final long serialVersionUID = 1L;
	private GujiaPanel gujiaPanel = null;// �������
	private JLabel jLabel = null;// �����䡱��ǩ
	private JTextField ageField = null;// �����䡱�ı���
	private JLabel jLabel1 = null;// ����̡���ǩ
	private JTextField mileageField = null;// ����̡��ı���
	private JLabel jLabel2 = null;// ������������ǩ
	public JComboBox<String> comboBox;//����ѡ���
	private JButton backButton = null;// �����ء���ť
	private JButton priceButton = null;// �����ۡ���ť
	private JTextField priceField = null;//�����ı���
	private static String ageStr;// �����䡱�ı����е�����
	private static String mileageStr; //����̡��ı����е�����
    private MainFrame mainFrame;// ������
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public String getUserStr() {// ��á����䡱�ı����е�����
		return ageStr;// ���ء����䡱�ı����е�����
	}
	
	public String getMileageStr() {// ��á���̡��ı����е�����
		return mileageStr;// ���ء���̡��ı����е�����
	}
	public GuJia() {// ����Ĺ��췽��
		try {
			// ���ô���ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private GujiaPanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (gujiaPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����䡱��ǩ
			jLabel1.setBounds(new Rectangle(90,120, 100, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("���䣨�꣩��");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("��̣������");// ���á���̡���ǩ���ı�����
			jLabel.setBounds(new Rectangle(80, 170, 100, 18));// ���á���̡���ǩ��λ������
			jLabel2 = new JLabel();//������������ǩ
			jLabel2.setText("��������");// ���á�����������ǩ���ı�����
			jLabel2.setBounds(new Rectangle(100,220, 100, 18));// ���á�����������ǩ��λ������
			gujiaPanel = new GujiaPanel();// ��¼���
			gujiaPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			gujiaPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			gujiaPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			gujiaPanel.add(getAgeField(), null);// �ѡ��û������ı������ڵ�¼�����
			gujiaPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			gujiaPanel.add(getMileageField(), null);// �ѡ����롱�ı������ڵ�¼�����
			gujiaPanel.add(jLabel2, null);// �ѡ�����������ǩ���ڵ�¼�����
			gujiaPanel.add(getcomboBox(),null);//�ѡ����������ı������ڵ�¼�����
			gujiaPanel.add(getPriceField(), null);// �ѡ����ۡ��ı������ڵ�¼�����
			gujiaPanel.add(getPriceButton(), null);// �ѡ����ۡ���ť���ڵ�¼�����
			gujiaPanel.add(getBackButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return gujiaPanel;// ���ص�¼���
	}

	private JTextField getAgeField() {// ��ʼ�������䡱�ı���
		if (ageField == null) {// �����䡱�ı������Ϊ��ʱ
			ageField = new JTextField();// ʵ���������䡱�ı���
			ageField.setBounds(new Rectangle(180, 120, 127, 22));// ���á��û������ı����λ�úͿ��
		}
		return ageField;// ���ء����䡱�ı���
	}

	private JTextField getMileageField() {// ��ʼ������̡��ı���
		if (mileageField == null) {// ����̡��ı������Ϊ��ʱ
			mileageField = new JTextField();// ʵ��������̡��ı���
			mileageField.setBounds(new Rectangle(180,170, 127, 22));// ���á���̡��ı����λ�úͿ��
		}
		return mileageField;// ���ء���̡��ı���
	}

	private JComboBox<String> getcomboBox() {// ������	
			comboBox = new JComboBox<String>();// ʵ��������������������
			 String[] select = {"����","�Զ�","�ֶ�"}; //	        ���ѡ��ֵ
	        comboBox.setModel(new DefaultComboBoxModel<String>(select));
			comboBox.setBounds(180, 220, 127, 22);// ���á����������ı����λ�úͿ��
			return comboBox;
	}
	
	private JButton getPriceButton() {// ��ʼ�����������ۡ���ť
		if (priceButton == null) {
			priceButton = new JButton();
			priceButton.setBounds(new Rectangle(80, 270, 90, 27));
			priceButton.setIcon(new ImageIcon(getClass().getResource("/res/gujiabutton.jpg")));
			priceButton.addActionListener(new ActionListener() {// Ϊ�����ۡ���ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					try {
						if (priceButton == e.getSource()) {//����ǹ��������ť�������,
							double ageStr=Double.valueOf(ageField.getText()).doubleValue();
							double mileageStr = Double.valueOf(mileageField.getText()).doubleValue(); //��ȡ�����ı����е�����
							if(comboBox.getSelectedItem()=="�Զ�") {
								double mission = 1;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.													
							}else if(comboBox.getSelectedItem()=="�ֶ�"){
								double mission = 2;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.							
							}else {
								double mission = 1.5;
								double price=17-0.91*ageStr+0.1667*mileageStr-4.7*mission;
								priceField.setText(""+String.format("%.2f", price)+"��Ԫ");//�Ѱ�ť��������ʾ�������ı�����.									
							}
								
							
							
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();

					} 
				}
			});
		}
		return priceButton;// ���ء����ۡ���ť
	}
	
	private JTextField getPriceField() {// ��ʼ�������ۡ��ı���
		if (priceField == null) {
			priceField = new JTextField();
			priceField.setBounds(new Rectangle(180,270, 127, 27));
		}
		return priceField;// ���ء����ۡ��ı���
	}
	
	private JButton getBackButton() {// ��ʼ����������ҳ����ť
		if (backButton == null) {// �����ء���ť����Ϊ��ʱ
			backButton = new JButton();// ʵ���������ء���ť
			backButton.setBounds(new Rectangle(215, 380, 50, 20));// ���á����ء���ť��λ�úͿ��
			backButton.setIcon(new ImageIcon(getClass().getResource("/res/backbutton.jpg")));// ���á����ء���ť��ͼ��
			backButton.addActionListener(new ActionListener() {// Ϊ�����ء���ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return backButton;// ���ء����ء���ť
	}

	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 230) / 2, (size.height - 400) / 2);// ���õ�¼����
		setSize(380, 500);// ���õ�¼����Ŀ��
		this.setTitle("��������");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}


}
