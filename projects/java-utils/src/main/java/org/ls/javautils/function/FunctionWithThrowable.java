package org.ls.javautils.function;

/**
 * The Interface FunctionWithThrowable.
 *
 * @param <T> the generic type
 * @param <R> the generic type
 * @param <E> the element type
 */
@FunctionalInterface
public interface FunctionWithThrowable<T, R, E extends Throwable>{
	 
 	/**
 	 * Apply.
 	 *
 	 * @param t the t
 	 * @return the r
 	 * @throws E the e
 	 */
 	R apply(T t) throws E;
}
