package BST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) throws IOException{
		Student[] student = new Student[1000000];
		int l = student.length;
		
		String path = "C:/Users/User/Downloads/Global_University_Students.csv";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		
		System.out.println("Enter the ID of the student you want to retrieve: ");
	    Scanner sc = new Scanner(System.in);
		int input_id = sc.nextInt();
		sc.close();
		
		System.out.println(Student.readLines(path, student, input_id, sc));
		
		
	}
}
