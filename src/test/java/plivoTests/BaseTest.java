package plivoTests;

import plivoAssignment.CommonActions;
import plivoAssignment.PlivoActions;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	String initialCashCredit;
	String senderPhoneNumber;
	String recipientPhoneNumber;
	float outbound_rate;
	float total_rate;
	
	public BaseTest() {
		
	}
	
	@BeforeClass
	void getTestData() {
		
//		  Get initial Cash Credit
		  initialCashCredit = PlivoActions.getCashCredit();
		  
//		  Get src and dst numbers
		  senderPhoneNumber = PlivoActions.getPhoneNumberByIndex(1).substring(1);
		  recipientPhoneNumber = PlivoActions.getPhoneNumberByIndex(2).substring(1);
		  
//		  Send Message
		  String uuid = PlivoActions.sendMessageAndGetMessageuuid(senderPhoneNumber, recipientPhoneNumber, "\"Hello, this is a sample text\"");
		  
//		  Get message outbound rate
		  outbound_rate = Float.parseFloat(PlivoActions.getOutboundRate());
				  
//		  Get sent message rate
		  total_rate = Float.parseFloat(PlivoActions.getTotalRateOfSentMessage(uuid));
	}
	
	@BeforeSuite
	static void getCommonTestData() {
		CommonActions.getAPITestData();
		PlivoActions plivoActions = new PlivoActions();
	}

}
