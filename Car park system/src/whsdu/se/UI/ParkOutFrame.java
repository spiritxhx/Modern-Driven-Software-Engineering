/*
 * ��ui������ʵ�ֳ�������˵��µ�vehicles out�˵���
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import whsdu.se.DAO.*;

public class ParkOutFrame extends JInternalFrame {
	private JTextField cardidjtextfield;//����card number�ı���
	private JTextField stationidtextfield;//���������ı���
	private JLabel sumparkjtextfield ;//����card number�ı���
	private JLabel feejtextfield ;//����card number�ı���
	private users user;
	private sit_infor sit;
	private charger charger;
	private park park;
	private int day;
	private int hour;
	private int min;

	//���췽��
	public ParkOutFrame() {
		super("vehicles out");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		JPanel mainPanel = new JPanel();			//�����������
		GridLayout gridLayout = new GridLayout(4,1);//������񲼾ֹ�����
		gridLayout.setVgap(20);					//�������֮�䴹ֱ����
		gridLayout.setHgap(10);					//�������֮��ƽ�о���
		mainPanel.setLayout(gridLayout);		//���ò���
		mainPanel.setBorder(new EmptyBorder(30, 10, 20, 10));		//���ñ߿�
		getContentPane().add(mainPanel);		//�����������뵽����
		setBounds(186,40,329,360);		
		JPanel Panel1 = new JPanel();			
		GridLayout gridLayout1 = new GridLayout(2,2);
		Panel1.setLayout(gridLayout1);
		mainPanel.add(Panel1);
		JPanel Panel3 = new JPanel();			
		Panel3.setLayout(new FlowLayout());		
		Panel3.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel3);	
		JButton xiaofeijbutton = new JButton();
		xiaofeijbutton.addActionListener(new xiaofeiActionListener());
		xiaofeijbutton.setText("credit card");
		Panel3.add(xiaofeijbutton);
		JPanel Panel2 = new JPanel();			
		GridLayout gridLayout2 = new GridLayout(2,2);
		Panel2.setLayout(gridLayout2);
		mainPanel.add(Panel2);
		JPanel Panel4 = new JPanel();			
		Panel4.setLayout(new FlowLayout());		
		Panel4.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel4);	
		JButton enjbutton = new JButton();
		enjbutton.addActionListener(new enActionListener());//ע�������
		enjbutton.setText("out lot confirmation");//���ð�ť�ı�
		Panel4.add(new JLabel());
		Panel4.add(enjbutton);
		Panel4.add(new JLabel());
		JLabel cardidjlabel = new JLabel();	//����card number��ǩ
		cardidjlabel.setText("card number:");			//���ñ�ǩ�ı�
		Panel1.add(cardidjlabel);				
		cardidjtextfield = new JTextField();//����card number�ı���
		cardidjtextfield.setColumns(12);//�����ı��򳤶�
		Panel1.add(cardidjtextfield);
		JLabel stationidjlabel = new JLabel();
		stationidjlabel.setText("lot number:");			
		Panel1.add(stationidjlabel);				
		stationidtextfield = new JTextField();
		stationidtextfield.setColumns(6);
		Panel1.add(stationidtextfield);
		JLabel sumparkjlabel = new JLabel();	
		sumparkjlabel.setText("parking time(h):");			
		Panel2.add(sumparkjlabel);			
		sumparkjtextfield = new JLabel();
		//sumparkjtextfield.setColumns(12);
		sumparkjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(sumparkjtextfield);
		JLabel feejlabel = new JLabel();	
		feejlabel.setText("fee($):");			
		Panel2.add(feejlabel);				
		feejtextfield = new JLabel();
		feejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(feejtextfield);
		setVisible(true);											
	}

	class enActionListener implements ActionListener {			// ���ȷ�ϳ������¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class xiaofeiActionListener implements ActionListener {			// ���credit card���¼�������
		public void actionPerformed(final ActionEvent e) {
			//��һ��:�õ����� = a6
			int  a1 = Integer.parseInt(cardidjtextfield.getText());
			int a2 = Integer.parseInt(stationidtextfield.getText());
			SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String a3 = myfmt.format(new java.util.Date()).toString();

			user = Dal.searchcominfo("select * from users where cardid =" + a1);
			String a4 = user.getCardtype();

			sit = Dal.chewei("select * from  sit_infor   where stationid ="+ a2 ) ;
			String a5 = sit.getStationtype();

			charger = Dal.searchcharge("select * from charger where cardtype = '"+a4 +"'and stationtype = '"+a5+"'");
			int a6 = charger.getCharge();
			//�ڶ���:�õ�startpark
			park = Dal.parkout("select * from park where cardid = "+a1 +"and stationid ="+ a2 +"and endpark is null");
			String a7 = park.getStartpark();

			//����sumpark = a8
			int a8,a9;
			try {
				java.util.Date now = myfmt.parse(a3);
				java.util.Date date=myfmt.parse(a7);
				int l=(int) (now.getTime()-date.getTime());
				day=l/(24*60*60*1000);
				hour=(l/(60*60*1000)-day*24);
				min=((l/(60*1000))-day*24*60-hour*60);
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null,"error");
			}
			System.out.print(min);
			if(min < 30)
				a8 = day*24+hour;
			else
				a8 = day*24+hour+1;
			//�������fee = a9
			a9 = a8*a6;
			//���³�����Ϣ endpark(a3)  fee(a9)  sumpark(a8)
			Dal.Updatepark(a3,a9,a8,a1,a7);
			//�����û���Ϣ�����1\�ȵõ����2���������
			int a10 = user.getOverage();
			int a11 = a10 - a9;
			if(a11 <0)
				JOptionPane.showMessageDialog(null,"balance not enough");
			else{
				Dal.Updateoverage(a1,a11);
				sumparkjtextfield.setText(String.valueOf(a8));
				feejtextfield.setText(String.valueOf(a9));
				JOptionPane.showMessageDialog(null,"payment successful!");
			}
		}
	}	
}