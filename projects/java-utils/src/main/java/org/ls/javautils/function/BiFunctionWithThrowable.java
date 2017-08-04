package org.ls.javautils.function;

@FunctionalInterface
public interface BiFunctionWithThrowable<T1, T2, R, E extends Throwable>{
	 R apply(T1 t1, T2 t2) throws E;
}
