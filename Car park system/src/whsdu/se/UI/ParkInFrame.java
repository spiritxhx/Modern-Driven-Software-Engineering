/*
 * 该ui类用于实现车辆管理菜单下的vehicles in菜单项
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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

public class ParkInFrame extends JInternalFrame {
	private  JTextField cardidjtextfield;
	private  JTextField stationidjtextfield;
	private  JComboBox stationtypejcombobox;
	private JButton ensurejbutton;
	private users user;

	//构造方法
	public ParkInFrame() {
		super("vehicles in");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(136, 107, 428, 214);
		JPanel mainPanel = new JPanel();			//创建中心面板
		GridBagLayout gridbag = new GridBagLayout();//创建表格布局管理器
		mainPanel.setLayout(gridbag);		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		JLabel cardidjlabel = new JLabel();	//创建card number标签
		cardidjlabel.setText("card number:");//设置标签文本
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(cardidjlabel,c);				//添加到中心面板
		cardidjtextfield = new JTextField();//创建card number文本框
		cardidjtextfield.setColumns(10);//设置文本框长度
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(cardidjtextfield,c);
		JLabel stationidjlabel = new JLabel();	
		stationidjlabel.setText("lot number:");	//设置标签文本
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationidjlabel,c);				//添加到中心面板
		stationidjtextfield = new JTextField();//
		stationidjtextfield.setColumns(10);//设置文本框长度
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationidjtextfield,c);
		JLabel stationtypejlabel = new JLabel();	
		stationtypejlabel.setText("lot type:");//设置标签文本
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationtypejlabel,c);				//添加到中心面板
		stationtypejcombobox = new JComboBox();//创建卡的类型下拉框
		String[] array=new String[]{"large lot","small lot"};//卡的类型列表
		stationtypejcombobox.setModel(new DefaultComboBoxModel(array));//设置下拉框模型
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationtypejcombobox,c);
		ensurejbutton = new JButton();//创建保存按钮
		ensurejbutton.addActionListener(new parkActionListener());//注册监听器
		ensurejbutton.setText("in lot confirmation");//设置按钮文本
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(ensurejbutton,c);//添加到中心面板
		JButton backjbutton = new JButton();//创建back按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("back");//设置按钮文本
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(backjbutton,c);//添加到中心面板
		setVisible(true);											// 显示窗体可见
	}

	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class parkActionListener implements ActionListener {			// 添加in lot confirmation按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			int  a1 = Integer.parseInt(cardidjtextfield.getText());
			int a2 = Integer.parseInt(stationidjtextfield.getText());
			String a3 = (String)stationtypejcombobox.getSelectedItem();
			SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String a4 = myfmt.format(new java.util.Date()).toString();


			user = Dal.searchcominfo("select * from users where cardid  = "+a1);

			if(user.getCardid() ==0)
				JOptionPane.showMessageDialog(null, "card numberis wrong, enter the correct card number");
			else if(user.getOverage()<100)
				JOptionPane.showMessageDialog(null, "余额不足100元，请先充值再入场！");
			else{
				int i=Dal.parkin(a1,a2,a3,a4);
				if(i==1)
					JOptionPane.showMessageDialog(null, "入场成功！");	
				else
					JOptionPane.showMessageDialog(null, "入场失败！");	
			}
		}
	}
}



