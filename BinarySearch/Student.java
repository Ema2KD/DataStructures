package BST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
	private int studentID;
	private int enrolmentYear;
	private String fullName;
	private String birthDate;
	private String university;
	private String departmentCode;
	private String departmentName;
	
	public Student(int studentID, String departmentName, String fullName, String birthDate, String university, String departmentCode, int enrolmentYear) {
		this.studentID = studentID;
		this.enrolmentYear = enrolmentYear;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.university = university;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}
	
	public String toString(){
        return ("\nStudent ID: " + this.studentID + "\nName and surname: " + this.fullName + "\nDate of birth: " + this.birthDate +
                "\nUniversity: " + this.university + "\nDepartment code: " + this.departmentCode + "\nDepartment: " + this.departmentName + "\nYear of enrolment: " + this.enrolmentYear + "\n\n");
    } 
	
	public int getID() {
		return studentID;
	}
	
	public static String readLines(String path, Student[] student, int input_id, Scanner sc) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		int l = student.length;
		
		BinarySearchTree x = new BinarySearchTree();
		
		for(int i=0; i<l; i++) {
			String x1 = reader.readLine();
			String[] splitting = x1.split(";");
			
			int studentID = Integer.parseInt(splitting[0]) ;
			int enrolmentYear = Integer.parseInt(splitting[6]);
			String fullName = splitting[1];
			String birthDate = splitting[2];
			String university = splitting[3];
			String departmentCode = splitting[4];
			String departmentName = splitting[5];
			student[i] = new Student(studentID, departmentName, fullName, birthDate, university, departmentCode, enrolmentYear);
		}
		
		BinarySearchTree<Integer, Student> y = new BinarySearchTree<Integer, Student>();
		for(int j=1; j<l; j++) {
			y.put(student[j].getID(), student[j]);
		}
		Student stud = y.get(input_id);
		
		if(stud == null) {
			return ("The student with the given ID does not exist.\nThe search was completed in " + y.getSteps() +" steps");
		}
		else {
			return (stud + "The student was retrieved from BST in " + y.getSteps() + " steps.");
		}
	}
}


