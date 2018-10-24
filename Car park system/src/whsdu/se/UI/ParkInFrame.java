/*
 * ��ui������ʵ�ֳ�������˵��µ�vehicles in�˵���
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

	//���췽��
	public ParkInFrame() {
		super("vehicles in");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(136, 107, 428, 214);
		JPanel mainPanel = new JPanel();			//�����������
		GridBagLayout gridbag = new GridBagLayout();//������񲼾ֹ�����
		mainPanel.setLayout(gridbag);		//���ò���
		getContentPane().add(mainPanel);		//�����������뵽����
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		JLabel cardidjlabel = new JLabel();	//����card number��ǩ
		cardidjlabel.setText("card number:");//���ñ�ǩ�ı�
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(cardidjlabel,c);				//��ӵ��������
		cardidjtextfield = new JTextField();//����card number�ı���
		cardidjtextfield.setColumns(10);//�����ı��򳤶�
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(cardidjtextfield,c);
		JLabel stationidjlabel = new JLabel();	
		stationidjlabel.setText("lot number:");	//���ñ�ǩ�ı�
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationidjlabel,c);				//��ӵ��������
		stationidjtextfield = new JTextField();//
		stationidjtextfield.setColumns(10);//�����ı��򳤶�
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationidjtextfield,c);
		JLabel stationtypejlabel = new JLabel();	
		stationtypejlabel.setText("lot type:");//���ñ�ǩ�ı�
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationtypejlabel,c);				//��ӵ��������
		stationtypejcombobox = new JComboBox();//������������������
		String[] array=new String[]{"large lot","small lot"};//���������б�
		stationtypejcombobox.setModel(new DefaultComboBoxModel(array));//����������ģ��
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(stationtypejcombobox,c);
		ensurejbutton = new JButton();//�������水ť
		ensurejbutton.addActionListener(new parkActionListener());//ע�������
		ensurejbutton.setText("in lot confirmation");//���ð�ť�ı�
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(ensurejbutton,c);//��ӵ��������
		JButton backjbutton = new JButton();//����back��ť
		backjbutton.addActionListener(new CloseActionListener());//ע�������
		backjbutton.setText("back");//���ð�ť�ı�
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		mainPanel.add(backjbutton,c);//��ӵ��������
		setVisible(true);											// ��ʾ����ɼ�
	}

	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class parkActionListener implements ActionListener {			// ���in lot confirmation��ť���¼�������
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
				JOptionPane.showMessageDialog(null, "����100Ԫ�����ȳ�ֵ���볡��");
			else{
				int i=Dal.parkin(a1,a2,a3,a4);
				if(i==1)
					JOptionPane.showMessageDialog(null, "�볡�ɹ���");	
				else
					JOptionPane.showMessageDialog(null, "�볡ʧ�ܣ�");	
			}
		}
	}
}



