package org.ls.javautils.function;

/**
 * The Interface BiFunctionWithThrowable.
 *
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <R> the generic type
 * @param <E> the element type
 */
@FunctionalInterface
public interface BiFunctionWithThrowable<T1, T2, R, E extends Throwable>{
	 
 	/**
 	 * Apply.
 	 *
 	 * @param t1 the t 1
 	 * @param t2 the t 2
 	 * @return the r
 	 * @throws E the e
 	 */
 	R apply(T1 t1, T2 t2) throws E;
}
