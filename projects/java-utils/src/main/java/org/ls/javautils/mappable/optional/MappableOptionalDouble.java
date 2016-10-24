package org.ls.javautils.mappable.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

/**
 * The Mappable wrapper of OptionalDouble.
 */
public class MappableOptionalDouble {

	/** The optional double. */
	private OptionalDouble optionalDouble;

	/**
	 * Instantiates a new mappable optional double.
	 *
	 * @param optionalDouble the optional double
	 */
	private MappableOptionalDouble(OptionalDouble optionalDouble) {
		this.optionalDouble = optionalDouble;
	}

	/**
	 * Map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> map(DoubleFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return Optional.empty();
		else {
			return Optional.<U>ofNullable(mapper.apply(optionalDouble.getAsDouble()));
		}
	}

	/**
	 * Map as mappable optional double.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional double
	 */
	public MappableOptionalDouble mapAsMappableOptionalDouble(DoubleUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return MappableOptionalDouble.empty();
		else {
			return MappableOptionalDouble.of(mapper.applyAsDouble(optionalDouble.getAsDouble()));
		}
	}
	
	/**
	 * Map as optional double.
	 *
	 * @param mapper the mapper
	 * @return the optional double
	 */
	public OptionalDouble mapAsOptionalDouble(DoubleUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return OptionalDouble.empty();
		else {
			return OptionalDouble.of(mapper.applyAsDouble(optionalDouble.getAsDouble()));
		}
	}

	/**
	 * Flat map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> flatMap(DoubleFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalDouble.getAsDouble()));
		}
	}
	
	/**
	 * Flat map as mappable optional double.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional double
	 */
	public MappableOptionalDouble flatMapAsMappableOptionalDouble(DoubleFunction<MappableOptionalDouble> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return MappableOptionalDouble.empty();
		else {
			return mapper.apply(optionalDouble.getAsDouble());
		}
	}
	
	/**
	 * Flat map as optional double.
	 *
	 * @param mapper the mapper
	 * @return the optional double
	 */
	public OptionalDouble flatMapAsOptionalDouble(DoubleFunction<OptionalDouble> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalDouble.isPresent())
			return OptionalDouble.empty();
		else {
			return mapper.apply(optionalDouble.getAsDouble());
		}
	}
	
	/**
	 * Gets the optional double.
	 *
	 * @return the optional double
	 */
	public OptionalDouble getOptionalDouble() {
		return optionalDouble;
	}

	/**
	 * Of.
	 *
	 * @param optionalDouble the optional double
	 * @return the mappable optional double
	 */
	public static MappableOptionalDouble of(OptionalDouble optionalDouble) {
		return new MappableOptionalDouble(optionalDouble);
	}
	

	/**
	 * Of.
	 *
	 * @param value the value
	 * @return the mappable optional double
	 */
	public static MappableOptionalDouble of(double value) {
		return MappableOptionalDouble.of(OptionalDouble.of(value));
	}
	
	/**
	 * Empty.
	 *
	 * @return the mappable optional double
	 */
	public static MappableOptionalDouble empty() {
		return MappableOptionalDouble.of(OptionalDouble.empty());
	}

}
