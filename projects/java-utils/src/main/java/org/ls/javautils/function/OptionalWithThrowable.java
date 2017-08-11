package org.ls.javautils.function;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * The Class OptionalWithThrowable.
 *
 * @param <T> the generic type
 * @param <E> the element type
 */
public class OptionalWithThrowable<T, E extends Throwable> {
	
	/** The optional. */
	private Optional<T> optional;
	
	/** The Constant EMPTY. */
	private static final OptionalWithThrowable<?, ?> EMPTY = new OptionalWithThrowable<>(Optional.empty());
	
	/**
	 * Instantiates a new optional with throwable.
	 *
	 * @param optional the optional
	 */
	public OptionalWithThrowable(Optional<T> optional) {
		this.optional = optional;
	}
	
	/**
	 * Of.
	 *
	 * @param <U> the generic type
	 * @param <V> the value type
	 * @param t the t
	 * @return the optional with throwable
	 */
	public static <U, V extends Throwable> OptionalWithThrowable<U, V> of(U t) {
		return of(Optional.of(t));
	}
	
	/**
	 * Of nullable.
	 *
	 * @param <U> the generic type
	 * @param <V> the value type
	 * @param t the t
	 * @return the optional with throwable
	 */
	public static <U,V extends Throwable> OptionalWithThrowable<U, V> ofNullable(U t) {
		return of(Optional.ofNullable(t));
	}
	
	/**
	 * Of.
	 *
	 * @param <U> the generic type
	 * @param <V> the value type
	 * @param optional the optional
	 * @return the optional with throwable
	 */
	public static <U, V extends Throwable> OptionalWithThrowable<U, V> of(Optional<U> optional) {
		return new OptionalWithThrowable<>(optional);
	}
	
	/**
	 * Gets the.
	 *
	 * @return the t
	 */
	public T get() {
		return optional.get();
	}
	
	/**
	 * Gets the optional.
	 *
	 * @return the optional
	 */
	public Optional<T> getOptional() {
		return optional;
	}
	
	/**
	 * Checks if is present.
	 *
	 * @return true, if is present
	 */
	public boolean isPresent() {
		return optional.isPresent();
	}
	
	/**
	 * If present.
	 *
	 * @param consumer the consumer
	 * @throws E the e
	 */
	public void ifPresent(ConsumerWithThrowable<T, E> consumer) throws E {
		if(isPresent()) {
			consumer.accept(optional.get());
		}
	}
	
	/**
	 * Filter.
	 *
	 * @param predicate the predicate
	 * @return the optional with throwable
	 * @throws E the e
	 */
	public OptionalWithThrowable<T,E> filter(Predicate<? super T> predicate) throws E {
		Objects.requireNonNull(predicate);
		return of(optional.filter(predicate));
	}
	
	/**
	 * Map.
	 *
	 * @param <R> the generic type
	 * @param mapper the mapper
	 * @return the optional with throwable
	 * @throws E the e
	 */
	public <R> OptionalWithThrowable<R, E> map(FunctionWithThrowable<T, R, E> mapper) throws E {
		Objects.requireNonNull(mapper);
		if (!isPresent())
			return empty();
		else {
			return ofNullable(mapper.apply(get()));
		}
	}
	
	/**
	 * Flat map.
	 *
	 * @param <R> the generic type
	 * @param mapper the mapper
	 * @return the optional with throwable
	 * @throws E the e
	 */
	public <R> OptionalWithThrowable<R, E> flatMap(FunctionWithThrowable<T, OptionalWithThrowable<R, E>, E> mapper)  throws E{
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(get()));
        }
    }
	
	/**
	 * Empty.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @return the optional with throwable
	 */
	public static<T, E extends Throwable> OptionalWithThrowable<T, E> empty() {
		@SuppressWarnings("unchecked")
		OptionalWithThrowable<T, E> t = (OptionalWithThrowable<T, E>) EMPTY;
        return t;
	}
}
