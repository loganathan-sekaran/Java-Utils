package org.ls.javautils.mappable.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * The  Mappable wrapper of OptionalInt.
 */
public class MappableOptionalInt {

	/** The optional int. */
	private OptionalInt optionalInt;

	/**
	 * Instantiates a new mappable optional int.
	 *
	 * @param optionalInt the optional int
	 */
	private MappableOptionalInt(OptionalInt optionalInt) {
		this.optionalInt = optionalInt;
	}

	/**
	 * Map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> map(IntFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return Optional.empty();
		else {
			return Optional.<U>ofNullable(mapper.apply(optionalInt.getAsInt()));
		}
	}

	/**
	 * Map as mappable optional int.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional int
	 */
	public MappableOptionalInt mapAsMappableOptionalInt(IntUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return MappableOptionalInt.empty();
		else {
			return MappableOptionalInt.of(mapper.applyAsInt(optionalInt.getAsInt()));
		}
	}
	
	/**
	 * Map as optional int.
	 *
	 * @param mapper the mapper
	 * @return the optional int
	 */
	public OptionalInt mapAsOptionalInt(IntUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return OptionalInt.empty();
		else {
			return OptionalInt.of(mapper.applyAsInt(optionalInt.getAsInt()));
		}
	}

	/**
	 * Flat map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> flatMap(IntFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalInt.getAsInt()));
		}
	}
	
	/**
	 * Flat map as mappable optional int.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional int
	 */
	public MappableOptionalInt flatMapAsMappableOptionalInt(IntFunction<MappableOptionalInt> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return MappableOptionalInt.empty();
		else {
			return mapper.apply(optionalInt.getAsInt());
		}
	}
	
	/**
	 * Flat map as optional int.
	 *
	 * @param mapper the mapper
	 * @return the optional int
	 */
	public OptionalInt flatMapAsOptionalInt(IntFunction<OptionalInt> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalInt.isPresent())
			return OptionalInt.empty();
		else {
			return mapper.apply(optionalInt.getAsInt());
		}
	}
	
	/**
	 * Gets the optional int.
	 *
	 * @return the optional int
	 */
	public OptionalInt getOptionalInt() {
		return optionalInt;
	}

	/**
	 * Of.
	 *
	 * @param optionalInt the optional int
	 * @return the mappable optional int
	 */
	public static MappableOptionalInt of(OptionalInt optionalInt) {
		return new MappableOptionalInt(optionalInt);
	}
	

	/**
	 * Of.
	 *
	 * @param value the value
	 * @return the mappable optional int
	 */
	public static MappableOptionalInt of(int value) {
		return MappableOptionalInt.of(OptionalInt.of(value));
	}
	
	/**
	 * Empty.
	 *
	 * @return the mappable optional int
	 */
	public static MappableOptionalInt empty() {
		return MappableOptionalInt.of(OptionalInt.empty());
	}

}
