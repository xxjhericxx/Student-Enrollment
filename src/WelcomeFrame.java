import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class WelcomeFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame window = new WelcomeFrame();
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
	public WelcomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 402, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 425, 470);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 48, 425, 422);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel WELCOME = new JLabel("WELCOME!");
		WELCOME.setHorizontalAlignment(SwingConstants.CENTER);
		WELCOME.setFont(new Font("Tahoma", Font.BOLD, 32));
		WELCOME.setForeground(Color.YELLOW);
		WELCOME.setBounds(82, 104, 239, 123);
		panel_1.add(WELCOME);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main main = new Main();
				main.main(null);
				frame.dispose();
			}
		});
		btnProceed.setBounds(155, 300, 89, 23);
		panel_1.add(btnProceed);
		
		JLabel GIF = new JLabel("");
		GIF.setIcon(new ImageIcon(WelcomeFrame.class.getResource("/images/projectSIRA.gif")));
		GIF.setBounds(0, 0, 425, 422);
		panel_1.add(GIF);
	}

}
