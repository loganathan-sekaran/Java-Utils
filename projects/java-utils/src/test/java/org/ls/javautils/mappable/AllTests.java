package org.ls.javautils.mappable;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.ls.javautils.mappable.optional.MappableOptionalDoubleTest;
import org.ls.javautils.mappable.optional.MappableOptionalIntTest;

@RunWith(Suite.class)
@SuiteClasses({ MappableOptionalDoubleTest.class, MappableOptionalIntTest.class, MappableOptionalDoubleTest.class })
public class AllTests {
}
