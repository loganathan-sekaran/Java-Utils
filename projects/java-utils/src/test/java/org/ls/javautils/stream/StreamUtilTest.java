package org.ls.javautils.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.vishag.javautils.stream.StreamUtil;

public class StreamUtilTest {

	@Test
	public void testFlatten() throws Exception {
		String[] array = new String[] { "aaa", "bbb", "ccc", "ddd" };
		Stream<Optional<String>> input = Arrays.stream(array).map(element -> Optional.ofNullable(element));

		Stream<String> flattenedStream = StreamUtil.flatten(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);

		array = new String[] { "aaa", "bbb", null, "ddd" };
		input = Arrays.stream(array).map(element -> Optional.ofNullable(element));

		flattenedStream = StreamUtil.flatten(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new String[] { "aaa", "bbb", "ddd" });
	}

	@Test
	public void testFlattenAsDoubleStream() throws Exception {
		double[] array = new double[] { 111, 222, 333, 444 };
		Stream<OptionalDouble> input = Arrays.stream(array).mapToObj(element -> OptionalDouble.of(element));

		DoubleStream flattenedStream = StreamUtil.flattenAsDoubleStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array, 0d);

		input = Arrays.stream(array).mapToObj(element -> {
			if (element == 333) {
				return OptionalDouble.empty();
			}
			return OptionalDouble.of(element);
		});

		flattenedStream = StreamUtil.flattenAsDoubleStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new double[] { 111, 222, 444 }, 0d);
	}

	@Test
	public void testFlattenAsIntStream() throws Exception {
		int[] array = new int[] { 111, 222, 333, 444 };
		Stream<OptionalInt> input = Arrays.stream(array).mapToObj(element -> OptionalInt.of(element));

		IntStream flattenedStream = StreamUtil.flattenAsIntStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);

		input = Arrays.stream(array).mapToObj(element -> {
			if (element == 333) {
				return OptionalInt.empty();
			}
			return OptionalInt.of(element);
		});

		flattenedStream = StreamUtil.flattenAsIntStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new int[] { 111, 222, 444 });
	}

	@Test
	public void testFlattenAsLongStream() throws Exception {
		long[] array = new long[] { 111, 222, 333, 444 };
		Stream<OptionalLong> input = Arrays.stream(array).mapToObj(element -> OptionalLong.of(element));

		LongStream flattenedStream = StreamUtil.flattenAsLongStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), array);

		input = Arrays.stream(array).mapToObj(element -> {
			if (element == 333) {
				return OptionalLong.empty();
			}
			return OptionalLong.of(element);
		});

		flattenedStream = StreamUtil.flattenAsLongStream(input);
		Assert.assertArrayEquals(flattenedStream.toArray(), new long[] { 111, 222, 444 });
	}

	@Test
	public void testStreamOf1() throws Exception {
		List<String> originalList = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd"));

		// Check if list contains all elements of stream
		Assert.assertTrue(StreamUtil.streamOf(originalList.iterator()).allMatch(elem -> originalList.contains(elem)));

		// Check if the stream contains all elements of list
		List<String> listFromStream = StreamUtil.streamOf(originalList.iterator()).collect(Collectors.toList());
		Assert.assertTrue(originalList.stream().allMatch(elem -> listFromStream.contains(elem)));

		Assert.assertFalse(StreamUtil.streamOf(originalList.iterator()).isParallel());

	}

	@Test
	public void testStreamOf2() throws Exception {
		List<String> originalList = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd"));

		// Check with Parallel is set to false
		// Check if list contains all elements of stream
		Assert.assertTrue(
				StreamUtil.streamOf(originalList.iterator(), false).allMatch(elem -> originalList.contains(elem)));

		// Check if the stream contains all elements of list
		List<String> listFromStream = StreamUtil.streamOf(originalList.iterator(), false).collect(Collectors.toList());
		Assert.assertTrue(originalList.stream().allMatch(elem -> listFromStream.contains(elem)));

		// Check the parallel flag applied
		Assert.assertFalse(StreamUtil.streamOf(originalList.iterator()).isParallel());

		// Check with Parallel is set to true
		// Check if list contains all elements of stream
		Assert.assertTrue(
				StreamUtil.streamOf(originalList.iterator(), true).allMatch(elem -> originalList.contains(elem)));

		// Check if the stream contains all elements of list
		List<String> listFromStream2 = StreamUtil.streamOf(originalList.iterator(), true).collect(Collectors.toList());
		Assert.assertTrue(originalList.parallelStream().allMatch(elem -> listFromStream2.contains(elem)));

		// Check the parallel flag applied
		Assert.assertTrue(StreamUtil.streamOf(originalList.iterator(), true).isParallel());
	}

}
