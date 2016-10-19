package org.ls.javautil.mappable.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

public class MappableOptionalDouble {

	private OptionalDouble optionalDouble;

	private MappableOptionalDouble(OptionalDouble optionalDouble) {
		this.optionalDouble = optionalDouble;
	}

	public <U> Optional<U> map(DoubleFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return Optional.empty();
		else {
			return Optional.ofNullable(mapper.apply(optionalDouble.getAsDouble()));
		}
	}

	public MappableOptionalDouble mapAsMappableOptionalDouble(DoubleUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return MappableOptionalDouble.empty();
		else {
			return MappableOptionalDouble.of(mapper.applyAsDouble(optionalDouble.getAsDouble()));
		}
	}

	public <U> Optional<U> flatMap(DoubleFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalDouble.getAsDouble()));
		}
	}
	
	public MappableOptionalDouble flatMapAsMappableOptionalDouble(DoubleFunction<MappableOptionalDouble> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return MappableOptionalDouble.empty();
		else {
			return mapper.apply(optionalDouble.getAsDouble());
		}
	}
	
	public OptionalDouble getOptionalDouble() {
		return optionalDouble;
	}

	public static MappableOptionalDouble of(OptionalDouble optionalDouble) {
		return new MappableOptionalDouble(optionalDouble);
	}
	

	public static MappableOptionalDouble of(double value) {
		return MappableOptionalDouble.of(OptionalDouble.of(value));
	}
	
	public static MappableOptionalDouble empty() {
		return MappableOptionalDouble.of(OptionalDouble.empty());
	}

}
