package plivoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import plivoAssignment.PlivoActions;

public class PlivoTest extends BaseTest {
	
  @Test
  public void validateMessageRateAndOutboundRateDifference() {
	  Assert.assertTrue(Math.abs(total_rate - outbound_rate) <= 0.0800, "Outbound rate("+outbound_rate+") differ by message rate("+total_rate+") by more than 0.0600");  
  }
  @Test
  public void validateUpdatedCashCreditValue() {
	  Assert.assertTrue(PlivoActions.calculateCashCreditUsageOnSendMessage(initialCashCredit).equals(String.format("%.4g", total_rate)), "Cash Credit is not updated by correct value");
  }
  
}
