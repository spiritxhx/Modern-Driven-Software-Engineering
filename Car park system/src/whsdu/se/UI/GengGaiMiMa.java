
package whsdu.se.UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;


public class GengGaiMiMa extends JInternalFrame{
	private JLabel name;
	private JPasswordField oldPass;
	private JPasswordField newPass2;
	private JPasswordField newPass1;
	private JLabel userName;
	private JTextField username;
	private users user = LoginFrame.getUser(); 

	public GengGaiMiMa() {
		super("change password");
		//setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(new GridBagLayout());
		setBounds(351, 193, 427, 334);
		final JLabel label_4 = new JLabel();
		label_4.setForeground(Color.blue);
		label_4.setText("<html>Note:everyone<b></b>can only change his/her own password</html>");
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.weighty = 1.0;
		gridBagConstraints_10.gridwidth = 4;
		gridBagConstraints_10.gridx = 0;
		gridBagConstraints_10.gridy = 0;
		getContentPane().add(label_4, gridBagConstraints_10);

		final JLabel label_5 = new JLabel();
		label_5.setText("login name:");
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.gridy = 2;
		gridBagConstraints_11.gridx = 0;
		getContentPane().add(label_5, gridBagConstraints_11);

		username  =new JTextField(user.getName());
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy = 2;
		gridBagConstraints_12.gridx = 1;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(username, gridBagConstraints_12);
		username.setEditable(false);

		final JLabel label_1 = new JLabel();
		label_1.setText("old password:");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 3;
		gridBagConstraints_2.gridx = 0;
		getContentPane().add(label_1, gridBagConstraints_2);

		oldPass = new JPasswordField();
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.weighty = 1.0;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3.gridwidth = 3;
		gridBagConstraints_3.gridy = 3;
		gridBagConstraints_3.gridx = 1;
		getContentPane().add(oldPass, gridBagConstraints_3);

		final JLabel label_2 = new JLabel();
		label_2.setText("new password:");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 4;
		gridBagConstraints_4.gridx = 0;
		getContentPane().add(label_2, gridBagConstraints_4);

		newPass1 = new JPasswordField();
		newPass1.setFont(new Font("", Font.PLAIN, 14));
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.weighty = 1.0;
		gridBagConstraints_5.ipadx = 30;
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.gridwidth = 3;
		gridBagConstraints_5.gridy = 4;
		gridBagConstraints_5.gridx = 1;
		getContentPane().add(newPass1, gridBagConstraints_5);

		final JLabel label_3 = new JLabel();
		label_3.setText("confirm new password:");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 5;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(label_3, gridBagConstraints_6);

		newPass2 = new JPasswordField();
		newPass2.setFont(new Font("", Font.PLAIN, 14));
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.weighty = 1.0;
		gridBagConstraints_7.ipadx = 30;
		gridBagConstraints_7.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.weightx = 1.0;
		gridBagConstraints_7.gridwidth = 3;
		gridBagConstraints_7.gridy = 5;
		gridBagConstraints_7.gridx = 1;
		getContentPane().add(newPass2, gridBagConstraints_7);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {//添加确认按钮的监听器
			public void actionPerformed(final ActionEvent e) {
				if (oldPass.getText().equals(user.getPassword())) {
					if (newPass1.getText().equals(newPass2.getText())) {
						user.setPassword(newPass1.getText());
						Dal.Updatepass(user.getPassword(),user.getName());
						oldPass.setText(null);
						newPass1.setText(null);
						newPass2.setText(null);
						JOptionPane.showMessageDialog(getContentPane(), "password has changed!");
						doDefaultCloseAction();
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "two passwords differ, try again! ");
					}
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "wrong old password, try again! ");
				}
			}
		});

		button.setText("confirm");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.weighty = 1.0;
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 6;
		gridBagConstraints_8.gridx = 1;
		getContentPane().add(button, gridBagConstraints_8);

		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {//添加重写按钮的监听器
			public void actionPerformed(final ActionEvent e) {
				oldPass.setText(null);
				newPass1.setText(null);
				newPass2.setText(null);
			}
		});

		button_1.setText("rewrite");
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 2;
		gridBagConstraints_9.weighty = 1.0;
		gridBagConstraints_9.gridy = 6;
		gridBagConstraints_9.gridx = 2;
		getContentPane().add(button_1, gridBagConstraints_9);

		setVisible(true);
	}
}
