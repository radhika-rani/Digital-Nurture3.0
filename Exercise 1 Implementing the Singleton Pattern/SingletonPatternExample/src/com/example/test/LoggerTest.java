package com.example.test;

import com.example.singleton.Logger;

public class LoggerTest {
	
	    public static void main(String[] args) {
	        // Retrieve the single instance of Logger
	        Logger logger1 = Logger.getInstance();
	        Logger logger2 = Logger.getInstance();

	        // Log messages using both instances
	        logger1.log("First log message");
	        logger2.log("Second log message");

	        // Verify that both logger1 and logger2 are the same instance
	        if (logger1 == logger2) {
	            System.out.println("Both logger1 and logger2 are the same instance.");
	        } else {
	            System.out.println("logger1 and logger2 are different instances.");
	        }
	    }
}
