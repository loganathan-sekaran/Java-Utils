# Java-Utils v1.0.0

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.vishag/java-utils/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.vishag/java-utils)
[![Build Status](https://travis-ci.org/loganathan001/Java-Utils.svg?branch=master)](https://travis-ci.org/loganathan001/Java-Utils)
[![Coverage Status](https://coveralls.io/repos/github/loganathan001/Java-Utils/badge.svg?branch=master)](https://coveralls.io/github/loganathan001/Java-Utils?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a2fef06aa2e946ca86a5ea05fbfccdc3)](https://www.codacy.com/app/loganathan001/Java-Utils?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=loganathan001/Java-Utils&amp;utm_campaign=Badge_Grade)
[![HitCount](http://hits.dwyl.io/loganathan001/loganathan001/Java-Utils.svg)](http://hits.dwyl.io/loganathan001/loganathan001/Java-Utils)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/loganathan001/Java-Utils/issues)

##Mappable Optionals
This library contains Mappable counterparts of OptionalInt, OptionalLong and OptionalDouble. This Mappable versions allows us to avoid boxing of primitive data typed streams. This implementation is done because the current versions of OptionalInt, OptionalLong and OptionalDouble do not provide a map or flatMap method, which forces us to use the Boxed verison of Optional.

##Stream Util
This library contains the StreamUtil, that contains flatten methods to flatten any stream of optionals to the stream of the type contained in the optionals. These flatten methods also supports boxed and non-boxed types of streams.

##Optional Util
This library contains the OptionalUtil, that flattens any optional of optional of any type to an optional of the type. Optional of a non-boxed optional type can also be flattened.

##Examples
Added an example project that demonstrates the use of this Library.
