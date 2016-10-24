package org.ls.javautils.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * The StreamUtil.
 *
 * @author Loganathan.S (loganathan001@gmail.com)
 *
 */
public enum StreamUtil {
	;

	/**
	 * Flatten.
	 *
	 * @param <T> the generic type
	 * @param optionalStream the optional stream
	 * @return the stream
	 */
	public static <T> Stream<T> flatten(Stream<Optional<T>> optionalStream) {
		return optionalStream.filter(op -> op.isPresent()).flatMap(opt -> Stream.of(opt.get()));
	}

	/**
	 * Flatten as double stream.
	 *
	 * @param optionalDoubleStream the optional double stream
	 * @return the double stream
	 */
	public static DoubleStream flattenAsDoubleStream(Stream<OptionalDouble> optionalDoubleStream) {
		return optionalDoubleStream.filter(op -> op.isPresent())
				.flatMapToDouble(opt -> DoubleStream.of(opt.getAsDouble()));
	}

	/**
	 * Flatten as int stream.
	 *
	 * @param optionalIntStream the optional int stream
	 * @return the int stream
	 */
	public static IntStream flattenAsIntStream(Stream<OptionalInt> optionalIntStream) {
		return optionalIntStream.filter(op -> op.isPresent()).flatMapToInt(opt -> IntStream.of(opt.getAsInt()));
	}

	/**
	 * Flatten as long stream.
	 *
	 * @param optionalLongStream the optional long stream
	 * @return the long stream
	 */
	public static LongStream flattenAsLongStream(Stream<OptionalLong> optionalLongStream) {
		return optionalLongStream.filter(op -> op.isPresent()).flatMapToLong(opt -> LongStream.of(opt.getAsLong()));
	}

}
