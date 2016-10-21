package org.ls.javautils.stream;

import java.util.Optional;
import java.util.stream.Stream;

public enum StreamUtil {
	;

	public static <T> Stream<T> flatten(Stream<Optional<T>> optionalStream) {
		return optionalStream.filter(op -> op.isPresent()).flatMap(opt -> Stream.of(opt.get()));
	}
}
