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
package org.vishag.javautils.function;

/**
 * The Interface BiFunctionWithThrowable.
 *
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <R> the generic type
 * @param <E> the element type
 */
@FunctionalInterface
public interface BiFunctionWithThrowable<T1, T2, R, E extends Throwable>{
	 
 	/**
 	 * Apply.
 	 *
 	 * @param t1 the t 1
 	 * @param t2 the t 2
 	 * @return the r
 	 * @throws E the e
 	 */
 	R apply(T1 t1, T2 t2) throws E;
}
