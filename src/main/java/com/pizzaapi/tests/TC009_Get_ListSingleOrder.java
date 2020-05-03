package com.pizzaapi.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;
import static io.restassured.RestAssured.given;
import static com.pizzaapi.utils.Constants.*;

public class TC009_Get_ListSingleOrder extends TestBase {

	@BeforeClass
	public void listPizzas() throws InterruptedException {

		logger.info("** TC009_Get_ListSingleOrder started **");
		RestAssured.baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.GET, "orders/1");

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
	public void checkResponseBody() {
		logger.info("** Checking Response Body **");

		String responseBody = response.getBody().asString();
		logger.info("Response body = " + responseBody);
		Assert.assertTrue(responseBody != null);

	}

	@Test
	public void checkResponseTime() {
		HelperMethods.checkResponseTime(response);

	}

	@AfterClass
	public void tearDown() {
		logger.info("** TC009_Get_ListSingleOrder completed **");
	}
}
