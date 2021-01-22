package stw.jamez.ns.demo.util

interface LoginCallback{
    fun success()
    fun fail(errorMsg: String)
}