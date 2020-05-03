package com.pizzaapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger = Logger.getLogger("PizzaRestAPI");
		PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}