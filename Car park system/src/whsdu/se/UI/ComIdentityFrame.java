

package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;

public class ComIdentityFrame extends JInternalFrame {
	private  JTextField cardidjtextfield;
	private  JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private  JComboBox cardtypejcombobox;
	private  JTextField overagejtextfield;
	private JTextField teljtextfield;
	private JButton savejbutton;
	private JTextField caridjtextfield;
	private JTable table; 
	private users user;
	private JTextField cardtypejtextfield;
	private String[] str = { "card number", "name", "password", "cardtype","plate number ","telephone", "balance"};

	private Object[][] getFileStates(List list){
		Object[][]users=new Object[list.size()][str.length];
		for(int i=0;i<list.size();i++){
			users user=(users)list.get(i);
			users[i][0]=user.getCardid();
			users[i][1]=user.getName();
			users[i][2]=user.getPassword();
			users[i][3]=user.getCardtype();
			users[i][4]=user.getCarid();
			users[i][5]=user.getTel();
			users[i][6]=user.getOverage();
		}
		return users;        		
	}


	public ComIdentityFrame() {
		super("user information edit");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setClosable(true);		
		setResizable(true);		
		setBounds(new Rectangle(98,42,532,369));
		getContentPane().setLayout(new BorderLayout());
		setVisible(true);	

		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(0, 150));
		getContentPane().add(panel1, BorderLayout.NORTH); 

		JPanel panel2 = new JPanel();
		GridLayout gridLayout = new GridLayout(4,4);
		gridLayout.setVgap(5);					
		gridLayout.setHgap(5);					
		panel2.setLayout(gridLayout);		
		getContentPane().add(panel2, BorderLayout.CENTER);		
		panel2.setBorder(new EmptyBorder(10, 30, 10, 30));

		JLabel cardidjlabel = new JLabel();	
		cardidjlabel.setText("card number:");			
		panel2.add(cardidjlabel);				
		cardidjtextfield = new JTextField();
		cardidjtextfield.setColumns(12);
		panel2.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	
		namejlabel.setText("name:");			
		panel2.add(namejlabel);				
		namejtextfield = new JTextField();
		cardidjtextfield.setColumns(6);
		panel2.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();	
		passwordjlabel.setText("password:");			
		panel2.add(passwordjlabel);				
		passwordjtextfield = new JTextField();
		passwordjtextfield.setColumns(10);
		panel2.add(passwordjtextfield);

		JLabel cardtypejlabel = new JLabel();	
		cardtypejlabel.setText("type:");			
		panel2.add(cardtypejlabel);				
		cardtypejtextfield = new JTextField();
		cardtypejtextfield.setColumns(10);
		panel2.add(cardtypejtextfield);

		JLabel overagejlabel = new JLabel();	
		overagejlabel.setText("balance:");			
		panel2.add(overagejlabel);				
		overagejtextfield = new JTextField();
		overagejtextfield.setColumns(4);
		panel2.add(overagejtextfield);

		JLabel teljlabel = new JLabel();	
		teljlabel.setText("telephone:");			
		panel2.add(teljlabel);				
		teljtextfield = new JTextField();
		teljtextfield.setColumns(11);
		panel2.add(teljtextfield);

		JLabel caridjlabel = new JLabel();	
		caridjlabel.setText("plate number:");			
		panel2.add(caridjlabel);				
		caridjtextfield = new JTextField();
		caridjtextfield.setColumns(11);
		panel2.add(caridjtextfield);

		final JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(0, 50));
		panel3.setLayout(new FlowLayout());
		getContentPane().add(panel3, BorderLayout.SOUTH);
		final JButton button1 = new JButton();
		button1.setText("edit");
		panel3.add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int a1 = Integer.parseInt(cardidjtextfield.getText());
				String a2 = namejtextfield.getText();
				String a3 = passwordjtextfield.getText();
				String a4 = caridjtextfield.getText();
				int a5 = Integer.parseInt(overagejtextfield.getText());
				int a6 = Integer.parseInt(teljtextfield.getText());
				int a7 = Integer.parseInt(caridjtextfield.getText());

				int i=	Dal.updateuser(a1,a2,a3,a4,a5,a6,a7);
				if(i==1){
					JOptionPane.showMessageDialog(null, "edit successful! ");
					Object[][] results=getFileStates(Dal.selectuser());
					DefaultTableModel model=new DefaultTableModel();					
					table.setModel(model);
					model.setDataVector(results, str);
				}
			}	
		});
		JButton button2 = new JButton();
		button2.setText("delete");
		panel3.add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e) {
				int a8 =Integer.parseInt(cardidjtextfield.getText());
				int i=Dal.Deluser(a8);
				if(i==1){
					JOptionPane.showMessageDialog(null, "delete successful");
					Object[][] results=getFileStates(Dal.selectuser());
					DefaultTableModel model=new DefaultTableModel();					
					table.setModel(model);
					model.setDataVector(results, str);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 120));
		panel1.add(scrollPane);
		Object[][] results=getFileStates(Dal.selectuser());
		table = new JTable(results,str);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				String cardid,name,password,cardtype,carid,tel,overage;
				int selRow = table.getSelectedRow();
				cardid = table.getValueAt(selRow, 0).toString().trim();
				name = table.getValueAt(selRow, 1).toString().trim();
				password = table.getValueAt(selRow,2).toString().trim();
				cardtype = table.getValueAt(selRow,3).toString().trim();
				carid = table.getValueAt(selRow,4).toString().trim();
				tel = table.getValueAt(selRow,5).toString().trim();
				overage = table.getValueAt(selRow,6).toString().trim();
				cardidjtextfield.setText(cardid);
				namejtextfield.setText(name);
				passwordjtextfield.setText(password);
				cardtypejtextfield.setText(cardtype);
				overagejtextfield.setText(overage);
				teljtextfield.setText( tel);
				caridjtextfield.setText( carid);
			}
		});
		scrollPane.setViewportView(table);
	}
}
