package org.ls.javautils.function;

/**
 * The Interface ConsumerWithThrowable.
 *
 * @param <T> the generic type
 * @param <E> the element type
 */
@FunctionalInterface
public interface ConsumerWithThrowable<T, E extends Throwable>{
	 
 	/**
 	 * Accept.
 	 *
 	 * @param t the t
 	 * @throws E the e
 	 */
 	void accept(T t) throws E;
}
