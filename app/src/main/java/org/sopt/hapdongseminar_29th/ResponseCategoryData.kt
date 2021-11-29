package org.sopt.hapdongseminar_29th

data class ResponseCategoryData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val categoryName: String,
        val itemName: String,
        val itemPrice: Int
    )
}