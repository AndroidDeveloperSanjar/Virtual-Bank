package uz.androbeck.virtualbank.domain.mapper

import uz.androbeck.virtualbank.domain.dto.PersonDto
import uz.androbeck.virtualbank.domain.ui_model.Person


fun PersonDto.toPerson(): Person {
    return Person(
        phone = phone,
        firstName = firstName,
        lastName = lastName,
        bornDate = bornDate
    )
}

fun Person.toPersonDto(): PersonDto {
    return PersonDto(
        phone = phone,
        firstName = firstName,
        lastName = lastName,
        bornDate = bornDate
    )
}