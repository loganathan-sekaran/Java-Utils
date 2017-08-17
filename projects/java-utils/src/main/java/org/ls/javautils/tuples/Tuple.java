package org.ls.javautils.tuples;

public final class Tuple {
	private Tuple() {
		throw new IllegalAccessError();
	}

	public static <A, B> Tuple2<A, B> of(A a, B b) {
		return new Tuple2<>(a, b);
	}

	public static <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {
		return new Tuple3<>(a, b, c);
	}

	public static <A, B, C, D> Tuple4<A, B, C, D> of(A a, B b, C c, D d) {
		return new Tuple4<>(a, b, c, d);
	}

	public static <A, B, C, D, E> Tuple5<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
		return new Tuple5<>(a, b, c, d, e);
	}

	public static <A, B, C, D, E, F> Tuple6<A, B, C, D, E, F> of(A a, B b, C c, D d, E e, F f) {
		return new Tuple6<>(a, b, c, d, e, f);
	}

	public static <A, B, C, D, E, F, G> Tuple7<A, B, C, D, E, F, G> of(A a, B b, C c, D d, E e, F f, G g) {
		return new Tuple7<>(a, b, c, d, e, f, g);
	}

	public static <A, B, C, D, E, F, G, H> Tuple8<A, B, C, D, E, F, G, H> of(A a, B b, C c, D d, E e, F f, G g, H h) {
		return new Tuple8<>(a, b, c, d, e, f, g, h);
	}

	public static <A, B, C, D, E, F, G, H, I> Tuple9<A, B, C, D, E, F, G, H, I> of(A a, B b, C c, D d, E e, F f, G g, H h,
			I i) {
		return new Tuple9<>(a, b, c, d, e, f, g, h, i);
	}

	public static <A, B, C, D, E, F, G, H, I, J> Tuple10<A, B, C, D, E, F, G, H, I, J> of(A a, B b, C c, D d, E e, F f, G g,
			H h, I i, J j) {
		return new Tuple10<>(a, b, c, d, e, f, g, h, i, j);
	}

}
