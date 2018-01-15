package org.ls.javautils.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

import org.junit.Assert;
import org.junit.Test;
import org.vishag.javautils.optional.MappableOptionalDouble;

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
	public void testMap() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleFunction<Double> mapper = d1 -> d1 * 2;
		Optional<Double> mod2 = mod1.map(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		Optional<Double> mod4 = mod3.map(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testMapAsOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleUnaryOperator mapper = d1 -> d1 * 2;
		OptionalDouble mod2 = mod1.mapAsOptionalDouble(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsDouble(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		OptionalDouble mod4 = mod3.mapAsOptionalDouble(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}

	@Test
	public void testMapAsMappableOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleUnaryOperator mapper = d1 -> d1 * 2;
		MappableOptionalDouble mod2 = mod1.mapAsMappableOptionalDouble(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalDouble().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalDouble().getAsDouble(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		MappableOptionalDouble mod4 = mod3.mapAsMappableOptionalDouble(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalDouble().isPresent());
	}
	
	@Test
	public void testFlatMap() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleFunction<Optional<Double>> mapper = d1 -> Optional.of(d1 * 2);
		Optional<Double> mod2 = mod1.flatMap(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		Optional<Double> mod4 = mod3.flatMap(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testFlatMapAOptionalDouble() throws Exception {
		double d = ThreadLocalRandom.current().nextDouble();
		MappableOptionalDouble mod1 = MappableOptionalDouble.of(d);
		DoubleFunction<OptionalDouble> mapper = d1 -> OptionalDouble.of(d1 * 2);
		OptionalDouble mod2 = mod1.flatMapAsOptionalDouble(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsDouble(), 0d);
		
		MappableOptionalDouble mod3 = MappableOptionalDouble.empty();
		OptionalDouble mod4 = mod3.flatMapAsOptionalDouble(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
		
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
