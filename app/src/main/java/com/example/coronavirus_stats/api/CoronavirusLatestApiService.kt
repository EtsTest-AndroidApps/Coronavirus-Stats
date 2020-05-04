package com.example.coronavirus_stats.api

import com.example.coronavirus_stats.models.CountryCurrentStat
import com.example.coronavirus_stats.models.WorldCurrentStat
import com.example.coronavirus_stats.network.createNetworkClient
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://covid-19-data.p.rapidapi.com/"
private const val API_KEY = "c64032eeafmsh14b4af700711ddcp1a88afjsn5bcc4454a330"

interface CoronavirusMonitorApiService {

    @Headers("x-rapidapi-key: $API_KEY")
    @GET("totals")
    fun getWorldStat(): Deferred<List<WorldCurrentStat>>

    @Headers("x-rapidapi-key: $API_KEY")
    @GET("country")
    fun getCountryStat(@Query("name") countryName: String): Deferred<List<CountryCurrentStat>>

}

object CoronavirusMonitorApi {
    val retrofitService : CoronavirusMonitorApiService by lazy {
        createNetworkClient(BASE_URL)
            .create(CoronavirusMonitorApiService::class.java) }
}
