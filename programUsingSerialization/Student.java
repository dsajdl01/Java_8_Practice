package programUsingSerialization.test;


import java.time.chrono.IsoChronology;
import java.time.LocalDate;
/**
 * Student class create a object of student with
 * student's id, mane, date of birthday, age, height and address
 * 
 *  When the student object is serialised then 
 *  student's age, height and address would not be included
 * 
 * @author David Sajdl
 * @version 15/10/2015
 *
 */

@SuppressWarnings("serial")
public class Student implements java.io.Serializable{
	
	private int stuRollNum;
	private transient int stuAge;
	private String stuName;
	private  LocalDate stuBirthday;
	private transient int stuHeight;
	private transient String stuAddress;
	
	/**
	 * constructor with five parameters
	 * 
	 * @param roll int student's id number
	 * @param birth LocalDate student's data of birthday
	 * @param name String sturent's name
	 * @param address String student's address
	 * @param height int student's height.
	 */
	 
	public Student(int roll, LocalDate birth, String name, String address, int height){
		this.stuRollNum = roll;
		this.stuBirthday = birth;
		this.stuName = name;
		this.stuAddress = address;
		this.stuHeight = height;
		this.setAge(birth);
	}
	
	public int getStuRollNumb(){
		return this.stuRollNum;
	}
	
	public void setAge(LocalDate b){
		this.stuAge = b.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}
	
	public LocalDate getDOF(){
		return this.stuBirthday;
	}
	
	public int getStuAge(){
		if(this.stuAge == 0){
			this.setAge(this.stuBirthday);
		}
		return this.stuAge; 
	}
	
	public String getStuName(){
		return this.stuName;
	}
	
	public int getStuHeight(){
		return this.stuHeight;
	}
	
	public String getStuAddress(){
		return this.stuAddress;
	}
	
	@Override
	public String toString(){
		return "ID: " + this.stuRollNum + ", Name: " + this.stuName + ", Address: " 
				+ this.stuAddress + ", Height: " + this.stuHeight + ", DBO: " + this.stuBirthday +  ", Age: " + this.stuAge; 
	}
}
