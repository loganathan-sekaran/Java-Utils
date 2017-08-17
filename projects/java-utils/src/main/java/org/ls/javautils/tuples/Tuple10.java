package org.ls.javautils.tuples;

public final class Tuple10<A, B, C, D, E, F, G, H, I, J> {
	final private A a;
	final private B b;
	final private C c;
	final private D d;
	final private E e;
	final private F f;
	final private G g;
	final private H h;
	final private I i;
	final private J j;

	public Tuple10(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
		this.j = j;
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

	public D get4() {
		return d;
	}

	public E get5() {
		return e;
	}

	public F get6() {
		return f;
	}

	public G get7() {
		return g;
	}

	public H get8() {
		return h;
	}

	public I get9() {
		return i;
	}

	public J get10() {
		return j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((j == null) ? 0 : j.hashCode());
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
		Tuple10 other = (Tuple10) obj;
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
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (g == null) {
			if (other.g != null)
				return false;
		} else if (!g.equals(other.g))
			return false;
		if (h == null) {
			if (other.h != null)
				return false;
		} else if (!h.equals(other.h))
			return false;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tuple10 [1=" + a + ", 2=" + b + ", 3=" + c + ", 4=" + d + ", 5=" + e + ", 6=" + f + ", 7=" + g + ", 8="
				+ h + ", 9=" + i + ", 10=" + j + "]";
	}

}
