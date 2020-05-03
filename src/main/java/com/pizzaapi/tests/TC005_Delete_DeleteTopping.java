package com.pizzaapi.tests;

import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pizzaapi.base.TestBase;
import com.pizzaapi.utils.HelperMethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC005_Delete_DeleteTopping extends TestBase {

	@BeforeClass
	public void deleteTopping() throws InterruptedException {
		logger.info("** TC005_Delete_DeleteTopping started **");

		RestAssured.baseURI = URI;
		httpRequest = given();
		response = httpRequest.request(Method.DELETE, "toppings/1");

	}
	// Expected Status Code is 204 Actual Status Code is 200
	@Test
	public void checkStatusCode() {
		HelperMethods.checkStatusIs204(response);
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

	@Test
	public void deleteToppingInvalidPath() throws InterruptedException {

		RestAssured.baseURI = "https://my-json-server.typicode.com/sa2225/demo/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.DELETE, "toppings/22");
		HelperMethods.checkStatusIs404(response);
	}

	@AfterClass
	public void tearDown() {
		logger.info("** TC005_Delete_DeleteTopping completed **");
	}
}
