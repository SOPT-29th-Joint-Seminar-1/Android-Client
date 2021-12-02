package org.sopt.hapdongseminar_29th.api

import org.sopt.hapdongseminar_29th.data.ResponseCategoryData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CategoryService {
    @Headers("Content-Type:application/json")
    @GET("category/{categoryID}")
    fun getCategoryList(
        @Path("categoryID") categoryID: String
    ) : Call<ResponseCategoryData>
}