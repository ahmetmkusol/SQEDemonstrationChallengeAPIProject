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


public class TC003_Post_CreateToppingDuplicate extends TestBase {

	@BeforeClass
	public void createTopping() throws InterruptedException {

		logger.info("** TC003_Post_CreateToppingDuplicate started **");
		
		baseURI = URI;
		httpRequest = given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "bacon");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		response = httpRequest.request(Method.POST, "toppings");

	}
	//No duplicate topping message
	@Test
	public void checkDuplicateTopping() {
		baseURI = URI;
		httpRequest = given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "bacon");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		response = httpRequest.request(Method.POST, "toppings");
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.equalsIgnoreCase("duplicate topping"), true);
		HelperMethods.checkStatusIs405(response);
		

	}

	@Test
	public void checkContentType() {
		HelperMethods.checkContentType(response);

	}
	


	@Test
	public void checkResponseTime() {

		HelperMethods.checkResponseTime(response);
	}

	@AfterClass
	void tearDown() {
		logger.info("** TC003_Post_CreateToppingDuplicate completed **");
	}

}
