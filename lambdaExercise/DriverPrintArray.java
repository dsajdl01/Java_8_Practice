package lambdaExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * DriverPrintArray class enable sort Person array
 * by age, name and email by using different style such as
 * interface Comparator, reference and by using lambda expression
 * 
 * The exercise is follow from the following URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 * 
 * @author David Sajdl
 * @version 23/10/2015
 *
 */
public class DriverPrintArray {

	public static void main(String[] args) {
		
		/**
		 * ComparisonProvider class has two method that inable to 
		 * sort mail and age by reference to an instance method of a particular object */
		class ComparisonProvider{
			/** compareByMail enable to sort array by person mail */
			public int compareByMail(Person a, Person b){
				return a.getEmailAddress().compareTo(b.getEmailAddress());
			}
			/** compareByMail enable to sort array by person age */
			public int compareByPersonAge(Person a, Person b){
				return Integer.compare(b.getAge(), a.getAge());
			}
		}
	
		/**
		 * personCompareByName class enable sort and Person name in that array
		 * by alphabetical order */
		class personCompareByName implements Comparator<Person>{
			public int compare(Person a, Person b){
				return a.getName().compareTo(b.getName());
			}
			
		}
		
		List<Person> lp = Person.createListOfPeople();
		/**
		 * print out all members from the Array	 */
		Person[] arrayPersons = lp.toArray(new Person[lp.size()]);
		for(Person p : arrayPersons){
			System.out.println(p.toString());
		}
		/**
		 * sorting array by person's age in ascending order
		 * by using method reference from compareByAge() method in Person class */
		System.out.println("\nSorted by age:");
		Arrays.sort(arrayPersons, Person::compareByAge);
		for(Person p : arrayPersons){
			p.printPerson();
		}
		/**
		 * sorting array by person's age in descending order
		 * by using lambda expression */
		System.out.println("\nRe-order by age:");
		Arrays.sort(arrayPersons, (Person a, Person b) -> { return Integer.compare(a.getAge(),b.getAge());});
		for(Person p : arrayPersons){
			p.printPerson();
		}
		/**
		 * sorting array by person's name in ascending order
		 * by using personCompareByName class */
		System.out.println("\nSort by name:");
		Arrays.sort(arrayPersons, new personCompareByName());
		for(Person p : arrayPersons){
			p.printPerson();
		}
		/**creating instance of the class ComparisonProvider*/
		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		
		/** sorting array by e-mail using object of the class ComparisonProvider
		 *  and using reference to instance method compareByMail */
		Arrays.sort(arrayPersons, myComparisonProvider::compareByMail);
		System.out.println("\nSort by e-mail:");
		Arrays.sort(arrayPersons, new personCompareByName());
		for(Person p : arrayPersons){
			System.out.print(p.getEmailAddress() + "\t| "); p.printPerson();
		}
		/** sorting array by age using object of the class ComparisonProvider
		 *  and using reference to instance method compareByPersonAge */
		Arrays.sort(arrayPersons, myComparisonProvider::compareByPersonAge);
		System.out.println("\nSort by age:");
		for(Person p : arrayPersons){
			System.out.print(p.getEmailAddress() + "\t| "); p.printPerson();
		}
		/** creating new string array  and print values out */
		String[] strMyArray = { "Barbara", "James", "Mary", "Andrei" ,"John",
	            "Patricia", "Robert", "Michael", "Linda", "Andrea" };
		System.out.println("\nunsorted:");
		for(String s : strMyArray){
			System.out.print(s+", ");
		}
		/**
		 * sorting array by using reference to an instance method
         * of an arbitrary object of a particular type */
		Arrays.sort(strMyArray, String::compareToIgnoreCase);
		System.out.println("\nsorted:");
		for(String s : strMyArray){
			System.out.print(s+", ");
		}
	}
}
