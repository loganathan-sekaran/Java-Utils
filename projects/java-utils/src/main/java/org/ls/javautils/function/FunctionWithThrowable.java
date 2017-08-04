package org.ls.javautils.function;

@FunctionalInterface
public interface FunctionWithThrowable<T, R, E extends Throwable>{
	 R apply(T t) throws E;
}
