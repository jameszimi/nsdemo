package stw.jamez.ns.demo.service

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.HttpException

abstract class SingleUseCase<T>(): UseCase<Observable<T>>() {
    fun execute(
        onResponse: (UseCaseResponse<T>) -> Unit
    ): Disposable {
        return this.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                onResponse(SuccessResponse(it))
            }, {
                it.printStackTrace()
                onResponse(ErrorResponse(it.getErrorString()))
            })
    }

    private fun Throwable.getErrorString(): String {
        var stringReturn = ""
        try {
            (this as HttpException).response()?.errorBody()?.string()?.let {
                val error = JSONObject(it)
                stringReturn =  error.get("description").toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return stringReturn
        }
    }
}