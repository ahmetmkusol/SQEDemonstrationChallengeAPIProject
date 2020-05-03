package com.pizzaapi.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import com.pizzaapi.base.TestBase;

import io.restassured.response.Response;

public class HelperMethods extends TestBase {

	public static void checkStatusIs200(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

	public static void checkStatusIs201(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 201);

	}

	public static void checkStatusIs204(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 204);

	}
	public static void checkStatusIs404(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 404);

	}

	public static void checkStatusIs405(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 405);

	}

	public static void checkStatusIs406(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 406);

	}

	public static void checkStatusIs407(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 407);

	}

	public static void checkStatusIs408(Response response) {
		logger.info("** Checking Status Code **");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is = " + statusCode);
		Assert.assertEquals(statusCode, 408);

	}
	
	public static void checkContentType(Response response ) {
		logger.info("** Checking Content Type **");
		String contentType = response.header("Content-Type");
		logger.info("Content-type = "+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	
	public static void checkResponseTime(Response response) {
		logger.info("** Checking Response Time");
		long responseTime = response.getTime();
		logger.info("Response Time is = " + responseTime);

		if (responseTime > 2000)
			logger.warn("Response Time is greater than 2000");
		Assert.assertTrue(responseTime < 2000);
	}
	
	 static String jsonFile;
     public static String readJson(String fileName) {
    	 try {
    		jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
    	 
    	 }catch(IOException e) {
    		 
    		 e.printStackTrace();
    	 }
    	 return jsonFile;
     }
     
}
