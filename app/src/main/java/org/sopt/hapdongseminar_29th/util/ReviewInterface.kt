package org.sopt.hapdongseminar_29th.util

import org.sopt.hapdongseminar_29th.data.RequestReviewData
import org.sopt.hapdongseminar_29th.data.ResponseReviewData
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReviewInterface {
    @POST("review/like")
    fun postReview(
        @Body body: RequestReviewData
    ): Call<ResponseReviewData>

    @GET("review/list")
    fun getReview(): Call<ResponseReviewGetData>
}