/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.vishag.javautils.function;

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
