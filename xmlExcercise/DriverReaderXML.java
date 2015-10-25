package xmlExcercise;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 * DriverReaderXML class enable read XML file and print data out
 * 
 * @author David Sajdl
 * @version 
 *
 */
public class DriverReaderXML {
	
	public static void main(String argv[]) {

	 try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {
				boolean fname = false;
				boolean lname = false;
				boolean sex = false;
				boolean salary = false;
				boolean dob = false;
				boolean mail = false;

				public void startElement(String uri, String localName,String qName, 
											Attributes attributes) throws SAXException {
					if(qName.equalsIgnoreCase("STAFF")){
						System.out.println("________________________");
					}
					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						fname = true;
					}
					if (qName.equalsIgnoreCase("LASTNAME")) {
						lname = true;
					}
					if (qName.equalsIgnoreCase("SEX")) {
						sex = true;
					}
					if (qName.equalsIgnoreCase("SALARY")) {
						salary = true;
					}
					if (qName.equalsIgnoreCase("EMAIL")) {
						mail = true;
					}
					if (qName.equalsIgnoreCase("DOB")) {
						dob = true;
					}
			  }

			   public void endElement(String uri, String localName,
					String qName) throws SAXException {
					if(qName.equalsIgnoreCase("STAFF")){
						System.out.println();
						
					}
			   }

				public void characters(char ch[], int start, int length) throws SAXException {
					if (fname) {
						System.out.println("First Name:\t" + new String(ch, start, length));
						fname = false;
					}
					if (lname) {
						System.out.println("Last Name:\t" + new String(ch, start, length));
						lname = false;
					}
					if (sex) {
						System.out.println("SEX:    \t" + new String(ch, start, length));
						sex = false;
					}
					if (salary) {
						System.out.println("Salary: \t" + new String(ch, start, length));
						salary = false;
					}
					if (mail) {
						System.out.println("MAIL:   \t" + new String(ch, start, length));
						mail = false;
					}
					if (dob) {
						System.out.println("DOB :    \t" + new String(ch, start, length));
						dob = false;
					}
				}
		  };
		     
		saxParser.parse("/home/david/workspace/staff.xml", handler);
       
	     } catch (Exception e) {
		       System.out.println("Exception: "+e.getMessage());
	     }
   }

}