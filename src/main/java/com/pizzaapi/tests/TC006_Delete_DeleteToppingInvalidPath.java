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

public class TC006_Delete_DeleteToppingInvalidPath extends TestBase {

	@BeforeClass
	public void deleteToppingInvalidPath() throws InterruptedException {
		logger.info("** TC006_Delete_DeleteToppingInvalidPath started **");
		baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.DELETE, "toppings/22");

	}

	@Test
	public void checkStatusCode() {
		HelperMethods.checkStatusIs404(response);
	}

	@Test
	public void checkResponseBody() {
		logger.info("** Checking Response Body **");
		String responseBody = response.getBody().asString();
		logger.info("Response body = " + responseBody);
		Assert.assertTrue(responseBody != null);
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
		logger.info("** TC006_Delete_DeleteToppingInvalidPath completed **");
	}
}
