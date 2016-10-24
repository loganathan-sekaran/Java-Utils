package org.ls.javautils.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public enum StreamUtil {
	;

	public static <T> Stream<T> flatten(Stream<Optional<T>> optionalStream) {
		return optionalStream.filter(op -> op.isPresent()).flatMap(opt -> Stream.of(opt.get()));
	}

	public static DoubleStream flattenAsDoubleStream(Stream<OptionalDouble> optionalDoubleStream) {
		return optionalDoubleStream.filter(op -> op.isPresent())
				.flatMapToDouble(opt -> DoubleStream.of(opt.getAsDouble()));
	}

	public static IntStream flattenAsIntStream(Stream<OptionalInt> optionalIntStream) {
		return optionalIntStream.filter(op -> op.isPresent()).flatMapToInt(opt -> IntStream.of(opt.getAsInt()));
	}

	public static LongStream flattenAsLongStream(Stream<OptionalLong> optionalLongStream) {
		return optionalLongStream.filter(op -> op.isPresent()).flatMapToLong(opt -> LongStream.of(opt.getAsLong()));
	}

}
