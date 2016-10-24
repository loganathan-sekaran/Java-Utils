
package org.ls.javautils.examples;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.ls.javautils.stream.StreamUtil;

/**
 * 
 * OptionalExamples class elaborated from the Java-8 example of Jose Paumard
 *
 */
public class OptionalExamples {

	public static void main(String[] args) {
		// List<Double> doubles = Arrays.asList(1d, -1d, 0d, 0.25d, -2d, 19d,
		// -4d, 4d, 25d, 0.10d);
		Stream<Double>doubles=ThreadLocalRandom.current().doubles(10_000).map(d->d*10*2-10).parallel().boxed();

		// List<Double> result = new ArrayList<>();
		List<Double>result=new CopyOnWriteArrayList<>();
		// Not recommended
		doubles.forEach(d->NewMath.inv(d).ifPresent(d1->NewMath.sqrt(d1).ifPresent(d2->result.add(d2))));System.out.println(result.size());

		// boxed version - 1
		doubles=ThreadLocalRandom.current().doubles(10_000).parallel().boxed();Function<Double,Stream<Double>>invSqrt=d->NewMath.inv(d).flatMap(NewMath::sqrt).map(Stream::of).orElseGet(Stream::empty);

		List<Double>rightResult=doubles.map(d->d*10*2-10).flatMap(invSqrt).collect(Collectors.toList());System.out.println(rightResult.size());

		// boxed version - 2 - Uses streamutil to flatten the optional doubles
		doubles=ThreadLocalRandom.current().doubles(10_000).parallel().boxed();Function<Double,Optional<Double>>invSqrt2=d->NewMath.inv(d).flatMap(NewMath::sqrt);

		List<Double>rightResult2=StreamUtil.flatten(doubles.map(d->d*10*2-10).map(invSqrt2)).collect(Collectors.toList());System.out.println(rightResult2.size());

		// Non-boxed version. Since OptionalDouble doesn't have flatMap or Map,
		// done the custom implementation methods of them
		// Seems a bit complex
		DoubleStream doubleStream=ThreadLocalRandom.current().doubles(10_000).map(d->d*10*2-10).parallel();DoubleFunction<DoubleStream>invSqrtDouble=d->optionalDoubleMap(optionalDoubleflatMap(NewMath.invAsOptionalDouble(d),NewMath::sqrtAsOptionalDouble),optionalDouble->Optional.of(DoubleStream.of(optionalDouble.getAsDouble()))).orElseGet(DoubleStream::empty);

		double[]doubleResult=doubleStream.map(d->d*10*2-10).flatMap(invSqrtDouble).toArray();System.out.println(doubleResult.length);

		// Non-boxed version Using MappableOptionalDouble
		doubleStream=ThreadLocalRandom.current().doubles(10_000).parallel();DoubleFunction<DoubleStream>invSqrtMappable=d->NewMath.invAsMappableOptionalDouble(d).flatMapAsMappableOptionalDouble(NewMath::sqrtAsMappableOptionalDouble).map(DoubleStream::of).orElseGet(DoubleStream::empty);

		double[]rightResultMappable=doubleStream.map(d->d*10*2-10).flatMap(invSqrtMappable).toArray();System.out.println(rightResultMappable.length);

		// Non-boxed version Using
		// MappableOptionalDouble.flatMapAsOptionalDouble and
		// StreamUtils.flattenAsDoubleStream
		doubleStream=ThreadLocalRandom.current().doubles(10_000).parallel();DoubleFunction<OptionalDouble>invSqrtAsOptionalDouble=d->NewMath.invAsMappableOptionalDouble(d).flatMapAsOptionalDouble(NewMath::sqrtAsOptionalDouble);

		DoubleStream flattenedResult=StreamUtil.flattenAsDoubleStream(doubleStream.map(d->d*10*2-10).mapToObj(invSqrtAsOptionalDouble));System.out.println(flattenedResult.count());
	}

	public static OptionalDouble optionalDoubleflatMap(OptionalDouble optionalDouble,
			DoubleFunction<OptionalDouble> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return OptionalDouble.empty();
		else {
			return mapper.apply(optionalDouble.getAsDouble());
		}
	}

	public static Optional<DoubleStream> optionalDoubleMap(OptionalDouble optionalDouble,
			Function<OptionalDouble, Optional<DoubleStream>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return Optional.empty();
		else {
			return mapper.apply(optionalDouble);
		}
	}

}
