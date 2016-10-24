package org.ls.javautils.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Function;

/**
 * The OptionalUtil.
 * 
 * @author Loganathan.S (loganathan001@gmail.com)
 * 
 */
public enum OptionalUtil {
	;
	
	/**
	 * Flatten.
	 *
	 * @param <T> the generic type
	 * @param optionalOfOptional the optional of optional
	 * @return the optional
	 */
	public static <T> Optional<T> flatten(Optional<Optional<T>> optionalOfOptional) {
		return optionalOfOptional.flatMap(Function.identity());
	}
	
	/**
	 * Flatten as optional double.
	 *
	 * @param optionalOfOptionalDouble the optional of optional double
	 * @return the optional double
	 */
	public static OptionalDouble flattenAsOptionalDouble(Optional<OptionalDouble> optionalOfOptionalDouble) {
		return optionalOfOptionalDouble.map(Function.identity()).orElse(OptionalDouble.empty());
	}
	
	/**
	 * Flatten as optional int.
	 *
	 * @param optionalOfOptionalInt the optional of optional int
	 * @return the optional int
	 */
	public static OptionalInt flattenAsOptionalInt(Optional<OptionalInt> optionalOfOptionalInt) {
		return optionalOfOptionalInt.map(Function.identity()).orElse(OptionalInt.empty());
	}
	
	/**
	 * Flatten as optional long.
	 *
	 * @param optionalOfOptionalLong the optional of optional long
	 * @return the optional long
	 */
	public static OptionalLong flattenAsOptionalLong(Optional<OptionalLong> optionalOfOptionalLong) {
		return optionalOfOptionalLong.map(Function.identity()).orElse(OptionalLong.empty());
	}
	
}
