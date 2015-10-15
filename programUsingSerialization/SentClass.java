package programUsingSerialization.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * SentClass class load list of students and 
 * then serialised list and save it onto this project 
 * as studentList.ser file
 * 
 * @author David Sajdl
 * @version 15/10/2015
 *
 */
public class SentClass {
	
	public static void main(String[]args){
		
		SentClass sc = new SentClass();
		// load student object into list
		List<Student> student = sc.createStudentList();
		
		try{
			
			// locate where the serialised data would be stored 
			FileOutputStream fos = new FileOutputStream("studentList.ser");
			// write data types object to output stream  
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// print all list of students 
			for(Student s : student){
				System.out.println(s);
			}
			
			// serialised list of students
			oos.writeObject(student);
			
			// close file and output stream
			oos.close();
			fos.close();
			System.out.println("Sertilzarion is done!!! ");
			
		} catch (IOException e){
			System.out.println(e.toString());
		} 
	}
	/**
	 * createStudentList() method creates Array list of students
	 * 
	 * @return list of students
	 */
	
	public List<Student> createStudentList() {    
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(20113,IsoChronology.INSTANCE.date(1980, 6, 20),"Fred","London - England", 171));
        studentList.add(new Student(20114,IsoChronology.INSTANCE.date(1990, 7, 15),"Jane","London - England", 170));
        studentList.add(new Student(20115,IsoChronology.INSTANCE.date(1988, 7, 21),"Magda","London - England", 168));
        studentList.add(new Student(20116, IsoChronology.INSTANCE.date(1977, 01, 02), "David", "London - England", 182));
        return studentList;
    }
}
