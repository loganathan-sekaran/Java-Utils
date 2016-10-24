package org.ls.javautils.examples;

import java.util.Optional;
import java.util.OptionalDouble;

import org.ls.javautils.optional.mappable.MappableOptionalDouble;

/**
 * NewMath class elaborated from the Java-8 example of Jose Paumard
 *
 */
public class NewMath {
	
	public static Optional<Double> sqrt(double d) {
		return d > 0 ? Optional.of(Math.sqrt(d)) : Optional.empty();
	}
	
	public static Optional<Double> inv(double d) {
		return d != 0 ? Optional.of(1/d) : Optional.empty();
	}
	
	public static OptionalDouble sqrtAsOptionalDouble(double d) {
		return d > 0 ? OptionalDouble.of(Math.sqrt(d)) : OptionalDouble.empty();
	}
	
	public static OptionalDouble invAsOptionalDouble(double d) {
		return d != 0 ? OptionalDouble.of(1/d) : OptionalDouble.empty();
	}
	
	public static MappableOptionalDouble sqrtAsMappableOptionalDouble(double d) {
		return d > 0 ? MappableOptionalDouble.of(Math.sqrt(d)) : MappableOptionalDouble.empty();
	}
	
	public static MappableOptionalDouble invAsMappableOptionalDouble(double d) {
		return d != 0 ? MappableOptionalDouble.of(1/d) : MappableOptionalDouble.empty();
	}

}
