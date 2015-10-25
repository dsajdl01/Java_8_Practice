package xmlExcercise;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * ReadXMLData class enable to read XML staff file and
 * store data into list.  
 * 
 * @author David Sajdl
 * @version 25/10/2015
 *
 */
public class ReadXMLData {
	
	public List<Staff> getListOfStaff(String fileName){
		 List<Staff> staff = new ArrayList<Staff>();
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {
				boolean fname = false;
				String FNAME = "";
				boolean lname = false;
				String LNAME = "";
				boolean sex = false;
				String SEX = "";
				boolean salary = false;
				double SALERY = 0.0;
				boolean dob = false;
				LocalDate DOB = null;
				boolean mail = false;
				String MAIL = "";

				public void startElement(String uri, String localName,String qName, 
											Attributes attributes) throws SAXException {
					if(qName.equalsIgnoreCase("STAFF")){
						FNAME = "";
						LNAME = "";
						SEX = "";
						SALERY = 0.0;
						DOB = null;
						MAIL = "";
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
						Sex s =  Sex.NOTSPECIFIED;
						System.out.println();
						if(SEX.length() != 0){
							if(SEX.equalsIgnoreCase("MALE")){
								s = Sex.MALE;
							} else if(SEX.equalsIgnoreCase("FEMALE")){
								s = Sex.FEMALE;
							}
						}
						if(LNAME.length() == 0 && SEX.length() == 0){							
							Staff stf = new Staff(FNAME, SALERY, MAIL, DOB);
							staff.add(stf);
						} else if(LNAME.length() == 0){
							Staff stf = new Staff(FNAME, s , SALERY, MAIL, DOB);
							staff.add(stf);
						} else {
							Staff stf = new Staff(FNAME, LNAME, s , SALERY, MAIL, DOB);
							staff.add(stf);
						}
					}
			   }

				public void characters(char ch[], int start, int length) throws SAXException {
					if (fname) {
//						System.out.println("First Name:\t" + new String(ch, start, length));
						fname = false;
						FNAME = new String(ch, start, length);
					}
					if (lname) {
					//	System.out.println("Last Name:\t" + new String(ch, start, length));
						lname = false;
						LNAME = new String(ch, start, length);
					}
					if (sex) {
						//System.out.println("SEX:    \t" + new String(ch, start, length));
						sex = false;
						SEX = new String(ch, start, length);
					}
					if (salary) {
						//System.out.println("Salary: \t" + new String(ch, start, length));
						salary = false;
						String sal = new String(ch, start, length);
						SALERY = Double.parseDouble(sal);
					}
					if (mail) {
						//System.out.println("MAIL:   \t" + new String(ch, start, length));
						mail = false;
						MAIL = new String(ch, start, length);
					}
					if (dob) {
						//System.out.println("DOB :    \t" + new String(ch, start, length));
						dob = false;
						String db = new String(ch, start, length);
						DOB = getInstanceOfDate(db);
					}
				}
		  };
		  
		
         saxParser.parse("/home/david/workspace/staff.xml", handler);
         return staff;
	     } catch (Exception e) {
		       System.out.println("Exception: "+e.getMessage());
	     }
		return null;
	}
	
	private LocalDate getInstanceOfDate(String date){
		String[] data = date.split(",");
		return IsoChronology.INSTANCE.date(getInt(data[0]), getInt(data[1]), getInt(data[2]));
	}
	
	private int getInt(String n){
		return Integer.parseInt(n);
	}
}
