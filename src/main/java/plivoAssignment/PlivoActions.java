package plivoAssignment;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PlivoActions extends CommonActions{
	
	public static String END_POINT_PREFIX = "/v1/Account/"+testInputData.get("auth_id")+"/";
	public static String GET_ALL_NUMBERS_ENDPOINT = END_POINT_PREFIX+"PhoneNumber/?country_iso=US";
	public static String SEND_MESSAGE_ENDPOINT = END_POINT_PREFIX+"Message/";
	public static String GET_PRICING_ENDPOINT = END_POINT_PREFIX+"Pricing/?country_iso=US";
	
	public static String getCashCredit() {
		Response response = APICallUtil.getCall(END_POINT_PREFIX);
		return APICallUtil.getResponseBody(response).getString("cash_credits");
	}
	
	public static String getPhoneNumberByIndex(int index) {
		Response response = APICallUtil.getCall(GET_ALL_NUMBERS_ENDPOINT);
		return APICallUtil.getResponseBody(response).getJSONArray("objects").getJSONObject(index).getString("number");
	}
	
	public static int sendMessage(String senderNumber, String recipientNumber, String messageText) {
		return callSendMessageAPI(senderNumber, recipientNumber, messageText).getStatusCode();
	}
	
	public static Response callSendMessageAPI(String senderNumber, String recipientNumber, String messageText) {
		HashMap<String, String> formData = new HashMap<String, String>();
		formData.put("dst", recipientNumber);
		formData.put("text", messageText);
		formData.put("src", senderNumber);
		
		return APICallUtil.postCallWithFormData(SEND_MESSAGE_ENDPOINT, formData);
	}
	
	public static String sendMessageAndGetMessageuuid(String senderNumber, String recipientNumber, String messageText) {
		Response response = callSendMessageAPI(senderNumber, recipientNumber, messageText);
		return APICallUtil.getResponseBody(response).getJSONArray("message_uuid").get(0).toString();
		
	}
	
	public static String getTotalRateOfSentMessage(String uuid) {
		Response response = APICallUtil.getCall(SEND_MESSAGE_ENDPOINT+uuid+"/");
		return APICallUtil.getResponseBody(response).getString("total_rate");
		
	}
	
	public static String getOutboundRate() {
		Response response = APICallUtil.getCall(GET_PRICING_ENDPOINT);
		return APICallUtil.getResponseBody(response).getJSONObject("message").getJSONObject("outbound").getString("rate").toString();
	}
	
	public static String calculateCashCreditUsageOnSendMessage(String initialCashCredit) {
		return String.format("%.4g", Float.parseFloat(initialCashCredit) - Float.parseFloat(PlivoActions.getCashCredit()));
	}
}
