package stw.jamez.ns.demo.service

abstract class UseCase<T> {
    abstract fun execute(): T
}