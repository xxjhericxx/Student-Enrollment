
public class Enrollment {
	
	// Array of Student Class
	private Student[] students;
	public static final int MAX = 100; // Maximum number for enrollees
	private static int numAccounts; // To Track the number of enrolling students
	
	// When sontructing a new enrollment
	public Enrollment() {
		students = new Student[MAX];
		numAccounts=0;
	}
	
	// Get data from the user then store it to the array of Student Class
	public void createAccount (String fName, String lName, String birthday, String gender, String address, String phoneNumber, double tuitionFee, String studentNumber, String program, String[] subjects,String[] subjectsDescription, String schedule[], int[] units) {
		Student temp = new Student (fName, lName, birthday, gender, address, phoneNumber, tuitionFee, studentNumber, program, subjects,subjectsDescription, schedule, units);
		students[numAccounts] = temp; 
		numAccounts++;
	}
	
	// Checks the enrolled status
	public boolean checkEnrolledStatus(String lName, String studentNumber) {
		boolean found = false;
		
		for (int i=0; i < numAccounts; i++) {
			if (students[i].getStudentNumber().equals(studentNumber) && students[i].getLName().equals(lName)) {
				found = students[i].getEnrolledStatus();
				break;
			}
		}
		return found;
	}
	
	// Changes the enrolled status
	public void changeEnrolledStatus(String lName, String studentNumber) {	
		for (int i=0; i < numAccounts; i++) {
			if (students[i].getStudentNumber().equals(studentNumber) && students[i].getLName().equals(lName)) {
				students[i].setEnrolledStatus();
				break;
			}
		}
	}
	
}
