package lambdaExercise;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import lambdaExercise.DriverPrintList.CheckPerson;

/**
 * DriverPrintListByUseLambda class provides different search approach by 
 * using lambda expression to find specific value from the list of object Person.
 *  
 * The class and following methods are practice on lambda Expression 
 * from the following URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 * @author David Sajdl
 * @version 21/10/2015
 *
 */
public class DriverPrintListByUseLambda {
	/**
	 * Predicate<T> is a generic interface.
	 * Generic types specify one or more type parameters within angle brackets (<>). 
	 * This interface contains only one type parameter.
	 * 
	 * @param <T> Generic types 
	 */
	interface Predicate<T> {
	    boolean test(T t);
	}

	public static void main(String[] args) {
		// load list of peoples
		List<Person> lp = Person.createListOfPeople();
		DriverPrintList dpl = new DriverPrintList();
		/**
		 * print all female who is older than 25 and younger than 35 inclusive
		 * by using Search Criteria Code with a Lambda Expression */ 
		printPersons(lp, (Person p) -> p.getGenda() == Person.Sex.FEMALE && p.getAge() >= 25
				&& p.getAge() <= 35);
		dpl.printSeperator(40);
		
		/**
		 * print all male from the list
		 * by using Search Criteria Code with a Lambda Expression 
		 * via interface Predicate*/ 
		printPersonsWithPredicate(lp, (Person p) -> p.getGenda() == Person.Sex.MALE);
		dpl.printSeperator(40);
		
		
		processPersons( lp,
				p -> p.getGenda() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, 
				p -> p.printPerson());
		dpl.printSeperator(40);
		
		 /** The method retrieves name and the email address from each member contained in list 
		 * who is eligible for selective service and then prints it:
		 * Selected members is those whom are male and older than 15 and younger than 35. */
		processPersonsWithFunction(lp,
			    p -> p.getGenda() == Person.Sex.MALE && p.getAge() >= 15 && p.getAge() <= 35,
			    p -> p.getName()+":\te-mail: "+ p.getEmailAddress(), 
			    email -> System.out.println(email));

	}
	/**
	 * processPersonsWithFunction method checks each Person instance contained 
	 * in the List parameter list whether it satisfies the criteria specified 
	 * in the Predicate parameter tester same as method printPersonsWithPredicate
	 * If person satisfied criteria string by passing via Function is perform
	 * an action on it and accept into block.  
	 * 
	 * functional interface that contains an abstract method that returns a value. 
	 * The Function<T,R> interface contains the method R apply(T t).
	 * Method retrieves the data specified by the parameter mapper, 
	 * and then performs an action on it specified by the parameter block
	 * 
	 * @param ls ArrayList Person values 
	 * @param tst Predicate result of the lambda expressions
	 * @param mapper Function message that would be applied to block (would be print) 
	 * @param block Consumer message to be printed 
	 */
	public static void processPersonsWithFunction(List<Person> ls,Predicate<Person> tst,
		    Function<Person, String> mapper,Consumer<String> block) {
		    for (Person p : ls) {
		        if (tst.test(p)) {
		            String data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}
	
	/**
	 * 	processPersons checks each Person instance contained 
	 * in the List parameter list whether it satisfies the criteria specified 
	 * in the Predicate parameter tester same as method printPersonsWithPredicate.
	 * 
	 * But method does not invoke printPerson. It is  specify a different action to perform on 
	 * those Person instances that satisfy the criteria specified by tester. The method replaces 
	 * the invocation p.printPerson() with an instance of Consumer<Person> that invokes the method accept
	 * 
	 * @param list ArrayList Person values 
	 * @param tester Predicate result of the lambda expressions
	 * @param block Consumer represent method printPerson of Person class.
	 */
	public static void processPersons(List<Person> list,Predicate<Person> tester,Consumer<Person> block){
		        for (Person p : list) {
		            if (tester.test(p)) {
		                block.accept(p);
		            }
		        }
		}
	/**
	 * printPersonsWithPredicate method checks each Person instance contained 
	 * in the List parameter list whether it satisfies the criteria specified 
	 * in the Predicate parameter tester. If the Person instance does satisfy 
	 * the criteria specified by tester, the method printPersron is invoked on 
	 * the Person instance.
	 * 
	 * 
	 * @param list ArrayList Person values 
	 * @param t Predicate result of the lambda expressions
	 */
	public static void printPersonsWithPredicate(
		    List<Person> list, Predicate<Person> t) {
		    for (Person p : list) {
		        if (t.test(p)) {
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
	 * @param list list ArrayList Person values
	 * @param cp ChechPerson interface 
	 */
	public static void printPersons(List<Person> list, CheckPerson cp) {
	    for (Person p : list) {
	        if (cp.test(p)) {
	            System.out.println(p.getName()+"\t| "+ p.getAge() +"\t| "+ p.getEmailAddress());
	        }
	    }
	}

}
