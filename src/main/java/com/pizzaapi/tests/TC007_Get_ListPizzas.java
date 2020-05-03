package com.pizzaapi.tests;

import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC007_Get_ListPizzas extends TestBase {

	@BeforeClass
	public void listPizzas() throws InterruptedException {
		logger.info("** TC007_Get_ListPizzas started **");

		baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.GET, "pizzas");

	}

	@Test
	public void checkStatusCode() {
		HelperMethods.checkStatusIs200(response);

	}

	@Test
	public void checkResponseTime() {
		HelperMethods.checkResponseTime(response);

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
		Assert.assertEquals(responseBody.contains("id"), true);
		Assert.assertEquals(responseBody.contains("1"), true);
		Assert.assertEquals(responseBody.contains("pizza"), true);
	}

	@AfterClass
	public void tearDown() {
		logger.info("** TC007_Get_ListPizzas completed **");
	}
}
