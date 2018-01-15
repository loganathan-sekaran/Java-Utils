package org.vishag.javautils.optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.annotation.Generated;

import org.junit.Assert;
import org.junit.Test;
import org.vishag.javautils.function.ConsumerWithThrowable;
import org.vishag.javautils.function.FunctionWithThrowable;
import org.vishag.javautils.function.PredicateWithThrowable;


@Generated(value = "org.junit-tools-1.0.6")
public class OptionalWithThrowableTest {

	private static final OptionalWithThrowable<String, Exception> INPUT = new OptionalWithThrowable<>(Optional.of("abcdef123456"));

	private OptionalWithThrowable<String, Exception> getTestSubject() {
		return INPUT;
	}

	@Test
	public void testOf() throws Exception {
		String t = "abcdef123456";
		OptionalWithThrowable<String, Exception> result;

		// default test
		result = OptionalWithThrowable.of(t);
		Assert.assertEquals(t, result.get());
	}

	@Test
	public void testOfNullable() throws Exception {
		String t = null;
		OptionalWithThrowable<String, Exception> result;

		// default test
		result = OptionalWithThrowable.ofNullable(t);
		Assert.assertFalse(result.isPresent());
	}

	@Test
	public void testOf_1() throws Exception {
		String t = "abcdef123456";
		Optional<String> optional = Optional.of(t);
		OptionalWithThrowable<String, Exception> result;

		// default test
		result = OptionalWithThrowable.of(optional);
		Assert.assertEquals(t, result.get());
	}

	@Test
	public void testGet() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		String result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.get();
		Assert.assertEquals("abcdef123456", result);
	}

	@Test
	public void testGetOptional() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		Optional<String> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.getOptional();
		Assert.assertEquals(Optional.of("abcdef123456"), result);
	}

	@Test
	public void testIsPresent() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		boolean result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.isPresent();
		assertTrue(result);
	}

	@Test
	public void testIfPresent() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject = getTestSubject();
		ConsumerWithThrowable<String, Exception> consumer = a -> {
			Assert.assertEquals(a, "abcdef123456");
		};

		// default test
		testSubject = getTestSubject();
		testSubject.ifPresent(consumer);
	}
	
	@Test(expected = Exception.class)
	public void testIfPresentWithException() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject = getTestSubject();
		ConsumerWithThrowable<String, Exception> consumer = a -> {
			throw new Exception();
		};

		// default test
		testSubject = getTestSubject();
		testSubject.ifPresent(consumer);
	}

	@Test
	public void testFilterTrue() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		PredicateWithThrowable<String, Exception> predicate = string -> true;
		OptionalWithThrowable<String, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.filter(predicate);
		assertEquals(result, getTestSubject());
	}
	
	@Test
	public void testFilterFalse() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		PredicateWithThrowable<String, Exception> predicate = string -> false;
		OptionalWithThrowable<String, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.filter(predicate);
		assertFalse(result.isPresent());
	}
	
	public void testFilterWithException() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		PredicateWithThrowable<String, Exception> predicate = string -> {
			throw new Exception();
		};
		OptionalWithThrowable<String, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.filter(predicate);
		assertFalse(result.isPresent());
	}

	@Test
	public void testMap() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		FunctionWithThrowable<String, Integer, Exception> mapper = str -> 123456;
		OptionalWithThrowable<Integer, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.map(mapper);
		assertEquals((int)123456, (int)result.get());
	}
	
	@Test(expected = Exception.class)
	public void testMapWithException() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		FunctionWithThrowable<String, Integer, Exception> mapper = str -> {
			throw new Exception();
		};
		OptionalWithThrowable<Integer, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.map(mapper);
		assertEquals((int)123456, (int)result.get());
	}

	@Test
	public void testFlatMap() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		FunctionWithThrowable<String, OptionalWithThrowable<Integer, Exception>, Exception> mapper = str -> OptionalWithThrowable.of(123456);
		OptionalWithThrowable<Integer, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.flatMap(mapper);
		assertEquals((int)123456, (int)result.get());
	}
	
	@Test(expected = Exception.class)
	public void testFlatMapWithException() throws Exception {
		OptionalWithThrowable<String, Exception> testSubject;
		FunctionWithThrowable<String, OptionalWithThrowable<Integer, Exception>, Exception> mapper = str -> {
			throw new Exception();
		};
		OptionalWithThrowable<Integer, Exception> result;

		// default test
		testSubject = getTestSubject();
		result = testSubject.flatMap(mapper);
		assertEquals((int)123456, (int)result.get());
	}


	@Test
	public void testEmpty() throws Exception {
		OptionalWithThrowable<String, Exception> result;

		// default test
		result = OptionalWithThrowable.empty();
		assertFalse(result.isPresent());
	}
}