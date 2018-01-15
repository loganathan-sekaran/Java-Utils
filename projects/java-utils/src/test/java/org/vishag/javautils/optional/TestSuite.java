package org.vishag.javautils.optional;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ MappableOptionalLongTest.class, MappableOptionalDoubleTest.class, MappableOptionalIntTest.class,
		OptionalUtilTest.class })
public class TestSuite { // nothing
}
