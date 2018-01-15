/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.vishag.javautils.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * The  Mappable wrapper of OptionalInt.
 * 
 * @author Loganathan.S (loganathan001@gmail.com)
 * 
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
