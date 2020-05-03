package com.pizzaapi.tests;

import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC008_Get_ListOrders extends TestBase {

	@BeforeClass
	public void listPizzas() throws InterruptedException {
		logger.info("** TC008_Get_ListOrders started **");
		
		RestAssured.baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.GET, "orders");

	}

	@Test
	public void checkResponseBody() {
		logger.info("** Checking Response Body **");

		String responseBody = response.getBody().asString();
		logger.info("Response body = " + responseBody);
		Assert.assertTrue(responseBody != null);
		Assert.assertEquals(responseBody.contains("id"), true);
	}
	@Test
	public void checkStatusCode() {
		HelperMethods.checkStatusIs200(response);

	}

	@Test
	public void checkContentType() {
		HelperMethods.checkContentType(response);

	}

	@Test
	public void checkResponseTime() {
		HelperMethods.checkResponseTime(response);


	}

	@BeforeClass
	public void tearDown() {
		logger.info("** TC008_Get_ListOrders completed **");
	}
}
