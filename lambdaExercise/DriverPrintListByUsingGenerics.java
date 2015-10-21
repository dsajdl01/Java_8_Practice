package lambdaExercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * DriverPrintListByUsingGenerics class provides different search approach by 
 * using lambda expression to find specific value from the list of object Person
 * by using Generic, aggregation.
 * 
 * The class and following methods are practice on lambda Expression 
 * from the following URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 * 
 * @author David Sajdl
 * @version 21/10/2015
 */
public class DriverPrintListByUsingGenerics {  
 
	
	public static void main(String[] args) {
		
		class PersonAgeComparator implements Comparator<Person> {
	        public int compare(Person a, Person b) {
	            return Integer.compare(a.getAge(),b.getAge());
	        }
	    }
		
		List<Person> lp = Person.createListOfPeople();
		DriverPrintList dpl = new DriverPrintList();
		
		// to print all people from list using aggregation
		lp.stream()
		  .forEach(e -> System.out.println(e.getName() +",\t" + e.getAge() +", "+ e.getEmailAddress()));
		dpl.printSeperator(50);
		
		/**
		 * print out all members who is older then 18 and younger than 35
		 * by using Function predicete and consumer interface via processElements method */
		processElements(
			    lp,
			    p -> p.getAge() >= 18 && p.getAge() <= 35,
			    p -> p.getName()+"\t" + p.getAge()+"\t" + p.getEmailAddress(),
			    message -> System.out.println(message));
		dpl.printSeperator(40);
		
		/**
		 * print out all male members who is older then 18 and younger than 35
		 * by using aggregation stream */
 		lp
		    .stream()
		    .filter(p -> p.getGenda() == Person.Sex.MALE
		            && p.getAge() >= 18&& p.getAge() <= 35)
		    .map(p -> p.getName()+"\t" + p.getAge()+"\t" + p.getEmailAddress())
		    .forEach(email -> System.out.println(email));
 		dpl.printSeperator(40);
 		
 		/**
 		 * getting average age of all people in the list than average of all 
 		 * male and finally average age of all female and print them out.*/ 
 		double average = lp.stream()
 						   .mapToInt(Person::getAge)
 						   .average()
 						   .getAsDouble();
 		System.out.println("The average age of all members in the list: " + String.format( "%.2f", average));
 		average = lp.stream()
				   .filter(p -> p.getGenda() == Person.Sex.MALE)
				   .mapToInt(Person::getAge)
				   .average()
				   .getAsDouble();
 		System.out.println("The average age of all male members in the list: " + String.format( "%.2f", average));
 		average = lp.stream()
				   .filter(p -> p.getGenda() == Person.Sex.FEMALE)
				   .mapToInt(Person::getAge)
				   .average()
				   .getAsDouble();
		System.out.println("The average age of all female members in the list: " + String.format( "%.2f", average));
		dpl.printSeperator(40);
		
		/**
		 * sorting list of peoples by their age.*/
		lp.stream()
		  .forEach(e -> System.out.print(e.getName()+" "+e.getAge() +", "));
		System.out.println();
		Collections.sort(lp, new PersonAgeComparator());
		System.out.println("sorted:");
		lp.stream()
		  .forEach(e -> System.out.print(e.getName()+" "+e.getAge() +", "));

	}
	
	/**
	 * processElements method invocation performs the following actions:
	 * 
	 * @param source Obtains a source of objects from the collection ls. It obtains a source of Person 
	 * 		  objects from the collection ls. Notice that the collection ls, which is a collection of type List, 
	 * 		  is also an object of type Iterable.
	 * @param tester  Filters objects that match the Predicate object tester. The Predicate object 
	 * 		  is a lambda expression that specifies which members would be eligible for Selective Service.
	 * @param mapper Maps each filtered object to a value as specified by the Function object mapper. 
	 * 		  The Function object is a lambda expression that returns name, age and the e-mail address of a member.
	 * @param block Performs an action on each mapped object as specified by the Consumer object block. 
	 * 		  The Consumer object is a lambda expression that prints a string, 
	 * 		  which is name, age and the e-mail address returned by the Function object.
	 */
	public static <X, Y> void processElements(
		    Iterable<X> source,
		    Predicate<X> tester,
		    Function <X, Y> mapper,
		    Consumer<Y> block) {
		    for (X p : source) {
		        if (tester.test(p)) {
		            Y data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}

}
