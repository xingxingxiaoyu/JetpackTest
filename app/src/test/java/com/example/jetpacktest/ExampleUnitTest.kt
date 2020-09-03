package com.example.jetpacktest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var person = Person("xujiafeng")

        var applyResult = person.apply { name = "xujiafeng1" }

        var alsoResult = person.also { it.name = "xujiafeng2" }

        var letResult = person.let { it.name = "xujiafeng3" }

        var withResult = with(person) { name = "xujiafeng4" }

        var runResult = person.run { name = "xujiafeng5" }

        println(applyResult.javaClass.name)
        println(alsoResult.javaClass.name)
        println(letResult.javaClass.name)
        println(withResult.javaClass.name)
        println(runResult.javaClass.name)


    }

    class Person(var name: String)
}
