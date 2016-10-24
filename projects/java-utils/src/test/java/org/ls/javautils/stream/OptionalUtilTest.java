package org.ls.javautils.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import org.junit.Assert;
import org.junit.Test;

public class OptionalUtilTest {

	@Test
	public void testFlatten() throws Exception {
		Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("Hello World"));
		Optional<String> flattenedOptional = OptionalUtil.flatten(optionalOfOptional);
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.get(), "Hello World");
		
		Optional<Optional<String>> optionalOfEmptyOptional = Optional.of(Optional.empty());
		Optional<String> flattenedOptional2 = OptionalUtil.flatten(optionalOfEmptyOptional);
		
		Assert.assertFalse(flattenedOptional2.isPresent());
		
		Optional<Optional<Optional<String>>> optionalOfOptionalOfOptional = Optional.of(Optional.of(Optional.of("Thank you!")));
		flattenedOptional = OptionalUtil.flatten(OptionalUtil.flatten(optionalOfOptionalOfOptional));
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.get(), "Thank you!");
	}

	@Test
	public void testFlattenAsOptionalDouble() throws Exception {
		Optional<OptionalDouble> optionalOfOptional = Optional.of(OptionalDouble.of(111));
		OptionalDouble flattenedOptional = OptionalUtil.flattenAsOptionalDouble(optionalOfOptional);
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsDouble(), 111, 0d);
		
		Optional<Optional<String>> optionalOfEmptyOptional = Optional.of(Optional.empty());
		Optional<String> flattenedOptional2 = OptionalUtil.flatten(optionalOfEmptyOptional);
		
		Assert.assertFalse(flattenedOptional2.isPresent());
		
		Optional<Optional<OptionalDouble>> optionalOfOptionalOfOptional = Optional.of(Optional.of(OptionalDouble.of(222)));
		flattenedOptional = OptionalUtil.flattenAsOptionalDouble(OptionalUtil.flatten(optionalOfOptionalOfOptional));
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsDouble(), 222, 0d);
	}

	@Test
	public void testFlattenAsOptionalInt() throws Exception {
		Optional<OptionalInt> optionalOfOptional = Optional.of(OptionalInt.of(111));
		OptionalInt flattenedOptional = OptionalUtil.flattenAsOptionalInt(optionalOfOptional);
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsInt(), 111);
		
		Optional<Optional<String>> optionalOfEmptyOptional = Optional.of(Optional.empty());
		Optional<String> flattenedOptional2 = OptionalUtil.flatten(optionalOfEmptyOptional);
		
		Assert.assertFalse(flattenedOptional2.isPresent());
		
		Optional<Optional<OptionalInt>> optionalOfOptionalOfOptional = Optional.of(Optional.of(OptionalInt.of(222)));
		flattenedOptional = OptionalUtil.flattenAsOptionalInt(OptionalUtil.flatten(optionalOfOptionalOfOptional));
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsInt(), 222);
	}

	@Test
	public void testFlattenAsOptionalLong() throws Exception {
		Optional<OptionalLong> optionalOfOptional = Optional.of(OptionalLong.of(111));
		OptionalLong flattenedOptional = OptionalUtil.flattenAsOptionalLong(optionalOfOptional);
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsLong(), 111);
		
		Optional<Optional<String>> optionalOfEmptyOptional = Optional.of(Optional.empty());
		Optional<String> flattenedOptional2 = OptionalUtil.flatten(optionalOfEmptyOptional);
		
		Assert.assertFalse(flattenedOptional2.isPresent());
		
		Optional<Optional<OptionalLong>> optionalOfOptionalOfOptional = Optional.of(Optional.of(OptionalLong.of(222)));
		flattenedOptional = OptionalUtil.flattenAsOptionalLong(OptionalUtil.flatten(optionalOfOptionalOfOptional));
		
		Assert.assertTrue(flattenedOptional.isPresent());
		Assert.assertEquals(flattenedOptional.getAsLong(), 222);
	}

}
