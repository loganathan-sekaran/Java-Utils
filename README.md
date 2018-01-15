# Java-Utils v1.0.0

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.vishag/java-utils/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.vishag/java-utils)
[![Build Status](https://travis-ci.org/loganathan001/Java-Utils.svg?branch=master)](https://travis-ci.org/loganathan001/Java-Utils)
[![Coverage Status](https://coveralls.io/repos/github/loganathan001/Java-Utils/badge.svg?branch=master)](https://coveralls.io/github/loganathan001/Java-Utils?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a2fef06aa2e946ca86a5ea05fbfccdc3)](https://www.codacy.com/app/loganathan001/Java-Utils?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=loganathan001/Java-Utils&amp;utm_campaign=Badge_Grade)
[![HitCount](http://hits.dwyl.io/loganathan001/loganathan001/Java-Utils.svg)](http://hits.dwyl.io/loganathan001/loganathan001/Java-Utils)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/loganathan001/Java-Utils/issues)

##Stream Util
This library contains the StreamUtil, that contains flatten methods to flatten any stream of optionals to the stream of the type contained in the optionals. These flatten methods also supports boxed and non-boxed types of streams.

##Optional Util
This library contains the OptionalUtil, that flattens any optional of optional of any type to an optional of the type. Optional of a non-boxed optional type can also be flattened.

##Optional with Throwable
A new OptionalWithThrowable is added so that any map/flatMap/filter/ifPresent operation will accept the corresponding 'Funtional Interface with Throwable' which are added in this Java Utlitity.

##Funtional Interfaces with Throwable
With regular Functional Interfaces, exceptions or errors are be not able chain the exceptions thrown inside the method to the caller. This required to handle the exception within the method definition itself. To handle this requirement new kind of Funtional Interfaces namely PredicateWithThrowable, FuntionWithThrowable, ConsumerWithThrowable and BiFunctionWithThrowable are added. Some of these are also used with OptionalWithThrowable implementation.

##Tuples
Inspired by Scala Tuples, this Java Utility includes convinent Generic Tuples from Tuple2 to Tuple10 and a convinient helper factory called Tuples to create them.

##Mappable Optionals
This library contains Mappable counterparts of OptionalInt, OptionalLong and OptionalDouble. This Mappable versions allows us to avoid boxing of primitive data typed streams. This implementation is done because the current versions of OptionalInt, OptionalLong and OptionalDouble do not provide a map or flatMap method, which forces us to use the Boxed verison of Optional.

##Examples
Added an example project that demonstrates the use of this Library.

Also, please look into the <a href="https://github.com/loganathan001/Java-Utils/tree/master/projects/java-utils/src/test/java/org/vishag/javautils">Unit tests</a> for all the use-cases and examples.

To install the latest version, add the below pom dependency entry:
```
<dependency>
  <groupId>org.vishag</groupId>
  <artifactId>java-utils</artifactId>
  <version>1.0.0</version>
</dependency>
```
