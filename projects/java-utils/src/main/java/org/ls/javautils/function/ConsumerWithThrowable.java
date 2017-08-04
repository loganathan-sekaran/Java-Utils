package org.ls.javautils.function;

@FunctionalInterface
public interface ConsumerWithThrowable<T, E extends Throwable>{
	 void accept(T t) throws E;
}
