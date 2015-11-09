package testingJavaEight;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
/**
* @author David Sajdl
*/
public class ListTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>();
		l.add("id:0943");
		l.add("id:0255");
		l.add("id:0987");
		System.out.println(l);
		
		l = Lists.transform(l, new Function<String, String>(){
			@Override
			public String apply(String addString){
				return addString +"/" + addString.substring(3); 
			}
		});
		
		System.out.println(l);

	}

}
