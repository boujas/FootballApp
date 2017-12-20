package com.test.footballapp.network;

import com.test.footballapp.utils.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private static HeaderInterceptor sInterceptor;

    public static HeaderInterceptor get() {
        if (sInterceptor == null) {
            sInterceptor = new HeaderInterceptor();
        }
        return sInterceptor;
    }

    private HeaderInterceptor() {
        // Intentionally blank
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("X-Auth-Token", Const.KEY);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

}