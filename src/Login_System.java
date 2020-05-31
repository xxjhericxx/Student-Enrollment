import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//import Sign_Up.Sign_Up;

import java.awt.Color;
import javax.swing.JPanel;

public class Login_System {
	
	private JFrame frame;
	private JPasswordField txtPassword;
	private JFrame frmLoginSystem;
	private JTextField txtUserID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
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
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(200, 200, 508, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("S I R A");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSystemOr = new JLabel("System of Information and Registration of Academics");
		lblSystemOr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSystemOr.setBounds(83, 119, 356, 14);
		frame.getContentPane().add(lblSystemOr);
		
		JLabel lblUserId = new JLabel("User ID :");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserId.setForeground(Color.YELLOW);
		lblUserId.setBounds(50, 196, 81, 14);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblNewLabel = new JLabel("Password :");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(50, 238, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(161, 193, 248, 20);
		frame.getContentPane().add(txtUserID);
		txtUserID.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(161, 234, 248, 22);
		frame.getContentPane().add(txtPassword);
		
		// Login button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Stores the username and password input
				String username = txtUserID.getText();
				String password = txtPassword.getText();
				
				// If username and password matched
					if (username.equals("admin") && password.equals("admin")) {
						
						// Sets the TextField to blank
						txtUserID.setText(null);
						txtPassword.setText(null);
						
						JOptionPane.showMessageDialog(null, "Login Successful!","S I R A",JOptionPane.OK_CANCEL_OPTION);
						
						// Splash Screen called
						Thread sp = new Thread(new LoadingScreen());
						sp.start();
						
						// Dispose frame
						frame.dispose();	
					}
				
				// If invalid login input
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login Details","S I R A",JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		
		btnNewButton.setBounds(50, 322, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		// Reset Button clears the TextFields
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 250, 250));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUserID.setText(null);
				txtPassword.setText(null);
			}
		});
		
		btnReset.setBounds(203, 322, 89, 23);
		frame.getContentPane().add(btnReset);
		
		// Exit button to end the program
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 250, 250));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit.","SIRA",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		btnExit.setBounds(337, 322, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 298, 397, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 164, 397, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(393, 69, 46, 14);
		frame.getContentPane().add(lblDate);
		
		Calendar time = Calendar.getInstance();
		time.getTime();
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		JLabel Date = new JLabel(date.format(time.getTime()));
		Date.setBounds(381, 94, 66, 14);
		frame.getContentPane().add(Date);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(48, 69, 399, 72);
		frame.getContentPane().add(panel);
		
		JLabel lblSIRA = new JLabel("S I R A ");
		panel.add(lblSIRA);
		lblSIRA.setFont(new Font("Arial", Font.BOLD, 24));
		
		
	}
	
}