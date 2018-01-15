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
package org.vishag.javautils.tuples;

/**
 * The Class Tuple.
 */
public final class Tuple {
	
	/**
	 * Instantiates a new tuple.
	 */
	private Tuple() {
		throw new IllegalAccessError();
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param a the a
	 * @param b the b
	 * @return the tuple 2
	 */
	public static <A, B> Tuple2<A, B> of(A a, B b) {
		return new Tuple2<>(a, b);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return the tuple 3
	 */
	public static <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {
		return new Tuple3<>(a, b, c);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @return the tuple 4
	 */
	public static <A, B, C, D> Tuple4<A, B, C, D> of(A a, B b, C c, D d) {
		return new Tuple4<>(a, b, c, d);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @return the tuple 5
	 */
	public static <A, B, C, D, E> Tuple5<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
		return new Tuple5<>(a, b, c, d, e);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param <F> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @param f the f
	 * @return the tuple 6
	 */
	public static <A, B, C, D, E, F> Tuple6<A, B, C, D, E, F> of(A a, B b, C c, D d, E e, F f) {
		return new Tuple6<>(a, b, c, d, e, f);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param <F> the generic type
	 * @param <G> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @param f the f
	 * @param g the g
	 * @return the tuple 7
	 */
	public static <A, B, C, D, E, F, G> Tuple7<A, B, C, D, E, F, G> of(A a, B b, C c, D d, E e, F f, G g) {
		return new Tuple7<>(a, b, c, d, e, f, g);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param <F> the generic type
	 * @param <G> the generic type
	 * @param <H> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @param f the f
	 * @param g the g
	 * @param h the h
	 * @return the tuple 8
	 */
	public static <A, B, C, D, E, F, G, H> Tuple8<A, B, C, D, E, F, G, H> of(A a, B b, C c, D d, E e, F f, G g, H h) {
		return new Tuple8<>(a, b, c, d, e, f, g, h);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param <F> the generic type
	 * @param <G> the generic type
	 * @param <H> the generic type
	 * @param <I> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @param f the f
	 * @param g the g
	 * @param h the h
	 * @param i the i
	 * @return the tuple 9
	 */
	public static <A, B, C, D, E, F, G, H, I> Tuple9<A, B, C, D, E, F, G, H, I> of(A a, B b, C c, D d, E e, F f, G g, H h,
			I i) {
		return new Tuple9<>(a, b, c, d, e, f, g, h, i);
	}

	/**
	 * Of.
	 *
	 * @param <A> the generic type
	 * @param <B> the generic type
	 * @param <C> the generic type
	 * @param <D> the generic type
	 * @param <E> the element type
	 * @param <F> the generic type
	 * @param <G> the generic type
	 * @param <H> the generic type
	 * @param <I> the generic type
	 * @param <J> the generic type
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param e the e
	 * @param f the f
	 * @param g the g
	 * @param h the h
	 * @param i the i
	 * @param j the j
	 * @return the tuple 10
	 */
	public static <A, B, C, D, E, F, G, H, I, J> Tuple10<A, B, C, D, E, F, G, H, I, J> of(A a, B b, C c, D d, E e, F f, G g,
			H h, I i, J j) {
		return new Tuple10<>(a, b, c, d, e, f, g, h, i, j);
	}

}
