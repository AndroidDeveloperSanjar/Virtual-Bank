package uz.androbeck.virtualbank.domain.dto

data class PersonDto(
    val phone: String? = null,
    val password: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val bornDate: String? = null,
    val gender: Boolean? = null
)