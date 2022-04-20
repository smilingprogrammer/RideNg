package com.example.rideng.network

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//private const val BASE_URL = "https://ride-ng.herokuapp.com/api/"
////private val moshi = Moshi.Builder()
////    .add(KotlinJsonAdapterFactory())
////    .build()
//
//private fun httpClient(): OkHttpClient {
//
//    val interceptor = HttpLoggingInterceptor().apply {
//        this.level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    return OkHttpClient.Builder().apply {
//        this.addInterceptor(interceptor)
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .readTimeout(60, TimeUnit.SECONDS)
//            .retryOnConnectionFailure(true)
//    }.build()
//}
//
//private val retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .client(httpClient())
//    .build()
//
//object ApiClient {
//    val retrofitService: RideNgApi by lazy {
//        retrofit.create(RideNgApi::class.java)
//    }
//}
class ApiClient {
    companion object {
        val BASE_URL = "https://ride-ng.herokuapp.com/api/"
        fun getRetrofitInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

//    var client = OkHttpClient().newBuilder()
//        .build()
//    var mediaType: MediaType = MediaType.parse("text/plain")
//    var body: RequestBody = create(
//        mediaType,
//        "{\r\n    \"firstname\": \"chinaza\",\r\n    \"lastname\": \"Chinaza\",\r\n    \"email\": \"ch@gmail.com\",\r\n    \"password\": \"123456\",\r\n    \"bvn\": \"234556773\",\r\n    \"phone\": \"2335566\"\r\n}"
//    )
//    var request: Request = Builder()
//        .url("https://ride-ng.herokuapp.com/api/v1/auth/register")
//        .method("POST", body)
//        .build()
//    var response: Response = client.newCall(request).execute()
}