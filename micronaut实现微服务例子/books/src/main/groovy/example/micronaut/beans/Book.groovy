package example.micronaut.beans

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
class Book {
    String isbn
    String name
}