package org.ls.javautils.stream;

import java.util.Optional;
import java.util.function.Function;

public enum OptionalUtil {
	;
	
	public static <T> Optional<T> flatten(Optional<Optional<T>> optionalOfOptional) {
		return optionalOfOptional.flatMap(Function.identity());
	}
	
}
