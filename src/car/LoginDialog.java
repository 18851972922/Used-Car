package car;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class LoginDialog extends JFrame {// ��¼����
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// ��¼���


	private LoginPanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (loginPanel == null) {// ��¼�����û�����ʱ
			JLabel jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("�ܡ��룺");// ���á����롱��ǩ���ı�����
			JLabel jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// ���á��û�������ǩ��λ������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����

		}
		return loginPanel;// ���ص�¼���
		
	}
	public static void main(String[] args) {
		JFrame login = new LoginDialog();
		login.setVisible(true);
		login.setSize(600,650);
		}
	}


