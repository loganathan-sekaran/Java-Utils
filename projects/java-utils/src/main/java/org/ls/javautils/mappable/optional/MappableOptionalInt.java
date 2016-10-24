package org.ls.javautils.mappable.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class MappableOptionalInt {

	private OptionalInt optionalInt;

	private MappableOptionalInt(OptionalInt optionalInt) {
		this.optionalInt = optionalInt;
	}

	public <U> Optional<U> map(IntFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return Optional.empty();
		else {
			return Optional.<U>ofNullable(mapper.apply(optionalInt.getAsInt()));
		}
	}

	public MappableOptionalInt mapAsMappableOptionalInt(IntUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return MappableOptionalInt.empty();
		else {
			return MappableOptionalInt.of(mapper.applyAsInt(optionalInt.getAsInt()));
		}
	}
	
	public OptionalInt mapAsOptionalInt(IntUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return OptionalInt.empty();
		else {
			return OptionalInt.of(mapper.applyAsInt(optionalInt.getAsInt()));
		}
	}

	public <U> Optional<U> flatMap(IntFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalInt.getAsInt()));
		}
	}
	
	public MappableOptionalInt flatMapAsMappableOptionalInt(IntFunction<MappableOptionalInt> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return MappableOptionalInt.empty();
		else {
			return mapper.apply(optionalInt.getAsInt());
		}
	}
	
	public OptionalInt flatMapAsOptionalInt(IntFunction<OptionalInt> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return OptionalInt.empty();
		else {
			return mapper.apply(optionalInt.getAsInt());
		}
	}
	
	public OptionalInt getOptionalInt() {
		return optionalInt;
	}

	public static MappableOptionalInt of(OptionalInt optionalInt) {
		return new MappableOptionalInt(optionalInt);
	}
	

	public static MappableOptionalInt of(int value) {
		return MappableOptionalInt.of(OptionalInt.of(value));
	}
	
	public static MappableOptionalInt empty() {
		return MappableOptionalInt.of(OptionalInt.empty());
	}

}
