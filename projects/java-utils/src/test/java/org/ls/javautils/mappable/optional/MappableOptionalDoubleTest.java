package org.ls.javautils.mappable.optional;

import static org.hamcrest.CoreMatchers.is;

import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;

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
}
