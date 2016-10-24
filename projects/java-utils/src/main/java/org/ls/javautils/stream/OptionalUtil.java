package org.ls.javautils.stream;

import java.util.Optional;
import java.util.function.Function;

/**
 * The OptionalUtil.
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
	
}
