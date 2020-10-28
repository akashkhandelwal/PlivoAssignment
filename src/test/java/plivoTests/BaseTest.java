package plivoTests;

import plivoAssignment.CommonActions;
import plivoAssignment.PlivoActions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
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
		  logger.info("Initial Cash Credit: "+initialCashCredit);
		  
//		  Get src and dst numbers
		  senderPhoneNumber = PlivoActions.getPhoneNumberByIndex(1).substring(1);
		  recipientPhoneNumber = PlivoActions.getPhoneNumberByIndex(2).substring(1);
		  
//		  Send Message
		  String uuid = PlivoActions.sendMessageAndGetMessageuuid(senderPhoneNumber, recipientPhoneNumber, "\"Hello, this is a sample text\"");
		  logger.info("Message UUID: "+uuid);
		  
//		  Get message outbound rate
		  outbound_rate = Float.parseFloat(PlivoActions.getOutboundRate());
		  logger.info("Outbound rate: "+outbound_rate);
				  
//		  Get sent message rate
		  total_rate = Float.parseFloat(PlivoActions.getTotalRateOfSentMessage(uuid));
		  logger.info("Message Rate: "+total_rate);
	}
	
	@BeforeSuite
	static void getCommonTestData() {
		CommonActions.getAPITestData();
		PlivoActions plivoActions = new PlivoActions();
	}

}
