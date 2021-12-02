package org.sopt.hapdongseminar_29th.data

data class ResponseReviewGetData(
    val status: Int,
    val success: Boolean,
    val data: List<Data>
) {
    data class Data(
        val id: String,
        val name: String,
        val pickupStar: Int,
        val deliveryStar: Int,
        val laundryStar: Int,
        val likecount: Int,
        val content: String,
        val image: String,
        val usingcount: Int,
    )
}
