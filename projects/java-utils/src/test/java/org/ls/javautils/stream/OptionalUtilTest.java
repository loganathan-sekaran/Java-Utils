package org.ls.javautils.stream;

import java.util.Optional;

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

}
