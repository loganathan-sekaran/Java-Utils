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

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Function;

/**
 * The OptionalUtil.
 * 
 * @author Loganathan.S (loganathan001@gmail.com)
 * 
 */
public enum OptionalUtil {
	;
	
	/**
	 * Flatten.
	 *
	 * @param <T> the generic type
	 * @param optionalOfOptional the optional of optional
	 * @return the optional
	 */
	public static <T> Optional<T> flatten(Optional<Optional<T>> optionalOfOptional) {
		return optionalOfOptional.flatMap(Function.identity());
	}
	
	/**
	 * Flatten as optional double.
	 *
	 * @param optionalOfOptionalDouble the optional of optional double
	 * @return the optional double
	 */
	public static OptionalDouble flattenAsOptionalDouble(Optional<OptionalDouble> optionalOfOptionalDouble) {
		return optionalOfOptionalDouble.map(Function.identity()).orElse(OptionalDouble.empty());
	}
	
	/**
	 * Flatten as optional int.
	 *
	 * @param optionalOfOptionalInt the optional of optional int
	 * @return the optional int
	 */
	public static OptionalInt flattenAsOptionalInt(Optional<OptionalInt> optionalOfOptionalInt) {
		return optionalOfOptionalInt.map(Function.identity()).orElse(OptionalInt.empty());
	}
	
	/**
	 * Flatten as optional long.
	 *
	 * @param optionalOfOptionalLong the optional of optional long
	 * @return the optional long
	 */
	public static OptionalLong flattenAsOptionalLong(Optional<OptionalLong> optionalOfOptionalLong) {
		return optionalOfOptionalLong.map(Function.identity()).orElse(OptionalLong.empty());
	}
	
}
