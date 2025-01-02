package org.vishag.javautils.log;

import java.util.function.Consumer;

public interface Logger {
    void info(String message);
    void debug(String message);
    void error(String message);
    void warn(String message);
    void fatal(String message);
    void trace(String message);
    
    static Logger of(Consumer<String> infoLogger, 
    		Consumer<String> debugLogger, 
    		Consumer<String> errorLogger,
    		Consumer<String> warnLogger, 
    		Consumer<String> traceLogger, 
    		Consumer<String> fatalLogger) {
    	return new Logger() {
			
			@Override
			public void info(String message) {
				infoLogger.accept(message);
			}
			
			@Override
			public void error(String message) {
				errorLogger.accept(message);
			}
			
			@Override
			public void debug(String message) {
				debugLogger.accept(message);				
			}
			
			@Override
			public void warn(String message) {
				warnLogger.accept(message);				
			}
			@Override
			public void trace(String message) {
				traceLogger.accept(message);				
			}
			@Override
			public void fatal(String message) {
				fatalLogger.accept(message);				
			}
		};
    }
    
    static Logger defaultSysOutLogger() {
		return Logger.of(System.out::println,System.out::println,System.out::println,System.out::println,System.out::println,System.out::println);
	}
    
	static Logger defaultSysOutErrLogger() {
		return Logger.of(System.out::println,System.out::println,System.err::println,System.out::println,System.out::println,System.err::println);
	}
}