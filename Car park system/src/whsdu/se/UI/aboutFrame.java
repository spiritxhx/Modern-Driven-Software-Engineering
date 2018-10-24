

package whsdu.se.UI;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class aboutFrame extends JInternalFrame {

	private  JLabel label;
	public  aboutFrame() {
		super("about");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setClosable(true);		
		setResizable(true);		
		setBounds(new Rectangle(206,76,331,300));
		JPanel Panel1 = new JPanel();	
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		
		getContentPane().add(Panel1);
		label = new JLabel();
		Panel1.add(label);
		label.setText("<html>Team: Cool name pending<br /> Hanxiang Xu: 40020940 <br /> Yiwen Niu: 40022060<br />  Leran Zhang: 40018066<br />  Ruopeng Wang: 40021930<br /> Boyuan wu: 40022491<br /> </html>");// ‰»Îœ‘ æµƒ∫∫◊÷
		setVisible(true);		
	}
}
