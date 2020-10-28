package plivoAssignment;

import java.util.HashMap;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICallUtil extends CommonActions{
	public static Response getCall(String endPoint) {
		return createRequest().request(Method.GET, endPoint);
	}
	
	public static Response postCallWithFormData(String endPoint, HashMap<String, String> formData) {
		return createRequest().formParams(formData).post(endPoint);
	}
	
	public static RequestSpecification createRequest() {
		RestAssured.baseURI = testInputData.get("host");
		RequestSpecification request = RestAssured.given().auth().basic(testInputData.get("auth_id"), testInputData.get("auth_token"));
		return request;
	}
	
	public static JSONObject getResponseBody(Response response) {
		String responseBody = response.getBody().asString();
		return new JSONObject(responseBody);
	}

}
