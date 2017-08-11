package org.ls.javautils.optional.mappable;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import org.junit.Assert;
import org.junit.Test;
import org.ls.javautils.optional.mappable.MappableOptionalInt;

public class MappableOptionalIntTest  {

	@Test
	public void testOfOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mappableOptionalInt = MappableOptionalInt.of(OptionalInt.of(d));
		Assert.assertNotNull(mappableOptionalInt);
		Assert.assertNotNull(mappableOptionalInt.getOptionalInt());
		Assert.assertEquals(d, mappableOptionalInt.getOptionalInt().getAsInt(),0d);
		
	}

	@Test
	public void testOfInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mappableOptionalInt = MappableOptionalInt.of(d);
		Assert.assertNotNull(mappableOptionalInt);
		Assert.assertNotNull(mappableOptionalInt.getOptionalInt());
		Assert.assertEquals(d, mappableOptionalInt.getOptionalInt().getAsInt(),0d);
	}

	@Test
	public void testEmpty() throws Exception {
		MappableOptionalInt mappableOptionalInt = MappableOptionalInt.empty();
		Assert.assertNotNull(mappableOptionalInt);
		Assert.assertNotNull(mappableOptionalInt.getOptionalInt());
		Assert.assertFalse(mappableOptionalInt.getOptionalInt().isPresent());
	}

	@Test
	public void testGetOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mappableOptionalInt = MappableOptionalInt.of(d);
		Assert.assertNotNull(mappableOptionalInt);
		Assert.assertNotNull(mappableOptionalInt.getOptionalInt());
		Assert.assertEquals(d, mappableOptionalInt.getOptionalInt().getAsInt(),0d);
	}

	@Test
	public void testMap() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntFunction<Integer> mapper = d1 -> d1 * 2;
		Optional<Integer> mod2 = mod1.map(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		Optional<Integer> mod4 = mod3.map(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testMapAsOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntUnaryOperator mapper = d1 -> d1 * 2;
		OptionalInt mod2 = mod1.mapAsOptionalInt(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsInt(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		OptionalInt mod4 = mod3.mapAsOptionalInt(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}

	@Test
	public void testMapAsMappableOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntUnaryOperator mapper = d1 -> d1 * 2;
		MappableOptionalInt mod2 = mod1.mapAsMappableOptionalInt(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalInt().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalInt().getAsInt(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		MappableOptionalInt mod4 = mod3.mapAsMappableOptionalInt(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalInt().isPresent());
	}
	
	@Test
	public void testFlatMap() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntFunction<Optional<Integer>> mapper = d1 -> Optional.of(d1 * 2);
		Optional<Integer> mod2 = mod1.flatMap(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		Optional<Integer> mod4 = mod3.flatMap(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testFlatMapAOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntFunction<OptionalInt> mapper = d1 -> OptionalInt.of(d1 * 2);
		OptionalInt mod2 = mod1.flatMapAsOptionalInt(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsInt(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		OptionalInt mod4 = mod3.flatMapAsOptionalInt(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
		
	}
	
	@Test
	public void testFlatMapAsMappableOptionalInt() throws Exception {
		int d = ThreadLocalRandom.current().nextInt();
		MappableOptionalInt mod1 = MappableOptionalInt.of(d);
		IntFunction<MappableOptionalInt> mapper = d1 -> MappableOptionalInt.of(d1 * 2);
		MappableOptionalInt mod2 = mod1.flatMapAsMappableOptionalInt(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalInt().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalInt().getAsInt(), 0d);
		
		MappableOptionalInt mod3 = MappableOptionalInt.empty();
		MappableOptionalInt mod4 = mod3.flatMapAsMappableOptionalInt(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalInt().isPresent());
		
	}

}
