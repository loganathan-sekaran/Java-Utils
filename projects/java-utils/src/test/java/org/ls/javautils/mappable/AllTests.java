package org.ls.javautils.mappable;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.ls.javautils.mappable.optional.MappableOptionalDoubleTest;
import org.ls.javautils.mappable.optional.MappableOptionalIntTest;
import org.ls.javautils.mappable.optional.MappableOptionalLongTest;
import org.ls.javautils.stream.OptionalUtilTest;
import org.ls.javautils.stream.StreamUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ MappableOptionalDoubleTest.class, MappableOptionalIntTest.class, MappableOptionalLongTest.class,
		OptionalUtilTest.class, StreamUtilTest.class })
public class AllTests {
}
