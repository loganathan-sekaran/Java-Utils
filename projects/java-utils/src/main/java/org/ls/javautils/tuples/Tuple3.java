package org.ls.javautils.tuples;

public final class Tuple3<A, B, C> {
	final private A a;
	final private B b;
	final private C c;

	public Tuple3(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public A get1() {
		return a;
	}

	public B get2() {
		return b;
	}

	public C get3() {
		return c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple3 other = (Tuple3) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tuple3 [1=" + a + ", 2=" + b + ", 3=" + c + "]";
	}

}
