package io.github.joelkanyi.paging3demo


import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) {
    data class Data(
        @SerializedName("avatar")
        val avatar: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("last_name")
        val lastName: String
    )

    data class Support(
        @SerializedName("text")
        val text: String,
        @SerializedName("url")
        val url: String
    )

    companion object {
        fun Data.toUser() = User(
            avatar = avatar,
            email = email,
            firstName = firstName,
            id = id,
            lastName = lastName
        )
    }
}