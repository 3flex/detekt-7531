package bug

import kotlinx.serialization.Serializable

fun main() {
    println("Hello Detekt")
    println("A Serializer: ${SerializableClass.serializer()}")
}

@Serializable
class SerializableClass

actual fun myExpectFun() = Unit
