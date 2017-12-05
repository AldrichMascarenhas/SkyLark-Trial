package com.nerdcutlet.skylarktest.di.data;

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface
import com.nerdcutlet.skylarktest.di.annotation.Remote
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource
import com.nerdcutlet.skylarktest.ui.sets.model.remote.SetRemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Aldrich on 14-Nov-17.
 */

@Module
class RemoteDataSourceModule {

    private val BASE_URL: String = "http://feature-code-test.skylark-cms.qa.aws.ostmodern.co.uk:8000/api/";

    @Singleton
    @Provides
    @Remote
    fun provideSetRemoteDataSource(skylarkServerInterface: SkylarkServerInterface): SetDataSource {
        return SetRemoteDataSource(skylarkServerInterface)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build()

    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }


    @Provides
    @Singleton
     fun provideRetrofit(okHttpClient : OkHttpClient , gson : Gson ) : Retrofit
    {

        return  Retrofit . Builder ()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

    }

    @Provides
    @Singleton
    fun  provideSkylarkServerInterface(retrofit : Retrofit ) : SkylarkServerInterface
    {
        return retrofit.create(SkylarkServerInterface::class.java)
        //TODO Why class.java? Compatibility?
    }

}
