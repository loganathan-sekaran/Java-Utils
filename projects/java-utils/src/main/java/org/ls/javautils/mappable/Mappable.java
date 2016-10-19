package org.ls.javautils.mappable;

import java.util.Optional;
import java.util.function.Function;

public interface Mappable<T> {
	
	public <U> Optional<U> map(Function<? super T, ? extends U> mapper);

	public <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper);
	
}
