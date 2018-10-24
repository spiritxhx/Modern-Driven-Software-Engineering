/*
 * 该ui类用于显示查询菜单里的计费标准菜单项
 * 
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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

import whsdu.se.DAO.*;
import whsdu.se.DAL.*;

public class ChargeFrame extends JInternalFrame {


	private  JLabel cardidjlabel;
	private  JTextField cardidjtextfield;
	private  JLabel namejlabel;
	private  JTextField namejtextfield;
	private  JLabel passwordjlabel;
	private  JTextField passwordjtextfield;
	private  JLabel cardtypejlabel;
	private  JComboBox cardtypejcombobox;
	private  JLabel overagejlabel;
	private  JTextField overagejtextfield;
	private  JLabel teljlabel;
	private  JTextField teljtextfield;


	private  JLabel zhanwei;
	private static charger charger;

	private static JLabel bigjtextfield1;
	private static JLabel bigjtextfield2;
	private static JLabel smalljtextfield1;
	private static JLabel smalljtextfield2;



	public  ChargeFrame() {
		super("fee");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		setClosable(true);		
		setResizable(true);		
		setBounds(new Rectangle(206,76,331,300));

		JPanel Panel1 = new JPanel();
		Panel1.setLayout(new GridLayout(6,2));
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));
		getContentPane().add(Panel1);

		Panel1.add(new JLabel("membership:"));
		Panel1.add(new JLabel());

		JLabel bigjlabel1 = new JLabel();
		bigjlabel1.setText("large vehicle（$/h）:");
		Panel1.add(bigjlabel1);	
		bigjtextfield1 = new JLabel();
		Panel1.add(bigjtextfield1);

		JLabel smalljlabel1 = new JLabel();
		smalljlabel1.setText("small vehicle（$/h）:");
		Panel1.add(smalljlabel1);
		smalljtextfield1 = new JLabel();
		Panel1.add(smalljtextfield1);

		Panel1.add(new JLabel("visitor:"));
		Panel1.add(new JLabel());

		JLabel bigjlabel2 = new JLabel();
		bigjlabel2.setText("large vehicle（$/h）:");			
		Panel1.add(bigjlabel2);				
		bigjtextfield2 = new JLabel();
		Panel1.add(bigjtextfield2);

		JLabel smalljlabel2 = new JLabel();
		smalljlabel2.setText("small vehicle（$/h）:");	
		Panel1.add(smalljlabel2);			
		smalljtextfield2 = new JLabel();
		Panel1.add(smalljtextfield2);


		charger = Dal.searchcharge("select * from charger where cardtype = 'membership'and stationtype = 'large vehicle'");
		String a1 = String.valueOf(charger.getCharge());
		bigjtextfield1.setText(a1);
	
		charger = Dal.searchcharge("select * from charger where cardtype = 'membership'and stationtype = 'small vehicle'");	
		String a2 = String.valueOf(charger.getCharge());
		smalljtextfield1.setText(a2);

		charger = Dal.searchcharge("select * from charger where cardtype = 'visitor'and stationtype = 'large vehicle'");	
		String a3 = String.valueOf(charger.getCharge());
		bigjtextfield2.setText(a3);

		charger = Dal.searchcharge("select * from charger where cardtype = 'visitor'and stationtype = 'small vehicle'");
		String a4 = String.valueOf(charger.getCharge());
		smalljtextfield2.setText(a4);

		setVisible(true);	
	}		
}
