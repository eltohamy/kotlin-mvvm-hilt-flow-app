package com.prasan.kotlinmvvmhiltflowapp.data.network

import com.prasan.kotlinmvvmhiltflowapp.BuildConfig
import com.prasan.kotlinmvvmhiltflowapp.NetworkOperationResult
import com.prasan.kotlinmvvmhiltflowapp.data.contract.IWebService
import com.prasan.kotlinmvvmhiltflowapp.data.datamodel.PhotoResponse
import com.prasan.kotlinmvvmhiltflowapp.performSafeNetworkApiCall
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [IWebService] impl class which uses Retrofit to provide the app with the functionality to make
 * network requests
 * @author Prasan
 * @since 1.0
 * @see FiveHundredPixelsAPI
 * @see [IWebService]
 */
@Singleton
class RetrofitWebService @Inject constructor(private val retrofitClient: FiveHundredPixelsAPI) :
    IWebService {

    @ExperimentalCoroutinesApi
    override suspend fun getPhotosByPage(
        pageNumber: Int
    ): Flow<NetworkOperationResult<PhotoResponse>> =

        performSafeNetworkApiCall("Error Obtaining Photos") {
            retrofitClient.getPopularPhotos(
                BuildConfig.API_KEY,
                "popular",
                pageNumber
            )
        }
}