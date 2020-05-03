package com.pizzaapi.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.utils.HelperMethods;
import io.restassured.http.Method;
import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;

public class TC013_Post_CreateOrderInvalidPizza extends HelperMethods {

	@BeforeClass
	public void createOrderInvalidPizza() throws InterruptedException {
		logger.info("** TC013_Post_CreateOrderInvalidPizza started **");

		baseURI = POST_URI;
		httpRequest = given().header("Content-Type", "application/json");
		httpRequest.body(readJson(CREATE_ORDER_INVALID_PIZZA));
		response = httpRequest.request(Method.POST);
	}
	// Expected Status Code is 407, Actual Status Code is 201
	@Test
	public void checkStatusCode407() {
		HelperMethods.checkStatusIs407(response);

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
		logger.info("** TC013_Post_CreateOrderInvalidPizza completed **");
	}
}
