package br.com.pet.schedulling.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}