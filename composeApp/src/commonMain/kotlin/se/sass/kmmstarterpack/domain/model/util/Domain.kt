package se.sass.kmmstarterpack.domain.model.util

interface Domain<T> {
    fun cast(): T
}