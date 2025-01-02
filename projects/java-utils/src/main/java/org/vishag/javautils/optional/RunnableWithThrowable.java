package org.vishag.javautils.optional;

@FunctionalInterface
public interface RunnableWithThrowable<E extends Throwable>{
	 
 	/**
 	 * Apply.
 	 *
 	 * @throws E the e
 	 */
 	void run() throws E;
}