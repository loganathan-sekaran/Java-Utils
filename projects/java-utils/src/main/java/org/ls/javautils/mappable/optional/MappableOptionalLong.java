package org.ls.javautils.mappable.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;

public class MappableOptionalLong {

	private OptionalLong optionalLong;

	private MappableOptionalLong(OptionalLong optionalLong) {
		this.optionalLong = optionalLong;
	}

	public <U> Optional<U> map(LongFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return Optional.empty();
		else {
			return Optional.<U>ofNullable(mapper.apply(optionalLong.getAsLong()));
		}
	}

	public MappableOptionalLong mapAsMappableOptionalLong(LongUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return MappableOptionalLong.empty();
		else {
			return MappableOptionalLong.of(mapper.applyAsLong(optionalLong.getAsLong()));
		}
	}

	public <U> Optional<U> flatMap(LongFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalLong.getAsLong()));
		}
	}
	
	public MappableOptionalLong flatMapAsMappableOptionalLong(LongFunction<MappableOptionalLong> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return MappableOptionalLong.empty();
		else {
			return mapper.apply(optionalLong.getAsLong());
		}
	}
	
	public OptionalLong getOptionalLong() {
		return optionalLong;
	}

	public static MappableOptionalLong of(OptionalLong optionalLong) {
		return new MappableOptionalLong(optionalLong);
	}
	

	public static MappableOptionalLong of(long value) {
		return MappableOptionalLong.of(OptionalLong.of(value));
	}
	
	public static MappableOptionalLong empty() {
		return MappableOptionalLong.of(OptionalLong.empty());
	}

}
