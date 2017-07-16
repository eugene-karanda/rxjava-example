package org.overmind.rxjavaexample.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 15.07.2017 18:30
 */
public class RestServiceFactory {
    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     * @param clazz Java interface of the retrofit service
     * @param endpoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    public static <T> T create(final Class<T> clazz, final String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(endpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        return retrofit.create(clazz);
    }
}
