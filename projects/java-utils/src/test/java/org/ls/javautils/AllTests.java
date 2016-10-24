package org.ls.javautils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.ls.javautils.optional.OptionalUtilTest;
import org.ls.javautils.optional.mappable.MappableOptionalDoubleTest;
import org.ls.javautils.optional.mappable.MappableOptionalIntTest;
import org.ls.javautils.optional.mappable.MappableOptionalLongTest;
import org.ls.javautils.stream.StreamUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ MappableOptionalDoubleTest.class, MappableOptionalIntTest.class, MappableOptionalLongTest.class,
		OptionalUtilTest.class, StreamUtilTest.class })
public class AllTests {
}
