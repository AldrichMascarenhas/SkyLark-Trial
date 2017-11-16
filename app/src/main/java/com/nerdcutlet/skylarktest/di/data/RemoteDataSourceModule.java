package com.nerdcutlet.skylarktest.di.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface;
import com.nerdcutlet.skylarktest.di.annotation.Remote;
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource;
import com.nerdcutlet.skylarktest.ui.sets.model.remote.SetRemoteDataSource;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aldrich on 14-Nov-17.
 */

@Module
public class RemoteDataSourceModule {

    private static final String BASE_URL = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/api/";

    @Singleton
    @Provides
    @Remote
    SetDataSource provideSetRemoteDataSource(SkylarkServerInterface skylarkServerInterface) {
        return new SetRemoteDataSource(skylarkServerInterface);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();


    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }


    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();


    }

    @Provides
    @Singleton
    public SkylarkServerInterface provideSkylarkServerInterface(Retrofit retrofit) {
        return retrofit.create(SkylarkServerInterface.class);
    }

}
