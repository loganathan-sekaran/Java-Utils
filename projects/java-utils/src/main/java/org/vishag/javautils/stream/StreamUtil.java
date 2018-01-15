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
package org.vishag.javautils.stream;

import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * The StreamUtil.
 *
 * @author Loganathan.S (loganathan001@gmail.com)
 *
 */
public enum StreamUtil {
	;

	/**
	 * Flatten Stream of Optionals as Stream.
	 *
	 * @param <T> the generic type
	 * @param optionalStream the optional stream
	 * @return the stream
	 */
	public static <T> Stream<T> flatten(Stream<Optional<T>> optionalStream) {
		return optionalStream.filter(op -> op.isPresent()).flatMap(opt -> Stream.of(opt.get()));
	}
	
	/**
	 * Flatten the array of Optionals as Stream.
	 *
	 * @param <T> the generic type
	 * @param optionals the array of optionals
	 * @return the stream
	 */
	@SafeVarargs
	public static <T> Stream<T> flatten(Optional<T>... optionals) {
		return Stream.of(optionals).filter(op -> op.isPresent()).flatMap(opt -> Stream.of(opt.get()));
	}

	/**
	 * Flatten Stream of OptionalDouble as DoubleStream.
	 *
	 * @param optionalDoubleStream the optional double stream
	 * @return the double stream
	 */
	public static DoubleStream flattenAsDoubleStream(Stream<OptionalDouble> optionalDoubleStream) {
		return optionalDoubleStream.filter(op -> op.isPresent())
				.flatMapToDouble(opt -> DoubleStream.of(opt.getAsDouble()));
	}

	/**
	 * Flatten Stream of OptionalInt as IntStream.
	 *
	 * @param optionalIntStream the optional int stream
	 * @return the int stream
	 */
	public static IntStream flattenAsIntStream(Stream<OptionalInt> optionalIntStream) {
		return optionalIntStream.filter(op -> op.isPresent()).flatMapToInt(opt -> IntStream.of(opt.getAsInt()));
	}

	/**
	 * Flatten Stream of OptionalLong as LongStream.
	 *
	 * @param optionalLongStream the optional long stream
	 * @return the long stream
	 */
	public static LongStream flattenAsLongStream(Stream<OptionalLong> optionalLongStream) {
		return optionalLongStream.filter(op -> op.isPresent()).flatMapToLong(opt -> LongStream.of(opt.getAsLong()));
	}
	
	/**
	 * Stream of Iterator.
	 *
	 * @param <T> the generic type
	 * @param iterator the iterator
	 * @param parallel the parallel
	 * @return the stream
	 */
	public static <T> Stream<T> streamOf(Iterator<T> iterator, boolean parallel) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), parallel);
	}
	
	/**
	 * Stream of Iterator.
	 *
	 * @param <T> the generic type
	 * @param iterator the iterator
	 * @return the stream
	 */
	public static <T> Stream<T> streamOf(Iterator<T> iterator) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
	}

}
