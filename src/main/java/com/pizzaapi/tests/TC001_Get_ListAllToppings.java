package com.pizzaapi.tests;

import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.http.Method;

public class TC001_Get_ListAllToppings extends TestBase {

	@BeforeClass
	public void listAllToppings() throws InterruptedException {

		logger.info("** TC001_Get_ListAllToppings started **");

		baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.GET, "toppings");

	}

	@Test
	public void checkResponseBody() {
		logger.info("** Checking Response Body **");

		String responseBody = response.getBody().asString();
		logger.info("Response body = " + responseBody);
		Assert.assertTrue(responseBody != null);
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

	@AfterClass
	public void tearDown() {
		logger.info("** TC001_Get_ListAllToppings completed **");
	}
}
