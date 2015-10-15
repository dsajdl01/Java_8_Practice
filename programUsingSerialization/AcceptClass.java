package programUsingSerialization.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * AcceptClass class load serialised file call studentList.ser
 * Then deserialise file into list of Students and print them out. 
 * 
 * @author David Sajdl
 * @version 15/10/2015
 */
public class AcceptClass {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
			
		try{
			// load the studentList.ser file
			FileInputStream fis = new FileInputStream("studentList.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// creating list  
			List<Student> studentList = new ArrayList<Student>();
			// deserialise file into list 
			studentList = (ArrayList<Student>)ois.readObject();
			
			// printing students values out 
			for(Student stu : studentList){
				System.out.println("Student name: " + stu.getStuName() 
						+ ", Student Roll Number: " + stu.getStuRollNumb()
						+ ", Student's DOB: " + stu.getDOF().toString()
						+ ", Student age: " + stu.getStuAge()
						// student's address and height have not been serialised so the values would be null or zero. 
						+ "\nStudent Addreass: " + stu.getStuAddress()
						+ ", Student height: " + stu.getStuHeight());
			}
			// close file and input stream
			ois.close();
			fis.close();
			
		} catch(IOException oie){
			System.out.println(oie.getMessage());
			return;
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Student Class is not found");
			cnfe.printStackTrace();
			return;
		}
	}

}
