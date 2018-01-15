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
import java.util.OptionalLong;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;

/**
 * The  Mappable wrapper of OptionalLong.
 * 
 * @author Loganathan.S (loganathan001@gmail.com)
 * 
 */
public class MappableOptionalLong {

	/** The optional long. */
	private OptionalLong optionalLong;

	/**
	 * Instantiates a new mappable optional long.
	 *
	 * @param optionalLong the optional long
	 */
	private MappableOptionalLong(OptionalLong optionalLong) {
		this.optionalLong = optionalLong;
	}

	/**
	 * Map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> map(LongFunction<? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return Optional.empty();
		else {
			return Optional.<U>ofNullable(mapper.apply(optionalLong.getAsLong()));
		}
	}

	/**
	 * Map as mappable optional long.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional long
	 */
	public MappableOptionalLong mapAsMappableOptionalLong(LongUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return MappableOptionalLong.empty();
		else {
			return MappableOptionalLong.of(mapper.applyAsLong(optionalLong.getAsLong()));
		}
	}
	
	/**
	 * Map as optional long.
	 *
	 * @param mapper the mapper
	 * @return the optional long
	 */
	public OptionalLong mapAsOptionalLong(LongUnaryOperator mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return OptionalLong.empty();
		else {
			return OptionalLong.of(mapper.applyAsLong(optionalLong.getAsLong()));
		}
	}

	/**
	 * Flat map.
	 *
	 * @param <U> the generic type
	 * @param mapper the mapper
	 * @return the optional
	 */
	public <U> Optional<U> flatMap(LongFunction<Optional<U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return Optional.empty();
		else {
			return Objects.requireNonNull(mapper.apply(optionalLong.getAsLong()));
		}
	}
	
	/**
	 * Flat map as mappable optional long.
	 *
	 * @param mapper the mapper
	 * @return the mappable optional long
	 */
	public MappableOptionalLong flatMapAsMappableOptionalLong(LongFunction<MappableOptionalLong> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return MappableOptionalLong.empty();
		else {
			return mapper.apply(optionalLong.getAsLong());
		}
	}
	
	/**
	 * Flat map as optional long.
	 *
	 * @param mapper the mapper
	 * @return the optional long
	 */
	public OptionalLong flatMapAsOptionalLong(LongFunction<OptionalLong> mapper) {
		Objects.requireNonNull(mapper);
		if (!optionalLong.isPresent())
			return OptionalLong.empty();
		else {
			return mapper.apply(optionalLong.getAsLong());
		}
	}
	
	/**
	 * Gets the optional long.
	 *
	 * @return the optional long
	 */
	public OptionalLong getOptionalLong() {
		return optionalLong;
	}

	/**
	 * Of.
	 *
	 * @param optionalLong the optional long
	 * @return the mappable optional long
	 */
	public static MappableOptionalLong of(OptionalLong optionalLong) {
		return new MappableOptionalLong(optionalLong);
	}
	

	/**
	 * Of.
	 *
	 * @param value the value
	 * @return the mappable optional long
	 */
	public static MappableOptionalLong of(long value) {
		return MappableOptionalLong.of(OptionalLong.of(value));
	}
	
	/**
	 * Empty.
	 *
	 * @return the mappable optional long
	 */
	public static MappableOptionalLong empty() {
		return MappableOptionalLong.of(OptionalLong.empty());
	}

}
