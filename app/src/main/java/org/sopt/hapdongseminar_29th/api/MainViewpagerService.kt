package org.sopt.hapdongseminar_29th.api

import org.sopt.hapdongseminar_29th.data.ResponseMainVpData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainViewpagerService {
    @GET("{main}")
    fun getEventData(
        @Path("main")main:String
    ): Call<ResponseMainVpData>
}