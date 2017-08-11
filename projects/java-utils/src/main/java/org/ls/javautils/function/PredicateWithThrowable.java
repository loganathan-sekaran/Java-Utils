package org.ls.javautils.function;

/**
 * The Interface PredicateWithThrowable.
 *
 * @param <T> the generic type
 * @param <E> the element type
 */
@FunctionalInterface
public interface PredicateWithThrowable<T, E extends Throwable> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     * @throws E the e
     */
    boolean test(T t) throws E;
}