import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Splash extends JFrame {

	public static JPanel contentPane;
	public static JLabel GIF;
	public static JLabel lblPercent;
	public static JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSIRA = new JLabel("S I R A");
		lblSIRA.setForeground(Color.YELLOW);
		lblSIRA.setHorizontalAlignment(SwingConstants.CENTER);
		lblSIRA.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblSIRA.setBounds(118, 118, 165, 49);
		contentPane.add(lblSIRA);
		
		JLabel lblPleaseWait = new JLabel("Please Wait . . .");
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWait.setForeground(Color.YELLOW);
		lblPleaseWait.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseWait.setBounds(59, 355, 291, 37);
		contentPane.add(lblPleaseWait);
		
		lblPercent = new JLabel("%");
		lblPercent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent.setBounds(182, 403, 46, 31);
		contentPane.add(lblPercent);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(59, 403, 291, 31);
		contentPane.add(progressBar);
		
		GIF = new JLabel("");
		GIF.setIcon(new ImageIcon(Splash.class.getResource("/images/projectSIRA.gif")));
		GIF.setBounds(0, 78, 437, 404);
		contentPane.add(GIF);
	}
}
