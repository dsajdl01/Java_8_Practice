package lambdaExercise;

import static java.lang.System.out;
/**
 * DriverCalculator class performs a mathematical operation on two doubles operands. 
 * The operation itself is specified by an instance of IntegerMath interface. 
 * The example defines four operations with lambda expressions are perform:
 * addition and subtraction multiplication and divide.
 * 
 * The exercise Reference to a Constructor is follow from the following URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 * @author David Sajdl
 * @version 23/10/2015
 *
 */
public class DriverCalculator {
	
	interface IntegerMath{
		double operator(double a, double b);
	}
	/**
	 * operateBinary method performs a mathematical operation on two doubles operands. 
	 * The operation itself is specified by an instance of IntegerMath. 
	 * 
	 * The this example defines for operations with lambda expressions, 
	 * addition, subtraction multiplication and divide.
	 * 
	 * 
	 * @param a double first number
	 * @param b double second number
	 * @param im IntegerMath mathematical performance
	 * @return  double total of parameter a and b 
	 */
	public double operateBinary(double a, double b, IntegerMath im){
		return im.operator(a, b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverCalculator myCal = new DriverCalculator();
		IntegerMath add = (a,b) -> a+b;
		IntegerMath minus = (a,b) -> a-b;
		IntegerMath multiple = (a,b) -> a*b;
		IntegerMath div = (a,b) -> a/b;
		double[][] nums = {{12, 2},
						 {13, 3},
						 {25,78, 5,93},
						 {7, 13}, 
						 {63, 0}, // does not throws zero exception print Infinity such as: 63.0 / 0.0 = Infinity  
						 {0.625, 0.8725}};
		double f, s;
		for(int i = 0; i < nums.length; i++){
			f = nums[i][0]; s = nums[i][1];
			out.println(f +" + " + s +" = " + String.format( "%.2f", myCal.operateBinary(f, s, add)));
			out.println(f +" - " + s +" = " + String.format( "%.2f", myCal.operateBinary(f, s, minus)));
			out.println(f +" * " + s +" = " + String.format( "%.2f", myCal.operateBinary(f, s, multiple)));
			out.println(f +" / " + s +" = " + String.format( "%.2f", myCal.operateBinary(f, s, div)));
			out.println();
		}
	}
	

}
