package com.pizzaapi.tests;

import static io.restassured.RestAssured.*;
import static com.pizzaapi.utils.Constants.*;
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pizzaapi.utils.HelperMethods;
import com.sample.test.demo.utils.Order;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC011_Post_CreateOrder extends HelperMethods {

	@BeforeClass
	public void createOrder() throws InterruptedException {
		logger.info("** TC011_Post_CreateOrder started **");
		
		baseURI = POST_URI;
		httpRequest = given().header("Content-Type", "application/json");
		httpRequest.body(readJson(CREATE_ORDER));
		response = httpRequest.request(Method.POST);

	}

	@Test
	public void checkResponseBody() throws IOException {
		logger.info("** Checking Response Body **");

		ObjectMapper mapper = new ObjectMapper();

		Order orders = mapper.readValue(new File(CREATE_ORDER), Order.class);

		response = given().when().header("Content-Type", "application/json").body(orders).post(POST_URI);
		String responseBody = response.body().asString();
		logger.info("** Response Body is = " + responseBody);

		Assert.assertTrue(responseBody.contains("id"), "Response body returns 'id' as expected");
		JsonPath jsonPath = response.jsonPath();
		String id = jsonPath.getString("id");

		response.then().body("id", Matchers.equalTo(id));

	}

	@Test
	public void checkStatusCode201() {
		HelperMethods.checkStatusIs201(response);

	}

	@Test
	public void checkContentType() {
		HelperMethods.checkContentType(response);

	}

	@AfterClass
	public void tearDown() {
		logger.info("** TC011_Post_CreateOrder completed **");
	}

}
