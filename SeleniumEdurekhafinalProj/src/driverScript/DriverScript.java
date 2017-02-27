package driverScript;
import org.apache.log4j.xml.DOMConfigurator;

import testcases.testcase01;

public class DriverScript {
	
	public static void main(String args[]){
		DOMConfigurator.configure("log4j.xml");
		try {

		 testcase01.TC001();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Test Failed"+ e.getMessage());
		}
	
		
	}

}
