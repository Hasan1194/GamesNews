package com.h1194.core.di

import androidx.room.Room
import com.h1194.core.data.source.local.LocalDataSource
import com.h1194.core.data.source.local.room.GamesDatabase
import com.h1194.core.data.source.remote.RemoteDataSource
import com.h1194.core.data.source.remote.network.ApiService
import com.h1194.core.domain.repository.IGamesRepository
import com.h1194.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<GamesDatabase>().tourismDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            GamesDatabase::class.java, "Games"
        ).openHelperFactory(factory).build()
    }
}

val networkModule = module {
    single {
        val hostname = "rawg.io"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/2tTpscd4SUXKQGPPwwH0aL6vYdDHDILJ9I6Qn1GU=")
            .add(hostname, "sha256/yDu9og255NN5GEf+Bwa9rTrqFQ0EydZ0r1FCh9TdAW4=")
            .add(hostname, "sha256/ hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IGamesRepository> { com.h1194.core.data.GamesRepository(get(), get(), get()) }
}