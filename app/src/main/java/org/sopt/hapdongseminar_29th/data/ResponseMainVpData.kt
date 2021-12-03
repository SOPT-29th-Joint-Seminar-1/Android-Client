package org.sopt.hapdongseminar_29th.data

data class ResponseMainVpData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: eventImgData
){
    data class eventImgData(
        val eventImage1: String,
        val eventImage2: String,
        val eventImage3: String
    )
}
