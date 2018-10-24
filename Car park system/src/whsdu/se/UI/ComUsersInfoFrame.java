/*
 * ��ui������find�˵��µ��û�������Ϣ�˵������ʾ
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;																										
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;

public class ComUsersInfoFrame extends JInternalFrame {
	private static JComboBox queryjcombobox;
	private static JTextField queryjtextfield;
	private static JButton queryjbutton;
	private static JLabel  cardidjtextfield;
	private static JLabel  namejtextfield;
	private static JLabel  passwordjtextfield;
	private static JLabel  cardtypejtextfield;
	private static JLabel  overagejtextfield;
	private static JLabel  teljtextfield;
	private static users user;
	private static JLabel caridjtextfield;
	
	
	//���췽��
	public ComUsersInfoFrame() {
		super("user information");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(124,110,495,295));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//�����������
		mainPanel.setLayout(new BorderLayout());		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		
		JPanel Panel1 = new JPanel();			//�������1
		Panel1.setLayout(new FlowLayout());		//���ò���
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//���ñ߿�Ϊ
		mainPanel.add(Panel1,BorderLayout.NORTH);		//�����1���뵽�������ı���
		
		queryjcombobox = new JComboBox();//����������
		String[] array=new String[]{"name","cardnumber"};//�б�
		queryjcombobox.setModel(new DefaultComboBoxModel(array));//����������ģ��
		Panel1.add(queryjcombobox);//��ӵ����1		
		
		queryjtextfield = new JTextField();//����find�ı���
		queryjtextfield.setColumns(10);//�����ı��򳤶�
		Panel1.add(queryjtextfield);
		
		queryjbutton = new JButton();//����find��ť
		queryjbutton.addActionListener(new queryActionListener());//ע�������
		queryjbutton.setText("find");//���ð�ť�ı�
		Panel1.add(queryjbutton);//��ӵ����1
		
		JPanel Panel2 = new JPanel();			//�������2
		GridLayout gridLayout = new GridLayout(4,4);
		Panel2.setLayout(gridLayout);		//���ò���
		gridLayout.setVgap(5);					//�������֮�䴹ֱ����
		gridLayout.setHgap(5);					//�������֮��ƽ�о���
		Panel2.setBorder(new EmptyBorder(10,30,30,30));		//���ñ߿�
		mainPanel.add(Panel2,BorderLayout.CENTER);		//�����2���뵽������������
		
	    JLabel cardidjlabel = new JLabel();	//����cardnumber��ǩ
		cardidjlabel.setText("card number:");			//���ñ�ǩ�ı�
		Panel2.add(cardidjlabel);				//��ӵ����2
		cardidjtextfield = new JLabel();
		cardidjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardidjtextfield);
		
		JLabel namejlabel = new JLabel();	//����name��ǩ
		namejlabel.setText("name:");			//���ñ�ǩ�ı�
		Panel2.add(namejlabel);				//��ӵ����2
		namejtextfield = new JLabel();
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(namejtextfield);
		
		JLabel passwordjlabel = new JLabel();	//����password��ǩ
		passwordjlabel.setText("password:");			//���ñ�ǩ�ı�
		Panel2.add(passwordjlabel);				//��ӵ����2
		passwordjtextfield = new JLabel();
		passwordjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(passwordjtextfield);
		
		JLabel cardtypejlabel = new JLabel();	//�����������ͱ�ǩ
		cardtypejlabel.setText("type:");			//���ñ�ǩ�ı�
		Panel2.add(cardtypejlabel);				//��ӵ����2
		cardtypejtextfield = new JLabel();//����password�ı���
		cardtypejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardtypejtextfield);
		
		JLabel overagejlabel = new JLabel();	//��������ǩ
		overagejlabel.setText("balance:");			//���ñ�ǩ�ı�
		Panel2.add(overagejlabel);				//��ӵ����2
		overagejtextfield = new JLabel();
		overagejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(overagejtextfield);
		
		JLabel teljlabel = new JLabel();	//�����绰��ǩ
		teljlabel.setText("telephone:");			//���ñ�ǩ�ı�
		Panel2.add(teljlabel);				//��ӵ����2
		teljtextfield = new JLabel();
		teljtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(teljtextfield);
		
		JLabel caridjlabel = new JLabel();	//�������ƺű�ǩ
		caridjlabel.setText("plate number:");			//���ñ�ǩ�ı�
		Panel2.add(caridjlabel);				//��ӵ����2
		caridjtextfield = new JLabel();
		caridjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(caridjtextfield);
	
		setVisible(true);											// ��ʾ����ɼ�	
}

	class queryActionListener implements ActionListener {			// ���find��ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			users user = new users();
			if(queryjcombobox.getSelectedItem().equals("name")){
				String a1 = queryjtextfield.getText();
				user = Dal.searchcominfo("select * from users where userstype = 'normal'and name =" +"'"+a1+"'");
				cardidjtextfield.setText(String.valueOf(user.getCardid()));
				namejtextfield.setText(String.valueOf(user.getName()));
				passwordjtextfield.setText(String.valueOf(user.getPassword()));
				cardtypejtextfield.setText(user.getCardtype());
				overagejtextfield.setText(String.valueOf(user.getOverage()));
				teljtextfield.setText(String.valueOf(user.getTel()));
				caridjtextfield.setText(String.valueOf(user.getCarid()));
			}
			
			else {
				int a2 = Integer.parseInt(queryjtextfield.getText().trim());
				user = Dal.searchcominfo("select * from users where userstype = 'normal'and cardid = "+a2 );
				cardidjtextfield.setText(String.valueOf(user.getCardid()));
				namejtextfield.setText(user.getName());
				passwordjtextfield.setText(String.valueOf(user.getPassword()));
				cardtypejtextfield.setText(user.getCardtype());
				overagejtextfield.setText(String.valueOf(user.getOverage()));
				teljtextfield.setText(String.valueOf(user.getTel()));
				caridjtextfield.setText(String.valueOf(user.getCarid()));
			}
		}
	}
}











