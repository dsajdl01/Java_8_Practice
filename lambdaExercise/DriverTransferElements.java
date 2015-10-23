package lambdaExercise;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * DriverTransferElements class enable to translate value form one collection
 * to another collection e.g. from list to set.
 * 
 *  The exercise Reference to a Constructor is follow from the following URL:
 *  https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 *  
 * @author David Sajdl
 * @version 23/10/2015
 *
 */
public class DriverTransferElements { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> lp = Person.createListOfPeople();
		/**
		 * print out all members from the list	 */
		for(Person p : lp){
			System.out.println(p.toString());
		}
		System.out.println("\nSetLambda: ");
		Set<Person> spSetLambda =
	            transferElements(lp, () -> { return new HashSet<>(); });
		spSetLambda.stream().forEach(p ->  p.printPerson());
		
		Set<Person> pSet = transferElements(
	            lp, HashSet::new);
	        System.out.println("\nPrinting MemberSet:");
	        pSet.stream().forEach(p -> p.printPerson());

	}
	/**
	 * transferElements method copies elements from one collection to another */
	/**
	 * 
	 * @param sourceCollection
	 * @param collectionFactory
	 * @return
	 */
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    	DEST transferElements( SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
	        DEST result = collectionFactory.get();
	        for (T t : sourceCollection) {
	            result.add(t);
	        }
        return result;
	}

}
