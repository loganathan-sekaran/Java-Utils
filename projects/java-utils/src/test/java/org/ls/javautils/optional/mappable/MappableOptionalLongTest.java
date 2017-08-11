package org.ls.javautils.optional.mappable;

import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;

import org.junit.Assert;
import org.junit.Test;
import org.ls.javautils.optional.mappable.MappableOptionalLong;

public class MappableOptionalLongTest  {
	@Test
	public void testOfOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mappableOptionalLong = MappableOptionalLong.of(OptionalLong.of(d));
		Assert.assertNotNull(mappableOptionalLong);
		Assert.assertNotNull(mappableOptionalLong.getOptionalLong());
		Assert.assertEquals(d, mappableOptionalLong.getOptionalLong().getAsLong(),0d);
		
	}

	@Test
	public void testOfLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mappableOptionalLong = MappableOptionalLong.of(d);
		Assert.assertNotNull(mappableOptionalLong);
		Assert.assertNotNull(mappableOptionalLong.getOptionalLong());
		Assert.assertEquals(d, mappableOptionalLong.getOptionalLong().getAsLong(),0d);
	}

	@Test
	public void testEmpty() throws Exception {
		MappableOptionalLong mappableOptionalLong = MappableOptionalLong.empty();
		Assert.assertNotNull(mappableOptionalLong);
		Assert.assertNotNull(mappableOptionalLong.getOptionalLong());
		Assert.assertFalse(mappableOptionalLong.getOptionalLong().isPresent());
	}

	@Test
	public void testGetOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mappableOptionalLong = MappableOptionalLong.of(d);
		Assert.assertNotNull(mappableOptionalLong);
		Assert.assertNotNull(mappableOptionalLong.getOptionalLong());
		Assert.assertEquals(d, mappableOptionalLong.getOptionalLong().getAsLong(),0d);
	}

	@Test
	public void testMap() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongFunction<Long> mapper = d1 -> d1 * 2;
		Optional<Long> mod2 = mod1.map(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		Optional<Long> mod4 = mod3.map(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testMapAsOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongUnaryOperator mapper = d1 -> d1 * 2;
		OptionalLong mod2 = mod1.mapAsOptionalLong(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsLong(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		OptionalLong mod4 = mod3.mapAsOptionalLong(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}

	@Test
	public void testMapAsMappableOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongUnaryOperator mapper = d1 -> d1 * 2;
		MappableOptionalLong mod2 = mod1.mapAsMappableOptionalLong(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalLong().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalLong().getAsLong(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		MappableOptionalLong mod4 = mod3.mapAsMappableOptionalLong(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalLong().isPresent());
	}
	
	@Test
	public void testFlatMap() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongFunction<Optional<Long>> mapper = d1 -> Optional.of(d1 * 2);
		Optional<Long> mod2 = mod1.flatMap(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.get(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		Optional<Long> mod4 = mod3.flatMap(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
	}
	
	@Test
	public void testFlatMapAOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongFunction<OptionalLong> mapper = d1 -> OptionalLong.of(d1 * 2);
		OptionalLong mod2 = mod1.flatMapAsOptionalLong(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.isPresent());
		Assert.assertEquals(d * 2, mod2.getAsLong(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		OptionalLong mod4 = mod3.flatMapAsOptionalLong(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.isPresent());
		
	}
	
	@Test
	public void testFlatMapAsMappableOptionalLong() throws Exception {
		long d = ThreadLocalRandom.current().nextLong();
		MappableOptionalLong mod1 = MappableOptionalLong.of(d);
		LongFunction<MappableOptionalLong> mapper = d1 -> MappableOptionalLong.of(d1 * 2);
		MappableOptionalLong mod2 = mod1.flatMapAsMappableOptionalLong(mapper);
		
		// Checks if the mapper is applied
		Assert.assertTrue(mod2.getOptionalLong().isPresent());
		Assert.assertEquals(d * 2, mod2.getOptionalLong().getAsLong(), 0d);
		
		MappableOptionalLong mod3 = MappableOptionalLong.empty();
		MappableOptionalLong mod4 = mod3.flatMapAsMappableOptionalLong(mapper);
		
		// Checks if the mapper is not applied
		Assert.assertFalse(mod4.getOptionalLong().isPresent());
		
	}


}
