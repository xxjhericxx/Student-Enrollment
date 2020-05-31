
public class Student {
	
	// All the Data that being stored
	private String fName;
	private String lName;
	private String birthday;
	private String gender;
	private String address;
	private String phoneNumber;
	private double tuitionFee;
	public String studentNumber;
	public String program;
	public String[] subjects;
	public String[] subjectsDescription;
	public String[] schedule;
	public int[] units;
	public static boolean enrolled = false;
	
	
	// Get data from the new student
	public Student (String fName, String lName, String birthday, String gender, String address, String phoneNumber, double tuitionFee, String studentNumber, String program, String[] subjects,String[] subjectsDescription, String schedule[], int[] units) {
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.tuitionFee = tuitionFee;
		this.studentNumber = studentNumber;
		this.program = program;
		this.subjects = subjects;
		this.subjectsDescription = subjectsDescription;
		this.schedule = schedule;
		this.units = units;
		
	}
	
	// Method that returns the student number
	public String  getStudentNumber() {
		return studentNumber;
		
	}
	
	// Returns the First Name
	public String getFName() {
		return fName;
	}
	
	// Returns the Last Name
	public String getLName() {
		return lName;
	}
	
	// Change Enroll status from unenroll to enrolled
	public static void setEnrolledStatus() {
		enrolled = true;
	}
	
	// Returns the enrolled status
	public static boolean getEnrolledStatus() {
		return enrolled;
	}
}
