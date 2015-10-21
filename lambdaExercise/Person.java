package lambdaExercise;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Person class 
 * 
 * @author David Sajdl
 * @version 21/10/2015
 *
 */
public class Person {
	
	public enum Sex {
        MALE, FEMALE
    }
	
	private String name;
	private LocalDate birthday;
	private Sex genda;
	private String email;
	
	public Person(String name, LocalDate birthday, Sex genda, String mail){
		this.name = name;
		this.birthday = birthday;
		this.genda = genda;
		this.email = mail;
	}
	public String getName(){
		return this.name;
	}
	public LocalDate getDOB(){
		return this.birthday;
	}
	public int getAge(){
		return birthday
	            .until(IsoChronology.INSTANCE.dateNow())
	            .getYears();
	}
	public Sex getGenda(){
		return this.genda;
	}
	public String getEmailAddress(){
		return this.email;
	}
	public void printPerson(){
		System.out.println(this.name + "\t| " + this.getAge());
	}
	
	public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
	
	public static List<Person> createListOfPeople() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Fred",IsoChronology.INSTANCE.date(1982, 6, 20),Person.Sex.MALE,"fred@example.com"));
		personList.add(new Person("Jane",IsoChronology.INSTANCE.date(1990, 7, 15),Person.Sex.FEMALE, "jane@example.com"));
		personList.add(new Person("George",IsoChronology.INSTANCE.date(1991, 8, 13),Person.Sex.MALE, "george@example.com"));
		personList.add(new Person("Bob",IsoChronology.INSTANCE.date(2000, 9, 12),Person.Sex.MALE, "bob@example.com"));
		personList.add(new Person("Magda", IsoChronology.INSTANCE.date(1979, 10, 21), Person.Sex.FEMALE, "magda@example.com"));
		personList.add(new Person("David", IsoChronology.INSTANCE.date(1977, 01,02), Person.Sex.MALE, "david@example.co.uk"));
    return personList;
}
}
