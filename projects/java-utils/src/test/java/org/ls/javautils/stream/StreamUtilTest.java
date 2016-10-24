package org.ls.javautils.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testFlatten() throws Exception {
		String[] array = new String[]{"aaa", "bbb", "ccc", "ddd"};
		Stream<Optional<String>> input = Arrays.stream(array).map(element -> Optional.ofNullable(element));
		
		Stream<String> flattenedStream = StreamUtil.flatten(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);
		
		array = new String[]{"aaa", "bbb", null, "ddd"};
		input = Arrays.stream(array).map(element -> Optional.ofNullable(element));
		
		flattenedStream = StreamUtil.flatten(input);
		Assert.assertArrayEquals(flattenedStream.toArray(),  new String[]{"aaa", "bbb", "ddd"});
	}

	@Test
	public void testFlattenAsDoubleStream() throws Exception {
		double[] array = new double[]{111, 222, 333, 444};
		Stream<OptionalDouble> input = Arrays.stream(array).mapToObj(element -> OptionalDouble.of(element));
		
		DoubleStream flattenedStream = StreamUtil.flattenAsDoubleStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array, 0d);
		
		input = Arrays.stream(array).mapToObj(element -> {
			if(element == 333) {
				return OptionalDouble.empty();
			}
			return OptionalDouble.of(element);
		});
		
		flattenedStream = StreamUtil.flattenAsDoubleStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new double[]{111, 222, 444}, 0d);
	}
	
	@Test
	public void testFlattenAsIntStream() throws Exception {
		int[] array = new int[]{111, 222, 333, 444};
		Stream<OptionalInt> input = Arrays.stream(array).mapToObj(element -> OptionalInt.of(element));
		
		IntStream flattenedStream = StreamUtil.flattenAsIntStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);
		
		input = Arrays.stream(array).mapToObj(element -> {
			if(element == 333) {
				return OptionalInt.empty();
			}
			return OptionalInt.of(element);
		});
		
		flattenedStream = StreamUtil.flattenAsIntStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new int[]{111, 222, 444});
	}
	
	@Test
	public void testFlattenAsLongStream() throws Exception {
		long[] array = new long[]{111, 222, 333, 444};
		Stream<OptionalLong> input = Arrays.stream(array).mapToObj(element -> OptionalLong.of(element));
		
		LongStream flattenedStream = StreamUtil.flattenAsLongStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);
		
		input = Arrays.stream(array).mapToObj(element -> {
			if(element == 333) {
				return OptionalLong.empty();
			}
			return OptionalLong.of(element);
		});
		
		flattenedStream = StreamUtil.flattenAsLongStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new long[]{111, 222, 444});
	}

}
