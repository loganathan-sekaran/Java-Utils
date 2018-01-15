package org.vishag.javautils.tuples;

import javax.annotation.Generated;

import org.junit.Assert;
import org.junit.Test;

@Generated(value = "org.junit-tools-1.0.6")
public class TupleTest {

	private static final Object OBJECT = new Object();

	@Test
	public void testOf() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Tuple2<String, Integer> result;

		// default test
		result = Tuple.of(a, b);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
	}

	@Test
	public void testOf_1() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		Tuple3<String, Integer, Object> result;

		// default test
		result = Tuple.of(a, b, c);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
	}

	@Test
	public void testOf_2() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		Tuple4<String, Integer, Object, String> result;

		// default test
		result = Tuple.of(a, b, c, d);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
	}

	@Test
	public void testOf_3() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		Tuple5<String, Integer, Object, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
	}

	@Test
	public void testOf_4() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		String f = "cccc";
		Tuple6<String, Integer, Object, String, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e, f);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
		Assert.assertEquals(f, result.get6());
	}

	@Test
	public void testOf_5() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		String f = "cccc";
		String g = "dddd";
		Tuple7<String, Integer, Object, String, String, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e, f, g);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
		Assert.assertEquals(f, result.get6());
		Assert.assertEquals(g, result.get7());
	}

	@Test
	public void testOf_6() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		String f = "cccc";
		String g = "dddd";
		String h = "eeee";
		Tuple8<String, Integer, Object, String, String, String, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e, f, g, h);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
		Assert.assertEquals(f, result.get6());
		Assert.assertEquals(g, result.get7());
		Assert.assertEquals(h, result.get8());
	}

	@Test
	public void testOf_7() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		String f = "cccc";
		String g = "dddd";
		String h = "eeee";
		String i = "ffff";
		Tuple9<String, Integer, Object, String, String, String, String, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e, f, g, h, i);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
		Assert.assertEquals(f, result.get6());
		Assert.assertEquals(g, result.get7());
		Assert.assertEquals(h, result.get8());
		Assert.assertEquals(i, result.get9());
	}

	@Test
	public void testOf_8() throws Exception {
		String a = "abcd";
		Integer b = 100;
		Object c = getTestObject();
		String d = "aaaa";
		String e = "bbbb";
		String f = "cccc";
		String g = "dddd";
		String h = "eeee";
		String i = "ffff";
		String j = "gggg";
		Tuple10<String, Integer, Object, String, String, String, String, String, String, String> result;

		// default test
		result = Tuple.of(a, b, c, d, e, f, g, h, i, j);

		Assert.assertEquals(a, result.get1());
		Assert.assertEquals(b, result.get2());
		Assert.assertEquals(c, result.get3());
		Assert.assertEquals(d, result.get4());
		Assert.assertEquals(e, result.get5());
		Assert.assertEquals(f, result.get6());
		Assert.assertEquals(g, result.get7());
		Assert.assertEquals(h, result.get8());
		Assert.assertEquals(i, result.get9());
		Assert.assertEquals(j, result.get10());
	}

	private Object getTestObject() {
		return OBJECT;
	}
}