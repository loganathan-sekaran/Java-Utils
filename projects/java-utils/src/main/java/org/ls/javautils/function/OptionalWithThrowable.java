package org.ls.javautils.function;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalWithThrowable<T, E extends Throwable> {
	private Optional<T> optional;
	
	private static final OptionalWithThrowable<?, ?> EMPTY = new OptionalWithThrowable<>(Optional.empty());
	
	public OptionalWithThrowable(Optional<T> optional) {
		this.optional = optional;
	}
	
	public static <U, V extends Throwable> OptionalWithThrowable<U, V> of(U t) {
		return of(Optional.of(t));
	}
	
	public static <U,V extends Throwable> OptionalWithThrowable<U, V> ofNullable(U t) {
		return of(Optional.ofNullable(t));
	}
	
	public static <U, V extends Throwable> OptionalWithThrowable<U, V> of(Optional<U> optional) {
		return new OptionalWithThrowable<>(optional);
	}
	
	public T get() {
		return optional.get();
	}
	
	public Optional<T> getOptional() {
		return optional;
	}
	
	public boolean isPresent() {
		return optional.isPresent();
	}
	
	public void ifPresent(ConsumerWithThrowable<T, E> consumer) throws E {
		if(isPresent()) {
			consumer.accept(optional.get());
		}
	}
	
	public OptionalWithThrowable<T,E> filter(Predicate<? super T> predicate) throws E {
		Objects.requireNonNull(predicate);
		return of(optional.filter(predicate));
	}
	
	public <R> OptionalWithThrowable<R, E> map(FunctionWithThrowable<T, R, E> mapper) throws E {
		Objects.requireNonNull(mapper);
		if (!isPresent())
			return empty();
		else {
			return ofNullable(mapper.apply(get()));
		}
	}
	
	public <R> OptionalWithThrowable<R, E> flatMap(FunctionWithThrowable<T, OptionalWithThrowable<R, E>, E> mapper)  throws E{
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(get()));
        }
    }
	
	public static<T, E extends Throwable> OptionalWithThrowable<T, E> empty() {
		@SuppressWarnings("unchecked")
		OptionalWithThrowable<T, E> t = (OptionalWithThrowable<T, E>) EMPTY;
        return t;
	}
}
