package com.pizzaapi.utils;

public class Constants extends HelperMethods{

	public static final String CREATE_ORDER = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createOrder.json";
	public static final String CREATE_ORDER_INCORRECT_NUM_TOPPINGS = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createOrderIncorrectNumToppings.json";
	public static final String CREATE_ORDER_INVALID_PIZZA = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createOrderInvalidPizza.json";
	public static final String CREATE_ORDER_PIZZA_NOT_SPECIFIED = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createOrderPizzaNotSpecified.json";
	
	public static final String REPORT_FILEPATH=System.getProperty("user.dir")
			+"/Reports/Extent-Report.html";
	
	public static final String URI ="https://my-json-server.typicode.com/sa2225/demo/";
	
	public static final String POST_URI = "https://my-json-server.typicode.com/sa2225/demo/orders";
}
