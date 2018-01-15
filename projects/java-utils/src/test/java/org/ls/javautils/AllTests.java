package org.ls.javautils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.ls.javautils.optional.MappableOptionalDoubleTest;
import org.ls.javautils.optional.MappableOptionalIntTest;
import org.ls.javautils.optional.MappableOptionalLongTest;
import org.ls.javautils.optional.OptionalUtilTest;
import org.ls.javautils.stream.StreamUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ MappableOptionalDoubleTest.class, MappableOptionalIntTest.class, MappableOptionalLongTest.class,
		OptionalUtilTest.class, StreamUtilTest.class })
public class AllTests {
}
