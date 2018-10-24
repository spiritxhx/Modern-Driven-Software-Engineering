/*
 * ��ui����������
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import whsdu.se.Common.*;
import whsdu.se.UI.*;
import whsdu.se.DAO.*;

public class MdiFrame extends JFrame implements ActionListener {
	private MDIDesktopPane desktop = new MDIDesktopPane();
	//�˵���
	private JMenuBar menuBar = new JMenuBar();
	//�˵�
	private JMenu mnuPark = new JMenu("parking lot information");
	private JMenu mnuQuery = new JMenu("information lonking");
	private JMenu mnuSever = new JMenu("information edit");
	private JMenu mnuManSes = new JMenu("system management");
	//�˵���
	private JMenuItem munParkIn = new JMenuItem("vehicles in");
	private JMenuItem mnuParkOut = new JMenuItem("vehicles out");
	private JMenuItem munCharge = new JMenuItem("fee");
	private JMenuItem mnuNowInfo = new JMenuItem("real time parking info");
	private JMenuItem mnuHistory = new JMenuItem("history user information");
	private JMenuItem mnuComUsersInfo = new JMenuItem("user information");
	private JMenuItem mnuInOut = new JMenuItem("in&out information");
	private JMenuItem mnuComZhuCe = new JMenuItem("user register");
	private JMenuItem mnuComIdentity = new JMenuItem("user info edit");
	private JMenuItem mnuManZhuCe = new JMenuItem("administrator");
	private JMenuItem mnuManIdentity = new JMenuItem("change password");
	private JMenuItem mnuManCharge = new JMenuItem("fee charge management");
	private JMenuItem mnumancharge = new JMenuItem("user recharge");
	private JMenuItem mnunowstation = new JMenuItem("real time parking info");
	private JMenuItem mnuabout = new JMenuItem("about");
	private JMenuItem mnuduichu = new JMenuItem("quit");
	private JScrollPane scrollPane = new JScrollPane();
	private users user = LoginFrame.getUser(); 
	

	public MdiFrame() {
		desktop.setOpaque(false);  //JPanel ͸��ģʽ
		ImageIcon img = new ImageIcon("E:/Course/mainsreen.jpg");  //����һ��ͼƬ·��
		JLabel background = new JLabel(img);  //������������ͼƬ��JLabel
		background.setIcon(img);
		this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		desktop.add(background);
		setMenu();
		setTitle("parking lot information");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(280,119,800, 600);
		this.setVisible(true);
	}

	/**
	 * Ϊ������Ӳ˵���ע�������
	 * ֻд�˲��ֲ˵�
	 */
	private void setMenu(){
		//��������˵�
		mnuPark.add(munParkIn);
		munParkIn.addActionListener(this);
		mnuPark.add(mnuParkOut);
		mnuParkOut.addActionListener(this);
		//��Ϣ��ѯ�˵�
		mnuQuery.add(munCharge);
		munCharge.addActionListener(this);
		mnuQuery.add(mnuNowInfo);
		mnuNowInfo.addActionListener(this);
		mnuQuery.add(mnuHistory);
		mnuHistory.addActionListener(this);
		mnuQuery.add(mnuComUsersInfo);
		mnuComUsersInfo.addActionListener(this);
		mnuQuery.add(mnuInOut);
		mnuInOut.addActionListener(this);
//		mnuQuery.add(mnunowstation);
//		mnunowstation.addActionListener(this);
		//��Ϣά���˵�
		mnuSever.add(mnuComZhuCe);
		mnuComZhuCe.addActionListener(this);
		mnuSever.add(mnuComIdentity);
		mnuComIdentity.addActionListener(this);
		mnuSever.add(mnumancharge);
		mnumancharge.addActionListener(this);
		//ϵͳ����˵�
		mnuManSes.add(mnuManZhuCe);
		mnuManZhuCe.addActionListener(this);
		mnuManSes.add(mnuManIdentity);
		mnuManIdentity.addActionListener(this);
		mnuManSes.add(mnuManCharge);
		mnuManCharge.addActionListener(this);
		mnuManSes.add(mnuabout);
		mnuabout.addActionListener(this);
		mnuManSes.add(mnuduichu);
		mnuduichu.addActionListener(this);
		
		//��ӵ��˵���
		menuBar.add(mnuPark);
		menuBar.add(mnuQuery);
		menuBar.add(mnuSever);
		menuBar.add(mnuManSes);
		//�˵�����ӵ�������
		setJMenuBar(menuBar);
	}

	//�������ͨ�û�����������ʹ�õĲ˵����ֹʹ��
	public void disMenu() {
		//������������Ϣά����ϵͳ�������ͨ�û���������
		mnuPark.setEnabled(false);
		mnuSever.setEnabled(false);
		mnuManZhuCe.setEnabled(false);
		mnuManCharge.setEnabled(false);
	}

	//����˵��������Ӧ���Ӵ���
	public void actionPerformed(ActionEvent ae) {

		//�������ͬʱ�򿪶���Ӵ��ڣ������ø÷�����������Ӵ��ڶ�������
		JInternalFrame[] jiFrame = desktop.getAllFrames();  

		//���ֻ����ͬʱ��һ���������ø÷����Ƴ����д���
		//desktop.removeAll();  

		//��õ���Ĳ˵�����
		String mnuName = ae.getActionCommand();

		//���ݲ˵����ƾ�����ʾ���Ӵ��ڣ����԰�����ĸ�ʽΪÿһ���Ӳ˵�ָ����ʾ���Ӵ���
		if(mnuName.equals("vehicles in")) {
			//MdiFrame.addIFrame(new ParkInFrame(),BorderLayout.CENTER);
			desktop.add(new ParkInFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("vehicles out")) {
			desktop.add(new ParkOutFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("fee")) {
			desktop.add(new ChargeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("real time parking info")) {
			desktop.add(new NowInfoFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("user information")) {
			if(user.getUserstype().equals("administrator"))
			desktop.add(new ComUsersInfoFrame(),BorderLayout.CENTER);
			else
				desktop.add(new ComUsersInfoFrame1(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("history user information")) {
			desktop.add(new HistoryFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("in&out information")) {
			desktop.add(new InOutFrame(),BorderLayout.CENTER);
		}
		//		
		else if(mnuName.equals("user register")) {
			desktop.add(new ComZhuCeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("user info edit")) {
			desktop.add(new ComIdentityFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("user recharge")) {
			desktop.add(new chongzhiFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("administrator")) {
			desktop.add(new ManZhuCeFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("change password")) {
			desktop.add(new GengGaiMiMa(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("real time parking info")) {
			desktop.add(new nowstationFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("about")) {
			desktop.add(new aboutFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("quit")) {
			System.exit(0);
		}
		else 
			desktop.add(new ManChargeFrame(),BorderLayout.CENTER);
	}		
	
}
