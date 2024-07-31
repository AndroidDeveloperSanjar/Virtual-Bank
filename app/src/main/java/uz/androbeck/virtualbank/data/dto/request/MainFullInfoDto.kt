package uz.androbeck.virtualbank.data.dto.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainFullInfoDto(
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("first-name")
    val first_name: String? = null,
    @SerialName("last-name")
    val last_name: String? = null,
    @SerialName("born-date")
    val born_date: String? = null,
    @SerialName("gender")
    val gender: String? = null
)
