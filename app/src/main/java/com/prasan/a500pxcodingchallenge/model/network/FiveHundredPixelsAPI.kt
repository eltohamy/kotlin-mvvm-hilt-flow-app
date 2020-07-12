package com.prasan.a500pxcodingchallenge.model.network

import com.prasan.a500pxcodingchallenge.model.datamodel.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API class for the 500px API
 * @author Prasan
 * @since 1.0
 */
interface FiveHundredPixelsAPI {

    /**
     * Performs a GET call to obtain a paginated list of photos
     * @param key API Key
     * @param feature feature source the photos should come from
     * @param page Page number of the data where the photos should come from
     * @return [Response] instance of [PhotoResponse] type
     */
    @GET("/v1/photos")
    suspend fun getPopularPhotos(
        @Query("consumer_key") key: String,
        @Query("feature") feature: String,
        @Query("page") page: Int
    ): Response<PhotoResponse>
}