package com.example.rideng.repository

import android.util.Log
import com.example.rideng.network.ApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.Serializable

open class BaseRepository {

    suspend fun <T> coroutineHandler(
        dispatcher: CoroutineDispatcher,
        apiRequest: suspend () -> T
    ): Serializable {
        return withContext(dispatcher) {
            try {
                Result.success(apiRequest.invoke())
            } catch (e: HttpException){
                val errorCode = e.code()
                val errorMessage = throwableResponse(e)
                Log.d("Network Error", "$errorCode: $errorMessage")
            }
        }
    }

    open val dispatcher = Dispatchers.IO

    private fun throwableResponse(exception: HttpException): ApiResponse? {
        return try {
            exception.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                    .adapter(ApiResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (t: Throwable) {
            Log.d("Throwable", "$t")
            null
        }
    }

}