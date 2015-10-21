package lambdaExercise;

import java.util.List;
/**
 * DriverPrintList class provides different search methods
 * to find specific value from the list of object Person.
 *  
 * The class and following methods are practice on lambda Expression 
 * from the following URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 * @author David Sadjl
 * @version 21/10/2015
 *
 */
public class DriverPrintList {

	/**
	 * To specify the search criteria. 
	 * Implement the CheckPerson interface. */
	interface CheckPerson {
	    boolean test(Person p);
	}
	
	public static void main(String[] args) {
		/**
		 * CheckingPersonGendaAndAge class implements the CheckPerson interface 
		 * by specifying an implementation for the method test. 
		 * 
		 * 
		 * @author david
		 *
		 */
		class CheckingPersonGendaAndAge implements CheckPerson {
		    /**
		     * test method filters members that are eligible for 
		     * Selective Service in the United States: it returns a true value 
		     * if its Person parameter is male and between the ages of 18 and 25 inclusive.
		     *  
		     */
			public boolean test(Person p) {
		        return p.getGenda() == Person.Sex.MALE &&
		            p.getAge() >= 18 &&
		            p.getAge() <= 25;
		    }
		}
		
		List<Person> listOfPeople = Person.createListOfPeople();
		DriverPrintList dpl = new DriverPrintList();
		
		/** print all values from list of people */
		printAllPersonDetails(listOfPeople);
		dpl.printSeperator(85);
		
		/** print all people who is older or equal to age 25 */
		printPersonsOlderThan(listOfPeople, 25);
		dpl.printSeperator(85);
		
		/** print all people who age is greater than 25 inclusive 
		    and is smaller than 35 inclusive */
		printPersonsWithinAgeRange(listOfPeople, 25,35);
		dpl.printSeperator(85);
		
		/**
		 * print all male who is older than 18 and younger than 25 inclusive
		 * by using Search Criteria Code in an Anonymous Class */ 
		printPersons(listOfPeople, new CheckingPersonGendaAndAge());
		dpl.printSeperator(85);
		/**
		 * print all male who is older than 15 and younger than 20 inclusive
		 * by specify search criteria code in an Anonymous Class
		 * 
		 * An anonymous class that filters members that are eligible for 
		 * Selective Service in the United States: those who are male and 
		 * between the ages of 15 and 20
		 */
		printPersons(listOfPeople,
			    new CheckPerson() { public boolean test(Person p) {
			            return p.getGenda() == Person.Sex.MALE
			            		&& p.getAge() >= 15 && p.getAge() <= 20;
			        }
			    }
			);
		
	}
	
	/**
	 *  printPersonsWithinAgeRange methods search for members 
	 *  that match to range of the specified incoming integers.
	 * 
	 * 
	 * @param list ArrayList with Person elements 
	 * @param low integer represent lowest age on the member 
	 * @param high integer represent highest age if the member.
	 */
	public static void printPersonsWithinAgeRange(List<Person> list, 
			int low, int high) { 
		for(Person p : list){
			if(p.getAge() >= low && p.getAge() <= high){ 
				p.printPerson();
			}
		}
	}
	
	/**
	 * printPersons methods is a specify search criteria code in a Local Class.
	 * methods print list of members values whether it satisfies the search 
	 * criteria specified in the CheckPerson parameter tester 
	 * by invoking the method tester.test. 
	 * If the method tester.test returns a true value, 
	 * then the method printPersons is invoked on the Person instance.
	 * 
	 *
	 * @param list ArrayList Person values 
	 * @param cp CheckPerson instance of the local class CheckingPersonGendaAndAge.
	 */
	public static void printPersons(List<Person> list, CheckPerson cp) {
		    for (Person p : list) {
		        if (cp.test(p)) {
		            p.printPerson();
		        }
		    }
		}
	/**
	 * printAllPersonDetails methods prints out all 
	 * details of the members in the list
	 * 
	 * @param list ArrayList represent members that would be printing out.
	 */
	public static void printAllPersonDetails(List<Person> list){
		for(Person p : list){
			System.out.println("Name: " + p.getName()
							  + " genda: " + p.getGenda()
							  +" DOB: " + p.getDOB()
							  +" age: " + p.getAge()
							  +" e-mail: " + p.getEmailAddress());
		}
	}
	
	/**
	 * printPersonsOlderThan methods that search for members 
	 * that the age is equal or greater that incoming integer
	 * and send message to print match members out. 
	 * 
	 * @param personList ArrayList with Person elements 
	 * @param age integer represent age 
	 */
	public static void printPersonsOlderThan(List<Person> personList, int age) {
	    for (Person p : personList) {
	        if (p.getAge() >= age) {
	            p.printPerson();
	        }
	    }
	}
	/**
	 * printSeperator method prints a newline follow by 
	 * line of hyphens. The number of hyphens depends on 
	 * incoming integer. If income integer is 5 then methods 
	 * prints out five hyphens follow by newline. 
	 * 
	 * @param n integer represent number of hyphens that methods prints.
	 */
	public void printSeperator(int n){
		System.out.println();
		for(int i = 0; i < n; i++){
			System.out.print("-");
		}
		System.out.println("\n");
	}
	
}
