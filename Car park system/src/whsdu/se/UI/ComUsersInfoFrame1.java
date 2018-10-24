

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

public class ComUsersInfoFrame1 extends JInternalFrame {
	private static JComboBox queryjcombobox;
	private static JTextField queryjtextfield;
	private static JButton queryjbutton;
	private static JLabel  cardidjtextfield;
	private static JLabel  namejtextfield;
	private static JLabel  passwordjtextfield;
	private static JLabel  cardtypejtextfield;
	private static JLabel  overagejtextfield;
	private static JLabel  teljtextfield;
	private static JLabel caridjtextfield;
	private users user = LoginFrame.getUser(); 
	
	
	public ComUsersInfoFrame1() {
		super("user information");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setClosable(true);		
		setResizable(true);		
		setBounds(new Rectangle(114,97,482,221));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			
		mainPanel.setLayout(new BorderLayout());		
		getContentPane().add(mainPanel);		
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		
		JPanel Panel2 = new JPanel();		
		GridLayout gridLayout = new GridLayout(4,4);
		Panel2.setLayout(gridLayout);		
		gridLayout.setVgap(5);				
		gridLayout.setHgap(5);					
		Panel2.setBorder(new EmptyBorder(10,30,30,30));		
		mainPanel.add(Panel2,BorderLayout.CENTER);		
		
	    JLabel cardidjlabel = new JLabel();	
		cardidjlabel.setText("card number:");			
		Panel2.add(cardidjlabel);				
		cardidjtextfield = new JLabel();
		cardidjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardidjtextfield);
		cardidjtextfield.setText(String.valueOf(user.getCardid()));
		
		JLabel namejlabel = new JLabel();	//创建name标签
		namejlabel.setText("name:");			//设置标签文本
		Panel2.add(namejlabel);				//添加到面板2
		namejtextfield = new JLabel();
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(namejtextfield);
		namejtextfield.setText(user.getName());
		
		JLabel passwordjlabel = new JLabel();	//创建password标签
		passwordjlabel.setText("password:");			//设置标签文本
		Panel2.add(passwordjlabel);				//添加到面板2
		passwordjtextfield = new JLabel();
		passwordjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(passwordjtextfield);
		passwordjtextfield.setText(user.getPassword());
		
		JLabel cardtypejlabel = new JLabel();	//创建卡的user type标签
		cardtypejlabel.setText("user type:");			//设置标签文本
		Panel2.add(cardtypejlabel);				//添加到面板2
		cardtypejtextfield = new JLabel();//创建password文本框
		cardtypejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardtypejtextfield);
		cardtypejtextfield.setText(user.getCardtype());
		
		JLabel overagejlabel = new JLabel();	//创建balance标签
		overagejlabel.setText("balance:");			//设置标签文本
		Panel2.add(overagejlabel);				//添加到面板2
		overagejtextfield = new JLabel();
		overagejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(overagejtextfield);
		overagejtextfield.setText(String.valueOf(user.getOverage()));
		
		JLabel teljlabel = new JLabel();	//创建telephone标签
		teljlabel.setText("telephone:");			//设置标签文本
		Panel2.add(teljlabel);				//添加到面板2
		teljtextfield = new JLabel();
		teljtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(teljtextfield);
		teljtextfield.setText(String.valueOf(user.getTel()));
		
		JLabel caridjlabel = new JLabel();	//创建plate number标签
		caridjlabel.setText("plate number:");			//设置标签文本
		Panel2.add(caridjlabel);				//添加到面板2
		caridjtextfield = new JLabel();
		caridjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(caridjtextfield);
		caridjtextfield.setText(String.valueOf(user.getCarid()));
		setVisible(true);		// 显示窗体可见	
  }
}











