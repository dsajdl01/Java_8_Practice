package xmlExcercise;

import java.io.File;
import java.util.List;
/**
 * DriverXMLTester class sends message to getListOfStaff() method
 * to get list of stuff stored in XML file and print list out.
 * 
 * @author David Sajdl
 * @version 25/10/2015
 *
 */
public class DriverXMLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File directory = new File("/home/david/workspace");
		if(directory.exists()){
			ReadXMLData rxmld = new ReadXMLData();
			String fileName = directory.toString() + "/staff.xml";
			List<Staff> staffList = rxmld.getListOfStaff(fileName);
			staffList
					.stream()
					.forEach(s -> System.out.println(s));
		}

	}

}
