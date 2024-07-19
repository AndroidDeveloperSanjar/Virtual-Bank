package uz.androbeck.virtualbank.domain.ui_model

data class Person(
    val phone: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val bornDate: String? = null,
)

/** English
 * This is a little different from the PersonDto cause all Person Dto`s option may not be interesting for the user so we do`nt need to show those fields
 *
 * Uzbek
 * Bu class PersonDto dan farqli chunki bizga faqatgina ui va user uchun qiziq bo`lgan ma`lumotlar shu clasda jamlanadi !
 **/