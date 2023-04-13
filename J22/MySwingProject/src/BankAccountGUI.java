import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.Color;

public class BankAccountGUI {

	private JFrame frame;
	private JTextField textBalance;
	private JTextField textAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGUI window = new BankAccountGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankAccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BankAccount myAccount = new BankAccount();
		DecimalFormat dc = new DecimalFormat("0.00");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(25, 50, 70, 15);
		frame.getContentPane().add(lblBalance);
		
		JLabel lblAmount = new JLabel("Amount: ");
		lblAmount.setBounds(25, 191, 70, 15);
		frame.getContentPane().add(lblAmount);
		
		textBalance = new JTextField();
		textBalance.setText("0.00");
		textBalance.setBounds(113, 48, 114, 19);
		frame.getContentPane().add(textBalance);
		textBalance.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setBounds(113, 189, 114, 19);
		frame.getContentPane().add(textAmount);
		textAmount.setColumns(10);
		
		/**
		 * Action button: Withdraw
		 * calls withdraw method of BankAccount object
		 */
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strAmount = textAmount.getText();
				Double numAmount = Double.parseDouble(strAmount);
				Double newBalance = myAccount.withdraw(numAmount);
				strAmount = dc.format(newBalance).toString();
				textBalance.setText(strAmount);;
			}
		});
		
		btnWithdraw.setBounds(177, 232, 117, 25);
		frame.getContentPane().add(btnWithdraw);
		
		/**
		 * Action button: Deposit
		 * calls deposit method of BankAccount object
		 */
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strAmount = textAmount.getText();
				Double numAmount = Double.parseDouble(strAmount);
				Double newBalance = myAccount.deposit(numAmount);
				strAmount = dc.format(newBalance).toString();
				textBalance.setText(strAmount);
			}
		});
		btnDeposit.setBounds(48, 232, 117, 25);
		frame.getContentPane().add(btnDeposit);
		
		JLabel lblJavaMutualBank = new JLabel("Java Mutual Bank");
		lblJavaMutualBank.setForeground(new Color(230, 97, 0));
		lblJavaMutualBank.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblJavaMutualBank.setBounds(125, 10, 203, 26);
		frame.getContentPane().add(lblJavaMutualBank);
		
		JTextArea txtrAboveDisplaysYour = new JTextArea();
		txtrAboveDisplaysYour.setText("Above displays your current balance.\nEnter a number below and choose the \nappropriate action to deposit or \nwithdraw legal tender.");
		txtrAboveDisplaysYour.setBounds(25, 82, 269, 60);
		frame.getContentPane().add(txtrAboveDisplaysYour);
	}
}
