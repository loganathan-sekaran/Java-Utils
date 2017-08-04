package org.ls.javautils.function;
@FunctionalInterface
public interface PredicateWithThrowable<T, E extends Throwable> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t) throws E;
}