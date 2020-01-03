package com.jacksonfoo.supportwheeloffate.data.api

import com.jacksonfoo.supportwheeloffate.data.response.GetEngineerListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("5e0c358c2f00008400283116")
    fun getEngineerList(): Single<GetEngineerListResponse>
}