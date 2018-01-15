package org.vishag.javautils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ org.vishag.javautils.optional.TestSuite.class, 
	org.vishag.javautils.stream.TestSuite.class, 
	org.vishag.javautils.tuples.TestSuite.class,
	org.vishag.javautils.optional.TestSuite.class})
public class TestSuiteAll { // nothing
}
