package stw.jamez.ns.demo.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import stw.jamez.ns.demo.BuildConfig

class RetrofitService{
    companion object {
        fun build(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.Base_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}