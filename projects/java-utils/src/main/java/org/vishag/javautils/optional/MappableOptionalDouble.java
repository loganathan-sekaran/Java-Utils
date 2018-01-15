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
import java.util.OptionalDouble;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

/**
 * The Mappable wrapper of OptionalDouble.
 * 
 * @author Loganathan.S (loganathan001@gmail.com)
 * 
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
