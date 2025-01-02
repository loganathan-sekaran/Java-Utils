package org.vishag.javautils.optional;

@FunctionalInterface
public interface SupplierWithThrowable<R, E extends Throwable>{
	 
 	/**
 	 * Apply.
 	 *
 	 * @return the r
 	 * @throws E the e
 	 */
 	R get() throws E;
}