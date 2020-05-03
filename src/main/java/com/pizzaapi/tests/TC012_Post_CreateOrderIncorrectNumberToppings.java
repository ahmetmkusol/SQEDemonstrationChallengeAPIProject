package com.pizzaapi.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.utils.HelperMethods;
import com.sample.test.demo.utils.Order;
import static com.pizzaapi.utils.Constants.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;

public class TC012_Post_CreateOrderIncorrectNumberToppings extends HelperMethods {



	@BeforeClass
	public void createOrderIncorrectNumberToppings() throws InterruptedException {

		logger.info("** TC012_Post_CreateOrderIncorrectNumberToppings started **");

		baseURI = POST_URI;
		httpRequest = given().header("Content-Type", "application/json");
		httpRequest.body(readJson(CREATE_ORDER_INCORRECT_NUM_TOPPINGS));
		response = httpRequest.request(Method.POST);

	}


	//Response body contains incorrect number of toppings
	@Test
	public void checkResponseBody() throws JsonParseException, JsonMappingException, IOException {
		logger.info("** Checking Response Body **");

		ObjectMapper mapper = new ObjectMapper();

		Order orders = mapper.readValue(new File(CREATE_ORDER_INCORRECT_NUM_TOPPINGS), Order.class);

		response = given().when().header("Content-Type", "application/json").body(orders).post(POST_URI);
		String responseBody = response.body().asString();
		logger.info("** Response Body is = " + responseBody);
		Assert.assertFalse(responseBody.contains("Bacon"), "Response Body Contains Incorrect Number of Toppings");

	}
	// Expected Status Code is 406 Actual Status Code is 201
	@Test
	public void checkStatusCode406() {
		HelperMethods.checkStatusIs406(response);

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
		logger.info("** TC012_Post_CreateOrderIncorrectNumberToppings completed **");
	}
}
