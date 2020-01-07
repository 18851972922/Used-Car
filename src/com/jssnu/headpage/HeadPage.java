package com.jssnu.headpage;

import java.awt.*;
import javax.swing.*;

import com.jssnu.UCMS.MainFrame;
import com.jssnu.cheliangxinxi.Maichefabu;
import com.jssnu.dao.BaseDao;
import com.jssnu.dao.Buycar;
import com.jssnu.gujia.GuJia;
import com.jssnu.kankan.GaoDuan;
import com.jssnu.kankan.PianYi;
import com.jssnu.kankan.SouSuo;
import com.jssnu.kankan.XinShou;
import com.jssnu.kankan.ZhunXin;
import com.jssnu.yonghuzhongxin.ShouCang;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeadPage extends JFrame {// ������ҳ����
	private static final long serialVersionUID = 1L;
	private PagePanel pagepanel = null;// ��ҳ���
	private JButton shouye = null;// ����ҳ����ť
	private JButton maiche = null;// ����������ť
	private JButton kanche = null;// ����������ť
	private JButton gujia = null;// ���������ۡ���ť
	private JButton yonghu = null;// ���û����ġ���ť
	private JButton sousuo = null;// ����������ť
	private JButton woyaokanche = null;// ����Ҫ�򳵡���ť
	private JButton laren = null;// ��������������ť
	private JButton xinshou = null;// ��������·����ť
	private JButton xinche = null;// ��׼�³�����ť
	private JButton pianyi = null;// �����ˡ���ť
	private JButton woyaomaiche = null;// ����Ҫ��������ť
	private static JTextField sousuoField = null;// ���������ı���
	private JButton aiche = null;// ���������ı���
    private MainFrame mainFrame;// ������
    private JLabel jLabel1 = null;// ��װ�Ρ���ǩ
    
    private JButton tianjiashoucang = null;// ������ղء���ť
    private JTextField yonghuidField = null;//"�����û�id���ı���"
    private JTextField shoucangidField = null;//��������Ҫ��ӵ��ղ����ĵ���Ʒid
    
    private JLabel jLabel2 = null;// �������û�id����ǩ
    private JLabel jLabel3 = null;// ���ղ���Ʒid����ǩ
    private JLabel jLabel4 = null;// ��װ�Ρ���ǩ
    
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	public static String getSearchStr() {   
		String searchStr=sousuoField.getText();
		return searchStr;
	}
	
//	public String getyonghuStr() {// ��á������û�id���ı����е�����
//		return yonghuidStr;// �����ı����е�����
//	}
//	
//	public String getshoucangStr() {// ��á������ղ���Ʒid���ı����е�����
//		return shoucangidStr;// �����ı����е�����
//	}
	
	

	
	public HeadPage() {// ����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// ʵ����������
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PagePanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (pagepanel == null) {// ��¼�����û�����ʱ
			pagepanel = new PagePanel();// ��¼���
			jLabel1 = new JLabel();// ��װ�Ρ���ǩ
			jLabel1.setBounds(new Rectangle(300,190, 20, 200));// ���á����롱��ǩ��λ������
			jLabel1.setIcon(new ImageIcon(getClass().getResource("/res/zhuangshi.jpg")));// ���á��򳵡���ť��ͼ��
			
			jLabel2 = new JLabel();// �������û�id����ǩ
			jLabel2.setBounds(new Rectangle(40,410, 120, 18));// ���á������û�id����ǩ��λ������
			jLabel2.setText("�����û�id");// ���á������û�id����ǩ���ı�����
			jLabel2.setIcon(new ImageIcon(getClass().getResource("/res/yonghuming.jpg")));
			
			jLabel3 = new JLabel();// �������ղ���Ʒid����ǩ
			jLabel3.setBounds(new Rectangle(215,402, 130, 30));// ���á��ղ���Ʒid����ǩ��λ������
			jLabel3.setText("��ӵ��ղ���Ʒid");// ���á��ղ���Ʒid����ǩ���ı�����
			jLabel3.setIcon(new ImageIcon(getClass().getResource("/res/shoucangpin.jpg")));
			
			jLabel4 = new JLabel();// ��װ�Ρ���ǩ
			jLabel4.setBounds(new Rectangle(70,360, 400, 30));// ���á����롱��ǩ��λ������
			jLabel4.setIcon(new ImageIcon(getClass().getResource("/res/fenge.jpg")));// ���á��򳵡���ť��ͼ��
			
			pagepanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			pagepanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			
			
			pagepanel.add(jLabel1, null);// �ѡ��û�������ǩ���ڵ�¼�����
			pagepanel.add(getshouye(), null);// �ѡ���ҳ����ť���ڵ�¼�����
			pagepanel.add(getmaiche(), null);// �ѡ���������ť���ڵ�¼�����
			pagepanel.add(getkanche(), null);// �ѡ��򳵡���ť���ڵ�¼�����
			pagepanel.add(getgujia(), null);// �ѡ����ۡ���ť���ڵ�¼�����
			pagepanel.add(getyonghu(), null);// �ѡ��û�����ť���ڵ�¼�����
			pagepanel.add(getsousuo(), null);// �ѡ���������ť���ڵ�¼�����
			pagepanel.add(getwoyaokanche(), null);// �ѡ���Ҫ��������ť���ڵ�¼�����
			pagepanel.add(getlaren(), null);// �ѡ����ˡ���ť���ڵ�¼�����
			pagepanel.add(getxinshou(), null);// �ѡ����֡���ť���ڵ�¼�����
			pagepanel.add(getxinche(), null);// �ѡ��³�����ť���ڵ�¼�����
			pagepanel.add(getpianyi(), null);// �ѡ����ˡ���ť���ڵ�¼�����
			pagepanel.add(getwoyaomaiche(), null);// �ѡ���Ҫ��������ť���ڵ�¼�����
			pagepanel.add(getaiche(), null);// �ѡ��������ۡ���ť���ڵ�¼�����
			pagepanel.add(getsousuoField(), null);//��������ı���
			
			pagepanel.add(getTianJiaShouCang(), null);// �ѡ�����ղء���ť���ڵ�¼�����
			pagepanel.add(jLabel2, null);// �ѡ������û�id����ǩ���ڵ�¼�����
			pagepanel.add(jLabel3, null);// �ѡ���Ҫ�ղص���Ʒid����ǩ���ڵ�¼�����
			pagepanel.add(jLabel4, null);// �ѡ�װ�Ρ���ǩ���ڵ�¼�����
			pagepanel.add(getyonghuidField(), null);//��������ı���
			pagepanel.add(getshoucangidField(), null);//��������ı���
		}
		return pagepanel;// ���ص�¼���
	}
	
	private JButton getTianJiaShouCang() {// ��ʼ��������ղء���ť
		if (tianjiashoucang == null) {
			tianjiashoucang = new JButton();
			tianjiashoucang.setBounds(new Rectangle(420,395,80,34));
			tianjiashoucang.setIcon(new ImageIcon(getClass().getResource("/res/shoucang.jpg")));
			tianjiashoucang.addActionListener(new ActionListener() {// Ϊ������ղء���ť��򰮶����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					try {
						if (tianjiashoucang == e.getSource()) {//���������ղ������ť�������,
							
							String yonghuidStr=yonghuidField.getText();
							String shoucangidStr = shoucangidField.getText();
							BaseDao bd=new BaseDao();
							String sql = "insert into tb_shoucang(user_id2,user_id,product1) values(?,?,?)";		
							bd.update(sql,yonghuidStr,yonghuidStr,shoucangidStr);	
							JOptionPane.showMessageDialog(HeadPage.this, "��Ʒ�ղ��Ѿ��ɹ����", "�ղ����",
									JOptionPane.INFORMATION_MESSAGE);// ������ʾ��
				        }
						
					} catch (NumberFormatException e1) {
					    e1.printStackTrace();
					} 
				}
			});
		}
		return tianjiashoucang;// ���ء�ɾ���ղء���ť
	}

	private JTextField getyonghuidField() {// ��ʼ���������û�id���ı���
		if (yonghuidField == null) {// �ı������Ϊ��ʱ
			yonghuidField = new JTextField();// ʵ�����ı���
			yonghuidField.setBounds(new Rectangle(150,405, 50, 25));// �����ı����λ�úͿ��
		}
		return yonghuidField;// �����ı���
	}
	
	
	private JTextField getshoucangidField() {// ��ʼ����������ӵ��ղ���Ʒid���ı���
		if (shoucangidField == null) {// �ı������Ϊ��ʱ
			shoucangidField = new JTextField();// ʵ�����ı���
			shoucangidField.setBounds(new Rectangle(340,405, 50, 25));// �����ı����λ�úͿ��
		}
		return shoucangidField;// �����ı���
	}
	private JTextField getsousuoField() {// ��ʼ�����������ı���
		if (sousuoField == null) {// ���������ı������Ϊ��ʱ
			sousuoField = new JTextField();// ʵ�������������ı���
			sousuoField.setBounds(new Rectangle(120,120, 200, 30));// ���á��������ı����λ�úͿ��
		}
		return sousuoField;// ���ء��������ı���
	}
	

	private JButton getmaiche() {// ��ʼ�����򳵡���ť
		if (maiche == null) {// ���򳵡���ť����Ϊ��ʱ
			maiche = new JButton();// ʵ�������򳵡���ť
			maiche.setIcon(new ImageIcon(getClass().getResource("/res/maiche.jpg")));// ���á��򳵡���ť��ͼ��
			maiche.setBounds(new Rectangle(270,48, 70, 25));// ���á��򳵡���ť��λ�úͿ��
			maiche.addActionListener(new ActionListener() {// Ϊ���򳵡���ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					if (maiche == e.getSource()) {
						JFrame maichefabu = new Maichefabu();
						maichefabu.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return maiche;// ���ء��򳵡���ť
	}
	
	private JButton getkanche() {// ��ʼ������ҳ����ť
		if (kanche == null) {// ��ȷ�Ϸ�������ť����Ϊ��ʱ
			kanche = new JButton();// ʵ������ȷ�Ϸ�������ť
			kanche.setBounds(new Rectangle(340,45, 70, 25));// ���á�ȷ�Ϸ�������ť��λ�úͿ��
			kanche.setIcon(new ImageIcon(getClass().getResource("/res/kanche.jpg")));// ���á����ء���ť��ͼ��
			kanche.addActionListener(new ActionListener() {// Ϊ��ȷ�Ϸ�������ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					if (kanche == e.getSource()) {
						JFrame buycar = new Buycar();
						buycar.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return kanche;// ���ء�ȷ�Ϸ�������ť
	}
	
	private JButton getgujia() {// ��ʼ������ҳ����ť
		if (gujia == null) {// ��ȷ�Ϸ�������ť����Ϊ��ʱ
			gujia = new JButton();// ʵ������ȷ�Ϸ�������ť
			gujia.setBounds(new Rectangle(410, 50,70, 25));// ���á�ȷ�Ϸ�������ť��λ�úͿ��
			gujia.setIcon(new ImageIcon(getClass().getResource("/res/gujia.jpg")));// ���á����ء���ť��ͼ��
			gujia.addActionListener(new ActionListener() {// Ϊ��ȷ�Ϸ�������ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					if (gujia == e.getSource()) {
						JFrame gujia = new GuJia();
						gujia.setVisible(true);// ʹ������ɼ�
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return gujia;// ���ء�ȷ�Ϸ�������ť
	}
	
	private JButton getyonghu() {// ��ʼ�����û����ġ���ť
		if (yonghu == null) {
			yonghu = new JButton();
			yonghu.setBounds(new Rectangle(500, 48, 70, 25));
			yonghu.setIcon(new ImageIcon(getClass().getResource("/res/yonghu.jpg")));
			yonghu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					System.exit(0);
					if (yonghu == e.getSource()) {
						JFrame shoucang = new ShouCang();
						shoucang.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return yonghu;// ���ء�ȷ�Ϸ�������ť
	}
	
	private JButton getsousuo() {// ��ʼ������������ť
		if (sousuo == null) {
			sousuo = new JButton();
			sousuo.setBounds(new Rectangle(380, 120, 70, 30));
			sousuo.setIcon(new ImageIcon(getClass().getResource("/res/sousuo.jpg")));
			sousuo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (sousuo == e.getSource()) {
						JFrame sousou = new SouSuo();
						sousou.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return sousuo;
	}
	
	private JButton getshouye() {// ��ʼ������ҳ����ť
		if (shouye == null) {// ��ȷ�Ϸ�������ť����Ϊ��ʱ
			shouye = new JButton();// ʵ������ȷ�Ϸ�������ť
			shouye.setBounds(new Rectangle(225, 50, 45, 20));// ���á�ȷ�Ϸ�������ť��λ�úͿ��
			shouye.setIcon(new ImageIcon(getClass().getResource("/res/shouye.jpg")));// ���á����ء���ť��ͼ��
			shouye.addActionListener(new ActionListener() {// Ϊ��ȷ�Ϸ�������ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return shouye;// ���ء�ȷ�Ϸ�������ť
	}

	private JButton getlaren() {// ��ʼ���������ػ�����ť
		if (laren == null) {
			laren = new JButton();
			laren.setBounds(new Rectangle(60, 250, 100, 40));
			laren.setIcon(new ImageIcon(getClass().getResource("/res/gaoduanche.jpg")));
			laren.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (laren == e.getSource()) {
						JFrame gaoduan = new GaoDuan();
						gaoduan.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return laren;// ���ء�ȡ������ť
	}
	
	private JButton getxinshou() {// ��ʼ����������·����ť
		if (xinshou == null) {
			xinshou = new JButton();
			xinshou.setBounds(new Rectangle(180, 250, 100, 40));
			xinshou.setIcon(new ImageIcon(getClass().getResource("/res/xinshou.jpg")));
			xinshou.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (xinshou == e.getSource()) {
						JFrame xinshou = new XinShou();
						xinshou.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return xinshou;// ���ء�ȡ������ť
	}

	private JButton getxinche() {// ��ʼ����׼�³�����ť
		if (xinche == null) {
			xinche = new JButton();
			xinche.setBounds(new Rectangle(60, 310, 100, 40));
			xinche.setIcon(new ImageIcon(getClass().getResource("/res/xinche.jpg")));
			xinche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (xinche == e.getSource()) {
						JFrame zhunxin = new ZhunXin();
						zhunxin.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return xinche;// ���ء�ȡ������ť
	}

	private JButton getpianyi() {// ��ʼ�������ˡ���ť
		if (pianyi == null) {
			pianyi = new JButton();
			pianyi.setBounds(new Rectangle(180, 310, 100, 40));
			pianyi.setIcon(new ImageIcon(getClass().getResource("/res/pianyi.jpg")));
			pianyi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pianyi == e.getSource()) {
						JFrame jianpianyi = new PianYi();
						jianpianyi.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return pianyi;// ���ء�ȡ������ť
	}

	
	private JButton getwoyaomaiche() {// ��ʼ������Ҫ��������ť
		if (woyaomaiche == null) {
			woyaomaiche = new JButton();
			woyaomaiche.setBounds(new Rectangle(360, 192, 145, 35));
			woyaomaiche.setIcon(new ImageIcon(getClass().getResource("/res/woyaomaiche.jpg")));
			woyaomaiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (woyaomaiche == e.getSource()) {
						JFrame maichefabu = new Maichefabu();
						maichefabu.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return woyaomaiche;// ���ء�ȡ������ť
	}

	private JButton getwoyaokanche() {// ��ʼ������Ҫ�򳵡���ť
		if (woyaokanche == null) {
			woyaokanche = new JButton();
			woyaokanche.setBounds(new Rectangle(100, 195, 140, 35));
			woyaokanche.setIcon(new ImageIcon(getClass().getResource("/res/woyaokanche.jpg")));
			woyaokanche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (woyaokanche == e.getSource()) {
						JFrame buycar = new Buycar();
						buycar.setVisible(true);
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return woyaokanche;// ���ء�ȡ������ť
	}

	private JButton getaiche() {// ��ʼ������������ť
		if (aiche == null) {
			aiche = new JButton();
			aiche.setBounds(new Rectangle(380, 280, 100, 40));
			aiche.setIcon(new ImageIcon(getClass().getResource("/res/aiche.jpg")));
			aiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (aiche == e.getSource()) {
						JFrame gujia = new GuJia();
						gujia.setVisible(true);// ʹ������ɼ�
						setVisible(false);// ʹ��¼���岻�ɼ�
					}
				}
			});
		}
		return aiche;// ���ء�ȡ������ť
	}
	
	
	private void initialize() {// ��ʼ����¼����
		setLocation(320, 100);// ���õ�¼����λ��
		setSize(600,515);// ���õ�¼����Ŀ��
		this.setTitle("��ҳ");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}

	
}
