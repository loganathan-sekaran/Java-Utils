package org.ls.javautils.mappable.optional;

import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleFunction;

import org.junit.Assert;
import org.junit.Test;

public class MappableOptionalDoubleTest  {

	@Test
	public void testOfOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mappableOptionalDouble = MappableOptionalDouble.of(OptionalDouble.of(d));
		Assert.assertNotNull(mappableOptionalDouble);
		Assert.assertNotNull(mappableOptionalDouble.getOptionalDouble());
		Assert.assertEquals(d, mappableOptionalDouble.getOptionalDouble().getAsDouble(),0d);
		
	}

	@Test
	public void testOfDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mappableOptionalDouble = MappableOptionalDouble.of(d);
		Assert.assertNotNull(mappableOptionalDouble);
		Assert.assertNotNull(mappableOptionalDouble.getOptionalDouble());
		Assert.assertEquals(d, mappableOptionalDouble.getOptionalDouble().getAsDouble(),0d);
	}

	@Test
	public void testEmpty() throws Exception {
		MappableOptionalDouble mappableOptionalDouble = MappableOptionalDouble.empty();
		Assert.assertNotNull(mappableOptionalDouble);
		Assert.assertNotNull(mappableOptionalDouble.getOptionalDouble());
		Assert.assertFalse(mappableOptionalDouble.getOptionalDouble().isPresent());
	}

	@Test
	public void testGetOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mappableOptionalDouble = MappableOptionalDouble.of(d);
		Assert.assertNotNull(mappableOptionalDouble);
		Assert.assertNotNull(mappableOptionalDouble.getOptionalDouble());
		Assert.assertEquals(d, mappableOptionalDouble.getOptionalDouble().getAsDouble(),0d);
	}

	@Test
	public void testFlatMapAsMappableOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleFunction<MappableOptionalDouble> mapper = d1 -> MappableOptionalDouble.of(d1 * 2);
		MappableOptionalDouble mod2 = mod1.flatMapAsMappableOptionalDouble(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalDouble().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalDouble().getAsDouble(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		MappableOptionalDouble mod4 = mod3.flatMapAsMappableOptionalDouble(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalDouble().isPresent());
		
	}
}
