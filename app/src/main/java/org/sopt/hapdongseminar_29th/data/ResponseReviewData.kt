package org.sopt.hapdongseminar_29th.data

data class ResponseReviewData(
    val status: Int,
    val success: Boolean,
    val data: List<Data>
) {
    data class Data(
        val id: Int,
        val name: String,
        val pickupStar: Int,
        val laundryStar: Int,
        val likecount: Int,
        val content: String,
        val image: String,
        val usingcount: Int,
    )
}
