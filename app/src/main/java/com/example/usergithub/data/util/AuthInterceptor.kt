package com.example.usergithub.data.util

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request.newBuilder()
            .header("Authorization", "Bearer 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")
            .build()

        return chain.proceed(request)
    }
}