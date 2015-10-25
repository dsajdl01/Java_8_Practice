package xmlExcercise;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
/**
 * Staff class
 * 
 * @author David Sajdl
 * @version 25/10/2015
 */
public class Staff {
	
	private String firstName;
	private String lastName;	
	private Sex sex;  
	private double salary;
	private int age;
	private String mail; 
	private LocalDate DOB;

	public Staff(String firstName, String lastName, Sex sex, double salery, String mail, LocalDate DOB){
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.mail = mail;
		this.DOB = DOB;
		this.setAge();
	}
	
	public Staff(String firstName, Sex sex, double salery, String mail, LocalDate DOB){
		this.firstName = firstName;
		this.lastName = null;
		this.sex = sex;
		this.mail = mail;
		this.DOB = DOB;
		this.setAge();
	}
	public Staff(String firstName, double salery, String mail, LocalDate DOB){
		this.firstName = firstName;
		this.lastName = null;
		this.sex = Sex.NOTSPECIFIED;
		this.mail = mail;
		this.DOB = DOB;
		this.setAge();
	}
	private void setAge(){
		this.age =  this.DOB.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public Sex getSex(){
		return this.sex;
	}
	public double getSalery(){
		return this.salary;
	}
	public LocalDate getDOB(){
		return this.DOB;
	}
	public String getEmailAddtess(){
		return this.mail;
	}
	public int getAge(){
		return this.age;
	}
	public void printStaff(){
		if(this.lastName != null){
			System.out.println("Name: " + this.firstName + " " +this.lastName + "\t" + "Sex: " +this.sex.toString() 
					+"\t"+"Age: " + this.age);
		}else{
			System.out.println("Name: " + this.firstName + "\t" + "Sex: " +this.sex.toString() 
					+"\t"+"Age: " + this.age);
		}
	}
	@Override
	public String toString(){
		return "Name: " + this.firstName + ", Sex: " +this.sex.toString() + ", DOB: " + this.DOB.toString() 
				+", Age: " + this.age + ", E-mail: " + this.mail;
	}
}
