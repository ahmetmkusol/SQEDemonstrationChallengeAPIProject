package com.pizzaapi.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.http.Method;
import static io.restassured.RestAssured.*;
import static com.pizzaapi.utils.Constants.*;

public class TC014_Post_CreateOrderPizzaNotSpecified extends HelperMethods {

	@BeforeClass
	public void createOrderPizzaNotSpecified() throws InterruptedException {
		logger.info("** TC014_Post_CreateOrderPizzaNotSpecified started **");

		baseURI = POST_URI;
		httpRequest = given().header("Content-Type", "application/json");
		httpRequest.body(readJson(CREATE_ORDER_PIZZA_NOT_SPECIFIED));
		response = httpRequest.request(Method.POST);

	}
	// Expected Status Code is 408 Actual Status Code is 201
	@Test
	public void checkStatusCode408() {
		HelperMethods.checkStatusIs408(response);

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
		logger.info("** TC014_Post_CreateOrderPizzaNotSpecified completed **");
	}
}
