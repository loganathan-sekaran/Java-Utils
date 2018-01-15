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
package org.vishag.javautils.examples;

import java.util.Optional;
import java.util.OptionalDouble;

import org.vishag.javautils.optional.MappableOptionalDouble;

/**
 * NewMath class elaborated from the Java-8 example of Jose Paumard
 *
 */
public class NewMath {

	public static Optional<Double> sqrt(double d) {
		return d > 0 ? Optional.of(Math.sqrt(d)) : Optional.empty();
	}

	public static Optional<Double> inv(double d) {
		return d != 0 ? Optional.of(1 / d) : Optional.empty();
	}

	public static OptionalDouble sqrtAsOptionalDouble(double d) {
		return d > 0 ? OptionalDouble.of(Math.sqrt(d)) : OptionalDouble.empty();
	}

	public static OptionalDouble invAsOptionalDouble(double d) {
		return d != 0 ? OptionalDouble.of(1 / d) : OptionalDouble.empty();
	}

	public static MappableOptionalDouble sqrtAsMappableOptionalDouble(double d) {
		return d > 0 ? MappableOptionalDouble.of(Math.sqrt(d)) : MappableOptionalDouble.empty();
	}

	public static MappableOptionalDouble invAsMappableOptionalDouble(double d) {
		return d != 0 ? MappableOptionalDouble.of(1 / d) : MappableOptionalDouble.empty();
	}

}
