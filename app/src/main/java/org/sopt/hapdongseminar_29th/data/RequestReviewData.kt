package org.sopt.hapdongseminar_29th.data

import com.google.gson.annotations.SerializedName

data class RequestReviewData(
    @SerializedName("userid")
    val id: Int,
    @SerializedName("reviewid")
    val review: Int,
)
