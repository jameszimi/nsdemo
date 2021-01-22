package stw.jamez.ns.demo.service

sealed class UseCaseResponse<out T>

data class SuccessResponse<out T>(val value: T): UseCaseResponse<T>()

data class ErrorResponse<out T>(val error: String): UseCaseResponse<T>()