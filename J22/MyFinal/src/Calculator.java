import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JTextArea;
/**
 * Swing Calculator GUI to do 4 arithmetic operations: Addition, Subtraction, Multiplication and Division
 * Division is the only formatted output to two decimal places, using DecimalFormat
 * 
 * @author Winston Tsia
 * @since 12/13/2022
 */
public class Calculator {

	private JFrame frame;
	private JTextField numOne;
	private JTextField numTwo;
	private JTextField numResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}
	public double calcAddition(double a, double b) {
		double c = a + b;
		return c;
	}
	public double calcDifference(double a, double b) {
		double c = a - b;
		return c;
	}
	public double calcMultiply(double a, double b) {
		double c = a*b;
		return c;
	}
	public double calcDivide(double a, double b) {
		double c = a/b;
		return c;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DecimalFormat dc = new DecimalFormat("0.00");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWinstonCalculator = new JLabel("WINSTON CALCULATOR");
		lblWinstonCalculator.setBounds(141, 0, 182, 32);
		frame.getContentPane().add(lblWinstonCalculator);
		
		numOne = new JTextField();
		numOne.setBounds(54, 59, 114, 19);
		frame.getContentPane().add(numOne);
		numOne.setColumns(10);
		
		numTwo = new JTextField();
		numTwo.setBounds(257, 59, 114, 19);
		frame.getContentPane().add(numTwo);
		numTwo.setColumns(10);
		
		JLabel lblNumber = new JLabel("NUMBER 1");
		lblNumber.setBounds(78, 43, 90, 15);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblNumber_1 = new JLabel("NUMBER 2");
		lblNumber_1.setBounds(277, 44, 70, 15);
		frame.getContentPane().add(lblNumber_1);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strNumOne = numOne.getText();
				String strNumTwo = numTwo.getText();
				if (strNumOne.isEmpty() || strNumTwo.isEmpty()) {
					return;
				}
				Double numOne = Double.parseDouble(strNumOne);
				Double numTwo = Double.parseDouble(strNumTwo);
				Double newResult = calcAddition(numOne, numTwo);
				String strResult = newResult.toString();
				numResult.setText(strResult);;
			}
		});
		button.setBounds(93, 141, 117, 25);
		frame.getContentPane().add(button);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strNumOne = numOne.getText();
				String strNumTwo = numTwo.getText();
				if (strNumOne.isEmpty() || strNumTwo.isEmpty()) {
					return;
				}
				Double numOne = Double.parseDouble(strNumOne);
				Double numTwo = Double.parseDouble(strNumTwo);
				Double newResult = calcMultiply(numOne, numTwo);
				String strResult = newResult.toString();
				numResult.setText(strResult);;
			}
		});
		btnX.setBounds(222, 178, 117, 25);
		frame.getContentPane().add(btnX);
		
		JButton button_2 = new JButton("/");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strNumOne = numOne.getText();
				String strNumTwo = numTwo.getText();
				if (strNumOne.isEmpty() || strNumTwo.isEmpty()) {
					return;
				}
				Double numOne = Double.parseDouble(strNumOne);
				Double numTwo = Double.parseDouble(strNumTwo);
				Double newResult = calcDivide(numOne, numTwo);
				String strResult = dc.format(newResult).toString();
				numResult.setText(strResult);;
			}
		});
		button_2.setBounds(93, 178, 117, 25);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strNumOne = numOne.getText();
				String strNumTwo = numTwo.getText();
				if (strNumOne.isEmpty() || strNumTwo.isEmpty()) {
					return;
				}
				Double numOne = Double.parseDouble(strNumOne);
				Double numTwo = Double.parseDouble(strNumTwo);
				Double newResult = calcDifference(numOne, numTwo);
				String strResult = newResult.toString();
				numResult.setText(strResult);;
			}
		});
		button_3.setBounds(222, 141, 117, 25);
		frame.getContentPane().add(button_3);
		
		numResult = new JTextField();
		numResult.setBounds(93, 110, 246, 19);
		frame.getContentPane().add(numResult);
		numResult.setColumns(10);
		
		JLabel lblResult = new JLabel("RESULT");
		lblResult.setBounds(187, 95, 70, 15);
		frame.getContentPane().add(lblResult);
		
		JTextArea txtrNoteToUsers = new JTextArea();
		txtrNoteToUsers.setText("Note to users: \nLeft to Right operations will begin with Number 1. \nDivision is the only formatted output.");
		txtrNoteToUsers.setBounds(26, 203, 391, 54);
		frame.getContentPane().add(txtrNoteToUsers);
	}
}
