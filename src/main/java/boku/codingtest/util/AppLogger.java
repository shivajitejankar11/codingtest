package boku.codingtest.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Following class provides a logging mechanism to the entire app.
 * Default implementation used in this class is log4j2
 * @author darshan
 *
 */
public final class AppLogger {

	private Logger logger;
	
	private AppLogger(String name){
		logger = LogManager.getLogger(name);
	}
	
	private AppLogger(Class<?> classRef){
		logger = LogManager.getLogger(classRef);
	}
	
	public static AppLogger getLogger(String name){
		return new AppLogger(name);
	}
	
	public static AppLogger getLogger(Class<?> classRef){
		return new AppLogger(classRef);
	}
	
	public void error(String message){
		logger.error(message);
	}
	
	public void error(String message, Throwable t){
		logger.error(message,t);
	}
	
	public void warn(String message){
		logger.warn(message);
	}
	
	public void warn(String message, Throwable t){
		logger.warn(message,t);
	}
	
	public void info(String message){
		logger.info(message);
	}
	
	public void info(String message, Throwable t){
		logger.info(message,t);
	}
	
	public void debug(String message){
		logger.debug(message);
	}
	
	public void debug(String message, Throwable t){
		logger.debug(message,t);
	}
	
}
