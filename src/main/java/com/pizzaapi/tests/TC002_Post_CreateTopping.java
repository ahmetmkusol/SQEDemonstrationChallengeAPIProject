package com.pizzaapi.tests;

import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.http.Method;
import junit.framework.Assert;


public class TC002_Post_CreateTopping extends TestBase {

	@BeforeClass
	public void createTopping() throws InterruptedException {

		logger.info("** TC002_Post_CreateTopping started **");
		
		baseURI = URI;
		httpRequest = given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "bacon");
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toString());

		response = httpRequest.request(Method.POST, "toppings");

	}
	// Expected Status Code is 204 Actual Status Code is 201
	@Test
	public void checkStatusCode() {
		HelperMethods.checkStatusIs204(response);

	}

	@Test
	public void checkContentType() {
		HelperMethods.checkContentType(response);

	}
	// Request should not return response body. 
	@Test
	public void checkNoResponseBody() {
		logger.info("** Checking Response Body **");
		String responseBody = response.getBody().asString();
		logger.info("Response body = " + responseBody);
		Assert.assertFalse("Returns response body" + responseBody, true);
		
	}

	@Test
	public void checkResponseBody() {

		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("bacon"), true);
		Assert.assertEquals(responseBody.contains("12"), true);

	}

	@Test
	public void checkResponseTime() {

		HelperMethods.checkResponseTime(response);
	}

	@AfterClass
	void tearDown() {
		logger.info("** TC002_Post_CreateTopping completed **");
	}

}
