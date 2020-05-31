import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	// Variables
	private JFrame frame;
	private JTextField textField;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtPhone;
	private static JRadioButton rdbtnBSIT;
	private static JRadioButton rdbtnBSIS;
	private static JRadioButton rdbtnBSCS;
	private static JRadioButton rdbtnBSCpE;
	private static JRadioButton rdbtn1stYear;
	private static JRadioButton rdbtn2ndYear;
	private static JRadioButton rdbtn3rdYear;
	private static JRadioButton rdbtn4thYear;
	private static String Program;
	private static final double tuitionPerUnit = 1235;
	private static final int MAXUNITS = 15;
	private static String[] enrolledSubjects;
	private static String[] enrolledSubjectsDescription;
	private static String[] enrolledSubjectsSchedule;
	private static int[] enrolledSubjectsUnits;
	private static String[] Subjects;
	private static String[] SubjectsDescription;
	public static String[] SubjectsSchedule;
	private static int[] SubjectsUnits;
	private static int units = 0;
	private static String birthday = "";
	private static String gender;
	private static double tuition = 0;
	private JTable tableSubjects;
	private JTextField txtStudentNumber;
	
	// Construct Enrollment Class
	Enrollment enroll = new Enrollment();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Enrollment Window");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.YELLOW);
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(34, 84, 1189, 595);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// Subjects Combo Box
		JComboBox comboSubjects = new JComboBox();
		comboSubjects.setBounds(177, 489, 162, 20);
		comboSubjects.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel.add(comboSubjects);
		
		JLabel lblFName = new JLabel("First Name :");
		lblFName.setBounds(39, 47, 95, 15);
		lblFName.setForeground(Color.BLACK);
		lblFName.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name :");
		lblLName.setBounds(39, 84, 95, 15);
		lblLName.setForeground(Color.BLACK);
		lblLName.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblLName);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setBounds(39, 122, 95, 15);
		lblBirthday.setForeground(Color.BLACK);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblBirthday);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(39, 172, 95, 15);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(39, 209, 95, 15);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblAddress);
		
		JLabel lblContact = new JLabel("Phone Number :");
		lblContact.setBounds(39, 309, 95, 15);
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblContact);
		
		// When clicked Delete button
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(297, 520, 80, 34);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tableSubjects.getModel();
				
				// Conditions for Delete Selected Row
				if (tableSubjects.getSelectedRow() == -1) {
					if (tableSubjects.getRowCount() == 0) {
						
						JOptionPane.showMessageDialog(null, "No Data to Delete","S I R A",JOptionPane.OK_OPTION);
					}
					else {
						JOptionPane.showMessageDialog(null, "Select a row you want to delete. ","S I R A",JOptionPane.OK_OPTION);
					}
				}
				else {
					
					// Remove Selected Row
					model.removeRow(tableSubjects.getSelectedRow());
				}
			}
		});
		panel.add(btnDelete);
		
		
		// Exit Button Clicked
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(995, 352, 117, 34);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit.","S I R A",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		panel.add(btnExit);
		
		txtFName = new JTextField();
		txtFName.setBounds(144, 42, 117, 20);
		panel.add(txtFName);
		txtFName.setColumns(10);
		
		txtLName = new JTextField();
		txtLName.setBounds(144, 82, 117, 20);
		txtLName.setColumns(10);
		panel.add(txtLName);
		
		// Gender ComboBox
		JComboBox comboGender = new JComboBox();
		comboGender.setBounds(144, 170, 80, 20);
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		panel.add(comboGender);
		
		JTextPane txtAddress = new JTextPane();
		txtAddress.setBounds(144, 209, 117, 85);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(143, 307, 118, 20);
		txtPhone.setColumns(10);
		panel.add(txtPhone);
		
		JLabel lblChooseProgram = new JLabel("Choose Program :");
		lblChooseProgram.setBounds(41, 385, 117, 14);
		lblChooseProgram.setForeground(Color.BLACK);
		lblChooseProgram.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblChooseProgram);
		
		// Radiobutton BSIS
		rdbtnBSIS = new JRadioButton("BSIS");
		rdbtnBSIS.setBounds(107, 406, 64, 23);
		rdbtnBSIS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Set Program to BSIS
				Program = "BSIS";
				
				// Clear out the Subjects Table whenever the use chose a different program
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
			}
		});
		rdbtnBSIS.setForeground(Color.BLACK);
		rdbtnBSIS.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBSIS.setBackground(new Color(255, 215, 0));
		panel.add(rdbtnBSIS);
		
		// Radiobutton BSIT
		rdbtnBSIT = new JRadioButton("BSIT");
		rdbtnBSIT.setBounds(41, 406, 64, 23);
		rdbtnBSIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Set Program to BSIT
				Program = "BSIT";
				
				// Clear out the Subjects Table whenever the use chose a different program
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
			}
		});
		rdbtnBSIT.setForeground(Color.BLACK);
		rdbtnBSIT.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBSIT.setBackground(new Color(255, 215, 0));
		panel.add(rdbtnBSIT);
		
		// Radiobutton BSCpE
		rdbtnBSCpE = new JRadioButton("BSCpE");
		rdbtnBSCpE.setBounds(41, 435, 64, 23);
		rdbtnBSCpE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Set Program to BSCpE
				Program = "BSCpE";
				
				// Clear out the Subjects Table whenever the use chose a different program
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
			}
		});
		rdbtnBSCpE.setForeground(Color.BLACK);
		rdbtnBSCpE.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBSCpE.setBackground(new Color(255, 215, 0));
		panel.add(rdbtnBSCpE);
		
		// Radiobutton BSCS
		rdbtnBSCS = new JRadioButton("BSCS");
		rdbtnBSCS.setBounds(107, 435, 64, 23);
		rdbtnBSCS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Set Program to BSCS
				Program = "BSCS";
				
				// Clear out the Subjects Table whenever the use chose a different program
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
			}
		});
		rdbtnBSCS.setForeground(Color.BLACK);
		rdbtnBSCS.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBSCS.setBackground(new Color(255, 215, 0));
		panel.add(rdbtnBSCS);
		
		ButtonGroup program = new ButtonGroup();
		program.add(rdbtnBSIT);
		program.add(rdbtnBSIS);
		program.add(rdbtnBSCS);
		program.add(rdbtnBSCpE);
		
		JLabel lblSelectYear = new JLabel("Select Year Level :");
		lblSelectYear.setBounds(41, 494, 117, 14);
		lblSelectYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectYear.setForeground(Color.BLACK);
		panel.add(lblSelectYear);
		
		// Radiobutton 1st Year
		rdbtn1stYear = new JRadioButton("1st");
		rdbtn1stYear.setBounds(41, 515, 51, 23);
		rdbtn1stYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear out the Subjects Table whenever the use chose a different Year Level
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
				
				// Initialize Variables for 1st Year Subjects
				comboSubjects.setModel(new DefaultComboBoxModel(new String[] {}));
				Subjects = Courses.getSubjects1stYear();
				SubjectsDescription = Courses.getSubjects1stYearDescription();
				SubjectsSchedule = Courses.getSubjects1stYearSchedule();
				SubjectsUnits = Courses.getSubjects1stYearUnits();
				for (int i=0; i < Subjects.length;i++) {
					comboSubjects.addItem(Subjects[i]);
				}
				
				if (rdbtnBSIT.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSIS.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCpE.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCS.isSelected()) {
					panel.add(comboSubjects);
				}
			}
		});
		rdbtn1stYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtn1stYear.setForeground(Color.BLACK);
		rdbtn1stYear.setBackground(new Color(255, 215, 0));
		panel.add(rdbtn1stYear);
		
		// Radiobutton 2nd Year
		rdbtn2ndYear = new JRadioButton("2nd");
		rdbtn2ndYear.setBounds(94, 515, 51, 23);
		rdbtn2ndYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear out the Subjects Table whenever the use chose a different Year Level
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
				
				// Initialize Variables for 2nd Year Subjects
				comboSubjects.setModel(new DefaultComboBoxModel(new String[] {}));
				Subjects = Courses.getSubjects2ndYear();
				SubjectsDescription = Courses.getSubjects2ndYearDescription();
				SubjectsSchedule = Courses.getSubjects2ndYearSchedule();
				SubjectsUnits = Courses.getSubjects2ndYearUnits();
				for (int i=0; i < Subjects.length;i++) {
					comboSubjects.addItem(Subjects[i]);
				}
				
				if (rdbtnBSIT.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSIS.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCpE.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCS.isSelected()) {
					panel.add(comboSubjects);
				}
				
			}
		});
		rdbtn2ndYear.setForeground(Color.BLACK);
		rdbtn2ndYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtn2ndYear.setBackground(new Color(255, 215, 0));
		panel.add(rdbtn2ndYear);
		
		// Radiobutton 3rd Year
		rdbtn3rdYear = new JRadioButton("3rd");
		rdbtn3rdYear.setBounds(41, 544, 51, 23);
		rdbtn3rdYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear out the Subjects Table whenever the use chose a different Year Level
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
				
				// Initialize Variables for 3rd Year Subjects
				comboSubjects.setModel(new DefaultComboBoxModel(new String[] {}));
				Subjects = Courses.getSubjects3rdYear();
				SubjectsDescription = Courses.getSubjects3rdYearDescription();
				SubjectsSchedule = Courses.getSubjects3rdYearSchedule();
				SubjectsUnits = Courses.getSubjects3rdYearUnits();
				for (int i=0; i < Subjects.length;i++) {
					comboSubjects.addItem(Subjects[i]);
				}
				
				if (rdbtnBSIT.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSIS.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCpE.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCS.isSelected()) {
					panel.add(comboSubjects);
				}
			}
		});
		rdbtn3rdYear.setForeground(Color.BLACK);
		rdbtn3rdYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtn3rdYear.setBackground(new Color(255, 215, 0));
		panel.add(rdbtn3rdYear);
		
		// Radiobutton 4th Year
		rdbtn4thYear = new JRadioButton("4th");
		rdbtn4thYear.setBounds(94, 544, 51, 23);
		rdbtn4thYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clear out the Subjects Table whenever the use chose a different Year Level
				tableSubjects.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Course Code", "Description", "Schedule", "Units", "Amount"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, String.class, String.class, Integer.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
				tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
				tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
				tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
				tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
				
				// Initialize Variables for 4th Year Subjects
				comboSubjects.setModel(new DefaultComboBoxModel(new String[] {}));
				Subjects = Courses.getSubjects4thYear();
				SubjectsDescription = Courses.getSubjects4thYearDescription();
				SubjectsSchedule = Courses.getSubjects4thYearSchedule();
				SubjectsUnits = Courses.getSubjects4thYearUnits();
				for (int i=0; i < Subjects.length;i++) {
					comboSubjects.addItem(Subjects[i]);
				}
				
				if (rdbtnBSIT.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSIS.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCpE.isSelected()) {
					panel.add(comboSubjects);
				}
				
				else if (rdbtnBSCS.isSelected()) {
					panel.add(comboSubjects);
				}
			}
		});
		rdbtn4thYear.setForeground(Color.BLACK);
		rdbtn4thYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtn4thYear.setBackground(new Color(255, 215, 0));
		panel.add(rdbtn4thYear);
		
		ButtonGroup yearLevel = new ButtonGroup();
		yearLevel.add(rdbtn1stYear);
		yearLevel.add(rdbtn2ndYear);
		yearLevel.add(rdbtn3rdYear);
		yearLevel.add(rdbtn4thYear);
		
		// When clicked Generate Student Number
		JButton btnGenerateStudentNumber = new JButton("Generate Student Number");
		btnGenerateStudentNumber.setBounds(177, 423, 162, 23);
		btnGenerateStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGenerateStudentNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = "";
				int num;
				num = 11325 + (int) (Math.random()*77300);
				number += num + 2011325;
				txtStudentNumber.setText(number);
			}
		});
		panel.add(btnGenerateStudentNumber);
		
		JLabel lblChooseSubjects = new JLabel("Choose Subjects (15 units max) :");
		lblChooseSubjects.setBounds(177, 464, 220, 14);
		lblChooseSubjects.setForeground(Color.BLACK);
		lblChooseSubjects.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblChooseSubjects);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 458, 547, 113);
		panel.add(scrollPane);
		
		// Subjects Table
		tableSubjects = new JTable();
		tableSubjects.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course Code", "Description", "Schedule", "Units", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
		tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
		tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
		tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
		tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);
		scrollPane.setViewportView(tableSubjects);
		
		// Add Subject Button
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.setBounds(177, 520, 110, 34);
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				DefaultTableModel model = (DefaultTableModel) tableSubjects.getModel();
				
				boolean flag = false;
				
				// Set number of units to 0 whenever clicking the add subject button for checking enrolled units
				units = 0;
				
				// Check for same course code & 
				for (int i=0; i < tableSubjects.getRowCount(); i++) {
					
					// Check number of units
					units += (int) tableSubjects.getValueAt(i, 3);
					
					// Check if same course code
					if (tableSubjects.getValueAt(i, 0).equals(comboSubjects.getSelectedItem())){
						flag = true;
					}
				}
				
				// If you try to enroll a duplicate subject
				if (flag == true) {
					JOptionPane.showMessageDialog(null, "You're already enrolled in this course.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// If you reached the maximum units
				else if (units > MAXUNITS) {
					JOptionPane.showMessageDialog(null, "You've reached the maximum allowed units.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// When try to add blank subject
				else if (comboSubjects.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Please choose a subject.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// Add Row of Course Code, Course Description, Schedule, Unit, and the Amount per subject
				else {
					model.addRow(new Object[] {
							comboSubjects.getSelectedItem(),
							SubjectsDescription[comboSubjects.getSelectedIndex()],
							SubjectsSchedule[comboSubjects.getSelectedIndex()],
							SubjectsUnits[comboSubjects.getSelectedIndex()],
							SubjectsUnits[comboSubjects.getSelectedIndex()]*tuitionPerUnit,
					});
				}
			}
		});
		panel.add(btnAddSubject);
		
		// Empty Combo Box Day unless you picked a Month
		JComboBox comboDay = new JComboBox();
		comboDay.setBounds(205, 120, 44, 20);
		comboDay.setModel(new DefaultComboBoxModel(new String[] {"DD"}));
		panel.add(comboDay);
		
		// Year Combo Box using Loop Ranging From Year 1900 to Year 2020
		JComboBox comboYear = new JComboBox();
		comboYear.setBounds(259, 120, 56, 20);
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"YYYY"}));
		for (int i=2020; i>=1900; i--) {
			comboYear.addItem(i);
		}
		panel.add(comboYear);
		
		// Month Combo Box using Loop from 1 to 12
		JComboBox comboMonth = new JComboBox();
		comboMonth.setBounds(144, 120, 51, 20);
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"MM"}));
		for (int i=1; i<=12; i++) {
			comboMonth.addItem(i);
		}
		
		// When you chose from one of the Value in the Month Combo Box
		comboMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index = comboMonth.getSelectedIndex();
				int leapYear = comboYear.getSelectedIndex() % 4;
				
				// Months with 31 Days
				if (index == 1 || index == 3 || index == 5 || index == 7 || index == 8 || index == 10 || index == 12) {
					comboDay.setModel(new DefaultComboBoxModel(new String[] {"DD"}));
					for (int i=1; i<32; i++) {
						comboDay.addItem(i);
					}
				}
				
				// Months with 30 days
				else if (index == 4 || index == 6 || index == 9 || index == 11) {
					comboDay.setModel(new DefaultComboBoxModel(new String[] {"DD"}));
					for (int i=1; i<31; i++) {
						comboDay.addItem(i);
					}
				}
				
				// Month of February If Leap Year, sets the day up to 29 Days
				else if (index == 2 && leapYear == 1) {
					comboDay.setModel(new DefaultComboBoxModel(new String[] {"DD"}));
					for (int i=1; i<30; i++) {
						comboDay.addItem(i);
					}
					
				}
				
				// February if not Leap Year, 28 Days
				else if (index == 2 && leapYear != 1) {
					comboDay.setModel(new DefaultComboBoxModel(new String[] {"DD"}));
					for (int i=1; i<29; i++) {
						comboDay.addItem(i);
					}
				}
			}
		});
		panel.add(comboMonth);
		
		JTextArea txtRegCard = new JTextArea();
		txtRegCard.setBounds(464, 23, 694, 307);
		txtRegCard.setEditable(false);
		panel.add(txtRegCard);
		
		// Enroll Button
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnroll.setBounds(521, 350, 117, 34);
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboSubjects.setSelectedIndex(0);
				
				// 2nd Filter for  checking errors and bugs
				boolean flag = false;
				units = 0;
				
				for (int i=0; i < tableSubjects.getRowCount(); i++) {
					
					units += (int) tableSubjects.getValueAt(i, 3);
					
					if (tableSubjects.getValueAt(i, 0).equals(comboSubjects.getSelectedItem())){
						flag = true;
					}
				}
				
				// IF there were spaces unfilled
				if (txtFName.getText().equals("") || txtLName.getText().equals("") || comboMonth.getSelectedIndex() == 0 || comboDay.getSelectedIndex() == 0 || comboYear.getSelectedIndex() == 0 || program.getSelection() == null || yearLevel.getSelection() == null || txtStudentNumber.getText().equals("")|| tableSubjects.getRowCount() == 0 || tableSubjects.getColumnCount() == 0) {
					JOptionPane.showMessageDialog(null, "Please fill up the blank spaces.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// Check for duplicate subjects
				else if (flag == true) {
					JOptionPane.showMessageDialog(null, "You have duplicate subjects.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// Check for units enrolled exceeds the limit
				else if (units > MAXUNITS) {
					JOptionPane.showMessageDialog(null, "You've exceeded the amount of allowed units.\nPlease remove some subjects.","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				// Check if the student is already enrolled
				else if (enroll.checkEnrolledStatus(txtLName.getText(), txtStudentNumber.getText())) {
					JOptionPane.showMessageDialog(null, "You're enrolled already","S I R A",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					// Initializing the size of enrolled data
					enrolledSubjects = new String [tableSubjects.getRowCount()];
					enrolledSubjectsDescription = new String [tableSubjects.getRowCount()];
					enrolledSubjectsSchedule = new String [tableSubjects.getRowCount()];
					enrolledSubjectsUnits = new int [tableSubjects.getRowCount()];
					
					// Storing data values from the combo boxes
					birthday += comboMonth.getSelectedItem() + "-" + comboDay.getSelectedItem() + "-" + comboYear.getSelectedItem();
					gender = (String) comboGender.getSelectedItem();
					
					// Storing the values
					for (int i=0; i < tableSubjects.getRowCount(); i++) {
						tuition += (double) tableSubjects.getValueAt(i, 4);
						enrolledSubjects[i] = (String) tableSubjects.getValueAt(i, 0);
						enrolledSubjectsDescription[i] = (String) tableSubjects.getValueAt(i, 1);
						enrolledSubjectsSchedule[i] = (String) tableSubjects.getValueAt(i, 2);
						enrolledSubjectsUnits[i] = (int) tableSubjects.getValueAt(i, 3);
					}
					
					// Creating account for new student
					enroll.createAccount(txtFName.getText(), txtLName.getText(), birthday, gender, txtAddress.getText(), txtPhone.getText(), tuition, txtStudentNumber.getText(), Program, enrolledSubjects, enrolledSubjectsDescription, enrolledSubjectsSchedule,enrolledSubjectsUnits);
					
					// Set Texts to the Text Area
					txtRegCard.setText("===================================================================================================\n");
					txtRegCard.append("\tCongratulations, You are now enrolled!\n\n"
									+ "\tStudent Number : "+txtStudentNumber.getText()
									+ "\n\tProgram : "+ Program
									+ "\n\tName : " +txtFName.getText()+" "+txtLName.getText()
									+ "\n\tBirthday : "+birthday
									+ "\n\tAddress : "+txtAddress.getText()
									+ "\n\tUnits: "+units
									+ "\n\tTuition Fee : P "+tuition+"\n\n"
									+ "\tCourse Code\tDescription\t\t\tSchedule\n\n");
					
					for (int i=0; i < enrolledSubjects.length;i++) {
						txtRegCard.append("\t"+enrolledSubjects[i] +"\t"+ enrolledSubjectsDescription[i]+"\t"+enrolledSubjectsSchedule[i]+"\n");
					}
					txtRegCard.append("===================================================================================================");
					
					// Change enrolled status of student from unenroll to enrolled
					enroll.changeEnrolledStatus(txtLName.getText(), txtStudentNumber.getText());
					
					// Re-initalize all variable after enrollment for the next enrollee
					txtFName.setText(null);
					txtLName.setText(null);
					txtPhone.setText(null);
					birthday = "";
					comboMonth.setSelectedIndex(0);
					comboDay.setSelectedIndex(0);
					comboYear.setSelectedIndex(0);
					comboGender.setSelectedIndex(0);
					comboSubjects.setModel(new DefaultComboBoxModel(new String[] {""}));
					txtAddress.setText(null);
					tuition = 0;
					txtStudentNumber.setText(null);
					Program = null;
					enrolledSubjects = null;
					enrolledSubjectsDescription = null;
					enrolledSubjectsSchedule = null;
					enrolledSubjectsUnits = null;
					program.clearSelection();
					yearLevel.clearSelection();
					tableSubjects.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Course Code", "Description", "Schedule", "Units", "Amount"
							}
						) {
							Class[] columnTypes = new Class[] {
								String.class, String.class, String.class, Integer.class, String.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					tableSubjects.getColumnModel().getColumn(0).setPreferredWidth(118);
					tableSubjects.getColumnModel().getColumn(1).setPreferredWidth(231);
					tableSubjects.getColumnModel().getColumn(2).setPreferredWidth(148);
					tableSubjects.getColumnModel().getColumn(3).setPreferredWidth(52);
					tableSubjects.getColumnModel().getColumn(4).setPreferredWidth(92);	
				}
			}
		});
		panel.add(btnEnroll);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 340, 441, 27);
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(411, 0, 30, 428);
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(411, 406, 778, 27);
		panel_2_1.setBackground(Color.BLACK);
		panel.add(panel_2_1);
		
		txtStudentNumber = new JTextField();
		txtStudentNumber.setEditable(false);
		txtStudentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentNumber.setBounds(177, 392, 167, 20);
		panel.add(txtStudentNumber);
		txtStudentNumber.setColumns(10);
		
		// Clear Log button to Clear the Text Area
		JButton btnClear = new JButton("Clear Log");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRegCard.setText(null);
			}
		});
		btnClear.setBounds(755, 352, 117, 34);
		panel.add(btnClear);
		
		JLabel manageStudent = new JLabel("STUDENT ENROLLMENT");
		manageStudent.setForeground(new Color(255, 215, 0));
		manageStudent.setHorizontalAlignment(SwingConstants.CENTER);
		manageStudent.setBackground(Color.RED);
		manageStudent.setFont(new Font("Tahoma", Font.BOLD, 32));
		manageStudent.setBounds(434, 0, 439, 73);
		frame.getContentPane().add(manageStudent);
	}
}