# Java-Utils v1.0.2
##Mappable Optionals
This library contains Mappable counterparts of OptionalInt, OptionalLong and OptionalDouble. This Mappable versions allows us to avoid boxing of primitive data typed streams. This implementation is done because the current versions of OptionalInt, OptionalLong and OptionalDouble do not provide a map or flatMap method, which forces us to use the Boxed verison of Optional.

##Stream Util
This library contains the StreamUtil, that contains flatten methods to flatten any stream of optionals to the stream of the type contained in the optionals. These flatten methods also supports boxed and non-boxed types of streams.

##Optional Util
This library contains the OptionalUtil, that flattens any optional of optional of any type to an optional of the type. Optional of a non-boxed optional type can also be flattened.
