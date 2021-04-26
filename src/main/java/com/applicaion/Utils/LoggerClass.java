package com.applicaion.Utils;


import org.apache.logging.log4j.Logger;




public class LoggerClass {
	
	public static Logger logger = Logger.getLogger("LoggerClass");
    PropertyConfigurator.configure("Log4j.properties");

}
